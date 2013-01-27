package com.pduda.penny.controller.android;

import java.io.File;

public interface AndroidDevicePublicStorageGateway {

    File findPublicExternalStorageDirectory() throws PublicStorageMediaNotAvailableException, PublicStorageMediaNotWritableException;
}