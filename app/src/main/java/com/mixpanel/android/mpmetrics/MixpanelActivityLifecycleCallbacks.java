package com.mixpanel.android.mpmetrics;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.mixpanel.android.mpmetrics.AnalyticsMessages;
import com.mixpanel.android.viewcrawler.GestureTracker;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MixpanelActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    private static Double PlaceComponentResult;
    private Runnable KClassImpl$Data$declaredNonStaticMembers$2;
    WeakReference<Activity> MyBillsEntityDataFactory;
    private final MPConfig getAuthRequestContext;
    private final MixpanelAPI moveToNextValue;
    private Handler BuiltInFictitiousFunctionClassFactory = new Handler(Looper.getMainLooper());
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    private boolean getErrorConfigVersion = true;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    static /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(MixpanelActivityLifecycleCallbacks mixpanelActivityLifecycleCallbacks) {
        mixpanelActivityLifecycleCallbacks.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        return false;
    }

    public MixpanelActivityLifecycleCallbacks(MixpanelAPI mixpanelAPI, MPConfig mPConfig) {
        this.moveToNextValue = mixpanelAPI;
        this.getAuthRequestContext = mPConfig;
        if (PlaceComponentResult == null) {
            PlaceComponentResult = Double.valueOf(System.currentTimeMillis());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent != null && intent.hasExtra("mp_campaign_id") && intent.hasExtra("mp_message_id")) {
            MixpanelAPI.getAuthRequestContext(this.moveToNextValue.BuiltInFictitiousFunctionClassFactory, intent, "$app_open");
        }
        if (Build.VERSION.SDK_INT >= 16 && this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory()) {
            this.moveToNextValue.scheduleImpl.BuiltInFictitiousFunctionClassFactory(activity);
        }
        new GestureTracker(this.moveToNextValue, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.getErrorConfigVersion = true;
        Runnable runnable = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (runnable != null) {
            this.BuiltInFictitiousFunctionClassFactory.removeCallbacks(runnable);
        }
        this.MyBillsEntityDataFactory = null;
        Handler handler = this.BuiltInFictitiousFunctionClassFactory;
        Runnable runnable2 = new Runnable() { // from class: com.mixpanel.android.mpmetrics.MixpanelActivityLifecycleCallbacks.1
            @Override // java.lang.Runnable
            public void run() {
                if (MixpanelActivityLifecycleCallbacks.this.NetworkUserEntityData$$ExternalSyntheticLambda0 && MixpanelActivityLifecycleCallbacks.this.getErrorConfigVersion) {
                    MixpanelActivityLifecycleCallbacks.KClassImpl$Data$declaredNonStaticMembers$2(MixpanelActivityLifecycleCallbacks.this);
                    try {
                        double currentTimeMillis = System.currentTimeMillis();
                        double doubleValue = MixpanelActivityLifecycleCallbacks.PlaceComponentResult.doubleValue();
                        Double.isNaN(currentTimeMillis);
                        double d = currentTimeMillis - doubleValue;
                        if (d >= MixpanelActivityLifecycleCallbacks.this.getAuthRequestContext.DatabaseTableConfigUtil && d < MixpanelActivityLifecycleCallbacks.this.getAuthRequestContext.newProxyInstance) {
                            double round = Math.round((d / 1000.0d) * 10.0d);
                            Double.isNaN(round);
                            double d2 = round / 10.0d;
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("$ae_session_length", d2);
                            MixpanelActivityLifecycleCallbacks.this.moveToNextValue.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2("$ae_total_app_sessions", 1.0d);
                            MixpanelActivityLifecycleCallbacks.this.moveToNextValue.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2("$ae_total_app_session_length", d2);
                            MixpanelActivityLifecycleCallbacks.this.moveToNextValue.BuiltInFictitiousFunctionClassFactory("$ae_session", jSONObject, true);
                        }
                    } catch (JSONException unused) {
                    }
                    MixpanelAPI mixpanelAPI = MixpanelActivityLifecycleCallbacks.this.moveToNextValue;
                    if (mixpanelAPI.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0() && !mixpanelAPI.getAuthRequestContext()) {
                        mixpanelAPI.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(new AnalyticsMessages.FlushDescription(mixpanelAPI.getErrorConfigVersion));
                    }
                    mixpanelAPI.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext();
                }
            }
        };
        this.KClassImpl$Data$declaredNonStaticMembers$2 = runnable2;
        handler.postDelayed(runnable2, 500L);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16 && this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory()) {
            this.moveToNextValue.scheduleImpl.PlaceComponentResult();
        }
        this.MyBillsEntityDataFactory = new WeakReference<>(activity);
        this.getErrorConfigVersion = false;
        boolean z = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        Runnable runnable = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (runnable != null) {
            this.BuiltInFictitiousFunctionClassFactory.removeCallbacks(runnable);
        }
        if ((!z) == true) {
            PlaceComponentResult = Double.valueOf(System.currentTimeMillis());
            this.moveToNextValue.BuiltInFictitiousFunctionClassFactory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
