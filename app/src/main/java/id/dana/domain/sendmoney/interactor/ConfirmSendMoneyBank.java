package id.dana.domain.sendmoney.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.sendmoney.model.SendMoneyConfirm;
import id.dana.domain.sendmoney.model.SendMoneyConfirmParam;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class ConfirmSendMoneyBank extends UseCase<SendMoneyConfirm, Params> {
    private final SendMoneyRepository repository;

    @Inject
    public ConfirmSendMoneyBank(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SendMoneyRepository sendMoneyRepository) {
        super(threadExecutor, postExecutionThread);
        this.repository = sendMoneyRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<SendMoneyConfirm> buildUseCaseObservable(Params params) {
        return this.repository.confirmSendMoneyToBank(params.sendMoneyConfirmParam);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private SendMoneyConfirmParam sendMoneyConfirmParam;

        private Params(SendMoneyConfirmParam sendMoneyConfirmParam) {
            this.sendMoneyConfirmParam = sendMoneyConfirmParam;
        }

        public static Params forConfirmSendMoneyBank(SendMoneyConfirmParam sendMoneyConfirmParam) {
            return new Params(sendMoneyConfirmParam);
        }
    }
}
