package id.dana.domain.promotion.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.promotion.repository.PromotionRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class SaveInterstitialBannerGapTime extends UseCase<Boolean, Params> {
    private final PromotionRepository promotionRepository;

    @Inject
    public SaveInterstitialBannerGapTime(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PromotionRepository promotionRepository) {
        super(threadExecutor, postExecutionThread);
        this.promotionRepository = promotionRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Params params) {
        return this.promotionRepository.saveInterstitialBannerGapTime(Long.valueOf(params.gapTimeInUnix));
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private long gapTimeInUnix;

        private Params(long j) {
            this.gapTimeInUnix = j;
        }

        public static Params forSaveInterstitialBannerGapTime(long j) {
            return new Params(j);
        }
    }
}
