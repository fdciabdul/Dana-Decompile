package id.dana.domain.sendmoney.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.sendmoney.model.OTCTransferInit;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class InitTransferOTC extends UseCase<OTCTransferInit, Param> {
    private final SendMoneyRepository sendMoneyRepository;

    @Inject
    public InitTransferOTC(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SendMoneyRepository sendMoneyRepository) {
        super(threadExecutor, postExecutionThread);
        this.sendMoneyRepository = sendMoneyRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<OTCTransferInit> buildUseCaseObservable(Param param) {
        return this.sendMoneyRepository.transferOTCInit(param.amount, param.fundType);
    }

    /* loaded from: classes4.dex */
    public static class Param {
        private final String amount;
        private final String fundType;

        private Param(String str, String str2) {
            this.amount = str;
            this.fundType = str2;
        }

        public static Param forTransferOTCInit(String str, String str2) {
            return new Param(str, str2);
        }
    }
}
