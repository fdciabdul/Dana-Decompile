package com.alibaba.ariver.ariverexthub.api.bind;

import com.alibaba.ariver.ariverexthub.api.annotations.BindingRVEHost;

/* loaded from: classes3.dex */
public class RVEHostBinder implements Binder<BindingRVEHost, String> {

    /* renamed from: a  reason: collision with root package name */
    private String f5998a;

    public RVEHostBinder(String str) {
        this.f5998a = str;
    }

    @Override // com.alibaba.ariver.ariverexthub.api.bind.Binder
    public String bind(Class<String> cls, BindingRVEHost bindingRVEHost) {
        return this.f5998a;
    }
}
