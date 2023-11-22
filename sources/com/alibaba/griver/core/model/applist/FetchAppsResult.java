package com.alibaba.griver.core.model.applist;

import com.alibaba.griver.base.common.rpc.BaseGriverRpcResult;
import java.util.List;

/* loaded from: classes3.dex */
public class FetchAppsResult extends BaseGriverRpcResult {
    public List<FetchAppInfo> appInfoList;
    public int totalCount;
}
