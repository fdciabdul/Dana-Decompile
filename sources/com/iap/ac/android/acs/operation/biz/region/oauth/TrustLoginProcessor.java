package com.iap.ac.android.acs.operation.biz.region.oauth;

import com.iap.ac.android.acs.operation.biz.region.bean.TrustLoginRequest;
import com.iap.ac.android.acs.operation.biz.region.bean.TrustLoginResult;
import com.iap.ac.android.biz.common.base.BaseNetwork;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes3.dex */
public class TrustLoginProcessor extends BaseNetwork<OAuthFacade> {
    @Override // com.iap.ac.android.biz.common.base.BaseNetwork
    public String getBizCode() {
        return "region_biz";
    }

    @Override // com.iap.ac.android.biz.common.base.BaseNetwork
    public Class<OAuthFacade> getFacadeClass() {
        return OAuthFacade.class;
    }

    public TrustLoginResult trustLogin(String str, String str2) {
        try {
            TrustLoginRequest trustLoginRequest = new TrustLoginRequest();
            trustLoginRequest.deviceId = str2;
            trustLoginRequest.clientUserId = str;
            OAuthFacade facade = getFacade();
            if (facade == null) {
                ACLog.e("IAPConnectPlugin", "do not implementation network proxy spi");
                return null;
            }
            return facade.trustLogin(trustLoginRequest);
        } catch (Exception e) {
            ACLog.e("IAPConnectPlugin", e.getMessage());
            return null;
        }
    }
}
