package com.alipay.multigateway.sdk.decision.condition.getter.impl;

import com.alipay.imobile.network.quake.Request;
import com.alipay.mobile.common.rpc.RpcInvokeContext;
import com.alipay.multigateway.sdk.decision.condition.getter.IGetter;
import com.alipay.multigateway.sdk.util.EnvironmentUtil;

/* loaded from: classes3.dex */
public class OperationTypeGetter implements IGetter<String> {
    public static final String EXT_OPERATION_TYPE = "EXT_MG_OPERATION_TYPE";

    @Override // com.alipay.multigateway.sdk.decision.condition.getter.IGetter
    public String getValue(Object obj) {
        RpcInvokeContext rpcInvokeContext;
        if (EnvironmentUtil.isUsingQuake() && Request.class.isInstance(obj)) {
            return ((Request) obj).getActionType();
        }
        if (!EnvironmentUtil.isUsingMpaasRpc() || !RpcInvokeContext.class.isInstance(obj) || (rpcInvokeContext = (RpcInvokeContext) obj) == null || rpcInvokeContext.getExtParams() == null) {
            return null;
        }
        return (String) rpcInvokeContext.getExtParams().get(EXT_OPERATION_TYPE);
    }
}
