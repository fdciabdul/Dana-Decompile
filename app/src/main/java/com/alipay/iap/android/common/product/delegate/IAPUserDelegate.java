package com.alipay.iap.android.common.product.delegate;

/* loaded from: classes.dex */
public interface IAPUserDelegate {
    void addUserChangeObserver(IAPUserChangeObserver iAPUserChangeObserver);

    boolean checkPermission();

    String getLoginId();

    String getUserId();

    IAPLoginUserInfo getUserInfo();

    void removeUserChangeObserver(IAPUserChangeObserver iAPUserChangeObserver);
}
