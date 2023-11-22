package com.alibaba.ariver.ariverexthub.api.bind;

import android.os.Bundle;
import com.alibaba.ariver.ariverexthub.api.annotations.BindingRVEExtParams;

/* loaded from: classes3.dex */
public class RVEExtParamsBinder implements Binder<BindingRVEExtParams, Bundle> {

    /* renamed from: a  reason: collision with root package name */
    private Bundle f5997a;

    public RVEExtParamsBinder(Bundle bundle) {
        this.f5997a = bundle;
    }

    @Override // com.alibaba.ariver.ariverexthub.api.bind.Binder
    public Bundle bind(Class<Bundle> cls, BindingRVEExtParams bindingRVEExtParams) {
        return this.f5997a;
    }
}
