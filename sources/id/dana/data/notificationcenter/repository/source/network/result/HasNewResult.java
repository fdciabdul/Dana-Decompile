package id.dana.data.notificationcenter.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;

/* loaded from: classes4.dex */
public class HasNewResult extends BaseRpcResult {
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
