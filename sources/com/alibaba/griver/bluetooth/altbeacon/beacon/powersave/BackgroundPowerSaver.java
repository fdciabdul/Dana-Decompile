package com.alibaba.griver.bluetooth.altbeacon.beacon.powersave;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconManager;
import com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager;

/* loaded from: classes6.dex */
public class BackgroundPowerSaver implements Application.ActivityLifecycleCallbacks {
    private static final String TAG = "BackgroundPowerSaver";
    private int activeActivityCount;
    private final BeaconManager beaconManager;

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
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Deprecated
    public BackgroundPowerSaver(Context context, boolean z) {
        this(context);
    }

    public BackgroundPowerSaver(Context context) {
        this.activeActivityCount = 0;
        if (Build.VERSION.SDK_INT < 18) {
            LogManager.w(TAG, "BackgroundPowerSaver requires API 18 or higher.", new Object[0]);
        }
        this.beaconManager = BeaconManager.getInstanceForApplication(context);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        int i = this.activeActivityCount + 1;
        this.activeActivityCount = i;
        if (i <= 0) {
            LogManager.d(TAG, "reset active activity count on resume.  It was %s", Integer.valueOf(i));
            this.activeActivityCount = 1;
        }
        this.beaconManager.setBackgroundMode(false);
        LogManager.d(TAG, "activity resumed: %s active activities: %s", activity, Integer.valueOf(this.activeActivityCount));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        int i = this.activeActivityCount - 1;
        this.activeActivityCount = i;
        LogManager.d(TAG, "activity paused: %s active activities: %s", activity, Integer.valueOf(i));
        if (this.activeActivityCount <= 0) {
            LogManager.d(TAG, "setting background mode", new Object[0]);
            this.beaconManager.setBackgroundMode(true);
        }
    }
}
