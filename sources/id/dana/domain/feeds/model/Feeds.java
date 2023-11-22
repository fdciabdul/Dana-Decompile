package id.dana.domain.feeds.model;

import id.dana.utils.rpc.response.BaseRpcResponse;
import java.util.List;

/* loaded from: classes4.dex */
public class Feeds extends BaseRpcResponse {
    private List<ActivityData> activities;
    private boolean hasMore;
    private boolean isFirstPage;
    private String maxId;
    private String minId;

    public String getMaxId() {
        return this.maxId;
    }

    public void setMaxId(String str) {
        this.maxId = str;
    }

    public String getMinId() {
        return this.minId;
    }

    public void setMinId(String str) {
        this.minId = str;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public List<ActivityData> getActivities() {
        return this.activities;
    }

    public void setActivities(List<ActivityData> list) {
        this.activities = list;
    }

    public boolean isFirstPage() {
        return this.isFirstPage;
    }

    public void setFirstPage(boolean z) {
        this.isFirstPage = z;
    }
}
