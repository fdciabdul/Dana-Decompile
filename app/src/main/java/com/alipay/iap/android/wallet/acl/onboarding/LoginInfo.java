package com.alipay.iap.android.wallet.acl.onboarding;

import java.util.Map;

/* loaded from: classes6.dex */
class LoginInfo {
    private Map<String, String> extendedInfo;
    private LoginType loginType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoginInfo(LoginType loginType, Map<String, String> map) {
        this.loginType = loginType;
        this.extendedInfo = map;
    }

    public LoginType getLoginType() {
        return this.loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public Map<String, String> getExtendedInfo() {
        return this.extendedInfo;
    }

    public void setExtendedInfo(Map<String, String> map) {
        this.extendedInfo = map;
    }
}
