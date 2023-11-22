package com.alipay.mobile.security.zim.biz;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;

/* loaded from: classes3.dex */
public class ZimComponentCallbacks implements ComponentCallbacks2 {
    private static final String TAG = "ZimPlatform";
    private static ZimComponentCallbacks sInstance;
    protected Context mApplicationContext;

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
    }

    private ZimComponentCallbacks(Context context) {
        this.mApplicationContext = context.getApplicationContext();
    }

    public static ZimComponentCallbacks getInstance(Application application) {
        if (sInstance == null) {
            synchronized (ZimComponentCallbacks.class) {
                if (sInstance == null) {
                    ZimComponentCallbacks zimComponentCallbacks = new ZimComponentCallbacks(application);
                    application.registerComponentCallbacks(zimComponentCallbacks);
                    sInstance = zimComponentCallbacks;
                }
            }
        }
        return sInstance;
    }
}
