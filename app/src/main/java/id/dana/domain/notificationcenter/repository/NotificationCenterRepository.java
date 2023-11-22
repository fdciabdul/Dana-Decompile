package id.dana.domain.notificationcenter.repository;

import id.dana.domain.notificationcenter.model.FetchInboxResponse;
import id.dana.domain.notificationcenter.model.HasNewResponse;
import id.dana.domain.notificationcenter.model.MarkNotificationResponse;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface NotificationCenterRepository {
    Observable<FetchInboxResponse> fetchInbox(int i, String str, String str2);

    Observable<HasNewResponse> hasNewInbox();

    Observable<MarkNotificationResponse> markNotificationAsRead(String str);
}
