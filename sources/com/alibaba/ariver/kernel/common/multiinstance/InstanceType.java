package com.alibaba.ariver.kernel.common.multiinstance;

import com.alibaba.ariver.kernel.RVParams;

/* loaded from: classes3.dex */
public enum InstanceType {
    ALIPAY(RVParams.ANTI_PHISHING),
    TAOBAO(RVParams.SMART_TOOLBAR);

    private String value;

    InstanceType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
