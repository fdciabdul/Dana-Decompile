package com.iap.ac.android.mpm.oauth.agreement.source;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.iap.ac.android.biz.common.rpc.annotation.ACRpcRequest;
import com.iap.ac.android.mpm.base.model.oauth.request.ApplyAgreementAuthRequest;
import com.iap.ac.android.mpm.base.model.oauth.request.PrepareAgreementAuthRequest;
import com.iap.ac.android.mpm.base.model.oauth.result.ApplyAgreementAuthResult;
import com.iap.ac.android.mpm.base.model.oauth.result.PrepareAgreementAuthResult;

/* loaded from: classes8.dex */
public interface AgreementAuthFacade {
    @ACRpcRequest
    @OperationType("ac.mobilepayment.agreement.oauth.apply")
    @SignCheck
    ApplyAgreementAuthResult Apply(ApplyAgreementAuthRequest applyAgreementAuthRequest);

    @ACRpcRequest
    @OperationType("ac.mobilepayment.agreement.oauth.prepare")
    @SignCheck
    PrepareAgreementAuthResult prepare(PrepareAgreementAuthRequest prepareAgreementAuthRequest);
}
