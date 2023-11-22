package com.twilio.verify.domain.challenge.models;

import com.twilio.verify.models.Challenge;
import com.twilio.verify.models.ChallengeList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eR \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\tX\u0017¢\u0006\u0006\n\u0004\b\b\u0010\n"}, d2 = {"Lcom/twilio/verify/domain/challenge/models/FactorChallengeList;", "Lcom/twilio/verify/models/ChallengeList;", "", "Lcom/twilio/verify/models/Challenge;", "getAuthRequestContext", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "()Ljava/util/List;", "PlaceComponentResult", "Lcom/twilio/verify/models/Metadata;", "Lcom/twilio/verify/models/Metadata;", "p0", "p1", "<init>", "(Ljava/util/List;Lcom/twilio/verify/models/Metadata;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class FactorChallengeList implements ChallengeList {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final com.twilio.verify.models.Metadata BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final List<Challenge> PlaceComponentResult;

    /* JADX WARN: Multi-variable type inference failed */
    public FactorChallengeList(List<? extends Challenge> list, com.twilio.verify.models.Metadata metadata) {
        Intrinsics.checkParameterIsNotNull(list, "");
        Intrinsics.checkParameterIsNotNull(metadata, "");
        this.PlaceComponentResult = list;
        this.BuiltInFictitiousFunctionClassFactory = metadata;
    }

    @Override // com.twilio.verify.models.ChallengeList
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final List<Challenge> BuiltInFictitiousFunctionClassFactory() {
        return this.PlaceComponentResult;
    }
}
