package com.alipay.mobile.embedview.mapbiz.core.controller;

import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;

/* loaded from: classes6.dex */
public class PerformLogController extends H5MapController {

    /* renamed from: a  reason: collision with root package name */
    private long f7163a;
    private long b;
    private long c;
    private long d;

    public PerformLogController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        this.f7163a = -1L;
        this.b = -1L;
        this.c = -1L;
        this.d = -1L;
    }

    public void clear() {
        this.f7163a = -1L;
        this.b = -1L;
        this.c = -1L;
        this.d = -1L;
    }

    public void logMap(boolean z, long j, long j2) {
        this.f7163a = j;
        this.b = j2;
        if (this.d > 0) {
            a(z);
        }
    }

    public void logData(boolean z, long j, long j2) {
        this.c = j;
        this.d = j2;
        if (this.b > 0) {
            a(z);
        }
    }

    private void a(boolean z) {
        clear();
    }
}
