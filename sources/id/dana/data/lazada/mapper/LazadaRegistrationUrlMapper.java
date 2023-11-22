package id.dana.data.lazada.mapper;

import id.dana.data.lazada.repository.source.network.response.LazadaRegistrationUrlResult;
import id.dana.domain.lazada.LazadaRegistrationUrl;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class LazadaRegistrationUrlMapper {
    @Inject
    public LazadaRegistrationUrlMapper() {
    }

    public LazadaRegistrationUrl transform(LazadaRegistrationUrlResult lazadaRegistrationUrlResult) {
        if (lazadaRegistrationUrlResult != null) {
            LazadaRegistrationUrl lazadaRegistrationUrl = new LazadaRegistrationUrl();
            lazadaRegistrationUrl.setRedirectUrl(lazadaRegistrationUrlResult.redirectUrl);
            lazadaRegistrationUrl.setNeedUserConsent(lazadaRegistrationUrlResult.needUserConsent);
            lazadaRegistrationUrl.setUserConsentConfigKey(lazadaRegistrationUrlResult.userConsentConfigKey);
            lazadaRegistrationUrl.setUserConsentMessage(lazadaRegistrationUrlResult.userConsentMessage);
            return lazadaRegistrationUrl;
        }
        return null;
    }
}
