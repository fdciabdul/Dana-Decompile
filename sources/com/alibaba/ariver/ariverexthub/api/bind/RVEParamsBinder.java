package com.alibaba.ariver.ariverexthub.api.bind;

import com.alibaba.ariver.ariverexthub.api.annotations.BindingRVEParams;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes3.dex */
public class RVEParamsBinder implements Binder<BindingRVEParams, JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f5999a;

    public RVEParamsBinder(JSONObject jSONObject) {
        this.f5999a = jSONObject;
    }

    @Override // com.alibaba.ariver.ariverexthub.api.bind.Binder
    public JSONObject bind(Class<JSONObject> cls, BindingRVEParams bindingRVEParams) {
        return this.f5999a;
    }
}
