package id.dana.domain.login.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.login.LoginRepository;
import id.dana.domain.model.rpc.response.Trust2RiskLoginResponse;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/login/interactor/ConsultTrust2RiskLogin;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/model/rpc/response/Trust2RiskLoginResponse;", "Lid/dana/domain/login/interactor/ConsultTrust2RiskLogin$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/login/interactor/ConsultTrust2RiskLogin$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/login/LoginRepository;", "loginRepository", "Lid/dana/domain/login/LoginRepository;", "<init>", "(Lid/dana/domain/login/LoginRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConsultTrust2RiskLogin extends BaseUseCase<Trust2RiskLoginResponse, Params> {
    private final LoginRepository loginRepository;

    @Inject
    public ConsultTrust2RiskLogin(LoginRepository loginRepository) {
        Intrinsics.checkNotNullParameter(loginRepository, "");
        this.loginRepository = loginRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Trust2RiskLoginResponse> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        LoginRepository loginRepository = this.loginRepository;
        String phoneNumber = params.getPhoneNumber();
        boolean isWhatsAppInstalled = params.getIsWhatsAppInstalled();
        Observable<Trust2RiskLoginResponse> consultTrust2RiskLogin = loginRepository.consultTrust2RiskLogin(phoneNumber, Boolean.valueOf(isWhatsAppInstalled), params.getIsPasskeysSupported(), params.getCredentialId());
        Intrinsics.checkNotNullExpressionValue(consultTrust2RiskLogin, "");
        return consultTrust2RiskLogin;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0006R\u001a\u0010\t\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006"}, d2 = {"Lid/dana/domain/login/interactor/ConsultTrust2RiskLogin$Params;", "", "", "credentialId", "Ljava/lang/String;", "getCredentialId", "()Ljava/lang/String;", "isPasskeysSupported", "", "isWhatsAppInstalled", "Z", "()Z", "phoneNumber", "getPhoneNumber", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final String credentialId;
        private final String isPasskeysSupported;
        private final boolean isWhatsAppInstalled;
        private final String phoneNumber;

        public Params(String str, boolean z, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.phoneNumber = str;
            this.isWhatsAppInstalled = z;
            this.isPasskeysSupported = str2;
            this.credentialId = str3;
        }

        public /* synthetic */ Params(String str, boolean z, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, z, str2, (i & 8) != 0 ? null : str3);
        }

        @JvmName(name = "getCredentialId")
        public final String getCredentialId() {
            return this.credentialId;
        }

        @JvmName(name = "getPhoneNumber")
        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        @JvmName(name = "isPasskeysSupported")
        /* renamed from: isPasskeysSupported  reason: from getter */
        public final String getIsPasskeysSupported() {
            return this.isPasskeysSupported;
        }

        @JvmName(name = "isWhatsAppInstalled")
        /* renamed from: isWhatsAppInstalled  reason: from getter */
        public final boolean getIsWhatsAppInstalled() {
            return this.isWhatsAppInstalled;
        }
    }
}
