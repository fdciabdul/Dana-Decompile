package com.iap.ac.android.biz.common.multilanguage.repository.source;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.multilanguage.querycity.CityQueryRpcRequest;
import com.iap.ac.android.biz.common.model.multilanguage.querycity.CityQueryRpcResult;
import com.iap.ac.android.biz.common.model.multilanguage.queryregioncode.RegionCodeQueryRpcRequest;
import com.iap.ac.android.biz.common.model.multilanguage.queryregioncode.RegionCodeQueryRpcResult;
import com.iap.ac.android.biz.common.rpc.annotation.ACRpcRequest;

/* loaded from: classes8.dex */
public interface MultiLanguageFacade {
    @ACRpcRequest
    @OperationType(Constants.OperationType.QUERY_CITY)
    @SignCheck
    CityQueryRpcResult queryCity(CityQueryRpcRequest cityQueryRpcRequest);

    @ACRpcRequest
    @OperationType(Constants.OperationType.QUERY_REGION_CODE)
    @SignCheck
    RegionCodeQueryRpcResult queryRegionCode(RegionCodeQueryRpcRequest regionCodeQueryRpcRequest);
}
