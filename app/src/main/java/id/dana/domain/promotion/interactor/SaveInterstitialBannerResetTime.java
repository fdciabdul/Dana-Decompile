package id.dana.domain.promotion.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.promotion.repository.PromotionRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class SaveInterstitialBannerResetTime extends UseCase<Boolean, Params> {
    private final PromotionRepository promotionRepository;

    @Inject
    public SaveInterstitialBannerResetTime(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PromotionRepository promotionRepository) {
        super(threadExecutor, postExecutionThread);
        this.promotionRepository = promotionRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Params params) {
        return this.promotionRepository.saveInterstitialBannerResetTime(params.resetTimeInUnix);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private Long resetTimeInUnix;

        private Params(Long l) {
            this.resetTimeInUnix = l;
        }

        public static Params forSaveInterstitialBannerResetTime(Long l) {
            return new Params(l);
        }
    }
}
