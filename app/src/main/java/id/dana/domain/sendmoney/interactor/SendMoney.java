package id.dana.domain.sendmoney.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.sendmoney.model.SendMoneyInit;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes8.dex */
public class SendMoney extends UseCase<SendMoneyInit, Params> {
    private final SendMoneyRepository sendMoneyRepository;

    @Inject
    public SendMoney(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SendMoneyRepository sendMoneyRepository) {
        super(threadExecutor, postExecutionThread);
        this.sendMoneyRepository = sendMoneyRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<SendMoneyInit> buildUseCaseObservable(Params params) {
        return this.sendMoneyRepository.sendMoneyInit(params.payeeLoginId, params.payeeUserId, params.version);
    }

    /* loaded from: classes8.dex */
    public static class Params {
        private String payeeLoginId;
        private String payeeUserId;
        private String version;

        private Params(String str, String str2, String str3) {
            this.payeeLoginId = str;
            this.payeeUserId = str2;
            this.version = str3;
        }

        public static Params forSendMoneyInit(String str, String str2, String str3) {
            return new Params(str, str2, str3);
        }
    }
}
