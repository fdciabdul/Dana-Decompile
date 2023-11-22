package com.iap.ac.android.biz;

import com.iap.ac.android.biz.c.b;
import com.iap.ac.android.biz.cpm.CpmManager;
import com.iap.ac.android.biz.cpm.CpmOption;

/* loaded from: classes8.dex */
public class IAPConnectClient {
    public static b mImpl = new b();

    public static CpmManager getCpmManager(CpmOption cpmOption) {
        return mImpl.a(cpmOption);
    }
}
