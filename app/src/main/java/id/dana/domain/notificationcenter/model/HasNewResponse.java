package id.dana.domain.notificationcenter.model;

import id.dana.utils.rpc.response.BaseRpcResponse;

/* loaded from: classes4.dex */
public class HasNewResponse extends BaseRpcResponse {
    private boolean hasNew;
    private boolean updated;

    public boolean isHasNew() {
        return this.hasNew;
    }

    public void setHasNew(boolean z) {
        this.hasNew = z;
    }

    public boolean isUpdated() {
        return this.updated;
    }

    public void setUpdated(boolean z) {
        this.updated = z;
    }
}
