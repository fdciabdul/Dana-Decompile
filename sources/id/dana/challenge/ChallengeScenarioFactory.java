package id.dana.challenge;

import android.os.Bundle;
import id.dana.challenge.scenario.AuthAgreementOtpScenario;
import id.dana.challenge.scenario.AuthAgreementPinScenario;
import id.dana.challenge.scenario.AutoRouteScenario;
import id.dana.challenge.scenario.CardBindingOtpScenario;
import id.dana.challenge.scenario.CardBindingPinScenario;
import id.dana.challenge.scenario.FaceActivationScenario;
import id.dana.challenge.scenario.FamilyAccountScenario;
import id.dana.challenge.scenario.JoinFamilyAccountScenario;
import id.dana.challenge.scenario.LoginScenario;
import id.dana.challenge.scenario.OtpRegistrationScenario;
import id.dana.challenge.scenario.PaymentAuthScenario;
import id.dana.challenge.scenario.RemoveFamilyAccountScenario;
import id.dana.challenge.scenario.RemoveFamilyMemberScenario;
import id.dana.challenge.scenario.ScenarioFacade;
import id.dana.challenge.scenario.TrustRiskLoginScenario;
import id.dana.challenge.scenario.TrustRiskLoginV2Scenario;
import id.dana.challenge.scenario.TwilioOtpScenario;
import id.dana.challenge.scenario.TwilioPinScenario;
import id.dana.challenge.scenario.UnbindMerchantScenario;
import id.dana.challenge.scenario.VerifyPushScenario;
import id.dana.challenge.scenario.WalletPersonalKtpScenario;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/challenge/ChallengeScenarioFactory;", "", "", "p0", "Landroid/os/Bundle;", "p1", "Lid/dana/challenge/scenario/ScenarioFacade;", "PlaceComponentResult", "(Ljava/lang/String;Landroid/os/Bundle;)Lid/dana/challenge/scenario/ScenarioFacade;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ChallengeScenarioFactory {
    public static final ChallengeScenarioFactory INSTANCE = new ChallengeScenarioFactory();

    private ChallengeScenarioFactory() {
    }

    @JvmStatic
    public static final ScenarioFacade PlaceComponentResult(String p0, Bundle p1) {
        if (p0 != null) {
            switch (p0.hashCode()) {
                case -2047416274:
                    if (p0.equals(ChallengeScenario.WALLET_PERSONAL_KTP)) {
                        return new WalletPersonalKtpScenario(p1);
                    }
                    break;
                case -1999183539:
                    if (p0.equals(ChallengeScenario.REGISTRATION)) {
                        return new OtpRegistrationScenario(p1);
                    }
                    break;
                case -978524326:
                    if (p0.equals(ChallengeScenario.REMOVE_FAMILY_MEMBER)) {
                        return new RemoveFamilyMemberScenario(p1);
                    }
                    break;
                case -786182429:
                    if (p0.equals(ChallengeScenario.JOIN_INVITATION_FAMILY_ACCOUNT)) {
                        return new JoinFamilyAccountScenario(p1);
                    }
                    break;
                case -781220926:
                    if (p0.equals(ChallengeScenario.CARD_BINDING_OTP)) {
                        return new CardBindingOtpScenario(p1);
                    }
                    break;
                case -781220308:
                    if (p0.equals("card_binding_pin")) {
                        return new CardBindingPinScenario(p1);
                    }
                    break;
                case -497502143:
                    if (p0.equals("payment_auth")) {
                        return new PaymentAuthScenario(p1);
                    }
                    break;
                case -489325167:
                    if (p0.equals("unbind_merchant")) {
                        return new UnbindMerchantScenario(p1);
                    }
                    break;
                case -41045063:
                    if (p0.equals("auto_route")) {
                        return new AutoRouteScenario(p1);
                    }
                    break;
                case 539748434:
                    if (p0.equals("family_account")) {
                        return new FamilyAccountScenario(p1);
                    }
                    break;
                case 703631723:
                    if (p0.equals(ChallengeScenario.TRUST_RISK_LOGIN_TWILIO)) {
                        return new VerifyPushScenario(p1);
                    }
                    break;
                case 1124674296:
                    if (p0.equals("twilio_otp")) {
                        return new TwilioOtpScenario(p1);
                    }
                    break;
                case 1124674914:
                    if (p0.equals("twilio_pin")) {
                        return new TwilioPinScenario(p1);
                    }
                    break;
                case 1319662811:
                    if (p0.equals(ChallengeScenario.TRUST_RISK_LOGIN_V2)) {
                        return new TrustRiskLoginV2Scenario(p1);
                    }
                    break;
                case 1573803584:
                    if (p0.equals(ChallengeScenario.TRUST_RISK_LOGIN)) {
                        return new TrustRiskLoginScenario(p1);
                    }
                    break;
                case 1656771640:
                    if (p0.equals("face_activation")) {
                        return new FaceActivationScenario(p1);
                    }
                    break;
                case 1667024159:
                    if (p0.equals(ChallengeScenario.AUTH_AGREEMENT_OTP)) {
                        return new AuthAgreementOtpScenario(p1);
                    }
                    break;
                case 1667024777:
                    if (p0.equals(ChallengeScenario.AUTH_AGREEMENT_PIN)) {
                        return new AuthAgreementPinScenario(p1);
                    }
                    break;
                case 1899283821:
                    if (p0.equals(ChallengeScenario.REMOVE_FAMILY_ACCOUNT)) {
                        return new RemoveFamilyAccountScenario(p1);
                    }
                    break;
            }
        }
        return new LoginScenario(p1);
    }
}
