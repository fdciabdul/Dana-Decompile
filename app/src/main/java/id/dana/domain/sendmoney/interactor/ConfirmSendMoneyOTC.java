package id.dana.domain.sendmoney.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.sendmoney.model.SendMoneyConfirm;
import id.dana.domain.sendmoney.model.SendMoneyConfirmOTCParam;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class ConfirmSendMoneyOTC extends UseCase<SendMoneyConfirm, Params> {
    private final SendMoneyRepository sendMoneyRepository;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public ConfirmSendMoneyOTC(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SendMoneyRepository sendMoneyRepository) {
        super(threadExecutor, postExecutionThread);
        this.sendMoneyRepository = sendMoneyRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<SendMoneyConfirm> buildUseCaseObservable(Params params) {
        return this.sendMoneyRepository.confirmSendMoneyOTC(params.sendMoneyConfirmOTCParam);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private final SendMoneyConfirmOTCParam sendMoneyConfirmOTCParam;

        private Params(SendMoneyConfirmOTCParam sendMoneyConfirmOTCParam) {
            this.sendMoneyConfirmOTCParam = sendMoneyConfirmOTCParam;
        }

        public static Params forConfirmSendMoneyOTC(SendMoneyConfirmOTCParam sendMoneyConfirmOTCParam) {
            return new Params(sendMoneyConfirmOTCParam);
        }
    }
}
