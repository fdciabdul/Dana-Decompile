package id.dana.data.feeds.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.feeds.model.ActivityEntity;
import java.util.List;

/* loaded from: classes4.dex */
public class FeedsResult extends BaseRpcResult {
    private List<ActivityEntity> activities;
    private boolean hasMore;
    private String maxId;
    private String minId;

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setActivities(List<ActivityEntity> list) {
        this.activities = list;
    }

    public void setMaxId(String str) {
        this.maxId = str;
    }

    public String getMaxId() {
        return this.maxId;
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

    public List<ActivityEntity> getActivities() {
        return this.activities;
    }
}
