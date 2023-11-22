package com.alibaba.wireless.security.open.litevm;

import com.alibaba.wireless.security.open.litevm.LiteVMParamType;

/* loaded from: classes6.dex */
public class LiteVMParameterWrapper {

    /* renamed from: a  reason: collision with root package name */
    private LiteVMParamType.PARAM_TYPE f6816a;
    private Object b;

    public LiteVMParameterWrapper(LiteVMParamType.PARAM_TYPE param_type, Object obj) {
        this.f6816a = param_type;
        this.b = obj;
    }

    public int getType() {
        return this.f6816a.getValue();
    }

    public Object getValue() {
        return this.b;
    }
}
