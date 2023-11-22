package id.dana.domain.login.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.login.LoginRepository;
import id.dana.domain.model.rpc.response.LoginResponse;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/login/interactor/Trust2RiskLogin;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/model/rpc/response/LoginResponse;", "Lid/dana/domain/login/interactor/Trust2RiskLogin$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/login/interactor/Trust2RiskLogin$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/login/LoginRepository;", "loginRepository", "Lid/dana/domain/login/LoginRepository;", "<init>", "(Lid/dana/domain/login/LoginRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Trust2RiskLogin extends BaseUseCase<LoginResponse, Params> {
    private final LoginRepository loginRepository;

    @Inject
    public Trust2RiskLogin(LoginRepository loginRepository) {
        Intrinsics.checkNotNullParameter(loginRepository, "");
        this.loginRepository = loginRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<LoginResponse> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<LoginResponse> trust2RiskLogin = this.loginRepository.trust2RiskLogin(params.getIsPasskeysSupported(), params.getCredentialId());
        Intrinsics.checkNotNullExpressionValue(trust2RiskLogin, "");
        return trust2RiskLogin;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0006"}, d2 = {"Lid/dana/domain/login/interactor/Trust2RiskLogin$Params;", "", "", "credentialId", "Ljava/lang/String;", "getCredentialId", "()Ljava/lang/String;", "isPasskeysSupported", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final String credentialId;
        private final String isPasskeysSupported;

        public Params(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            this.isPasskeysSupported = str;
            this.credentialId = str2;
        }

        public /* synthetic */ Params(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2);
        }

        @JvmName(name = "getCredentialId")
        public final String getCredentialId() {
            return this.credentialId;
        }

        @JvmName(name = "isPasskeysSupported")
        /* renamed from: isPasskeysSupported  reason: from getter */
        public final String getIsPasskeysSupported() {
            return this.isPasskeysSupported;
        }
    }
}
