package com.iap.ac.android.biz.common.multilanguage.repository.source;

import com.iap.ac.android.biz.common.base.BaseNetwork;
import com.iap.ac.android.biz.common.model.multilanguage.queryregioncode.RegionCodeQueryRpcRequest;
import com.iap.ac.android.biz.common.model.multilanguage.queryregioncode.RegionCodeQueryRpcResult;

/* loaded from: classes8.dex */
public class QueryRegionCodeEntityData extends BaseNetwork<MultiLanguageFacade> {
    @Override // com.iap.ac.android.biz.common.base.BaseNetwork
    public Class<MultiLanguageFacade> getFacadeClass() {
        return MultiLanguageFacade.class;
    }

    public RegionCodeQueryRpcResult queryRegionCode(String str) throws Exception {
        final RegionCodeQueryRpcRequest regionCodeQueryRpcRequest = new RegionCodeQueryRpcRequest();
        regionCodeQueryRpcRequest.locale = str;
        return (RegionCodeQueryRpcResult) wrapper(new BaseNetwork.FacadeProcessor<MultiLanguageFacade, RegionCodeQueryRpcResult>() { // from class: com.iap.ac.android.biz.common.multilanguage.repository.source.QueryRegionCodeEntityData.1
            @Override // com.iap.ac.android.biz.common.base.BaseNetwork.FacadeProcessor
            public RegionCodeQueryRpcResult processFacade(MultiLanguageFacade multiLanguageFacade) {
                return multiLanguageFacade.queryRegionCode(regionCodeQueryRpcRequest);
            }
        });
    }
}
