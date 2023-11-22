package com.alipay.iap.android.lbs;

import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class LBSLocationRequest {

    /* renamed from: a  reason: collision with root package name */
    private static long f6994a = TimeUnit.SECONDS.toMillis(30);
    private static long b = TimeUnit.SECONDS.toMillis(60);
    private static long c = TimeUnit.SECONDS.toMillis(1);
    private static float d = 5.0f;
    public String bizType = "";
    public long cacheValidTime = f6994a;
    public boolean isHighAccuracy = false;
    public long timeOut = b;
    public long updateInterval = c;
    public float minDistance = d;
}
