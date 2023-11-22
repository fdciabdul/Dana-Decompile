package com.alibaba.ariver.engine.common.extension.bind;

import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes3.dex */
public class RequestBinder<T> implements Binder<BindingRequest, T> {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f6045a;

    public RequestBinder(JSONObject jSONObject) {
        this.f6045a = jSONObject;
    }

    @Override // com.alibaba.ariver.engine.common.extension.bind.Binder
    public T bind(Class<T> cls, BindingRequest bindingRequest) throws BindException {
        JSONObject jSONObject = this.f6045a;
        if (jSONObject == null) {
            throw new BindException("input JSON is null");
        }
        try {
            return (T) JSON.toJavaObject(jSONObject, cls);
        } catch (Throwable th) {
            throw new BindException(th.getMessage());
        }
    }
}
