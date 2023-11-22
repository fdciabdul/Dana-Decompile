package com.iap.ac.android.bscanc.b;

import com.alipay.mobile.common.rpc.RpcException;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.base.BaseNetwork;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.cpm.online.rpc.facade.MobileInStorePaymentEncodeRpcFacade;
import com.iap.ac.android.cpm.online.rpc.model.MobileInStorePaymentInitInfo;
import com.iap.ac.android.cpm.online.rpc.service.MobileInStorePaymentEncodeRpcRequest;
import com.iap.ac.android.cpm.online.rpc.service.MobileInStorePaymentEncodeRpcResult;

/* loaded from: classes8.dex */
public class a extends BaseNetwork<MobileInStorePaymentEncodeRpcFacade> {
    public MobileInStorePaymentEncodeRpcResult a(int i, String str, int i2, String str2) throws RpcException {
        try {
            MobileInStorePaymentEncodeRpcRequest mobileInStorePaymentEncodeRpcRequest = new MobileInStorePaymentEncodeRpcRequest();
            MobileInStorePaymentInitInfo mobileInStorePaymentInitInfo = new MobileInStorePaymentInitInfo();
            mobileInStorePaymentInitInfo.tid = ACManager.getInstance().getTid();
            mobileInStorePaymentEncodeRpcRequest.batchCount = i;
            mobileInStorePaymentEncodeRpcRequest.codeType = str;
            mobileInStorePaymentEncodeRpcRequest.generateInterval = i2;
            if (!ConfigCenter.INSTANCE.getRegionCodeToggle()) {
                str2 = null;
            }
            mobileInStorePaymentEncodeRpcRequest.region = str2;
            mobileInStorePaymentEncodeRpcRequest.mobileInStorePaymentInitInfo = mobileInStorePaymentInitInfo;
            return getFacade().encode(mobileInStorePaymentEncodeRpcRequest);
        } catch (Throwable th) {
            if (th instanceof RpcException) {
                throw th;
            }
            throw new RpcException((Integer) 5000, (Throwable) th);
        }
    }

    @Override // com.iap.ac.android.biz.common.base.BaseNetwork
    public Class<MobileInStorePaymentEncodeRpcFacade> getFacadeClass() {
        return MobileInStorePaymentEncodeRpcFacade.class;
    }
}
