package com.alipay.iap.android.common.product.delegate;

/* loaded from: classes.dex */
public interface IAPUserChangeObserver {
    void onUserChanged(IAPLoginUserInfo iAPLoginUserInfo);

    void onUserLogin(IAPLoginUserInfo iAPLoginUserInfo);

    void onUserLogout();
}
