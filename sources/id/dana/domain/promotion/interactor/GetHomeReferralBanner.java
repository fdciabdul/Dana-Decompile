package id.dana.domain.promotion.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.promotion.Space;
import id.dana.domain.promotion.repository.PromotionRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes8.dex */
public class GetHomeReferralBanner extends UseCase<Space, Void> {
    private final PromotionRepository promotionRepository;

    @Inject
    public GetHomeReferralBanner(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PromotionRepository promotionRepository) {
        super(threadExecutor, postExecutionThread);
        this.promotionRepository = promotionRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Space> buildUseCaseObservable(Void r1) {
        return this.promotionRepository.getHomeReferralEntryBanner();
    }
}
