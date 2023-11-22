package com.alipay.iap.android.common.securityprofiles.extractor;

import android.content.Context;
import com.alipay.iap.android.common.securityprofiles.provider.ProfileProvider;
import com.alipay.iap.android.common.securityprofiles.provider.SecurityGuardProfileProvider;

/* loaded from: classes3.dex */
public class SecurityProfileExtractor extends ProfileExtractor {
    public SecurityProfileExtractor(Context context, String str) {
        super(context, str);
    }

    @Override // com.alipay.iap.android.common.securityprofiles.extractor.ProfileExtractor
    protected ProfileProvider createProfileProvider() {
        return new SecurityGuardProfileProvider(this.mAuthCode);
    }
}
