package com.alipay.iap.android.aplog.core.layout.mas;

import com.alipay.iap.android.aplog.log.BaseLogInfo;

/* loaded from: classes.dex */
public interface MasLog<T extends BaseLogInfo> {

    /* loaded from: classes6.dex */
    public interface Constant {
        public static final String GAP = "$$";
        public static final int HIT_RATE = 1000;
        public static final String LOG_VERSION = "2";
    }

    String getLayout(T t);
}
