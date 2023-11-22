package com.alibaba.griver.base.api;

import android.os.SystemClock;

/* loaded from: classes6.dex */
public class GriverPerformanceStages {
    public static final String KEY_APPX_APP_LOADED = "appxAppLoaded";
    public static final String KEY_APPX_PAGE_LOADED = "appxPageLoaded";
    public static final String KEY_APPX_WORKER_LOADED = "appxWorkerFrameworkLoaded";
    public static final String KEY_APP_FINISHED = "appFinished";
    public static final String KEY_APP_INFO_END = "appInfoEnd";
    public static final String KEY_APP_INFO_START = "appInfoStart";
    public static final String KEY_APP_STARTUP_BREAK = "appStartupBreak";
    public static final String KEY_FIRST_SCREEN = "firstScreen";
    public static final String KEY_JUMP_APP_START_UNIX = "jumpAppStartUnix";
    public static final String KEY_PAGE_STARTUP_BREAK = "pageStartupBreak";
    public static final String KEY_RESOURCE_READY = "resourceReady";

    /* renamed from: a  reason: collision with root package name */
    private long f6277a;
    private long b;
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;
    private long m;

    public long getJumpAppStart() {
        return this.f6277a;
    }

    public void setJumpAppStart() {
        this.f6277a = SystemClock.elapsedRealtime();
    }

    public long getSetupStart() {
        return this.b;
    }

    public void setSetupStart() {
        this.b = SystemClock.elapsedRealtime();
    }

    public long getSetupEnd() {
        return this.c;
    }

    public void setSetupEnd() {
        this.c = SystemClock.elapsedRealtime();
    }

    public long getStartActivity() {
        return this.d;
    }

    public void setStartActivity() {
        this.d = SystemClock.elapsedRealtime();
    }

    public long getAttachContext() {
        return this.e;
    }

    public void setAttachContext() {
        this.e = SystemClock.elapsedRealtime();
    }

    public long getActivityCreated() {
        return this.f;
    }

    public void setActivityCreated() {
        this.f = SystemClock.elapsedRealtime();
    }

    public long getAppInfoStart() {
        return this.g;
    }

    public void setAppInfoStart() {
        this.g = SystemClock.elapsedRealtime();
    }

    public long getAppInfoEnd() {
        return this.h;
    }

    public void setAppInfoEnd() {
        this.h = SystemClock.elapsedRealtime();
    }

    public long getResourceReady() {
        return this.i;
    }

    public void setResourceReady() {
        this.i = SystemClock.elapsedRealtime();
    }

    public long getAppxWorkerFrameworkLoaded() {
        return this.j;
    }

    public void setAppxWorkerFrameworkLoaded() {
        this.j = SystemClock.elapsedRealtime();
    }

    public long getAppxAppLoaded() {
        return this.k;
    }

    public void setAppxAppLoaded() {
        this.k = SystemClock.elapsedRealtime();
    }

    public long getAppxPageLoaded() {
        return this.l;
    }

    public void setAppxPageLoaded() {
        this.l = SystemClock.elapsedRealtime();
    }

    public long getFirstScreen() {
        return this.m;
    }

    public void setFirstScreen() {
        this.m = SystemClock.elapsedRealtime();
    }
}
