package id.dana.data.notificationcenter.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.notificationcenter.repository.source.network.request.FetchInboxRequest;
import id.dana.data.notificationcenter.repository.source.network.request.HasNewRequest;
import id.dana.data.notificationcenter.repository.source.network.request.MarkNotificationRequest;
import id.dana.data.notificationcenter.repository.source.network.result.FetchInboxResult;
import id.dana.data.notificationcenter.repository.source.network.result.HasNewResult;
import id.dana.data.notificationcenter.repository.source.network.result.MarkNotificationResult;

/* loaded from: classes4.dex */
public interface NotificationCenterFacade {
    @OperationType("alipayplus.mobilewallet.user.notification.fetchInbox")
    @SignCheck
    FetchInboxResult fetchInboxNotification(FetchInboxRequest fetchInboxRequest);

    @OperationType("alipayplus.mobilewallet.user.notification.hasNew")
    @SignCheck
    HasNewResult hasNewNotification(HasNewRequest hasNewRequest);

    @OperationType("alipayplus.mobilewallet.user.notification.markAsRead")
    @SignCheck
    MarkNotificationResult markAsReadNotification(MarkNotificationRequest markNotificationRequest);
}
