package id.dana.domain.promotion.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.promotion.model.BannerCollection;
import id.dana.domain.promotion.repository.PromotionRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetHomePromotionBanner extends UseCase<BannerCollection, Void> {
    private final PromotionRepository promotionRepository;

    @Inject
    public GetHomePromotionBanner(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PromotionRepository promotionRepository) {
        super(threadExecutor, postExecutionThread);
        this.promotionRepository = promotionRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<BannerCollection> buildUseCaseObservable(Void r1) {
        return this.promotionRepository.getHomePromotionBanner();
    }
}
