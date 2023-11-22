package com.iap.ac.android.mpm.oauth.agreement.source;

import com.iap.ac.android.biz.common.base.BaseNetwork;
import com.iap.ac.android.mpm.base.model.oauth.request.ApplyAgreementAuthRequest;
import com.iap.ac.android.mpm.base.model.oauth.request.PrepareAgreementAuthRequest;
import com.iap.ac.android.mpm.base.model.oauth.result.ApplyAgreementAuthResult;
import com.iap.ac.android.mpm.base.model.oauth.result.PrepareAgreementAuthResult;

/* loaded from: classes8.dex */
public class AgreementAuthEntityData extends BaseNetwork<AgreementAuthFacade> {
    @Override // com.iap.ac.android.biz.common.base.BaseNetwork
    public Class<AgreementAuthFacade> getFacadeClass() {
        return AgreementAuthFacade.class;
    }

    public PrepareAgreementAuthResult prepare(String str, String str2) throws Exception {
        final PrepareAgreementAuthRequest prepareAgreementAuthRequest = new PrepareAgreementAuthRequest();
        prepareAgreementAuthRequest.appId = str;
        prepareAgreementAuthRequest.signStr = str2;
        return (PrepareAgreementAuthResult) wrapper(new BaseNetwork.FacadeProcessor<AgreementAuthFacade, PrepareAgreementAuthResult>() { // from class: com.iap.ac.android.mpm.oauth.agreement.source.AgreementAuthEntityData.1
            @Override // com.iap.ac.android.biz.common.base.BaseNetwork.FacadeProcessor
            public PrepareAgreementAuthResult processFacade(AgreementAuthFacade agreementAuthFacade) {
                return ((AgreementAuthFacade) AgreementAuthEntityData.this.getFacade()).prepare(prepareAgreementAuthRequest);
            }
        });
    }

    public ApplyAgreementAuthResult Apply(String str, String str2) throws Exception {
        final ApplyAgreementAuthRequest applyAgreementAuthRequest = new ApplyAgreementAuthRequest();
        applyAgreementAuthRequest.authCode = str;
        applyAgreementAuthRequest.state = str2;
        return (ApplyAgreementAuthResult) wrapper(new BaseNetwork.FacadeProcessor<AgreementAuthFacade, ApplyAgreementAuthResult>() { // from class: com.iap.ac.android.mpm.oauth.agreement.source.AgreementAuthEntityData.2
            @Override // com.iap.ac.android.biz.common.base.BaseNetwork.FacadeProcessor
            public ApplyAgreementAuthResult processFacade(AgreementAuthFacade agreementAuthFacade) {
                return ((AgreementAuthFacade) AgreementAuthEntityData.this.getFacade()).Apply(applyAgreementAuthRequest);
            }
        });
    }
}
