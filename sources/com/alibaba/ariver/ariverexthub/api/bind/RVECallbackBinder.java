package com.alibaba.ariver.ariverexthub.api.bind;

import com.alibaba.ariver.ariverexthub.api.annotations.BindingRVECallback;
import com.alibaba.ariver.ariverexthub.api.provider.RVEApiResponseCallback;

/* loaded from: classes3.dex */
public class RVECallbackBinder implements Binder<BindingRVECallback, RVEApiResponseCallback> {

    /* renamed from: a  reason: collision with root package name */
    private RVEApiResponseCallback f5995a;

    public RVECallbackBinder(RVEApiResponseCallback rVEApiResponseCallback) {
        this.f5995a = rVEApiResponseCallback;
    }

    @Override // com.alibaba.ariver.ariverexthub.api.bind.Binder
    public RVEApiResponseCallback bind(Class<RVEApiResponseCallback> cls, BindingRVECallback bindingRVECallback) {
        return this.f5995a;
    }
}
