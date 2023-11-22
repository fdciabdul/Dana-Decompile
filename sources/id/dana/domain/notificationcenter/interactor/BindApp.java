package id.dana.domain.notificationcenter.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.notificationcenter.model.BindAppResponse;
import id.dana.domain.notificationcenter.repository.PushNotificationRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class BindApp extends UseCase<BindAppResponse, Void> {
    private final PushNotificationRepository pushNotificationRepository;

    @Inject
    public BindApp(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PushNotificationRepository pushNotificationRepository) {
        super(threadExecutor, postExecutionThread);
        this.pushNotificationRepository = pushNotificationRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<BindAppResponse> buildUseCaseObservable(Void r1) {
        return this.pushNotificationRepository.bindAppSession();
    }
}
