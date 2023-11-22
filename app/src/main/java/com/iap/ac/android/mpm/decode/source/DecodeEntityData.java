package com.iap.ac.android.mpm.decode.source;

import com.iap.ac.android.biz.common.base.BaseNetwork;
import com.iap.ac.android.biz.common.constants.ACConstants;
import com.iap.ac.android.mpm.base.model.decode.request.DecodeRequest;
import com.iap.ac.android.mpm.base.model.decode.result.DecodeResult;
import com.iap.ac.android.rpccommon.model.facade.MobileEnvInfo;

/* loaded from: classes3.dex */
public class DecodeEntityData extends BaseNetwork<DecodeFacade> {
    @Override // com.iap.ac.android.biz.common.base.BaseNetwork
    public Class<DecodeFacade> getFacadeClass() {
        return DecodeFacade.class;
    }

    public DecodeResult decode(String str, boolean z) throws Exception {
        final DecodeRequest decodeRequest = new DecodeRequest();
        if (z) {
            decodeRequest.envInfo = new MobileEnvInfo();
            decodeRequest.envInfo.orderTerminalType = ACConstants.OrderTerminalType.MINI_APP;
        }
        decodeRequest.code = str;
        return (DecodeResult) wrapper(new BaseNetwork.FacadeProcessor<DecodeFacade, DecodeResult>() { // from class: com.iap.ac.android.mpm.decode.source.DecodeEntityData.1
            @Override // com.iap.ac.android.biz.common.base.BaseNetwork.FacadeProcessor
            public DecodeResult processFacade(DecodeFacade decodeFacade) {
                return ((DecodeFacade) DecodeEntityData.this.getFacade()).decode(decodeRequest);
            }
        });
    }
}
