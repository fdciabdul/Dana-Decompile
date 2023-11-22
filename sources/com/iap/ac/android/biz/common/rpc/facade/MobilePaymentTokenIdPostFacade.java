package com.iap.ac.android.biz.common.rpc.facade;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.rpc.annotation.ACRpcRequest;
import com.iap.ac.android.biz.common.rpc.request.MobilePaymentTokenIdPostRequest;
import com.iap.ac.android.biz.common.rpc.result.MobilePaymentTokenIdPostResult;

/* loaded from: classes8.dex */
public interface MobilePaymentTokenIdPostFacade {
    @ACRpcRequest
    @OperationType(Constants.OperationType.TOKEN_ID_POST)
    @SignCheck
    MobilePaymentTokenIdPostResult reportTokenId(MobilePaymentTokenIdPostRequest mobilePaymentTokenIdPostRequest);
}
