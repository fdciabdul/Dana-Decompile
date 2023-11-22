package com.alibaba.griver.core.model.codec.cancodec;

import com.alibaba.griver.base.common.rpc.BaseGriverRpcRequest;

/* loaded from: classes6.dex */
public class UrlCanCodecRequest extends BaseGriverRpcRequest {
    private String code;

    public UrlCanCodecRequest(String str) {
        this.code = str;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }
}
