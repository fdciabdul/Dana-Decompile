package com.iap.ac.android.acs.plugin.core;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class IAPConnectPluginContext {
    public JSONObject acParams;
    public String acquireSite;
    public boolean isMiniProgram;
    public JSONObject jsParameters;
    public Context mContext;
    public WeakReference<Activity> mWeakReferenceAct;
    public String miniProgramAppID;
    public String miniProgramName;
    public String miniProgramPageURL;
    public String newSourceSite;
    public String pluginId;
    public String sourceSite;
    public Bundle startParams;

    public IAPConnectPluginContext(Context context) {
        this.mContext = context.getApplicationContext();
        if (context instanceof Activity) {
            this.mWeakReferenceAct = new WeakReference<>((Activity) context);
        }
    }

    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.mWeakReferenceAct;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void setActivity(Activity activity) {
        if (activity != null) {
            this.mWeakReferenceAct = new WeakReference<>(activity);
        }
    }
}
