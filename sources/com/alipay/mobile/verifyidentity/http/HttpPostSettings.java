package com.alipay.mobile.verifyidentity.http;

import com.alipay.fc.riskcloud.biz.mic.rpc.ICRpcService;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICInitRequest;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICRpcRequest;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICRpcResponse;

/* loaded from: classes7.dex */
public class HttpPostSettings implements ICRpcService {
    private static HttpPostSettings instance;

    public static HttpPostSettings getInstance() {
        HttpPostSettings httpPostSettings;
        synchronized (HttpPostSettings.class) {
            if (instance == null) {
                instance = new HttpPostSettings();
            }
            httpPostSettings = instance;
        }
        return httpPostSettings;
    }

    @Override // com.alipay.fc.riskcloud.biz.mic.rpc.ICRpcService
    public MICRpcResponse initVerifyTaskOuter(MICInitRequest mICInitRequest) {
        return HttpTaskUtil.getHttpResponse(mICInitRequest);
    }

    @Override // com.alipay.fc.riskcloud.biz.mic.rpc.ICRpcService
    public MICRpcResponse dispatch(MICRpcRequest mICRpcRequest) {
        return HttpTaskUtil.getHttpResponse(mICRpcRequest);
    }
}
