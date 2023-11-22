package id.dana.data.notificationcenter.repository.source;

import id.dana.data.notificationcenter.repository.source.network.result.FetchInboxResult;
import id.dana.data.notificationcenter.repository.source.network.result.HasNewResult;
import id.dana.data.notificationcenter.repository.source.network.result.MarkNotificationResult;
import io.reactivex.Observable;

/* loaded from: classes4.dex */
public interface NotificationCenterEntityData {
    Observable<FetchInboxResult> fetchInbox(int i, String str, String str2);

    Observable<HasNewResult> hasNew();

    Observable<MarkNotificationResult> markAsRead(String str);
}
