package com.twilio.verify.models;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0011\u0010\u000b\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0013\u0010\r\u001a\u0004\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lcom/twilio/verify/models/ChallengeListPayload;", "", "", "getAuthRequestContext", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Lcom/twilio/verify/models/ChallengeListOrder;", "MyBillsEntityDataFactory", "Lcom/twilio/verify/models/ChallengeListOrder;", "", "I", "PlaceComponentResult", "Lcom/twilio/verify/models/ChallengeStatus;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/twilio/verify/models/ChallengeStatus;", "p0", "p1", "p2", "p3", "p4", "<init>", "(Ljava/lang/String;ILcom/twilio/verify/models/ChallengeStatus;Lcom/twilio/verify/models/ChallengeListOrder;Ljava/lang/String;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class ChallengeListPayload {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final int PlaceComponentResult;
    public final ChallengeStatus KClassImpl$Data$declaredNonStaticMembers$2;
    public final ChallengeListOrder MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    private ChallengeListPayload(String str, int i, ChallengeStatus challengeStatus, ChallengeListOrder challengeListOrder, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "");
        Intrinsics.checkParameterIsNotNull(challengeListOrder, "");
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.PlaceComponentResult = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = challengeStatus;
        this.MyBillsEntityDataFactory = challengeListOrder;
        this.getAuthRequestContext = str2;
    }

    public /* synthetic */ ChallengeListPayload(String str, int i, ChallengeStatus challengeStatus, ChallengeListOrder challengeListOrder, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 4) != 0 ? null : challengeStatus, (i2 & 8) != 0 ? ChallengeListOrder.Asc : challengeListOrder, (i2 & 16) != 0 ? null : str2);
    }
}
