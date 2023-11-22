package id.dana.challenge;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface ChallengeScenario {
    public static final String AUTH_AGREEMENT_OTP = "auth_agreement_otp";
    public static final String AUTH_AGREEMENT_PIN = "auth_agreement_pin";
    public static final String AUTO_ROUTE = "auto_route";
    public static final String CARD_BINDING_OTP = "card_binding_otp";
    public static final String CARD_BINDING_PIN = "card_binding_pin";
    public static final String CASHIER = "cashier";
    public static final String FACE_ACTIVATION = "face_activation";
    public static final String FAMILY_ACCOUNT = "family_account";
    public static final String JOIN_INVITATION_FAMILY_ACCOUNT = "join_invitation_family_account";
    public static final String LOGIN = "login";
    public static final String PAYMENT_AUTH = "payment_auth";
    public static final String REGISTRATION = "otp_registration";
    public static final String REMOVE_FAMILY_ACCOUNT = "remove_family_account";
    public static final String REMOVE_FAMILY_MEMBER = "remove_family_member";
    public static final String TRUST_RISK_LOGIN = "trust_risk_login";
    public static final String TRUST_RISK_LOGIN_TWILIO = "trust_risk_login_twilio";
    public static final String TRUST_RISK_LOGIN_V2 = "trust_risk_login_v2";
    public static final String TWILIO_OTP = "twilio_otp";
    public static final String TWILIO_PIN = "twilio_pin";
    public static final String UNBIND_MERCHANT = "unbind_merchant";
    public static final String WALLET_PERSONAL_KTP = "wallet_personal_ktp";
}
