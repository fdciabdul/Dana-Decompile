package com.alibaba.griver.beehive.lottie.adapter.impl;

import android.app.Application;
import com.alibaba.griver.base.common.env.GriverEnv;
import java.io.File;

/* loaded from: classes6.dex */
public class ApplicationAapter {
    public static final String TAG = "ApplicationAapter";

    public static Application getApplicationContext() {
        return GriverEnv.getApplicationContext();
    }

    public static File getFilesDir() {
        return getApplicationContext().getFilesDir();
    }
}
