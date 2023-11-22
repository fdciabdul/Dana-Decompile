package id.dana.riskChallenges.constant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/riskChallenges/constant/RiskChallengeKey;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public @interface RiskChallengeKey {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.KClassImpl$Data$declaredNonStaticMembers$2;
    public static final String MIC_FACE = "MICFACE";
    public static final String MIC_OTP_EMAIL = "MICOTPEMAIL";
    public static final String MIC_OTP_SMS = "MICOTPSMS";
    public static final String MIC_SQ = "MICSQ";
    public static final String MISSED_CALL_OTP = "MISSEDCALLOTP";
    public static final String OTP_EMAIL = "OTPEMAIL";
    public static final String OTP_SMS = "OTPSMS";
    public static final String PASSKEYS = "PASSKEYS";
    public static final String PASSWORD = "PASSWORD";
    public static final String RISK_REJECT = "RISKREJECT";
    public static final String SQ = "SQ";
    public static final String WHATSAPP_OTP = "WHATSAPPOTP";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/riskChallenges/constant/RiskChallengeKey$Companion;", "", "", "", "BuiltInFictitiousFunctionClassFactory", "()Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion KClassImpl$Data$declaredNonStaticMembers$2 = new Companion();

        private Companion() {
        }

        public static List<String> BuiltInFictitiousFunctionClassFactory() {
            return CollectionsKt.listOf((Object[]) new String[]{RiskChallengeKey.MIC_FACE, RiskChallengeKey.MIC_OTP_SMS, RiskChallengeKey.OTP_SMS, RiskChallengeKey.MIC_OTP_EMAIL, RiskChallengeKey.OTP_EMAIL, RiskChallengeKey.MIC_SQ, "SQ", RiskChallengeKey.RISK_REJECT, RiskChallengeKey.MISSED_CALL_OTP, "PASSWORD", RiskChallengeKey.WHATSAPP_OTP, "PASSKEYS"});
        }
    }
}
