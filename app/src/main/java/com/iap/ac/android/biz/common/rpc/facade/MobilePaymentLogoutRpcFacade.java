package com.iap.ac.android.biz.common.rpc.facade;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.rpc.annotation.ACRpcRequest;
import com.iap.ac.android.biz.common.rpc.request.MobilePaymentLogoutRequest;
import com.iap.ac.android.biz.common.rpc.result.MobilePaymentLogoutResult;

/* loaded from: classes3.dex */
public interface MobilePaymentLogoutRpcFacade {
    @ACRpcRequest
    @OperationType(Constants.OperationType.LOGOUT)
    @SignCheck
    MobilePaymentLogoutResult logout(MobilePaymentLogoutRequest mobilePaymentLogoutRequest);
}
