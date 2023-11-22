package com.alipay.iap.android.common.securityprofiles.provider;

import android.content.Context;
import com.alipay.iap.android.common.securityprofiles.utils.SecurityProfileUtils;

/* loaded from: classes3.dex */
public class SecurityGuardProfileProvider implements ProfileProvider {
    private static final String TAG = "SecurityGuardProfileProvider";
    private String mAuthCode;

    public SecurityGuardProfileProvider(String str) {
        this.mAuthCode = str;
    }

    @Override // com.alipay.iap.android.common.securityprofiles.provider.ProfileProvider
    public String getProfileData(Context context, String str) {
        return SecurityProfileUtils.getSecurityExtraData(context, this.mAuthCode, str);
    }
}
