package com.alipay.iap.android.wallet.acl.onboarding;

import com.alipay.iap.android.wallet.acl.base.BaseResult;
import java.util.Map;

/* loaded from: classes6.dex */
public class LoginResult extends BaseResult {
    private String clientKey;
    private Map<String, String> extendedInfo;
    private String sessionId;
    private String userId;

    public LoginResult(String str, String str2, String str3, Map<String, String> map) {
        this.userId = str;
        this.sessionId = str2;
        this.clientKey = str3;
        this.extendedInfo = map;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public String getClientKey() {
        return this.clientKey;
    }

    public void setClientKey(String str) {
        this.clientKey = str;
    }

    @Override // com.alipay.iap.android.wallet.acl.base.BaseResult, com.alipay.iap.android.wallet.acl.base.Result
    public Map<String, String> getExtendedInfo() {
        return this.extendedInfo;
    }

    @Override // com.alipay.iap.android.wallet.acl.base.BaseResult, com.alipay.iap.android.wallet.acl.base.Result
    public void setExtendedInfo(Map<String, String> map) {
        this.extendedInfo = map;
    }
}
