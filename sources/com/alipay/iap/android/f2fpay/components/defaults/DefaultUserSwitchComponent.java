package com.alipay.iap.android.f2fpay.components.defaults;

import android.text.TextUtils;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.product.delegate.IAPLoginUserInfo;
import com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver;
import com.alipay.iap.android.common.product.delegate.IAPUserDelegate;
import com.alipay.iap.android.f2fpay.client.IF2FPayClient;
import com.alipay.iap.android.f2fpay.common.F2FPayConstants;
import com.alipay.iap.android.f2fpay.components.IF2FPayInitializeComponent;
import com.alipay.iap.android.f2fpay.components.IF2FPayOpenComponent;
import com.alipay.iap.android.f2fpay.components.IF2FPayUserSwitchComponent;

/* loaded from: classes3.dex */
public class DefaultUserSwitchComponent extends DefaultBaseComponent implements IAPUserChangeObserver, IF2FPayUserSwitchComponent {
    protected String mCurrentF2FPayUserId;

    private String a(IAPLoginUserInfo iAPLoginUserInfo) {
        if (iAPLoginUserInfo != null) {
            return iAPLoginUserInfo.userID;
        }
        return null;
    }

    private void a(String str) {
        ((IF2FPayInitializeComponent) getComponent(IF2FPayInitializeComponent.class)).clearOtpInfo();
        setCurrentF2FPayUserId(str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        IF2FPayOpenComponent iF2FPayOpenComponent = (IF2FPayOpenComponent) getComponent(IF2FPayOpenComponent.class);
        if (iF2FPayOpenComponent != null) {
            iF2FPayOpenComponent.setLocalOpenFlag(false);
            iF2FPayOpenComponent.checkOpen();
            return;
        }
        LoggerWrapper.w(F2FPayConstants.TAG, "open component is null, init directly");
        IF2FPayInitializeComponent iF2FPayInitializeComponent = (IF2FPayInitializeComponent) getComponent(IF2FPayInitializeComponent.class);
        if (iF2FPayInitializeComponent == null) {
            LoggerWrapper.e(F2FPayConstants.TAG, "initializeComponent is null, cannot init otp seed");
        } else {
            iF2FPayInitializeComponent.asyncInitializeOtpInfo();
        }
    }

    private boolean b(IAPLoginUserInfo iAPLoginUserInfo) {
        return (iAPLoginUserInfo == null || TextUtils.isEmpty(iAPLoginUserInfo.userID) || !TextUtils.equals(iAPLoginUserInfo.userID, this.mCurrentF2FPayUserId)) ? false : true;
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayUserSwitchComponent
    public String getCurrentF2FPayUserId() {
        return this.mCurrentF2FPayUserId;
    }

    @Override // com.alipay.iap.android.f2fpay.components.defaults.DefaultBaseComponent, com.alipay.iap.android.f2fpay.components.IF2FPayBaseComponent
    public void initialize(IF2FPayClient iF2FPayClient) {
        super.initialize(iF2FPayClient);
        IAPUserDelegate userDelegate = getUserDelegate();
        String userId = userDelegate.getUserId();
        StringBuilder sb = new StringBuilder();
        sb.append("initialize. userId = ");
        sb.append(userId);
        LoggerWrapper.d(F2FPayConstants.TAG, sb.toString());
        setCurrentF2FPayUserId(userId);
        userDelegate.addUserChangeObserver(this);
    }

    public void onDestroy() {
        getUserDelegate().removeUserChangeObserver(this);
    }

    @Override // com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver
    public void onUserChanged(IAPLoginUserInfo iAPLoginUserInfo) {
        LoggerWrapper.d(F2FPayConstants.TAG, String.format("onUserChanged. oldUserId = %s, newUserId = %s", this.mCurrentF2FPayUserId, a(iAPLoginUserInfo)));
        if (b(iAPLoginUserInfo)) {
            return;
        }
        a(iAPLoginUserInfo.userID);
    }

    @Override // com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver
    public void onUserLogin(IAPLoginUserInfo iAPLoginUserInfo) {
        LoggerWrapper.d(F2FPayConstants.TAG, String.format("onUserLogin. oldUserId = %s, newUserId = %s", this.mCurrentF2FPayUserId, a(iAPLoginUserInfo)));
        if (b(iAPLoginUserInfo)) {
            return;
        }
        a(iAPLoginUserInfo.userID);
    }

    @Override // com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver
    public void onUserLogout() {
        LoggerWrapper.d(F2FPayConstants.TAG, String.format("onUserLogin. oldUserId = %s, newUserId = null", this.mCurrentF2FPayUserId));
        a((String) null);
    }

    public void setCurrentF2FPayUserId(String str) {
        LoggerWrapper.d(F2FPayConstants.TAG, String.format("setCurrentF2FPayUserId. oldUserId = %s, newUserId = %s", this.mCurrentF2FPayUserId, str));
        this.mCurrentF2FPayUserId = str;
    }
}
