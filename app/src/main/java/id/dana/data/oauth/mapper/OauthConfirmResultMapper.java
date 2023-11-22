package id.dana.data.oauth.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.authcode.AuthCodeResult;
import id.dana.domain.oauth.model.OauthConfirmation;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class OauthConfirmResultMapper extends BaseMapper<AuthCodeResult, OauthConfirmation> {
    @Inject
    public OauthConfirmResultMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public OauthConfirmation map(AuthCodeResult authCodeResult) {
        if (authCodeResult != null) {
            OauthConfirmation oauthConfirmation = new OauthConfirmation();
            oauthConfirmation.setServerAuthCode(authCodeResult.getAuthCode());
            oauthConfirmation.setMobileAuthCode(authCodeResult.getMobileAuthCode());
            return oauthConfirmation;
        }
        return null;
    }
}
