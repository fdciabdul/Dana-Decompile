package id.dana.domain.playstorereview.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.playstorereview.repository.PlayStoreReviewRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class SaveLastPlayStoreReviewShow extends UseCase<Boolean, Params> {
    private final PlayStoreReviewRepository playStoreReviewRepository;

    @Inject
    public SaveLastPlayStoreReviewShow(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PlayStoreReviewRepository playStoreReviewRepository) {
        super(threadExecutor, postExecutionThread);
        this.playStoreReviewRepository = playStoreReviewRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Params params) {
        return this.playStoreReviewRepository.saveLastPlayStoreReviewShow(params.action, params.actionTime, params.triggerTime);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private final String action;
        private final long actionTime;
        private final long triggerTime;

        private Params(String str, long j, long j2) {
            this.action = str;
            this.actionTime = j;
            this.triggerTime = j2;
        }

        public static Params forSaveLastPlayStoreReviewParams(String str, long j, long j2) {
            return new Params(str, j, j2);
        }
    }
}
