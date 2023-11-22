package id.dana.data.notificationcenter.repository;

import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.notificationcenter.mapper.NotificationCenterMapper;
import id.dana.data.notificationcenter.repository.source.NotificationCenterEntityData;
import id.dana.data.notificationcenter.repository.source.NotificationCenterEntityDataFactory;
import id.dana.data.notificationcenter.repository.source.network.result.FetchInboxResult;
import id.dana.data.notificationcenter.repository.source.network.result.HasNewResult;
import id.dana.data.notificationcenter.repository.source.network.result.MarkNotificationResult;
import id.dana.domain.notificationcenter.model.FetchInboxResponse;
import id.dana.domain.notificationcenter.model.HasNewResponse;
import id.dana.domain.notificationcenter.model.MarkNotificationResponse;
import id.dana.domain.notificationcenter.repository.NotificationCenterRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class NotificationCenterEntityRepository implements NotificationCenterRepository {
    private final NotificationCenterEntityDataFactory factory;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final NotificationCenterMapper notificationCenterMapper;

    @Inject
    public NotificationCenterEntityRepository(NotificationCenterEntityDataFactory notificationCenterEntityDataFactory, NotificationCenterMapper notificationCenterMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        this.factory = notificationCenterEntityDataFactory;
        this.notificationCenterMapper = notificationCenterMapper;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    private NotificationCenterEntityData createNotificationData() {
        return this.factory.createData2("network");
    }

    @Override // id.dana.domain.notificationcenter.repository.NotificationCenterRepository
    public Observable<FetchInboxResponse> fetchInbox(int i, String str, String str2) {
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createNotificationData().fetchInbox(i, str, str2));
        final NotificationCenterMapper notificationCenterMapper = this.notificationCenterMapper;
        Objects.requireNonNull(notificationCenterMapper);
        return authenticatedRequest.map(new Function() { // from class: id.dana.data.notificationcenter.repository.NotificationCenterEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NotificationCenterMapper.this.transform((FetchInboxResult) obj);
            }
        });
    }

    @Override // id.dana.domain.notificationcenter.repository.NotificationCenterRepository
    public Observable<HasNewResponse> hasNewInbox() {
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createNotificationData().hasNew());
        final NotificationCenterMapper notificationCenterMapper = this.notificationCenterMapper;
        Objects.requireNonNull(notificationCenterMapper);
        return authenticatedRequest.map(new Function() { // from class: id.dana.data.notificationcenter.repository.NotificationCenterEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NotificationCenterMapper.this.transform((HasNewResult) obj);
            }
        });
    }

    @Override // id.dana.domain.notificationcenter.repository.NotificationCenterRepository
    public Observable<MarkNotificationResponse> markNotificationAsRead(String str) {
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createNotificationData().markAsRead(str));
        final NotificationCenterMapper notificationCenterMapper = this.notificationCenterMapper;
        Objects.requireNonNull(notificationCenterMapper);
        return authenticatedRequest.map(new Function() { // from class: id.dana.data.notificationcenter.repository.NotificationCenterEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NotificationCenterMapper.this.transform((MarkNotificationResult) obj);
            }
        });
    }
}
