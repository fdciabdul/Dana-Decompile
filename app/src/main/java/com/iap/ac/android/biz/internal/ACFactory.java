package com.iap.ac.android.biz.internal;

import com.iap.ac.android.biz.b.c;
import com.iap.ac.android.biz.b.d;

/* loaded from: classes3.dex */
public class ACFactory {
    public static IIAPConnect createIAPConnectImpl() {
        return new c();
    }

    public static IOperationManager createIAPOperationManager() {
        return new d();
    }
}
