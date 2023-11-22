package com.alipay.iap.android.f2fpay.extension.impl;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.iap.android.common.utils.DeviceUtils;
import com.alipay.iap.android.f2fpay.extension.IF2FPayDeviceIdGenerator;
import java.util.UUID;

/* loaded from: classes6.dex */
public class DefaultDeviceIdGeneratorImpl implements IF2FPayDeviceIdGenerator {

    /* renamed from: a  reason: collision with root package name */
    private String f6964a;

    @Override // com.alipay.iap.android.f2fpay.extension.IF2FPayDeviceIdGenerator
    public String generateDeviceId(Context context) {
        if (TextUtils.isEmpty(this.f6964a)) {
            String deviceId = DeviceUtils.getDeviceId(context);
            this.f6964a = deviceId;
            if (TextUtils.isEmpty(deviceId)) {
                this.f6964a = UUID.randomUUID().toString();
            }
        }
        return this.f6964a;
    }
}
