package com.iap.ac.android.rpc.multigateway;

import com.alipay.multigateway.sdk.decision.condition.getter.IGetter;
import com.iap.ac.android.common.rpc.RpcRequest;

/* loaded from: classes3.dex */
public class RpcOperationTypeGetter implements IGetter {
    @Override // com.alipay.multigateway.sdk.decision.condition.getter.IGetter
    public String getValue(Object obj) {
        if (obj instanceof RpcRequest) {
            return ((RpcRequest) obj).operationType;
        }
        return null;
    }
}
