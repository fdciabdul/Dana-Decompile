package com.alipay.iap.android.wallet.acl.onboarding;

/* loaded from: classes6.dex */
class PasswordLoginInfo extends LoginInfo {
    private String account;
    private String password;
    private PasswordLoginSubType subType;

    PasswordLoginInfo(String str, String str2) {
        super(LoginType.PASSWORD_LOGIN, null);
        this.account = str;
        this.password = str2;
    }

    PasswordLoginInfo(String str, String str2, PasswordLoginSubType passwordLoginSubType) {
        super(LoginType.PASSWORD_LOGIN, null);
        this.account = str;
        this.password = str2;
        this.subType = passwordLoginSubType;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public PasswordLoginSubType getSubType() {
        return this.subType;
    }

    public void setSubType(PasswordLoginSubType passwordLoginSubType) {
        this.subType = passwordLoginSubType;
    }
}
