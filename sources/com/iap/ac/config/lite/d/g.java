package com.iap.ac.config.lite.d;

import android.content.Context;
import com.iap.ac.android.common.instance.InstanceInfo;
import com.iap.ac.config.lite.delegate.ConfigIdentifierProvider;

/* loaded from: classes3.dex */
public class g extends ConfigIdentifierProvider {
    @Override // com.iap.ac.config.lite.delegate.ConfigIdentifierProvider
    public String getUtdId(Context context) {
        return InstanceInfo.getInstanceId(context);
    }
}
