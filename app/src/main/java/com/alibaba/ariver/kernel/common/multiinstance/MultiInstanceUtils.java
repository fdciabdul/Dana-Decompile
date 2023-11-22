package com.alibaba.ariver.kernel.common.multiinstance;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes3.dex */
public class MultiInstanceUtils {

    /* renamed from: a  reason: collision with root package name */
    private static InstanceType f6144a;

    public static InstanceType getInstanceTypeFromParam(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String string = jSONObject.getString("platformType");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        for (InstanceType instanceType : InstanceType.values()) {
            if (string.equalsIgnoreCase(instanceType.getValue())) {
                return instanceType;
            }
        }
        return null;
    }

    public static InstanceType getInstanceTypeFromParam(Bundle bundle) {
        if (bundle == null) {
            return getDefaultInstanceType();
        }
        String string = bundle.getString("_mp_code");
        if (TextUtils.isEmpty(string)) {
            return getDefaultInstanceType();
        }
        for (InstanceType instanceType : InstanceType.values()) {
            if (string.equalsIgnoreCase(instanceType.getValue())) {
                return instanceType;
            }
        }
        return getDefaultInstanceType();
    }

    public static InstanceType getDefaultInstanceType() {
        if (f6144a == null) {
            String defaultPlatform = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).defaultPlatform();
            if ("AP".equals(defaultPlatform)) {
                f6144a = InstanceType.ALIPAY;
            } else if ("TB".equals(defaultPlatform)) {
                f6144a = InstanceType.TAOBAO;
            } else {
                return InstanceType.ALIPAY;
            }
        }
        return f6144a;
    }
}
