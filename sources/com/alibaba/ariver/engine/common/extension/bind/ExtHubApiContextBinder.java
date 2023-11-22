package com.alibaba.ariver.engine.common.extension.bind;

import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;

/* loaded from: classes3.dex */
public class ExtHubApiContextBinder implements Binder<BindingApiContext, ApiContext> {

    /* renamed from: a  reason: collision with root package name */
    private ApiContext f6039a;

    public ExtHubApiContextBinder(ApiContext apiContext) {
        this.f6039a = apiContext;
    }

    @Override // com.alibaba.ariver.engine.common.extension.bind.Binder
    public ApiContext bind(Class<ApiContext> cls, BindingApiContext bindingApiContext) throws BindException {
        if (bindingApiContext.required() && this.f6039a == null) {
            throw new BindException("Required ApiContext but not inject!!!");
        }
        return this.f6039a;
    }
}
