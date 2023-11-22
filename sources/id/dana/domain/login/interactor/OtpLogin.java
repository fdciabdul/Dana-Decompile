package id.dana.domain.login.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.login.LoginRepository;
import id.dana.domain.model.rpc.response.LoginResponse;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/login/interactor/OtpLogin;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/model/rpc/response/LoginResponse;", "Lid/dana/domain/login/interactor/OtpLogin$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/login/interactor/OtpLogin$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/login/LoginRepository;", "loginRepository", "Lid/dana/domain/login/LoginRepository;", "<init>", "(Lid/dana/domain/login/LoginRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OtpLogin extends BaseUseCase<LoginResponse, Params> {
    private final LoginRepository loginRepository;

    @Inject
    public OtpLogin(LoginRepository loginRepository) {
        Intrinsics.checkNotNullParameter(loginRepository, "");
        this.loginRepository = loginRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<LoginResponse> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<LoginResponse> otpLogin = this.loginRepository.otpLogin(params.getVerifyAnswer(), params.getLoginType(), params.getVerifyMethod());
        Intrinsics.checkNotNullExpressionValue(otpLogin, "");
        return otpLogin;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \r2\u00020\u0001:\u0001\rB!\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006"}, d2 = {"Lid/dana/domain/login/interactor/OtpLogin$Params;", "", "", "loginType", "Ljava/lang/String;", "getLoginType", "()Ljava/lang/String;", "verifyAnswer", "getVerifyAnswer", "verifyMethod", "getVerifyMethod", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String loginType;
        private final String verifyAnswer;
        private final String verifyMethod;

        public /* synthetic */ Params(String str, String str2, String str3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3);
        }

        @JvmStatic
        public static final Params forOtpLogin(String str, String str2, String str3) {
            return INSTANCE.forOtpLogin(str, str2, str3);
        }

        private Params(String str, String str2, String str3) {
            this.verifyAnswer = str;
            this.loginType = str2;
            this.verifyMethod = str3;
        }

        @JvmName(name = "getVerifyAnswer")
        public final String getVerifyAnswer() {
            return this.verifyAnswer;
        }

        @JvmName(name = "getLoginType")
        public final String getLoginType() {
            return this.loginType;
        }

        @JvmName(name = "getVerifyMethod")
        public final String getVerifyMethod() {
            return this.verifyMethod;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/domain/login/interactor/OtpLogin$Params$Companion;", "", "", "verifyAnswer", "loginType", "verifyMethod", "Lid/dana/domain/login/interactor/OtpLogin$Params;", "forOtpLogin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/login/interactor/OtpLogin$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params forOtpLogin(String verifyAnswer, String loginType, String verifyMethod) {
                if (verifyAnswer == null) {
                    verifyAnswer = "";
                }
                if (loginType == null) {
                    loginType = "";
                }
                if (verifyMethod == null) {
                    verifyMethod = "";
                }
                return new Params(verifyAnswer, loginType, verifyMethod, null);
            }
        }
    }
}
