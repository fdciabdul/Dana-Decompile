package id.dana.domain.notificationcenter.model;

import id.dana.utils.rpc.response.BaseRpcResponse;
import java.util.List;

/* loaded from: classes4.dex */
public class FetchInboxResponse extends BaseRpcResponse {
    private boolean hasMore;
    private String maxId;
    private List<NotificationDTOResponse> notifications;

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

    public List<NotificationDTOResponse> getNotifications() {
        return this.notifications;
    }

    public void setNotifications(List<NotificationDTOResponse> list) {
        this.notifications = list;
    }
}
