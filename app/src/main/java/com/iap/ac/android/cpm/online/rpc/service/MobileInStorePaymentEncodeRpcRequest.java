package com.iap.ac.android.cpm.online.rpc.service;

import com.iap.ac.android.cpm.online.rpc.model.MobileInStorePaymentInitInfo;
import com.iap.ac.android.rpccommon.model.domain.request.BaseRpcRequest;

/* loaded from: classes8.dex */
public class MobileInStorePaymentEncodeRpcRequest extends BaseRpcRequest {
    public int batchCount;
    public String codeType;
    public int generateInterval;
    public MobileInStorePaymentInitInfo mobileInStorePaymentInitInfo;
    public String region;
}
