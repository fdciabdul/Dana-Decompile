package id.dana.data.notificationcenter.mapper;

import id.dana.data.BaseMapper;
import id.dana.data.notificationcenter.repository.source.network.result.FetchInboxResult;
import id.dana.data.notificationcenter.repository.source.network.result.HasNewResult;
import id.dana.data.notificationcenter.repository.source.network.result.MarkNotificationResult;
import id.dana.data.notificationcenter.repository.source.network.result.NotificationDTOResult;
import id.dana.domain.notificationcenter.model.FetchInboxResponse;
import id.dana.domain.notificationcenter.model.HasNewResponse;
import id.dana.domain.notificationcenter.model.MarkNotificationResponse;
import id.dana.domain.notificationcenter.model.NotificationDTOResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class NotificationCenterMapper {
    @Inject
    public NotificationCenterMapper() {
    }

    public FetchInboxResponse transform(FetchInboxResult fetchInboxResult) {
        if (fetchInboxResult != null) {
            FetchInboxResponse fetchInboxResponse = new FetchInboxResponse();
            BaseMapper.transform(fetchInboxResponse, fetchInboxResult);
            fetchInboxResponse.setHasMore(fetchInboxResult.isHasMore());
            fetchInboxResponse.setMaxId(fetchInboxResult.getMaxId());
            fetchInboxResponse.setNotifications(transform(fetchInboxResult.getNotifications()));
            return fetchInboxResponse;
        }
        return null;
    }

    public HasNewResponse transform(HasNewResult hasNewResult) {
        if (hasNewResult != null) {
            HasNewResponse hasNewResponse = new HasNewResponse();
            BaseMapper.transform(hasNewResponse, hasNewResult);
            hasNewResponse.setHasNew(hasNewResult.isHasNew());
            hasNewResponse.setUpdated(hasNewResult.isUpdated());
            return hasNewResponse;
        }
        return null;
    }

    public MarkNotificationResponse transform(MarkNotificationResult markNotificationResult) {
        if (markNotificationResult != null) {
            MarkNotificationResponse markNotificationResponse = new MarkNotificationResponse();
            BaseMapper.transform(markNotificationResponse, markNotificationResult);
            return markNotificationResponse;
        }
        return null;
    }

    private List<NotificationDTOResponse> transform(List<NotificationDTOResult> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<NotificationDTOResult> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(transform(it.next()));
        }
        return arrayList;
    }

    private NotificationDTOResponse transform(NotificationDTOResult notificationDTOResult) {
        if (notificationDTOResult != null) {
            NotificationDTOResponse notificationDTOResponse = new NotificationDTOResponse();
            notificationDTOResponse.setContent(notificationDTOResult.getContent());
            notificationDTOResponse.setIconUrl(notificationDTOResult.getIconUrl());
            notificationDTOResponse.setCreatedTime(notificationDTOResult.getCreatedTime());
            notificationDTOResponse.setId(notificationDTOResult.getId());
            notificationDTOResponse.setRead(notificationDTOResult.isRead());
            notificationDTOResponse.setRedirectType(notificationDTOResult.getRedirectType());
            notificationDTOResponse.setRedirectValue(notificationDTOResult.getRedirectValue());
            return notificationDTOResponse;
        }
        return null;
    }
}
