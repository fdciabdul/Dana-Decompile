package com.iap.ac.android.biz.common.rpc.facade;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.rpc.annotation.ACRpcRequest;
import com.iap.ac.android.biz.common.rpc.request.MobilePaymentHoldLoginRequest;
import com.iap.ac.android.biz.common.rpc.result.MobilePaymentHoldLoginResult;

/* loaded from: classes3.dex */
public interface MobilePaymentHoldLoginRpcFacade {
    @ACRpcRequest
    @OperationType(Constants.OperationType.HOLD_LOGIN)
    @SignCheck
    MobilePaymentHoldLoginResult holdLogin(MobilePaymentHoldLoginRequest mobilePaymentHoldLoginRequest);

    @ACRpcRequest
    @OperationType(Constants.APlusRewardsOperationType.REWARDS_HOLD_LOGIN)
    @SignCheck
    MobilePaymentHoldLoginResult rewardsHoldLogin(MobilePaymentHoldLoginRequest mobilePaymentHoldLoginRequest);
}
