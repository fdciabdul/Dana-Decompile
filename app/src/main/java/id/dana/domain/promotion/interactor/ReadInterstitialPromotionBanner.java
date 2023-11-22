package id.dana.domain.promotion.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.promotion.repository.PromotionRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class ReadInterstitialPromotionBanner extends UseCase<Boolean, Params> {
    private final PromotionRepository promotionRepository;

    @Inject
    public ReadInterstitialPromotionBanner(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PromotionRepository promotionRepository) {
        super(threadExecutor, postExecutionThread);
        this.promotionRepository = promotionRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Params params) {
        return this.promotionRepository.readInterstitialPromotionBanner(params.contentId);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private String contentId;

        private Params(String str) {
            this.contentId = str;
        }

        public static Params forReadInterstitialPromotionBanner(String str) {
            return new Params(str);
        }
    }
}
