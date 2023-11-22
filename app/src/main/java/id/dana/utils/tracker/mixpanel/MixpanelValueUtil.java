package id.dana.utils.tracker.mixpanel;

import id.dana.challenge.ChallengeScenario;
import id.dana.domain.otp.model.OtpChannel;
import id.dana.tracker.mixpanel.ChallengeEvent;

/* loaded from: classes5.dex */
public class MixpanelValueUtil {
    private MixpanelValueUtil() {
    }

    public static String getAuthRequestContext(String str) {
        if (str == null) {
            return "";
        }
        str.hashCode();
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1142348422) {
            if (hashCode != 708704563) {
                if (hashCode == 1854112322 && str.equals(OtpChannel.WHATSAPP)) {
                    c = 2;
                }
            } else if (str.equals(OtpChannel.SMS)) {
                c = 1;
            }
        } else if (str.equals("Misscall")) {
            c = 0;
        }
        return c != 0 ? c != 1 ? c != 2 ? "" : ChallengeEvent.Channel.WHATSAPP : ChallengeEvent.Channel.SMS : "Misscall";
    }

    public static String BuiltInFictitiousFunctionClassFactory(String str) {
        if (str == null) {
            return "";
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1999183539:
                if (str.equals(ChallengeScenario.REGISTRATION)) {
                    c = 0;
                    break;
                }
                break;
            case -497502143:
                if (str.equals("payment_auth")) {
                    c = 1;
                    break;
                }
                break;
            case -489325167:
                if (str.equals("unbind_merchant")) {
                    c = 2;
                    break;
                }
                break;
            case 103149417:
                if (str.equals("login")) {
                    c = 3;
                    break;
                }
                break;
            case 1319662811:
                if (str.equals(ChallengeScenario.TRUST_RISK_LOGIN_V2)) {
                    c = 4;
                    break;
                }
                break;
            case 1573803584:
                if (str.equals(ChallengeScenario.TRUST_RISK_LOGIN)) {
                    c = 5;
                    break;
                }
                break;
            case 1656771640:
                if (str.equals("face_activation")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "Registration";
            case 1:
                return ChallengeEvent.Source.PAYMENT_AUTH;
            case 2:
                return ChallengeEvent.Source.UNBIND_MERCHANT;
            case 3:
                return "Login";
            case 4:
                return "Trust Risk Login V2";
            case 5:
                return ChallengeEvent.Source.TRUST_RISK_LOGIN;
            case 6:
                return ChallengeEvent.Source.FACE_ACTIVATION;
            default:
                return "";
        }
    }
}
