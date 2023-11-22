package com.iap.safemode.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.iap.safemode.api.IAPSafeModeTraceListener;
import com.iap.safemode.handler.IAPSafeModeHandlerRegistrator;
import com.iap.safemode.storage.IAPStorageManager;
import java.util.Timer;

/* loaded from: classes3.dex */
public class IAPSafeModeContext implements Application.ActivityLifecycleCallbacks {
    public static int KClassImpl$Data$declaredNonStaticMembers$2;
    public static boolean MyBillsEntityDataFactory;
    private static volatile IAPSafeModeContext NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    public static String PlaceComponentResult;
    public final String BuiltInFictitiousFunctionClassFactory = "IAPSafeModeContext";
    public Application getAuthRequestContext;
    public IAPStorageManager getErrorConfigVersion;
    public IAPSafeModeTraceListener lookAheadTest;
    public IAPSafeModeHandlerRegistrator moveToNextValue;
    public Timer scheduleImpl;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    public static IAPSafeModeContext getAuthRequestContext() {
        if (NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
            synchronized (IAPSafeModeContext.class) {
                if (NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = new IAPSafeModeContext();
                }
            }
        }
        return NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BuiltInFictitiousFunctionClassFactory() {
        synchronized (this) {
            if (NetworkUserEntityData$$ExternalSyntheticLambda1) {
                return;
            }
            if (!TextUtils.isEmpty(PlaceComponentResult)) {
                this.lookAheadTest.onlog(PlaceComponentResult);
            }
            NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
            KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            IAPStorageManager.getAuthRequestContext(this.getAuthRequestContext, "safemode_marker", "0");
            Timer timer = this.scheduleImpl;
            if (timer != null) {
                timer.cancel();
            }
            this.getAuthRequestContext.unregisterActivityLifecycleCallbacks(this);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        BuiltInFictitiousFunctionClassFactory();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        BuiltInFictitiousFunctionClassFactory();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        BuiltInFictitiousFunctionClassFactory();
    }
}
