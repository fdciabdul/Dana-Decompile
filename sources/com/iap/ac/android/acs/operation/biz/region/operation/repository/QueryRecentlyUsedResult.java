package com.iap.ac.android.acs.operation.biz.region.operation.repository;

import com.iap.ac.android.acs.plugin.biz.region.stageinfo.repository.outter.MiniProgramLaunchableItem;
import com.iap.ac.android.rpccommon.model.domain.result.BaseRpcResult;
import java.util.List;

/* loaded from: classes3.dex */
public class QueryRecentlyUsedResult extends BaseRpcResult {
    public boolean hasMore;
    public List<MiniProgramLaunchableItem> recentlyUsedApps;
}
