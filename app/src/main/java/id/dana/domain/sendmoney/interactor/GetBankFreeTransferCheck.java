package id.dana.domain.sendmoney.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.promotion.repository.PromotionRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetBankFreeTransferCheck extends UseCase<Integer, Void> {
    private final PromotionRepository promotionRepository;

    @Inject
    public GetBankFreeTransferCheck(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PromotionRepository promotionRepository) {
        super(threadExecutor, postExecutionThread);
        this.promotionRepository = promotionRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Integer> buildUseCaseObservable(Void r2) {
        return this.promotionRepository.getFreeTransferCount("BANK_TRANSFER");
    }
}
