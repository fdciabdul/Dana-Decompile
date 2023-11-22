package id.dana.domain.notificationcenter.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.notificationcenter.model.HasNewResponse;
import id.dana.domain.notificationcenter.repository.NotificationCenterRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class HasNewInbox extends UseCase<HasNewResponse, Void> {
    private NotificationCenterRepository notificationCenterRepository;

    @Inject
    public HasNewInbox(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, NotificationCenterRepository notificationCenterRepository) {
        super(threadExecutor, postExecutionThread);
        this.notificationCenterRepository = notificationCenterRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<HasNewResponse> buildUseCaseObservable(Void r1) {
        return this.notificationCenterRepository.hasNewInbox();
    }
}
