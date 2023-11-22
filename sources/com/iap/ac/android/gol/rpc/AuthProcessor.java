package com.iap.ac.android.gol.rpc;

import com.iap.ac.android.biz.common.base.BaseNetwork;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.gol.rpc.facade.AuthFacade;
import com.iap.ac.android.gol.rpc.request.AuthPrepareCallbackRequest;
import com.iap.ac.android.gol.rpc.request.AuthPrepareRequest;
import com.iap.ac.android.gol.rpc.result.AuthPrepareCallbackResult;
import com.iap.ac.android.gol.rpc.result.AuthPrepareResult;

/* loaded from: classes3.dex */
public class AuthProcessor extends BaseNetwork<AuthFacade> {
    private static final String TAG = "AuthProcessor";

    @Override // com.iap.ac.android.biz.common.base.BaseNetwork
    public Class<AuthFacade> getFacadeClass() {
        return AuthFacade.class;
    }

    public AuthPrepareCallbackResult prepareCallback(AuthPrepareCallbackRequest authPrepareCallbackRequest) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("prepareCallback method invoke error: getFacade()==null");
            sb.append(getFacade() != null);
            ACLog.e(TAG, sb.toString());
            return getFacade().prepareCallback(authPrepareCallbackRequest);
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("prepareCallback method invoke error:");
            sb2.append(th.getMessage());
            ACLog.e(TAG, sb2.toString());
            return null;
        }
    }

    public AuthPrepareResult prepare(AuthPrepareRequest authPrepareRequest) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("prepare method invoke error: getFacade()==null");
            sb.append(getFacade() != null);
            ACLog.e(TAG, sb.toString());
            return getFacade().prepare(authPrepareRequest);
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("prepare method invoke error:");
            sb2.append(th.getMessage());
            ACLog.e(TAG, sb2.toString());
            return null;
        }
    }
}
