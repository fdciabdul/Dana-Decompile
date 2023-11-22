package com.iap.ac.android.mpm.hook.source;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.rpc.annotation.ACRpcRequest;
import com.iap.ac.android.mpm.base.model.hook.request.CommonHookRequest;
import com.iap.ac.android.mpm.base.model.hook.result.CommonHookResult;

/* loaded from: classes3.dex */
public interface CommonHookFacade {
    @ACRpcRequest
    @OperationType(Constants.OperationType.COMMON_HOOK)
    @SignCheck
    CommonHookResult commonHook(CommonHookRequest commonHookRequest);
}
