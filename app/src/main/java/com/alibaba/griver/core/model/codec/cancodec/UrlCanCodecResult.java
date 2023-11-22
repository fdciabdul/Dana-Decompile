package com.alibaba.griver.core.model.codec.cancodec;

import com.alibaba.griver.base.common.rpc.BaseGriverRpcResult;

/* loaded from: classes6.dex */
public class UrlCanCodecResult extends BaseGriverRpcResult {
    private boolean canDecode;

    public boolean isCanDecode() {
        return this.canDecode;
    }

    public void setCanDecode(boolean z) {
        this.canDecode = z;
    }
}
