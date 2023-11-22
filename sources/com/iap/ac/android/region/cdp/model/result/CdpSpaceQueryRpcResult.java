package com.iap.ac.android.region.cdp.model.result;

import com.iap.ac.android.region.cdp.model.CdpSpaceInfo;
import com.iap.ac.android.rpccommon.model.domain.result.BaseRpcResult;
import java.util.Map;

/* loaded from: classes3.dex */
public class CdpSpaceQueryRpcResult extends BaseRpcResult {
    public long serverTimeInMillis;
    public Map<String, CdpSpaceInfo> spaceInfos;
    public String timeZone;
}
