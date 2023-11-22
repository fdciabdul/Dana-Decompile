package id.dana.domain.playstorereview.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.playstorereview.model.AppReviewInfo;
import id.dana.domain.playstorereview.repository.PlayStoreReviewRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class IsNeedToShowPlayStoreReview extends UseCase<AppReviewInfo, Void> {
    private final PlayStoreReviewRepository playStoreReviewRepository;

    @Inject
    public IsNeedToShowPlayStoreReview(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PlayStoreReviewRepository playStoreReviewRepository) {
        super(threadExecutor, postExecutionThread);
        this.playStoreReviewRepository = playStoreReviewRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<AppReviewInfo> buildUseCaseObservable(Void r1) {
        return this.playStoreReviewRepository.isNeedToShowPlayStoreReview();
    }
}
