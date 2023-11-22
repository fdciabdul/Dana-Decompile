package id.dana.domain.sendmoney.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.sendmoney.model.NameCheckParam;
import id.dana.domain.sendmoney.model.WithdrawNameCheck;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class SendMoneyNameCheck extends UseCase<WithdrawNameCheck, Params> {
    private final SendMoneyRepository sendMoneyRepository;

    @Inject
    public SendMoneyNameCheck(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SendMoneyRepository sendMoneyRepository) {
        super(threadExecutor, postExecutionThread);
        this.sendMoneyRepository = sendMoneyRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<WithdrawNameCheck> buildUseCaseObservable(Params params) {
        return this.sendMoneyRepository.nameCheck(params.nameCheckParam);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private NameCheckParam nameCheckParam;

        private Params(NameCheckParam nameCheckParam) {
            this.nameCheckParam = nameCheckParam;
        }

        public static Params forSendMoneyNameCheck(NameCheckParam nameCheckParam) {
            return new Params(nameCheckParam);
        }
    }
}
