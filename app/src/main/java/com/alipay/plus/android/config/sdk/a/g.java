package com.alipay.plus.android.config.sdk.a;

import android.content.Context;
import com.alipay.plus.android.config.sdk.delegate.ConfigIdentifierProvider;
import com.ta.utdid2.device.UTDevice;

/* loaded from: classes7.dex */
public class g extends ConfigIdentifierProvider {
    @Override // com.alipay.plus.android.config.sdk.delegate.ConfigIdentifierProvider
    public String getUtdId(Context context) {
        return UTDevice.getUtdid(context);
    }
}
