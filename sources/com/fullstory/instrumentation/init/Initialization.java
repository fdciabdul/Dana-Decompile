package com.fullstory.instrumentation.init;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Process;
import android.view.WindowManager;
import com.fullstory.instrumentation.Bootstrap;
import com.fullstory.instrumentation.CurrentPlatform;
import com.fullstory.jni.FSNative;
import com.fullstory.util.Log;
import fsimpl.C0256bg;
import fsimpl.C0331eb;
import fsimpl.K;
import fsimpl.bG;
import fsimpl.bH;
import fsimpl.cS;
import fsimpl.cZ;
import fsimpl.eD;
import fsimpl.eV;

/* loaded from: classes.dex */
public class Initialization {

    /* renamed from: a  reason: collision with root package name */
    public static String f7427a;
    private bG b;
    private ConnectivityManager c;
    private WindowManager d;
    private PackageInfo e;
    private Context f;

    private void a(Application application, Context context, bH bHVar, boolean z) {
        Log.v("[startup] init!");
        try {
            Bootstrap.success(new K(application, context, this.b, bHVar, z));
        } catch (Throwable th) {
            cS.a("Failed to initialize impl", th);
        }
    }

    private boolean a() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f.getSystemService("connectivity");
        this.c = connectivityManager;
        if (connectivityManager == null) {
            Log.logAlways("Failed to get ConnectivityManager, capture is disabled");
            return false;
        }
        return true;
    }

    private boolean a(Application application, Boolean[] boolArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("Initialized ");
        sb.append(application.getClass());
        sb.append(" (SDK ");
        sb.append(Build.VERSION.SDK_INT);
        sb.append(")");
        Log.i(sb.toString());
        if (FSNative.a()) {
            boolArr[0] = Boolean.valueOf(!C0331eb.hook());
            return true;
        }
        Log.logAlways("Unable to load FSNative, aborting");
        return false;
    }

    private boolean a(Context context) {
        bG a2 = bG.a(context);
        this.b = a2;
        if (a2 == null) {
            Log.logAlways("Failed to load configuration, aborting");
            return false;
        }
        C0256bg.e(a2.C());
        C0256bg.f(this.b.D());
        C0256bg.g(this.b.E());
        C0256bg.h(this.b.F());
        C0256bg.a(this.b.n());
        C0256bg.b(this.b.t());
        C0256bg.c(this.b.v());
        C0256bg.d(this.b.w());
        Log.setLevel(this.b.o());
        Log.setLogcatLevel(this.b.p());
        if (this.b.m()) {
            Log.DISABLE_LOGGING = false;
            this.b.a();
            return true;
        }
        return true;
    }

    private boolean a(Context context, int i, int i2) {
        if (context.checkPermission("android.permission.INTERNET", i, i2) == -1) {
            Log.logAlways("Internet permission denied, capture is disabled");
            return false;
        }
        return true;
    }

    private boolean b() {
        WindowManager windowManager = (WindowManager) this.f.getSystemService("window");
        this.d = windowManager;
        if (windowManager == null) {
            Log.logAlways("Failed to get WindowManager, capture is disabled");
            return false;
        }
        return true;
    }

    private boolean b(Context context, int i, int i2) {
        if (context.checkPermission("android.permission.ACCESS_NETWORK_STATE", i, i2) == -1) {
            Log.logAlways("Access network state permission denied, capture is disabled");
            return false;
        }
        return true;
    }

    private boolean c() {
        PackageInfo a2 = cZ.a(this.f);
        this.e = a2;
        if (a2 == null) {
            Log.logAlways("Failed to get PackageInfo, capture is disabled");
            return false;
        }
        return true;
    }

    private boolean d() {
        StringBuilder sb;
        String str;
        int k = this.b.k();
        if (k > Build.VERSION.SDK_INT) {
            sb = new StringBuilder();
            sb.append("SDK is too old, not loading (SDK=");
            sb.append(Build.VERSION.SDK_INT);
            str = ", min=";
        } else {
            k = this.b.l();
            if (k >= Build.VERSION.SDK_INT) {
                return true;
            }
            sb = new StringBuilder();
            sb.append("SDK is too new, not loading (SDK=");
            sb.append(Build.VERSION.SDK_INT);
            str = ", max=";
        }
        sb.append(str);
        sb.append(k);
        sb.append(")");
        Log.logAlways(sb.toString());
        return false;
    }

    private boolean e() {
        int i = CurrentPlatform.TARGET_SDK;
        return true;
    }

    private boolean f() {
        if (eV.a()) {
            return true;
        }
        Log.logAlways("Unable to use reflection, not loading");
        return false;
    }

    private void g() {
        f7427a = String.format("FS/%s %s/%d Android/%s  %s %s", "1.41.0", this.e.packageName, Integer.valueOf(cZ.a(this.e)), Build.VERSION.RELEASE, Build.BRAND, Build.MODEL);
    }

    public void init(Application application, Context context) {
        this.f = context;
        bH bHVar = new bH();
        application.registerActivityLifecycleCallbacks(bHVar);
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        Boolean[] boolArr = {Boolean.FALSE};
        try {
            if (!a(context, myPid, myUid) || !b(context, myPid, myUid) || !a() || !b() || !c() || !a(context) || !d() || !e() || !f() || !a(application, boolArr)) {
                Bootstrap.fail();
                return;
            }
            g();
            eD.a(this.d);
            a(application, context, bHVar, boolArr[0].booleanValue());
        } catch (Throwable th) {
            cS.a("Unexpected error starting up", th);
        }
    }
}
