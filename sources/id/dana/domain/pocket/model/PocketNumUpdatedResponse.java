package id.dana.domain.pocket.model;

import id.dana.utils.rpc.response.BaseRpcResponse;
import java.util.List;

/* loaded from: classes8.dex */
public class PocketNumUpdatedResponse extends BaseRpcResponse {
    private List<PocketBadgeInfo> badgeInfos;
    private int numUpdated;
    private long serverTimestamp;

    public long getServerTimestamp() {
        return this.serverTimestamp;
    }

    public void setServerTimestamp(long j) {
        this.serverTimestamp = j;
    }

    public void setBadgeInfos(List<PocketBadgeInfo> list) {
        this.badgeInfos = list;
    }

    public List<PocketBadgeInfo> getBadgeInfos() {
        return this.badgeInfos;
    }

    public int getNumUpdated() {
        return this.numUpdated;
    }

    public void setNumUpdated(int i) {
        this.numUpdated = i;
    }
}
