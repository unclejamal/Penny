package com.pduda.penny.view.android;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.common.collect.Lists;
import com.pduda.penny.controller.android.AndroidDevicePublicStorageGateway;
import com.pduda.penny.controller.android.PublicStorageMediaNotAvailableException;
import com.pduda.penny.domain.controller.ExportAllTransactionsAction;
import com.pduda.penny.domain.mvp.BrowseTransactionsModel;
import com.pduda.penny.domain.mvp.BrowseTransactionsPresenter;
import com.pduda.penny.domain.mvp.BrowseTransactionsView;
import com.pduda.penny.domain.mvp.RendersView;
import com.pduda.penny.toolkit.ProgrammerMistake;
import java.io.File;
import java.util.Collection;

public class BrowseTransactionsActivity extends Activity implements BrowseTransactionsView {

    private final RendersView rendersView;
    private final AndroidDevicePublicStorageGateway androidDevicePublicStorageGateway;

    public BrowseTransactionsActivity() {
        // We can't chain the constructor, because the instance in the process of being created is itself the view.
        // We have to wait for super() to be (implicitly) invoked.

        // REFACTOR Delegate BrowseTransactionsView behavior to a new class
        this.rendersView = new BrowseTransactionsPresenter(
                new BrowseTransactionsModel() {
                    @Override
                    public int countTransactions() {
                        return 12;
                    }

                    @Override
                    public Collection<Object> findAllTransactions() {
                        return Lists.newArrayList();
                    }
                }, this);

        // SMELL I have to initialize this because I can't use
        // constructor chaining yet. This has to be anything
        // that won't throw a stupid exception.
        this.androidDevicePublicStorageGateway = new AndroidDevicePublicStorageGateway() {
            @Override
            public File findPublicExternalStorageDirectory()
                    throws PublicStorageMediaNotAvailableException {
                return new File(".");
            }
        };

    }

    /**
     * @deprecated
     */
    public BrowseTransactionsActivity(
            RendersView rendersView) {
        this(rendersView, null, null);
    }

    public BrowseTransactionsActivity(
            RendersView rendersView, ExportAllTransactionsAction exportAllTransactionsAction) {
        this(rendersView, exportAllTransactionsAction, null);
    }

    public BrowseTransactionsActivity(
            RendersView rendersView, ExportAllTransactionsAction exportAllTransactionsAction, AndroidDevicePublicStorageGateway androidDevicePublicStorageGateway) {
        this.rendersView = rendersView;
        this.androidDevicePublicStorageGateway = androidDevicePublicStorageGateway;
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Arbitrarily, I assume that I should do my work after the superclass, but I don't really know.
        rendersView.render();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    public void displayNumberOfTransactions(
            int transactionCount) {
        if (transactionCount < 0) {
            throw new ProgrammerMistake(
                    new IllegalArgumentException(
                    String.format(
                    "number of transactions can't be negative, but it's %1$d",
                    transactionCount)));
        }

        final TextView transactionsCountView = (TextView) findViewById(R.id.transactionsCount);
        transactionsCountView.setText(
                String.format(
                "%1$d", transactionCount));
    }

    public void exportAllTransactions(View clicked) {
        try {
            androidDevicePublicStorageGateway
                    .findPublicExternalStorageDirectory();
            Toast.makeText(
                    getApplicationContext(),
                    "Exported all transactions to /mnt/sdcard/TrackEveryPenny.csv",
                    Toast.LENGTH_LONG).show();

        } catch (PublicStorageMediaNotAvailableException reported) {
            Log.e("TrackEveryPenny",
                    "Couldn't save a file to public storage; media not available",
                    reported);
            Toast.makeText(getApplicationContext(),
                    "No place to which to export the transactions. Insert an SD card or connect an "
                    + "external storage device and try again.",
                    Toast.LENGTH_LONG).show();
        }
    }
}
