package com.alibaba.griver.core.model.share;

import com.alibaba.griver.base.common.rpc.BaseGriverRpcRequest;

/* loaded from: classes6.dex */
public class ShareShortUrlRequest extends BaseGriverRpcRequest {
    public String bizType = "MINI_PROGRAM_APP_SHARE";
    public String currentWorkspaceId;
    public String paramData;
    public String walletAppId;
}
