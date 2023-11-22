package com.iap.ac.android.acs.operation.biz.region.bean;

import com.iap.ac.android.rpccommon.model.domain.request.BaseRpcRequest;
import java.util.List;

/* loaded from: classes3.dex */
public class HeartBeatRequest extends BaseRpcRequest {
    public List<String> actionTypeList;
    public String appId;
    public MenuExtraInfoVO menuExtraInfoVO;
    public UploadRecentlyUsedVO uploadRecentlyUsedVO;
}
