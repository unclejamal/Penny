package com.pduda.penny.android;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import com.pduda.snakemaster.android.R;

public class MainActivity extends Activity {

    private TableLayout table;
    private Button blackButton;
    private Button whiteButton;
    private Button randomButton;
    private Handler tickHandler = new Handler();
    private TickThread tickThread = new TickThread();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // get all the view components
        table = (TableLayout) findViewById(R.id.Table);
        blackButton = (Button) findViewById(R.id.btnBlack);
        whiteButton = (Button) findViewById(R.id.btnWhite);
        randomButton = (Button) findViewById(R.id.btnRandom);

        // default the full screen to white
        table.setBackgroundColor(Color.WHITE);

        // hook up all the buttons with a table color change on click listener
        blackButton.setOnClickListener(changz0rage(Color.BLACK));
        whiteButton.setOnClickListener(changz0rage(Color.WHITE));
        randomButton.setOnClickListener(startTicking());
    }

    private void changeColor(int color) {
        table.setBackgroundColor(color);
    }

    private int randomInt(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private class TickThread implements Runnable {

        @Override
        public void run() {
            changeColor(randomInt(Color.BLACK, Color.WHITE));
            tickHandler.postDelayed(tickThread, 500);
        }
    }

    View.OnClickListener changz0rage(final int color) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(color);
            }
        };
    }

    View.OnClickListener startTicking() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tickHandler.post(tickThread);
            }
        };
    }
}