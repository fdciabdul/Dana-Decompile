package id.dana.domain.sendmoney.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.sendmoney.model.TransferPrepay;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetTransferPrePay extends UseCase<TransferPrepay, Params> {
    private final SendMoneyRepository sendMoneyRepository;

    @Inject
    public GetTransferPrePay(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SendMoneyRepository sendMoneyRepository) {
        super(threadExecutor, postExecutionThread);
        this.sendMoneyRepository = sendMoneyRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<TransferPrepay> buildUseCaseObservable(Params params) {
        return this.sendMoneyRepository.initPrePay(params.amount, params.transferMethod);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private final String amount;
        private final String transferMethod;

        private Params(String str, String str2) {
            this.amount = str;
            this.transferMethod = str2;
        }

        public static Params forPrePay(String str, String str2) {
            return new Params(str, str2);
        }
    }
}
