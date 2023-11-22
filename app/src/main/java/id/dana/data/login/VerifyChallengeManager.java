package id.dana.data.login;

import id.dana.data.login.source.network.model.VerifyMethod;
import id.dana.network.response.login.LoginRpcResult;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class VerifyChallengeManager {
    private String loginTokenId;
    private String phoneNumber;
    private String pin;
    private String securityId;

    @Inject
    public VerifyChallengeManager() {
    }

    public static boolean isNeedChallenge(List<String> list) {
        return list != null && list.size() > 0;
    }

    public static String getFirstVerificationOrder(LoginRpcResult loginRpcResult) {
        return (loginRpcResult == null || !isNeedChallenge(loginRpcResult.verificationMethods)) ? VerifyMethod.NO_VERIFICATION : loginRpcResult.verificationMethods.get(0);
    }

    public void setChallenge(String str, String str2, String str3) {
        this.phoneNumber = str;
        this.pin = str2;
        this.securityId = str3;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getPin() {
        return this.pin;
    }

    public String getSecurityId() {
        return this.securityId;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public void setPin(String str) {
        this.pin = str;
    }

    public void setSecurityId(String str) {
        this.securityId = str;
    }

    public String getLoginTokenId() {
        return this.loginTokenId;
    }

    public void setLoginTokenId(String str) {
        this.loginTokenId = str;
    }

    public void clear() {
        this.phoneNumber = null;
        this.pin = null;
        this.securityId = null;
        this.loginTokenId = null;
    }
}
