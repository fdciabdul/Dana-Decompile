package com.iap.ac.android.biz.common.internal.oauth.authlogin;

import android.content.Context;
import com.iap.ac.android.biz.common.base.BaseNetwork;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.rpc.facade.MobilePaymentLoginRpcFacade;
import com.iap.ac.android.biz.common.rpc.request.MobilePaymentLoginRequest;
import com.iap.ac.android.biz.common.rpc.result.MobilePaymentLoginResult;
import com.iap.ac.android.common.instance.InstanceInfo;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes3.dex */
public class AuthLoginProcessor extends BaseNetwork<MobilePaymentLoginRpcFacade> {
    public MobilePaymentLoginResult authLogin(Context context, String str) {
        MobilePaymentLoginRequest mobilePaymentLoginRequest = new MobilePaymentLoginRequest();
        mobilePaymentLoginRequest.instanceId = InstanceInfo.getInstanceId(context);
        mobilePaymentLoginRequest.authCode = str;
        ACLog.i(Constants.TAG, "startOAuthLogin begin");
        return getFacade().login(mobilePaymentLoginRequest);
    }

    @Override // com.iap.ac.android.biz.common.base.BaseNetwork
    public Class<MobilePaymentLoginRpcFacade> getFacadeClass() {
        return MobilePaymentLoginRpcFacade.class;
    }

    public MobilePaymentLoginResult rewardsAuthLogin(Context context, String str) {
        MobilePaymentLoginRequest mobilePaymentLoginRequest = new MobilePaymentLoginRequest();
        mobilePaymentLoginRequest.instanceId = InstanceInfo.getInstanceId(context);
        mobilePaymentLoginRequest.authCode = str;
        ACLog.i(Constants.TAG, "startRewardsOAuthLogin begin");
        return getFacade().rewardsLogin(mobilePaymentLoginRequest);
    }
}
