package com.iap.ac.android.biz.common.multilanguage.repository.source;

import com.iap.ac.android.biz.common.base.BaseNetwork;
import com.iap.ac.android.biz.common.model.multilanguage.querycity.CityQueryRpcRequest;
import com.iap.ac.android.biz.common.model.multilanguage.querycity.CityQueryRpcResult;
import java.util.List;

/* loaded from: classes8.dex */
public class QueryCityEntityData extends BaseNetwork<MultiLanguageFacade> {
    @Override // com.iap.ac.android.biz.common.base.BaseNetwork
    public Class<MultiLanguageFacade> getFacadeClass() {
        return MultiLanguageFacade.class;
    }

    public CityQueryRpcResult queryCity(String str, List<String> list) throws Exception {
        final CityQueryRpcRequest cityQueryRpcRequest = new CityQueryRpcRequest();
        cityQueryRpcRequest.locale = str;
        cityQueryRpcRequest.regionList = list;
        return (CityQueryRpcResult) wrapper(new BaseNetwork.FacadeProcessor<MultiLanguageFacade, CityQueryRpcResult>() { // from class: com.iap.ac.android.biz.common.multilanguage.repository.source.QueryCityEntityData.1
            @Override // com.iap.ac.android.biz.common.base.BaseNetwork.FacadeProcessor
            public CityQueryRpcResult processFacade(MultiLanguageFacade multiLanguageFacade) {
                return ((MultiLanguageFacade) QueryCityEntityData.this.getFacade()).queryCity(cityQueryRpcRequest);
            }
        });
    }
}
