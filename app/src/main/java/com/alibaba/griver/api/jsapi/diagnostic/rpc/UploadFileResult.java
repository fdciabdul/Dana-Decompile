package com.alibaba.griver.api.jsapi.diagnostic.rpc;

import com.alibaba.griver.base.common.rpc.BaseGriverRpcResult;
import java.util.Map;

/* loaded from: classes6.dex */
public class UploadFileResult extends BaseGriverRpcResult {
    public String objectUrl;
    public String uploadOrigin;
    public Map<String, String> uploadParams;
}
