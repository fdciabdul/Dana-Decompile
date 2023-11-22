package com.alibaba.ariver.engine.common.extension.bind;

import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingId;

/* loaded from: classes3.dex */
public class IdBinder implements Binder<BindingId, String> {

    /* renamed from: a  reason: collision with root package name */
    private String f6042a;

    public IdBinder(String str) {
        this.f6042a = str;
    }

    @Override // com.alibaba.ariver.engine.common.extension.bind.Binder
    public String bind(Class<String> cls, BindingId bindingId) throws BindException {
        return this.f6042a;
    }
}
