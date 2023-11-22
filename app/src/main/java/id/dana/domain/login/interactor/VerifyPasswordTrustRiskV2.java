package id.dana.domain.login.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.login.LoginRepository;
import id.dana.domain.login.model.VerifyPasswordResult;
import id.dana.domain.model.rpc.UserInfo;
import id.dana.domain.model.rpc.response.LoginResponse;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\r\u000eB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/login/interactor/VerifyPasswordTrustRiskV2;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/model/rpc/response/LoginResponse;", "Lid/dana/domain/login/interactor/VerifyPasswordTrustRiskV2$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/login/interactor/VerifyPasswordTrustRiskV2$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/login/LoginRepository;", "loginRepository", "Lid/dana/domain/login/LoginRepository;", "<init>", "(Lid/dana/domain/login/LoginRepository;)V", "Companion", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VerifyPasswordTrustRiskV2 extends BaseUseCase<LoginResponse, Param> {
    private static final String TRUST_RISK_LOGIN_SCENE = "TRUST_RISK_LOGIN";
    private final LoginRepository loginRepository;

    @Inject
    public VerifyPasswordTrustRiskV2(LoginRepository loginRepository) {
        Intrinsics.checkNotNullParameter(loginRepository, "");
        this.loginRepository = loginRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<LoginResponse> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable map = this.loginRepository.verifyPasswordTrustRiskV2(params.getPassword(), "TRUST_RISK_LOGIN", params.getOperationId()).map(new Function() { // from class: id.dana.domain.login.interactor.VerifyPasswordTrustRiskV2$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                LoginResponse m2365buildUseCase$lambda1;
                m2365buildUseCase$lambda1 = VerifyPasswordTrustRiskV2.m2365buildUseCase$lambda1((VerifyPasswordResult) obj);
                return m2365buildUseCase$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-1  reason: not valid java name */
    public static final LoginResponse m2365buildUseCase$lambda1(VerifyPasswordResult verifyPasswordResult) {
        Intrinsics.checkNotNullParameter(verifyPasswordResult, "");
        String str = null;
        String str2 = null;
        String str3 = null;
        Boolean bool = null;
        String str4 = null;
        UserInfo userInfo = null;
        LoginResponse loginResponse = new LoginResponse(str, str2, str3, bool, str4, userInfo, Integer.valueOf(verifyPasswordResult.getMaxFailedCount()), Integer.valueOf(verifyPasswordResult.getLockedExpireSeconds()), verifyPasswordResult.getFailedCount(), null, null, null, null, null, null, null, 65087, null);
        loginResponse.setSuccess(verifyPasswordResult.getSuccess());
        return loginResponse;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b"}, d2 = {"Lid/dana/domain/login/interactor/VerifyPasswordTrustRiskV2$Param;", "", "", "operationId", "Ljava/lang/String;", "getOperationId", "()Ljava/lang/String;", "setOperationId", "(Ljava/lang/String;)V", "password", "getPassword", "setPassword", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Param {
        private String operationId;
        private String password;

        public Param(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.password = str;
            this.operationId = str2;
        }

        @JvmName(name = "getPassword")
        public final String getPassword() {
            return this.password;
        }

        @JvmName(name = "setPassword")
        public final void setPassword(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.password = str;
        }

        @JvmName(name = "getOperationId")
        public final String getOperationId() {
            return this.operationId;
        }

        @JvmName(name = "setOperationId")
        public final void setOperationId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.operationId = str;
        }
    }
}
