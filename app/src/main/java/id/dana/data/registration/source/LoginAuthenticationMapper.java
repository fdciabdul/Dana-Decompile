package id.dana.data.registration.source;

import id.dana.data.base.BaseMapper;
import id.dana.data.registration.model.LoginAuthenticationOptionResult;
import id.dana.domain.model.rpc.response.LoginAuthenticationOptionResponse;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class LoginAuthenticationMapper extends BaseMapper<LoginAuthenticationOptionResult, LoginAuthenticationOptionResponse> {
    @Inject
    public LoginAuthenticationMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public LoginAuthenticationOptionResponse map(LoginAuthenticationOptionResult loginAuthenticationOptionResult) {
        if (loginAuthenticationOptionResult != null) {
            LoginAuthenticationOptionResponse loginAuthenticationOptionResponse = new LoginAuthenticationOptionResponse();
            loginAuthenticationOptionResponse.setAuthenticationMethod(loginAuthenticationOptionResult.getAuthenticationMethod());
            loginAuthenticationOptionResponse.setEnrollFlag(loginAuthenticationOptionResult.isEnrollFlag());
            loginAuthenticationOptionResponse.setKycFlag(loginAuthenticationOptionResult.isKycFlag());
            loginAuthenticationOptionResponse.setRiskFlag(loginAuthenticationOptionResult.isRiskFlag());
            return loginAuthenticationOptionResponse;
        }
        return null;
    }
}
