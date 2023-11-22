package id.dana.riskChallenges.ui.otp.otpwhatsapp;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.utils.danah5.DanaH5Facade;

/* loaded from: classes5.dex */
public final class OtpWhatsappSharedLogicHandler_MembersInjector implements MembersInjector<OtpWhatsappSharedLogicHandler> {
    public static void PlaceComponentResult(OtpWhatsappSharedLogicHandler otpWhatsappSharedLogicHandler, Lazy<DanaH5Facade> lazy) {
        otpWhatsappSharedLogicHandler.danaH5Facade = lazy;
    }
}
