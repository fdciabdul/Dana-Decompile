package com.iap.ac.android.biz.common.rpc.facade;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.rpc.annotation.ACRpcRequest;
import com.iap.ac.android.biz.common.rpc.request.MobilePaymentFetchConfigsRequest;
import com.iap.ac.android.biz.common.rpc.result.MobilePaymentFetchConfigsResult;

/* loaded from: classes3.dex */
public interface MobilePaymentConfigRpcFacade {
    @ACRpcRequest
    @OperationType(Constants.OperationType.FETCH_CONFIG)
    @SignCheck
    MobilePaymentFetchConfigsResult fetchConfigs(MobilePaymentFetchConfigsRequest mobilePaymentFetchConfigsRequest);
}
