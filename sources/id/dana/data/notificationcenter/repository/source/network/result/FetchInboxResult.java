package id.dana.data.notificationcenter.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import java.util.List;

/* loaded from: classes4.dex */
public class FetchInboxResult extends BaseRpcResult {
    private boolean hasMore;
    private String maxId;
    private List<NotificationDTOResult> notifications;

    public boolean isHasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public String getMaxId() {
        return this.maxId;
    }

    public void setMaxId(String str) {
        this.maxId = str;
    }

    public List<NotificationDTOResult> getNotifications() {
        return this.notifications;
    }

    public void setNotifications(List<NotificationDTOResult> list) {
        this.notifications = list;
    }
}
