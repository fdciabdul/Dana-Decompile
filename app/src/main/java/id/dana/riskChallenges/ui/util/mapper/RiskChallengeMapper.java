package id.dana.riskChallenges.ui.util.mapper;

import id.dana.analytics.tracker.TrackerKey;
import id.dana.analytics.tracker.danaviz.DanaVizTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/riskChallenges/ui/util/mapper/RiskChallengeMapper;", "", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/String;)Ljava/lang/Integer;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Ljava/lang/String;", "Lid/dana/analytics/tracker/danaviz/DanaVizTracker$Source;", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Lid/dana/analytics/tracker/danaviz/DanaVizTracker$Source;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RiskChallengeMapper {
    public static final RiskChallengeMapper INSTANCE = new RiskChallengeMapper();

    public static DanaVizTracker.Source MyBillsEntityDataFactory(@TrackerKey.RiskChallenge.Source String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return null;
    }

    private RiskChallengeMapper() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
    
        if (r1.equals(id.dana.riskChallenges.constant.RiskChallengeKey.MIC_OTP_SMS) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0058, code lost:
    
        if (r1.equals(id.dana.riskChallenges.constant.RiskChallengeKey.OTP_SMS) != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
    
        return java.lang.Integer.valueOf(id.dana.riskChallenges.R.string.general_otp_sms);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Integer PlaceComponentResult(@id.dana.riskChallenges.constant.RiskChallengeKey java.lang.String r1) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            int r0 = r1.hashCode()
            switch(r0) {
                case -1953223090: goto L52;
                case -1683955915: goto L49;
                case -1547659207: goto L3a;
                case 1120391410: goto L2b;
                case 1772260612: goto L1c;
                case 1999612571: goto Ld;
                default: goto Lc;
            }
        Lc:
            goto L61
        Ld:
            java.lang.String r0 = "PASSWORD"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L61
            int r1 = id.dana.riskChallenges.R.string.res_0x7f1308d9_networkuserentitydata_externalsyntheticlambda1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L62
        L1c:
            java.lang.String r0 = "MICFACE"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L61
            int r1 = id.dana.riskChallenges.R.string.res_0x7f1308d2_networkuserentitydata_externalsyntheticlambda0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L62
        L2b:
            java.lang.String r0 = "MISSEDCALLOTP"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L61
            int r1 = id.dana.riskChallenges.R.string.general_missed_call_otp
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L62
        L3a:
            java.lang.String r0 = "WHATSAPPOTP"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L61
            int r1 = id.dana.riskChallenges.R.string.res_0x7f1308d8_networkuserentitydata_externalsyntheticlambda2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L62
        L49:
            java.lang.String r0 = "MICOTPSMS"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L5a
            goto L61
        L52:
            java.lang.String r0 = "OTPSMS"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L61
        L5a:
            int r1 = id.dana.riskChallenges.R.string.general_otp_sms
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L62
        L61:
            r1 = 0
        L62:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.ui.util.mapper.RiskChallengeMapper.PlaceComponentResult(java.lang.String):java.lang.Integer");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007e A[ORIG_RETURN, RETURN] */
    @id.dana.analytics.tracker.TrackerKey.RiskChallenge.Type
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String BuiltInFictitiousFunctionClassFactory(@id.dana.riskChallenges.constant.RiskChallengeKey java.lang.String r1) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            int r0 = r1.hashCode()
            switch(r0) {
                case -1953223090: goto L73;
                case -1683955915: goto L6a;
                case -1547659207: goto L5f;
                case -159625391: goto L54;
                case 2654: goto L4b;
                case 73352901: goto L42;
                case 908092024: goto L39;
                case 1120391410: goto L2e;
                case 1146827566: goto L25;
                case 1772260612: goto L1a;
                case 1999612571: goto Le;
                default: goto Lc;
            }
        Lc:
            goto L7e
        Le:
            java.lang.String r0 = "PASSWORD"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L7e
            java.lang.String r1 = "PIN"
            goto L7f
        L1a:
            java.lang.String r0 = "MICFACE"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L7e
            java.lang.String r1 = "DANA Viz"
            goto L7f
        L25:
            java.lang.String r0 = "RISKREJECT"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L5c
            goto L7e
        L2e:
            java.lang.String r0 = "MISSEDCALLOTP"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L7e
            java.lang.String r1 = "Missed Call OTP"
            goto L7f
        L39:
            java.lang.String r0 = "MICOTPEMAIL"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L5c
            goto L7e
        L42:
            java.lang.String r0 = "MICSQ"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L5c
            goto L7e
        L4b:
            java.lang.String r0 = "SQ"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L5c
            goto L7e
        L54:
            java.lang.String r0 = "OTPEMAIL"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L7e
        L5c:
            java.lang.String r1 = "REJECT"
            goto L7f
        L5f:
            java.lang.String r0 = "WHATSAPPOTP"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L7e
            java.lang.String r1 = "WhatsApp OTP"
            goto L7f
        L6a:
            java.lang.String r0 = "MICOTPSMS"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L7b
            goto L7e
        L73:
            java.lang.String r0 = "OTPSMS"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L7e
        L7b:
            java.lang.String r1 = "SMS OTP"
            goto L7f
        L7e:
            r1 = 0
        L7f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.ui.util.mapper.RiskChallengeMapper.BuiltInFictitiousFunctionClassFactory(java.lang.String):java.lang.String");
    }
}
