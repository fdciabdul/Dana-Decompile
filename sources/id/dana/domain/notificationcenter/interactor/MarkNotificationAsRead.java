package id.dana.domain.notificationcenter.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.notificationcenter.model.MarkNotificationResponse;
import id.dana.domain.notificationcenter.repository.NotificationCenterRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class MarkNotificationAsRead extends UseCase<MarkNotificationResponse, Params> {
    private NotificationCenterRepository notificationCenterRepository;

    @Inject
    public MarkNotificationAsRead(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, NotificationCenterRepository notificationCenterRepository) {
        super(threadExecutor, postExecutionThread);
        this.notificationCenterRepository = notificationCenterRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<MarkNotificationResponse> buildUseCaseObservable(Params params) {
        return this.notificationCenterRepository.markNotificationAsRead(params.f8175id);
    }

    /* loaded from: classes4.dex */
    public static class Params {

        /* renamed from: id  reason: collision with root package name */
        private String f8175id;

        private Params(String str) {
            this.f8175id = str;
        }

        public static Params forMarkNotificationAsRead(String str) {
            return new Params(str);
        }
    }
}
