package com.return0.netcasa;

import android.app.Application;
import android.content.Context;

import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;

@ReportsCrashes(mailTo = "returnzero41@gmail.com",
customReportContent ={ReportField.APP_VERSION_CODE,ReportField.APP_VERSION_NAME,ReportField.ANDROID_VERSION,ReportField.PHONE_MODEL,ReportField.CUSTOM_DATA,ReportField.STACK_TRACE,ReportField.LOGCAT},
mode = ReportingInteractionMode.TOAST,
resToastText =R.string.errorToast)
public class NetCasa extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        ACRA.init(this);
    }
}
