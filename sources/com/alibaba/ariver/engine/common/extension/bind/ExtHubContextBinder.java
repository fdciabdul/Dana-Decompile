package com.alibaba.ariver.engine.common.extension.bind;

import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindExtHubContext;
import com.alibaba.exthub.base.ExtHubContext;

/* loaded from: classes3.dex */
public class ExtHubContextBinder implements Binder<BindExtHubContext, ExtHubContext> {

    /* renamed from: a  reason: collision with root package name */
    private ExtHubContext f6040a;

    public ExtHubContextBinder(ExtHubContext extHubContext) {
        this.f6040a = extHubContext;
    }

    @Override // com.alibaba.ariver.engine.common.extension.bind.Binder
    public ExtHubContext bind(Class<ExtHubContext> cls, BindExtHubContext bindExtHubContext) throws BindException {
        if (bindExtHubContext.required() && this.f6040a == null) {
            throw new BindException("Required ExtHubContext but not inject!!!");
        }
        return this.f6040a;
    }
}
