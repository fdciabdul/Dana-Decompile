package com.iap.ac.android.acs.plugin.biz.region.stageinfo.repository;

import com.iap.ac.android.rpccommon.model.domain.result.BaseRpcResult;
import java.util.Map;

/* loaded from: classes3.dex */
public class FetchStageInfosResult extends BaseRpcResult {
    public int clientCacheExpireTime;
    public Map<String, StageInfo> stageInfo;
}
