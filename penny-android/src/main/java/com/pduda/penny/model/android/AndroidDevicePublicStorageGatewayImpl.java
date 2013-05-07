package com.pduda.penny.model.android;

import com.pduda.penny.model.android.*;
import android.os.Environment;
import com.pduda.penny.controller.android.AndroidDevicePublicStorageGateway;
import com.pduda.penny.controller.android.PublicStorageMediaNotAvailableException;
import com.pduda.penny.controller.android.PublicStorageMediaNotWritableException;

import java.io.File;

public class AndroidDevicePublicStorageGatewayImpl
    implements AndroidDevicePublicStorageGateway {
  public String getExternalStorageState() {
    return Environment.getExternalStorageState();
  }

  public File getExternalStoragePublicDirectory() {
    return Environment.getExternalStoragePublicDirectory(
        Environment.DIRECTORY_DOWNLOADS);
  }

  @Override
  public File findPublicExternalStorageDirectory()
      throws PublicStorageMediaNotAvailableException,
             PublicStorageMediaNotWritableException {
    if (Environment.MEDIA_MOUNTED.equals(
        getExternalStorageState()))
      return getExternalStoragePublicDirectory();

    if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(
        getExternalStorageState()))
      throw new PublicStorageMediaNotWritableException(
          getExternalStoragePublicDirectory());

    throw new PublicStorageMediaNotAvailableException();
  }
}