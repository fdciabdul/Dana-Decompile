package com.iap.ac.android.region.cdp.rpc;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.iap.ac.android.biz.common.rpc.annotation.ACRpcRequest;
import com.iap.ac.android.region.cdp.model.request.CdpSpaceQueryRpcRequest;
import com.iap.ac.android.region.cdp.model.result.CdpSpaceQueryRpcResult;

/* loaded from: classes3.dex */
public interface CdpQueryRpcFacade {
    public static final String OPERATION_TYPE_BATCH_QUERY = "eco.region.client.cdp.batchQuery";

    @ACRpcRequest
    @OperationType(OPERATION_TYPE_BATCH_QUERY)
    @SignCheck
    CdpSpaceQueryRpcResult querySpace(CdpSpaceQueryRpcRequest cdpSpaceQueryRpcRequest);
}
