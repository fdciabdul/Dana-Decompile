package com.alibaba.ariver.ariverexthub.api.bind;

import com.alibaba.ariver.ariverexthub.api.RVEContext;
import com.alibaba.ariver.ariverexthub.api.annotations.BindingRVEContext;

/* loaded from: classes3.dex */
public class RVEContextBinder implements Binder<BindingRVEContext, RVEContext> {

    /* renamed from: a  reason: collision with root package name */
    private RVEContext f5996a;

    public RVEContextBinder(RVEContext rVEContext) {
        this.f5996a = rVEContext;
    }

    @Override // com.alibaba.ariver.ariverexthub.api.bind.Binder
    public RVEContext bind(Class<RVEContext> cls, BindingRVEContext bindingRVEContext) {
        return this.f5996a;
    }
}
