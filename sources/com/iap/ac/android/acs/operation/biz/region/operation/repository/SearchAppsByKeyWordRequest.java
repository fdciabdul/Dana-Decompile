package com.iap.ac.android.acs.operation.biz.region.operation.repository;

import com.iap.ac.android.rpccommon.model.domain.request.BaseRpcRequest;

/* loaded from: classes3.dex */
public class SearchAppsByKeyWordRequest extends BaseRpcRequest {
    public String keyword;
    public int querySize;
    public int queryStartIndex;
}
