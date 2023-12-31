package com.alipay.mobile.verifyidentity.http;

import com.alipay.fc.riskcloud.biz.mic.rpc.ICRpcService;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICInitRequest;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICRpcRequest;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICRpcResponse;

/* loaded from: classes3.dex */
public class HttpGetSettings implements ICRpcService {
    private static HttpGetSettings instance;

    public static HttpGetSettings getInstance() {
        HttpGetSettings httpGetSettings;
        synchronized (HttpGetSettings.class) {
            if (instance == null) {
                instance = new HttpGetSettings();
            }
            httpGetSettings = instance;
        }
        return httpGetSettings;
    }

    @Override // com.alipay.fc.riskcloud.biz.mic.rpc.ICRpcService
    public MICRpcResponse initVerifyTaskOuter(MICInitRequest mICInitRequest) {
        return HttpGetTaskUtil.getHttpResponse(mICInitRequest);
    }

    @Override // com.alipay.fc.riskcloud.biz.mic.rpc.ICRpcService
    public MICRpcResponse dispatch(MICRpcRequest mICRpcRequest) {
        return HttpGetTaskUtil.getHttpResponse(mICRpcRequest);
    }
}
