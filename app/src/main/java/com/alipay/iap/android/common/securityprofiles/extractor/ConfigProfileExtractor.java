package com.alipay.iap.android.common.securityprofiles.extractor;

import android.content.Context;
import com.alipay.iap.android.common.securityprofiles.provider.ConfigProfileProvider;
import com.alipay.iap.android.common.securityprofiles.provider.ProfileProvider;

/* loaded from: classes6.dex */
public class ConfigProfileExtractor extends ProfileExtractor {
    private String mProfileJson;

    public ConfigProfileExtractor(Context context, String str, String str2) {
        super(context, str);
        this.mProfileJson = str2;
    }

    @Override // com.alipay.iap.android.common.securityprofiles.extractor.ProfileExtractor
    protected ProfileProvider createProfileProvider() {
        return new ConfigProfileProvider(this.mProfileJson);
    }
}
