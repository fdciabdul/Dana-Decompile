package com.alipay.iap.android.wallet.acl.base;

import com.alipay.iap.android.wallet.acl.base.Result;

/* loaded from: classes.dex */
public interface Callback<T extends Result> {
    void result(T t);
}
