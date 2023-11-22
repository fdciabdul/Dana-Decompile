package com.iap.ac.android.mpm.base.model.payment.request;

import com.iap.ac.android.rpccommon.model.domain.request.BaseRpcRequest;
import java.util.Map;

/* loaded from: classes3.dex */
public class SwapOrderRequest extends BaseRpcRequest {
    public String acquirerId;
    public Map<String, String> acquirerOrderExtendInfo;
    public String acquirerTradeNo;
}
