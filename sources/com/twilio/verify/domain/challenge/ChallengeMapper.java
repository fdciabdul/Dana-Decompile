package com.twilio.verify.domain.challenge;

import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.models.Challenge;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¨\u0006\f"}, d2 = {"Lcom/twilio/verify/domain/challenge/ChallengeMapper;", "", "()V", "fromApi", "Lcom/twilio/verify/models/Challenge;", "jsonObject", "Lorg/json/JSONObject;", "signatureFieldsHeader", "", "toChallengeDetails", "Lcom/twilio/verify/models/ChallengeDetails;", "details", "verify_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class ChallengeMapper {
    public static /* synthetic */ Challenge KClassImpl$Data$declaredNonStaticMembers$2(ChallengeMapper challengeMapper, JSONObject jSONObject) throws TwilioVerifyException {
        return challengeMapper.getAuthRequestContext(jSONObject, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0105 A[Catch: ParseException -> 0x0156, JSONException -> 0x0158, TryCatch #2 {ParseException -> 0x0156, JSONException -> 0x0158, blocks: (B:71:0x0007, B:74:0x0023, B:80:0x003d, B:81:0x003f, B:84:0x0045, B:86:0x005d, B:91:0x0068, B:93:0x00ab, B:100:0x00b9, B:102:0x00c7, B:104:0x00ed, B:110:0x0105, B:112:0x010b, B:114:0x011b, B:115:0x012f, B:117:0x0135, B:118:0x0147, B:119:0x014a, B:103:0x00e9, B:77:0x0037), top: B:130:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x011b A[Catch: ParseException -> 0x0156, JSONException -> 0x0158, TryCatch #2 {ParseException -> 0x0156, JSONException -> 0x0158, blocks: (B:71:0x0007, B:74:0x0023, B:80:0x003d, B:81:0x003f, B:84:0x0045, B:86:0x005d, B:91:0x0068, B:93:0x00ab, B:100:0x00b9, B:102:0x00c7, B:104:0x00ed, B:110:0x0105, B:112:0x010b, B:114:0x011b, B:115:0x012f, B:117:0x0135, B:118:0x0147, B:119:0x014a, B:103:0x00e9, B:77:0x0037), top: B:130:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.twilio.verify.models.Challenge getAuthRequestContext(org.json.JSONObject r23, java.lang.String r24) throws com.twilio.verify.TwilioVerifyException {
        /*
            Method dump skipped, instructions count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twilio.verify.domain.challenge.ChallengeMapper.getAuthRequestContext(org.json.JSONObject, java.lang.String):com.twilio.verify.models.Challenge");
    }
}
