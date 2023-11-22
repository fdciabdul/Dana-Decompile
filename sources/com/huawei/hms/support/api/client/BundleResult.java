package com.huawei.hms.support.api.client;

import android.os.Bundle;

/* loaded from: classes8.dex */
public class BundleResult {

    /* renamed from: a  reason: collision with root package name */
    private int f7487a;
    private Bundle b;

    public BundleResult(int i, Bundle bundle) {
        this.f7487a = i;
        this.b = bundle;
    }

    public int getResultCode() {
        return this.f7487a;
    }

    public Bundle getRspBody() {
        return this.b;
    }

    public void setResultCode(int i) {
        this.f7487a = i;
    }

    public void setRspBody(Bundle bundle) {
        this.b = bundle;
    }
}
