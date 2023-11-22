package com.alibaba.griver.core.keepalive;

import android.os.Bundle;
import android.os.SystemClock;
import com.alibaba.griver.core.ui.activity.GriverBaseActivity;
import java.io.Serializable;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class AliveActivityInfo implements Serializable {
    public static final int BACKGROUND = 3;
    public static final int READY = 1;
    public static final int RUNNING = 2;
    public static final int TERMINATED = 0;
    private int aliveId;
    private long aliveTime;
    private String appId;
    private long backgroundTime;
    private Class<? extends GriverBaseActivity> clazz;
    private String fromActivity;
    private int fromTaskId;
    private boolean isHighAlive;
    private WeakReference<GriverProxyActivity> proxyActivityWeakReference;
    private long resetTime;
    private Runnable runnable;
    private Bundle startParams;
    private long startToken = -1;
    private int state;
    private long token;

    public int getState() {
        return this.state;
    }

    public void setState(int i) {
        this.state = i;
    }

    public long getStartToken() {
        return this.startToken;
    }

    public void setStartToken(long j) {
        this.startToken = j;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public Class<? extends GriverBaseActivity> getClazz() {
        return this.clazz;
    }

    public void setClazz(Class<? extends GriverBaseActivity> cls) {
        this.clazz = cls;
    }

    public int getAliveId() {
        return this.aliveId;
    }

    public void setAliveId(int i) {
        this.aliveId = i;
    }

    public void reset() {
        this.startToken = -1L;
        this.appId = null;
        this.state = 0;
        this.fromTaskId = -1;
        this.runnable = null;
        this.aliveTime = 0L;
        this.backgroundTime = 0L;
        this.isHighAlive = false;
        this.startParams = null;
        this.resetTime = SystemClock.elapsedRealtime();
        this.fromActivity = "";
        clearProxyActivity();
    }

    public int getFromTaskId() {
        return this.fromTaskId;
    }

    public void setFromTaskId(int i) {
        this.fromTaskId = i;
    }

    public Runnable getRunnable() {
        return this.runnable;
    }

    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    public long getAliveTime() {
        return this.aliveTime;
    }

    public void setAliveTime(long j) {
        this.aliveTime = j;
    }

    public long getBackgroundTime() {
        return this.backgroundTime;
    }

    public void setBackgroundTime(long j) {
        this.backgroundTime = j;
    }

    public boolean isHighAlive() {
        return this.isHighAlive;
    }

    public void setHighAlive(boolean z) {
        this.isHighAlive = z;
    }

    public long getResetTime() {
        return this.resetTime;
    }

    public void setResetTime(long j) {
        this.resetTime = j;
    }

    public Bundle getStartParams() {
        return this.startParams;
    }

    public void setStartParams(Bundle bundle) {
        this.startParams = bundle;
    }

    public void setToken(long j) {
        this.token = j;
    }

    public long getToken() {
        return this.token;
    }

    public GriverProxyActivity getProxyActivity() {
        WeakReference<GriverProxyActivity> weakReference = this.proxyActivityWeakReference;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void setProxyActivity(GriverProxyActivity griverProxyActivity) {
        if (griverProxyActivity != null) {
            this.proxyActivityWeakReference = new WeakReference<>(griverProxyActivity);
        }
    }

    public void clearProxyActivity() {
        this.token = -1L;
        WeakReference<GriverProxyActivity> weakReference = this.proxyActivityWeakReference;
        if (weakReference != null) {
            GriverProxyActivity griverProxyActivity = weakReference.get();
            if (griverProxyActivity != null) {
                griverProxyActivity.finish();
            }
            this.proxyActivityWeakReference.clear();
            this.proxyActivityWeakReference = null;
        }
    }

    public void setFromActivity(String str) {
        this.fromActivity = str;
    }

    public String getFromActivity() {
        return this.fromActivity;
    }
}
