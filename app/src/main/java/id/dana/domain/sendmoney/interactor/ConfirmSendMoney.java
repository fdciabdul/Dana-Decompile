package id.dana.domain.sendmoney.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.sendmoney.model.SendMoneyConfirm;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class ConfirmSendMoney extends UseCase<SendMoneyConfirm, Params> {
    private final SendMoneyRepository sendMoneyRepository;

    @Inject
    public ConfirmSendMoney(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SendMoneyRepository sendMoneyRepository) {
        super(threadExecutor, postExecutionThread);
        this.sendMoneyRepository = sendMoneyRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<SendMoneyConfirm> buildUseCaseObservable(Params params) {
        return this.sendMoneyRepository.sendMoney(params.payAmount, params.payCurrency, params.payeeAvatar, params.payeeNickname, params.payeeLoginId, params.payeeUserId, params.comment, params.share, params.payMethod);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private String comment;
        private String payAmount;
        private String payCurrency;
        private String payMethod;
        private String payeeAvatar;
        private String payeeLoginId;
        private String payeeNickname;
        private String payeeUserId;
        private boolean share;

        private Params() {
        }

        public static Params forSendMoney() {
            return new Params();
        }

        public Params currencyAmount(String str, String str2) {
            this.payAmount = str;
            this.payCurrency = str2;
            return this;
        }

        public Params payeeDetail(String str, String str2, String str3, String str4) {
            this.payeeAvatar = str;
            this.payeeNickname = str2;
            this.payeeLoginId = str3;
            this.payeeUserId = str4;
            return this;
        }

        public Params additionalInfo(String str, boolean z, String str2) {
            this.comment = str;
            this.share = z;
            this.payMethod = str2;
            return this;
        }
    }
}
