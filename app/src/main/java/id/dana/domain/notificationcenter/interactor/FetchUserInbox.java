package id.dana.domain.notificationcenter.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.notificationcenter.model.FetchInboxResponse;
import id.dana.domain.notificationcenter.repository.NotificationCenterRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class FetchUserInbox extends UseCase<FetchInboxResponse, Params> {
    private NotificationCenterRepository notificationCenterRepository;

    @Inject
    public FetchUserInbox(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, NotificationCenterRepository notificationCenterRepository) {
        super(threadExecutor, postExecutionThread);
        this.notificationCenterRepository = notificationCenterRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<FetchInboxResponse> buildUseCaseObservable(Params params) {
        return this.notificationCenterRepository.fetchInbox(params.pageSize, params.maxId, params.minId);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private String maxId;
        private String minId;
        private int pageSize;

        private Params(int i, String str, String str2) {
            this.pageSize = i;
            this.maxId = str;
            this.minId = str2;
        }

        public static Params forFetchUserInbox(int i, String str, String str2) {
            return new Params(i, str, str2);
        }
    }
}
