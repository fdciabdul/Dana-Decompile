package com.twilio.verify.api;

import android.content.Context;
import com.twilio.verify.data.DateProvider;
import com.twilio.verify.domain.challenge.models.FactorChallenge;
import com.twilio.verify.models.Factor;
import com.twilio.verify.networking.Authentication;
import com.twilio.verify.networking.NetworkProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\r"}, d2 = {"Lcom/twilio/verify/api/ChallengeAPIClient;", "Lcom/twilio/verify/api/BaseAPIClient;", "Lcom/twilio/verify/networking/Authentication;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/twilio/verify/networking/Authentication;", "MyBillsEntityDataFactory", "", "PlaceComponentResult", "Ljava/lang/String;", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "Lcom/twilio/verify/networking/NetworkProvider;", "Lcom/twilio/verify/networking/NetworkProvider;", "getAuthRequestContext", "p0", "p1", "p2", "p3", "Lcom/twilio/verify/data/DateProvider;", "p4", "<init>", "(Lcom/twilio/verify/networking/NetworkProvider;Landroid/content/Context;Lcom/twilio/verify/networking/Authentication;Ljava/lang/String;Lcom/twilio/verify/data/DateProvider;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class ChallengeAPIClient extends BaseAPIClient {
    private final Context BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Authentication MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final NetworkProvider getAuthRequestContext;
    private final String PlaceComponentResult;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ ChallengeAPIClient(com.twilio.verify.networking.NetworkAdapter r7, android.content.Context r8, com.twilio.verify.networking.Authentication r9, java.lang.String r10, com.twilio.verify.data.DateProvider r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 1
            if (r13 == 0) goto Lb
            com.twilio.verify.networking.NetworkAdapter r7 = new com.twilio.verify.networking.NetworkAdapter
            r7.<init>()
            com.twilio.verify.networking.NetworkProvider r7 = (com.twilio.verify.networking.NetworkProvider) r7
        Lb:
            r1 = r7
            r7 = r12 & 16
            if (r7 == 0) goto L20
            android.content.SharedPreferences r7 = com.twilio.verify.TwilioVerifyKt.PlaceComponentResult(r8)
            java.lang.String r11 = ""
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r11)
            com.twilio.verify.data.DateAdapter r11 = new com.twilio.verify.data.DateAdapter
            r11.<init>(r7)
            com.twilio.verify.data.DateProvider r11 = (com.twilio.verify.data.DateProvider) r11
        L20:
            r5 = r11
            r0 = r6
            r2 = r8
            r3 = r9
            r4 = r10
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twilio.verify.api.ChallengeAPIClient.<init>(com.twilio.verify.networking.NetworkProvider, android.content.Context, com.twilio.verify.networking.Authentication, java.lang.String, com.twilio.verify.data.DateProvider, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private ChallengeAPIClient(NetworkProvider networkProvider, Context context, Authentication authentication, String str, DateProvider dateProvider) {
        super(dateProvider);
        Intrinsics.checkParameterIsNotNull(networkProvider, "");
        Intrinsics.checkParameterIsNotNull(context, "");
        Intrinsics.checkParameterIsNotNull(authentication, "");
        Intrinsics.checkParameterIsNotNull(str, "");
        Intrinsics.checkParameterIsNotNull(dateProvider, "");
        this.getAuthRequestContext = networkProvider;
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.MyBillsEntityDataFactory = authentication;
        this.PlaceComponentResult = str;
    }

    public static final /* synthetic */ String PlaceComponentResult(ChallengeAPIClient challengeAPIClient, String str, Factor factor) {
        StringBuilder sb = new StringBuilder();
        sb.append(challengeAPIClient.PlaceComponentResult);
        sb.append("Services/{ServiceSid}/Entities/{Identity}/Challenges/{ChallengeSid}");
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace(sb.toString(), "{ServiceSid}", factor.getMoveToNextValue(), true), "{Identity}", factor.getBuiltInFictitiousFunctionClassFactory(), false, 4, (Object) null), "{ChallengeSid}", str, false, 4, (Object) null);
    }

    public static final /* synthetic */ String getAuthRequestContext(ChallengeAPIClient challengeAPIClient, Factor factor) {
        StringBuilder sb = new StringBuilder();
        sb.append(challengeAPIClient.PlaceComponentResult);
        sb.append("Services/{ServiceSid}/Entities/{Identity}/Challenges");
        return StringsKt.replace$default(StringsKt.replace(sb.toString(), "{ServiceSid}", factor.getMoveToNextValue(), true), "{Identity}", factor.getBuiltInFictitiousFunctionClassFactory(), false, 4, (Object) null);
    }

    public static final /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2(ChallengeAPIClient challengeAPIClient, FactorChallenge factorChallenge) {
        Factor factor = factorChallenge.KClassImpl$Data$declaredNonStaticMembers$2;
        if (factor != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(challengeAPIClient.PlaceComponentResult);
            sb.append("Services/{ServiceSid}/Entities/{Identity}/Challenges/{ChallengeSid}");
            String replace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace(sb.toString(), "{ServiceSid}", factor.getMoveToNextValue(), true), "{Identity}", factor.getBuiltInFictitiousFunctionClassFactory(), false, 4, (Object) null), "{ChallengeSid}", factorChallenge.getErrorConfigVersion, false, 4, (Object) null);
            if (replace$default != null) {
                return replace$default;
            }
        }
        throw new IllegalArgumentException("ServiceSid or Identity is null or empty");
    }
}
