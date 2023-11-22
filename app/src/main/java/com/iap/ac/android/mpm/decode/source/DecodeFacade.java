package com.iap.ac.android.mpm.decode.source;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.rpc.annotation.ACRpcRequest;
import com.iap.ac.android.mpm.base.model.decode.request.DecodeRequest;
import com.iap.ac.android.mpm.base.model.decode.result.DecodeResult;

/* loaded from: classes3.dex */
public interface DecodeFacade {
    @ACRpcRequest
    @OperationType(Constants.OperationType.CODE_SCAN)
    @SignCheck
    DecodeResult decode(DecodeRequest decodeRequest);
}
