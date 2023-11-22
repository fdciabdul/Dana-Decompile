package com.iap.ac.android.biz.common.rpc.facade;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.rpc.annotation.ACRpcRequest;
import com.iap.ac.android.biz.common.rpc.request.MobilePaymentLoginRequest;
import com.iap.ac.android.biz.common.rpc.result.MobilePaymentLoginResult;

/* loaded from: classes3.dex */
public interface MobilePaymentLoginRpcFacade {
    @ACRpcRequest
    @OperationType(Constants.OperationType.AUTH_LOGIN)
    @SignCheck
    MobilePaymentLoginResult login(MobilePaymentLoginRequest mobilePaymentLoginRequest);

    @ACRpcRequest
    @OperationType(Constants.APlusRewardsOperationType.REWARDS_AUTH_LOGIN)
    @SignCheck
    MobilePaymentLoginResult rewardsLogin(MobilePaymentLoginRequest mobilePaymentLoginRequest);
}
