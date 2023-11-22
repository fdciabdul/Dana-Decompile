package com.huawei.hms.support.common;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public final class ActivityMgr implements Application.ActivityLifecycleCallbacks {
    public static final ActivityMgr INST = new ActivityMgr();

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Activity> f7492a;

    public static String a(Object obj) {
        if (obj == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(obj.getClass().getName());
        sb.append('@');
        sb.append(Integer.toHexString(obj.hashCode()));
        return sb.toString();
    }

    public final Activity getCurrentActivity() {
        if (this.f7492a == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("mCurrentActivity is ");
            sb.append(this.f7492a);
            HMSLog.i("ActivityMgr", sb.toString());
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("mCurrentActivity.get() is ");
        sb2.append(this.f7492a.get());
        HMSLog.i("ActivityMgr", sb2.toString());
        return this.f7492a.get();
    }

    public final void init(Application application) {
        HMSLog.d("ActivityMgr", IAPSyncCommand.COMMAND_INIT);
        if (application == null) {
            HMSLog.w("ActivityMgr", "init failed for app is null");
            return;
        }
        ActivityMgr activityMgr = INST;
        application.unregisterActivityLifecycleCallbacks(activityMgr);
        application.registerActivityLifecycleCallbacks(activityMgr);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        sb.append("onCreated:");
        sb.append(a(activity));
        HMSLog.d("ActivityMgr", sb.toString());
        this.f7492a = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        StringBuilder sb = new StringBuilder();
        sb.append("onResumed:");
        sb.append(a(activity));
        HMSLog.d("ActivityMgr", sb.toString());
        this.f7492a = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        StringBuilder sb = new StringBuilder();
        sb.append("onStarted:");
        sb.append(a(activity));
        HMSLog.d("ActivityMgr", sb.toString());
        this.f7492a = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
