package com.twilio.verify.domain.challenge.models;

import com.twilio.verify.models.Challenge;
import com.twilio.verify.models.ChallengeDetails;
import com.twilio.verify.models.ChallengeStatus;
import com.twilio.verify.models.Factor;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\"\u001a\u00020\u000f\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0013\u0012\u0006\u0010%\u001a\u00020\u000f\u0012\u0006\u0010&\u001a\u00020\u001d\u0012\u0006\u0010'\u001a\u00020\b\u0012\u0006\u0010(\u001a\u00020\b\u0012\u0006\u0010)\u001a\u00020\b\u0012\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001a\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b,\u0010-R\u001a\u0010\u0007\u001a\u00020\u00028\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\t\u001a\u00020\bX\u0017¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\bX\u0017¢\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0014\u0010\u0005\u001a\u0004\u0018\u00010\fX\u0081\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\r\u001a\u00020\u000f8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0007\u0010\u0012R(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00138\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u000b\u0010\u0016R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0017X\u0001¢\u0006\u0006\n\u0004\b\u000b\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u000f8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\r\u0010\u0012R\u0019\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001aX\u0001¢\u0006\u0006\n\u0004\b\u0019\u0010\u001bR\u001a\u0010\u0014\u001a\u00020\u001d8\u0017X\u0097\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\t\u0010 R\u0011\u0010!\u001a\u00020\bX\u0017¢\u0006\u0006\n\u0004\b\u001c\u0010\n"}, d2 = {"Lcom/twilio/verify/domain/challenge/models/FactorChallenge;", "Lcom/twilio/verify/models/Challenge;", "Lcom/twilio/verify/models/ChallengeDetails;", "getErrorConfigVersion", "Lcom/twilio/verify/models/ChallengeDetails;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lcom/twilio/verify/models/ChallengeDetails;", "getAuthRequestContext", "Ljava/util/Date;", "PlaceComponentResult", "Ljava/util/Date;", "MyBillsEntityDataFactory", "Lcom/twilio/verify/models/Factor;", "BuiltInFictitiousFunctionClassFactory", "Lcom/twilio/verify/models/Factor;", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/lang/String;", "()Ljava/lang/String;", "", "scheduleImpl", "Ljava/util/Map;", "()Ljava/util/Map;", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "moveToNextValue", "", "Ljava/util/List;", "lookAheadTest", "Lcom/twilio/verify/models/ChallengeStatus;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lcom/twilio/verify/models/ChallengeStatus;", "()Lcom/twilio/verify/models/ChallengeStatus;", "DatabaseTableConfigUtil", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "<init>", "(Ljava/lang/String;Lcom/twilio/verify/models/ChallengeDetails;Ljava/util/Map;Ljava/lang/String;Lcom/twilio/verify/models/ChallengeStatus;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/List;Lorg/json/JSONObject;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class FactorChallenge implements Challenge {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public Factor KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final JSONObject moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private ChallengeStatus scheduleImpl;
    public final Date PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Date MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final ChallengeDetails getAuthRequestContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final Date DatabaseTableConfigUtil;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final List<String> lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Map<String, String> NetworkUserEntityData$$ExternalSyntheticLambda0;

    public FactorChallenge(String str, ChallengeDetails challengeDetails, Map<String, String> map, String str2, ChallengeStatus challengeStatus, Date date, Date date2, Date date3, List<String> list, JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(str, "");
        Intrinsics.checkParameterIsNotNull(challengeDetails, "");
        Intrinsics.checkParameterIsNotNull(str2, "");
        Intrinsics.checkParameterIsNotNull(challengeStatus, "");
        Intrinsics.checkParameterIsNotNull(date, "");
        Intrinsics.checkParameterIsNotNull(date2, "");
        Intrinsics.checkParameterIsNotNull(date3, "");
        this.getErrorConfigVersion = str;
        this.getAuthRequestContext = challengeDetails;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = map;
        this.BuiltInFictitiousFunctionClassFactory = str2;
        this.scheduleImpl = challengeStatus;
        this.PlaceComponentResult = date;
        this.DatabaseTableConfigUtil = date2;
        this.MyBillsEntityDataFactory = date3;
        this.lookAheadTest = list;
        this.moveToNextValue = jSONObject;
    }

    @Override // com.twilio.verify.models.Challenge
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final String getGetErrorConfigVersion() {
        return this.getErrorConfigVersion;
    }

    @Override // com.twilio.verify.models.Challenge
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final ChallengeDetails getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Override // com.twilio.verify.models.Challenge
    @JvmName(name = "MyBillsEntityDataFactory")
    public final Map<String, String> MyBillsEntityDataFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    @Override // com.twilio.verify.models.Challenge
    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final String getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // com.twilio.verify.models.Challenge
    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final ChallengeStatus getScheduleImpl() {
        return this.scheduleImpl;
    }
}
