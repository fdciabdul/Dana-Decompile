package id.dana.data.paylater.repository.source;

import com.alipay.mobile.framework.service.annotation.OperationType;
import id.dana.data.paylater.repository.source.network.request.LoanConsultWhitelistRequest;
import id.dana.data.paylater.repository.source.network.request.LoanRegisterEntityRequest;
import id.dana.data.paylater.repository.source.network.request.PaylaterHomeInfoRequest;
import id.dana.data.paylater.repository.source.network.result.LoanRegisterResult;
import id.dana.data.paylater.repository.source.network.result.LoanWhitelistResult;
import id.dana.data.paylater.repository.source.network.result.PaylaterHomeInfoResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/paylater/repository/source/PaylaterFacade;", "", "Lid/dana/data/paylater/repository/source/network/request/LoanConsultWhitelistRequest;", "request", "Lid/dana/data/paylater/repository/source/network/result/LoanWhitelistResult;", "getLoanConsultWhitelist", "(Lid/dana/data/paylater/repository/source/network/request/LoanConsultWhitelistRequest;)Lid/dana/data/paylater/repository/source/network/result/LoanWhitelistResult;", "Lid/dana/data/paylater/repository/source/network/request/LoanRegisterEntityRequest;", "Lid/dana/data/paylater/repository/source/network/result/LoanRegisterResult;", "getLoanRegisterInfo", "(Lid/dana/data/paylater/repository/source/network/request/LoanRegisterEntityRequest;)Lid/dana/data/paylater/repository/source/network/result/LoanRegisterResult;", "Lid/dana/data/paylater/repository/source/network/request/PaylaterHomeInfoRequest;", "Lid/dana/data/paylater/repository/source/network/result/PaylaterHomeInfoResult;", "getPaylaterHomeInfo", "(Lid/dana/data/paylater/repository/source/network/request/PaylaterHomeInfoRequest;)Lid/dana/data/paylater/repository/source/network/result/PaylaterHomeInfoResult;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface PaylaterFacade {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @OperationType("id.dana.mobilebizpaylaterprod.loan.consult.whitelist")
    LoanWhitelistResult getLoanConsultWhitelist(LoanConsultWhitelistRequest request);

    @OperationType("id.dana.mobilebizpaylaterprod.loan.register")
    LoanRegisterResult getLoanRegisterInfo(LoanRegisterEntityRequest request);

    @OperationType("id.dana.mobilebizpaylaterprod.home")
    PaylaterHomeInfoResult getPaylaterHomeInfo(PaylaterHomeInfoRequest request);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004"}, d2 = {"Lid/dana/data/paylater/repository/source/PaylaterFacade$Companion;", "", "", "LOAN_CONSULT_WHITELIST", "Ljava/lang/String;", "LOAN_REGISTER", "PAYLATER_HOME_INFO", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String LOAN_CONSULT_WHITELIST = "id.dana.mobilebizpaylaterprod.loan.consult.whitelist";
        private static final String LOAN_REGISTER = "id.dana.mobilebizpaylaterprod.loan.register";
        private static final String PAYLATER_HOME_INFO = "id.dana.mobilebizpaylaterprod.home";

        private Companion() {
        }
    }
}
