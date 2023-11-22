package id.dana.domain.login;

import com.iap.ac.android.rpccommon.model.facade.MobileEnvInfo;
import id.dana.domain.login.model.VerifyPasswordResult;
import id.dana.domain.model.rpc.response.LoginResponse;
import id.dana.domain.model.rpc.response.Trust2RiskLoginResponse;
import io.reactivex.Observable;
import kotlin.jvm.functions.Function0;

/* loaded from: classes2.dex */
public interface LoginRepository {
    Observable<Boolean> checkSession();

    Observable<Trust2RiskLoginResponse> consultTrust2RiskLogin(String str, Boolean bool, String str2, String str3);

    Observable<Boolean> forceLogout();

    Observable<MobileEnvInfo> getEnvInfo();

    Observable<Boolean> getIsSessionChecked();

    Observable<LoginResponse> holdLogin(Function0<String> function0);

    Observable<LoginResponse> login(String str, String str2, String str3, boolean z);

    Observable<Boolean> logout();

    Observable<LoginResponse> otpLogin(String str, String str2, String str3);

    Observable<Boolean> saveIsSessionChecked(Boolean bool);

    Observable<LoginResponse> trust2RiskLogin(String str, String str2);

    Observable<VerifyPasswordResult> verifyPasswordTrustRiskV2(String str, String str2, String str3);

    Observable<LoginResponse> verifyPushLogin(String str, String str2, int i, int i2);
}
