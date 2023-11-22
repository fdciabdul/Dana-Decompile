package com.iap.ac.android.mpm.payment.source;

import com.iap.ac.android.biz.common.base.BaseNetwork;
import com.iap.ac.android.biz.common.constants.ACConstants;
import com.iap.ac.android.mpm.base.model.payment.request.SwapOrderRequest;
import com.iap.ac.android.mpm.base.model.payment.result.SwapOrderResult;
import com.iap.ac.android.rpccommon.model.facade.MobileEnvInfo;
import java.util.Map;

/* loaded from: classes3.dex */
public class SwapOrderEntityData extends BaseNetwork<SwapOrderFacade> {
    @Override // com.iap.ac.android.biz.common.base.BaseNetwork
    public Class<SwapOrderFacade> getFacadeClass() {
        return SwapOrderFacade.class;
    }

    public SwapOrderResult swapOrder(Map<String, String> map, String str, String str2, boolean z) throws Exception {
        final SwapOrderRequest swapOrderRequest = new SwapOrderRequest();
        if (z) {
            swapOrderRequest.envInfo = new MobileEnvInfo();
            swapOrderRequest.envInfo.orderTerminalType = ACConstants.OrderTerminalType.MINI_APP;
        }
        swapOrderRequest.acquirerTradeNo = str;
        swapOrderRequest.acquirerId = str2;
        swapOrderRequest.acquirerOrderExtendInfo = map;
        return (SwapOrderResult) wrapper(new BaseNetwork.FacadeProcessor<SwapOrderFacade, SwapOrderResult>() { // from class: com.iap.ac.android.mpm.payment.source.SwapOrderEntityData.1
            @Override // com.iap.ac.android.biz.common.base.BaseNetwork.FacadeProcessor
            public SwapOrderResult processFacade(SwapOrderFacade swapOrderFacade) {
                return swapOrderFacade.swapOrder(swapOrderRequest);
            }
        });
    }
}
