package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.challenge.ChallengeScenario;
import id.dana.challenge.pin.AbstractPinContract;
import id.dana.challenge.pin.PinAuthAgreementPresenter;
import id.dana.challenge.pin.PinLoginPresenter;
import id.dana.challenge.pin.PinPaymentAuthPresenter;
import id.dana.challenge.pin.PinSwitchAutoRoutePresenter;
import id.dana.challenge.pin.PinSwitchFaceAuthPresenter;
import id.dana.challenge.pin.PinTwilioPresenter;
import id.dana.challenge.pin.presenter.PinCardBindingPresenter;
import id.dana.challenge.pin.presenter.PinFamilyAccountPresenter;
import id.dana.challenge.pin.presenter.PinUnbindMerchantPresenter;
import id.dana.challenge.pin.presenter.PinWalletPersonalKtpPresenter;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes4.dex */
public class PinChallengeModule {
    private final AbstractPinContract.View KClassImpl$Data$declaredNonStaticMembers$2;
    private final String getAuthRequestContext;

    public PinChallengeModule(AbstractPinContract.View view, String str) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.getAuthRequestContext = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public AbstractPinContract.View BuiltInFictitiousFunctionClassFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public AbstractPinContract.Presenter BuiltInFictitiousFunctionClassFactory(PinLoginPresenter pinLoginPresenter, PinPaymentAuthPresenter pinPaymentAuthPresenter, PinSwitchFaceAuthPresenter pinSwitchFaceAuthPresenter, PinUnbindMerchantPresenter pinUnbindMerchantPresenter, PinTwilioPresenter pinTwilioPresenter, PinSwitchAutoRoutePresenter pinSwitchAutoRoutePresenter, PinAuthAgreementPresenter pinAuthAgreementPresenter, PinFamilyAccountPresenter pinFamilyAccountPresenter, PinWalletPersonalKtpPresenter pinWalletPersonalKtpPresenter, PinCardBindingPresenter pinCardBindingPresenter) {
        if ("login".equals(this.getAuthRequestContext) || ChallengeScenario.TRUST_RISK_LOGIN.equals(this.getAuthRequestContext) || ChallengeScenario.TRUST_RISK_LOGIN_V2.equals(this.getAuthRequestContext)) {
            return pinLoginPresenter;
        }
        if ("twilio_pin".equals(this.getAuthRequestContext) || "twilio_otp".equals(this.getAuthRequestContext)) {
            return pinTwilioPresenter;
        }
        if ("payment_auth".equals(this.getAuthRequestContext)) {
            return pinPaymentAuthPresenter;
        }
        if ("face_activation".equals(this.getAuthRequestContext)) {
            return pinSwitchFaceAuthPresenter;
        }
        if ("unbind_merchant".equals(this.getAuthRequestContext)) {
            return pinUnbindMerchantPresenter;
        }
        if ("auto_route".equals(this.getAuthRequestContext)) {
            return pinSwitchAutoRoutePresenter;
        }
        if (ChallengeScenario.AUTH_AGREEMENT_PIN.equals(this.getAuthRequestContext)) {
            return pinAuthAgreementPresenter;
        }
        if ("family_account".equals(this.getAuthRequestContext) || ChallengeScenario.REMOVE_FAMILY_ACCOUNT.equals(this.getAuthRequestContext) || ChallengeScenario.REMOVE_FAMILY_MEMBER.equals(this.getAuthRequestContext) || ChallengeScenario.JOIN_INVITATION_FAMILY_ACCOUNT.equals(this.getAuthRequestContext)) {
            return pinFamilyAccountPresenter;
        }
        if ("card_binding_pin".equals(this.getAuthRequestContext)) {
            return pinCardBindingPresenter;
        }
        if (ChallengeScenario.WALLET_PERSONAL_KTP.equals(this.getAuthRequestContext)) {
            return pinWalletPersonalKtpPresenter;
        }
        return null;
    }
}
