package com.iap.ac.android.acs.operation.biz.region.operation.repository;

import com.iap.ac.android.rpccommon.model.domain.request.BaseRpcRequest;

/* loaded from: classes3.dex */
public class FetchAllAppsRequest extends BaseRpcRequest {
    public String category;
    public String orderKey;
    public String orderType;
    public int querySize;
    public int queryStartIndex;
    public String sourceStageCode;
}
