package com.iap.ac.android.cpm.online.rpc.facade;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.rpc.annotation.ACRpcRequest;
import com.iap.ac.android.cpm.online.rpc.service.MobileInStorePaymentEncodeRpcRequest;
import com.iap.ac.android.cpm.online.rpc.service.MobileInStorePaymentEncodeRpcResult;

/* loaded from: classes8.dex */
public interface MobileInStorePaymentEncodeRpcFacade {
    @ACRpcRequest
    @OperationType(Constants.OperationType.CPM_ENCODE)
    @SignCheck
    MobileInStorePaymentEncodeRpcResult encode(MobileInStorePaymentEncodeRpcRequest mobileInStorePaymentEncodeRpcRequest);
}
