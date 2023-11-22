package com.iap.ac.android.gol.rpc.facade;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.rpc.annotation.ACRpcRequest;
import com.iap.ac.android.gol.rpc.request.AuthPrepareCallbackRequest;
import com.iap.ac.android.gol.rpc.request.AuthPrepareRequest;
import com.iap.ac.android.gol.rpc.result.AuthPrepareCallbackResult;
import com.iap.ac.android.gol.rpc.result.AuthPrepareResult;

/* loaded from: classes3.dex */
public interface AuthFacade {
    @ACRpcRequest
    @OperationType(Constants.OperationType.OAUTH_PREPARE)
    @SignCheck
    AuthPrepareResult prepare(AuthPrepareRequest authPrepareRequest);

    @ACRpcRequest
    @OperationType(Constants.OperationType.OAUTH_PREPARE_CALLBACK)
    @SignCheck
    AuthPrepareCallbackResult prepareCallback(AuthPrepareCallbackRequest authPrepareCallbackRequest);
}
