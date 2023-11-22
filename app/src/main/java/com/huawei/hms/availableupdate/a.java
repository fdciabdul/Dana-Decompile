package com.huawei.hms.availableupdate;

import android.app.Activity;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class a {
    public static final a b = new a();

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Activity> f7461a;

    public boolean a(Activity activity) {
        HMSLog.i("UpdateAdapterMgr", "onActivityCreate");
        Activity a2 = a();
        if (a2 != null && !a2.isFinishing()) {
            activity.finish();
            HMSLog.i("UpdateAdapterMgr", "finish one");
            return false;
        }
        this.f7461a = new WeakReference<>(activity);
        return true;
    }

    public void b(Activity activity) {
        HMSLog.i("UpdateAdapterMgr", "onActivityDestroy");
        Activity a2 = a();
        if (activity == null || !activity.equals(a2)) {
            return;
        }
        HMSLog.i("UpdateAdapterMgr", "reset");
        this.f7461a = null;
    }

    public final Activity a() {
        WeakReference<Activity> weakReference = this.f7461a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
