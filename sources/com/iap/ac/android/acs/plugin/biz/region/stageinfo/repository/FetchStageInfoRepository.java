package com.iap.ac.android.acs.plugin.biz.region.stageinfo.repository;

import com.alipay.mobile.common.rpc.RpcException;
import com.iap.ac.android.acs.operation.biz.region.bean.ExceptionWrap;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import java.util.List;

/* loaded from: classes3.dex */
public class FetchStageInfoRepository {
    public static final String TAG = "FetchStageInfoRepository";
    public ExceptionWrap exceptionWrap;

    public FetchStageInfoRepository() {
        this.exceptionWrap = new ExceptionWrap();
    }

    public FetchStageInfosResult fetchStageInfo(List<String> list) {
        try {
            FetchStageInfoFacade fetchStageInfoFacade = (FetchStageInfoFacade) RPCProxyHost.getInterfaceProxy(FetchStageInfoFacade.class, "region_biz");
            FetchStageInfoRequest fetchStageInfoRequest = new FetchStageInfoRequest();
            fetchStageInfoRequest.stageCodeList = list;
            return fetchStageInfoFacade.fetchStageInfo(fetchStageInfoRequest);
        } catch (RpcException e) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("fetchStageInfo error:");
            sb.append(e);
            ACLog.e(str, sb.toString());
            this.exceptionWrap.exceptionCode = e.getCode();
            return null;
        } catch (Throwable th) {
            String str2 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("fetchStageInfo error:");
            sb2.append(th);
            ACLog.e(str2, sb2.toString());
            return null;
        }
    }

    public FetchStageInfoRepository(ExceptionWrap exceptionWrap) {
        new ExceptionWrap();
        this.exceptionWrap = exceptionWrap;
    }
}
