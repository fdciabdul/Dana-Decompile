package id.dana.data.login.source;

import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.danah5.constant.BridgeName;
import id.dana.data.login.source.network.result.CheckSessionResult;
import id.dana.data.login.source.network.result.LogoutRpcResult;
import id.dana.data.registration.source.network.result.Trust2RiskLoginResult;
import id.dana.domain.foundation.logger.LoginScenarioConstant;
import id.dana.network.response.login.LoginRpcResult;
import id.dana.network.response.login.VerifyPasswordRpcResult;
import io.reactivex.Observable;
import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J;\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004H&¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00042\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\bH'¢\u0006\u0004\b\u0017\u0010\u0018JQ\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u0004H&¢\u0006\u0004\b \u0010\u0012JW\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00160\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010!\u001a\u0004\u0018\u00010\b2\b\u0010\"\u001a\u0004\u0018\u00010\b2\b\u0010#\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b$\u0010%J?\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00160\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b'\u0010(J-\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\u00042\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\bH&¢\u0006\u0004\b-\u0010\u0018JK\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00160\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\b2\b\u0010\"\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b.\u0010/ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/login/source/LoginEntityData;", "", "", "isNewCheckSessionApi", "Lio/reactivex/Observable;", "Lid/dana/data/login/source/network/result/CheckSessionResult;", "checkSession", "(Ljava/lang/Boolean;)Lio/reactivex/Observable;", "", "phoneNumber", "isWhatsAppInstalled", "isPasskeysSupported", "credentialId", "Lid/dana/data/registration/source/network/result/Trust2RiskLoginResult;", "consultTrust2RiskLogin", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/alipayplus/mobile/component/common/facade/base/MobileEnvInfo;", BridgeName.GET_ENV_INFO, "()Lio/reactivex/Observable;", "userId", "clientKey", "operationType", "Lid/dana/network/response/login/LoginRpcResult;", "holdLogin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "pin", "key", BioUtilityBridge.SECURITY_ID, "scenario", "login", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lio/reactivex/Observable;", "Lid/dana/data/login/source/network/result/LogoutRpcResult;", "logout", "verifyAnswer", "loginType", "verifyMethod", LoginScenarioConstant.OTPLOGIN, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "loginTokenId", "trust2RiskLogin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "password", "scene", "loginOperationId", "Lid/dana/network/response/login/VerifyPasswordRpcResult;", "verifyPasswordTrustRiskV2", "verifyPushLogin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface LoginEntityData {
    Observable<CheckSessionResult> checkSession(Boolean isNewCheckSessionApi);

    Observable<Trust2RiskLoginResult> consultTrust2RiskLogin(String phoneNumber, Boolean isWhatsAppInstalled, String isPasskeysSupported, String credentialId);

    Observable<MobileEnvInfo> getEnvInfo();

    @Deprecated(message = "")
    Observable<LoginRpcResult> holdLogin(String userId, String clientKey, String operationType);

    Observable<LoginRpcResult> login(String phoneNumber, String pin, String key, String r4, String scenario, Boolean isWhatsAppInstalled);

    Observable<LogoutRpcResult> logout();

    Observable<LoginRpcResult> otpLogin(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    Observable<LoginRpcResult> trust2RiskLogin(String phoneNumber, String r2, String loginTokenId, String isPasskeysSupported, String credentialId);

    Observable<VerifyPasswordRpcResult> verifyPasswordTrustRiskV2(String password, String scene, String loginOperationId);

    Observable<LoginRpcResult> verifyPushLogin(String phoneNumber, String pin, String key, String r4, String verifyAnswer, String loginType);
}
