package id.dana.domain.login.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.login.LoginRepository;
import id.dana.domain.model.rpc.response.LoginResponse;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/login/interactor/HoldLogin;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/model/rpc/response/LoginResponse;", "Lid/dana/domain/login/interactor/HoldLogin$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/login/interactor/HoldLogin$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/login/LoginRepository;", "loginRepository", "Lid/dana/domain/login/LoginRepository;", "<init>", "(Lid/dana/domain/login/LoginRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class HoldLogin extends BaseUseCase<LoginResponse, Param> {
    private final LoginRepository loginRepository;

    @Inject
    public HoldLogin(LoginRepository loginRepository) {
        Intrinsics.checkNotNullParameter(loginRepository, "");
        this.loginRepository = loginRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<LoginResponse> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<LoginResponse> holdLogin = this.loginRepository.holdLogin(params.getGetOAuthMerchantName());
        Intrinsics.checkNotNullExpressionValue(holdLogin, "");
        return holdLogin;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\n\u0010\tR(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/domain/login/interactor/HoldLogin$Param;", "", "Lkotlin/Function0;", "", "getOAuthMerchantName", "Lkotlin/jvm/functions/Function0;", "getGetOAuthMerchantName", "()Lkotlin/jvm/functions/Function0;", "setGetOAuthMerchantName", "(Lkotlin/jvm/functions/Function0;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Param {
        private Function0<String> getOAuthMerchantName;

        public Param(Function0<String> function0) {
            Intrinsics.checkNotNullParameter(function0, "");
            this.getOAuthMerchantName = function0;
        }

        @JvmName(name = "getGetOAuthMerchantName")
        public final Function0<String> getGetOAuthMerchantName() {
            return this.getOAuthMerchantName;
        }

        @JvmName(name = "setGetOAuthMerchantName")
        public final void setGetOAuthMerchantName(Function0<String> function0) {
            Intrinsics.checkNotNullParameter(function0, "");
            this.getOAuthMerchantName = function0;
        }
    }
}
