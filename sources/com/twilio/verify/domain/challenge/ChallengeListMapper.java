package com.twilio.verify.domain.challenge;

import android.net.Uri;
import com.twilio.security.logger.Level;
import com.twilio.security.logger.Logger;
import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.domain.challenge.models.ChallengeListMetadata;
import com.twilio.verify.domain.challenge.models.FactorChallengeList;
import com.twilio.verify.models.ChallengeList;
import java.text.ParseException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lcom/twilio/verify/domain/challenge/ChallengeListMapper;", "", "Lorg/json/JSONObject;", "p0", "Lcom/twilio/verify/models/ChallengeList;", "getAuthRequestContext", "(Lorg/json/JSONObject;)Lcom/twilio/verify/models/ChallengeList;", "Lcom/twilio/verify/domain/challenge/ChallengeMapper;", "PlaceComponentResult", "Lcom/twilio/verify/domain/challenge/ChallengeMapper;", "MyBillsEntityDataFactory", "<init>", "(Lcom/twilio/verify/domain/challenge/ChallengeMapper;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class ChallengeListMapper {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final ChallengeMapper MyBillsEntityDataFactory;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, com.twilio.verify.domain.challenge.ChallengeMapper] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ChallengeListMapper() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twilio.verify.domain.challenge.ChallengeListMapper.<init>():void");
    }

    private ChallengeListMapper(ChallengeMapper challengeMapper) {
        Intrinsics.checkParameterIsNotNull(challengeMapper, "");
        this.MyBillsEntityDataFactory = challengeMapper;
    }

    public /* synthetic */ ChallengeListMapper(ChallengeMapper challengeMapper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ChallengeMapper() : challengeMapper);
    }

    public final ChallengeList getAuthRequestContext(JSONObject p0) throws TwilioVerifyException {
        Intrinsics.checkParameterIsNotNull(p0, "");
        try {
            JSONArray jSONArray = p0.getJSONArray("challenges");
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                ChallengeMapper challengeMapper = this.MyBillsEntityDataFactory;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                Intrinsics.checkExpressionValueIsNotNull(jSONObject, "");
                arrayList.add(ChallengeMapper.KClassImpl$Data$declaredNonStaticMembers$2(challengeMapper, jSONObject));
            }
            JSONObject jSONObject2 = p0.getJSONObject("meta");
            int i2 = jSONObject2.getInt("page");
            int i3 = jSONObject2.getInt("page_size");
            String optString = jSONObject2.optString("previous_page_url");
            String queryParameter = optString != null ? Uri.parse(optString).getQueryParameter("PageToken") : null;
            String optString2 = jSONObject2.optString("next_page_url");
            return new FactorChallengeList(arrayList, new ChallengeListMetadata(i2, i3, queryParameter, optString2 != null ? Uri.parse(optString2).getQueryParameter("PageToken") : null));
        } catch (ParseException e) {
            Logger logger = Logger.PlaceComponentResult;
            Level level = Level.Error;
            String obj = e.toString();
            ParseException parseException = e;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(level, obj, parseException);
            throw new TwilioVerifyException(parseException, TwilioVerifyException.ErrorCode.MapperError);
        } catch (JSONException e2) {
            Logger logger2 = Logger.PlaceComponentResult;
            Level level2 = Level.Error;
            String obj2 = e2.toString();
            JSONException jSONException = e2;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(level2, obj2, jSONException);
            throw new TwilioVerifyException(jSONException, TwilioVerifyException.ErrorCode.MapperError);
        }
    }
}
