package com.iap.ac.android.gol.google.model;

import com.iap.ac.android.biz.common.internal.config.utils.ConfigUtils;

/* loaded from: classes8.dex */
public class AuthenticationResult {
    public String extendInfo;
    public MerchantAuthenticationResult merchantAuthenticationResponse;
    public String state;

    public String getAuthUrl() {
        AuthenticationExtendInfo authenticationExtendInfo;
        String str = this.extendInfo;
        if (str == null || (authenticationExtendInfo = (AuthenticationExtendInfo) ConfigUtils.fromJson(str, AuthenticationExtendInfo.class)) == null) {
            return null;
        }
        return authenticationExtendInfo.authUrl;
    }
}
