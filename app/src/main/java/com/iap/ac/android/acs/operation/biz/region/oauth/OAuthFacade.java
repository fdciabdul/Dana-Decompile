package com.iap.ac.android.acs.operation.biz.region.oauth;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.iap.ac.android.acs.operation.biz.region.RegionConstants;
import com.iap.ac.android.acs.operation.biz.region.bean.LogoutRequest;
import com.iap.ac.android.acs.operation.biz.region.bean.LogoutResult;
import com.iap.ac.android.acs.operation.biz.region.bean.TrustLoginRequest;
import com.iap.ac.android.acs.operation.biz.region.bean.TrustLoginResult;
import com.iap.ac.android.biz.common.rpc.annotation.ACRpcRequest;

/* loaded from: classes3.dex */
public interface OAuthFacade {
    @ACRpcRequest
    @OperationType(RegionConstants.LOGOUT)
    @SignCheck
    LogoutResult logout(LogoutRequest logoutRequest);

    @ACRpcRequest
    @OperationType(RegionConstants.TRUST_LOGIN)
    @SignCheck
    TrustLoginResult trustLogin(TrustLoginRequest trustLoginRequest);
}
