package com.iap.ac.android.biz.common.internal.config.processor;

import com.iap.ac.android.biz.common.base.BaseNetwork;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.rpc.facade.MobilePaymentConfigRpcFacade;
import com.iap.ac.android.biz.common.rpc.request.MobilePaymentFetchConfigsRequest;
import com.iap.ac.android.biz.common.rpc.result.MobilePaymentFetchConfigsResult;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes3.dex */
public class RemoteConfigProcessor extends BaseNetwork<MobilePaymentConfigRpcFacade> {
    public MobilePaymentFetchConfigsResult fetchRemoteConfigsInWorker() {
        try {
            return getFacade().fetchConfigs(new MobilePaymentFetchConfigsRequest());
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("RemoteConfigProcessor, fetchConfig exception: ");
            sb.append(th);
            ACLog.e(Constants.TAG, sb.toString());
            return null;
        }
    }

    @Override // com.iap.ac.android.biz.common.base.BaseNetwork
    public Class<MobilePaymentConfigRpcFacade> getFacadeClass() {
        return MobilePaymentConfigRpcFacade.class;
    }
}
