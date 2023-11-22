package com.iap.ac.android.acs.operation.biz.region.oauth;

import com.iap.ac.android.acs.operation.biz.region.bean.LogoutRequest;
import com.iap.ac.android.acs.operation.biz.region.bean.LogoutResult;
import com.iap.ac.android.biz.common.base.BaseNetwork;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes3.dex */
public class LogoutProcessor extends BaseNetwork<OAuthFacade> {
    @Override // com.iap.ac.android.biz.common.base.BaseNetwork
    public String getBizCode() {
        return "region_biz";
    }

    @Override // com.iap.ac.android.biz.common.base.BaseNetwork
    public Class<OAuthFacade> getFacadeClass() {
        return OAuthFacade.class;
    }

    public LogoutResult logout(String str, String str2) {
        try {
            LogoutRequest logoutRequest = new LogoutRequest();
            logoutRequest.deviceId = str2;
            logoutRequest.sessionId = str;
            OAuthFacade facade = getFacade();
            if (facade == null) {
                ACLog.e(Constants.TAG, "do not implementation network proxy spi");
                return null;
            }
            return facade.logout(logoutRequest);
        } catch (Exception e) {
            ACLog.e(Constants.TAG, e.getMessage());
            return null;
        }
    }
}
