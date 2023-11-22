package com.alibaba.griver.base.nebula;

import com.alibaba.griver.base.api.APWebMessagePort;

/* loaded from: classes6.dex */
public class APWebMessage {

    /* renamed from: a  reason: collision with root package name */
    private String f6320a;
    private APWebMessagePort[] b;

    public APWebMessage(String str) {
        this.f6320a = str;
    }

    public APWebMessage(String str, APWebMessagePort[] aPWebMessagePortArr) {
        this.f6320a = str;
        this.b = aPWebMessagePortArr;
    }

    public String getData() {
        return this.f6320a;
    }

    public APWebMessagePort[] getPorts() {
        return this.b;
    }
}
