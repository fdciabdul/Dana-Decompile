package id.dana.domain.promotion.interactor;

import id.dana.domain.CompletableUseCase;
import id.dana.domain.promotion.repository.PromotionRepository;
import io.reactivex.Completable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class DecrementFreeTransferCount extends CompletableUseCase<String> {
    private final PromotionRepository promotionRepository;

    @Inject
    public DecrementFreeTransferCount(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.CompletableUseCase
    public Completable buildCompletableUseCase(String str) {
        return this.promotionRepository.decrementFreeTransferCount(str);
    }
}
