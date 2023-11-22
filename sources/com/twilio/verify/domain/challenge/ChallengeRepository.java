package com.twilio.verify.domain.challenge;

import com.twilio.security.logger.Level;
import com.twilio.security.logger.Logger;
import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.api.ChallengeAPIClient;
import com.twilio.verify.api.ChallengeAPIClient$get$1;
import com.twilio.verify.api.ChallengeAPIClient$getAll$1;
import com.twilio.verify.api.ChallengeAPIClient$update$1;
import com.twilio.verify.domain.challenge.models.FactorChallenge;
import com.twilio.verify.models.Challenge;
import com.twilio.verify.models.ChallengeList;
import com.twilio.verify.models.ChallengeListOrder;
import com.twilio.verify.models.ChallengeStatus;
import com.twilio.verify.models.Factor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u0005\u001a\u00020!\u0012\b\b\u0002\u0010\t\u001a\u00020\u001e¢\u0006\u0004\b#\u0010$JG\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJc\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b0\u00062\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u0019JG\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0006H\u0016¢\u0006\u0004\b\f\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\u0018\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\""}, d2 = {"Lcom/twilio/verify/domain/challenge/ChallengeRepository;", "Lcom/twilio/verify/domain/challenge/ChallengeProvider;", "", "p0", "Lcom/twilio/verify/models/Factor;", "p1", "Lkotlin/Function1;", "Lcom/twilio/verify/models/Challenge;", "", "p2", "Lcom/twilio/verify/TwilioVerifyException;", "p3", "PlaceComponentResult", "(Ljava/lang/String;Lcom/twilio/verify/models/Factor;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lcom/twilio/verify/models/ChallengeStatus;", "", "Lcom/twilio/verify/models/ChallengeListOrder;", "p4", "Lcom/twilio/verify/models/ChallengeList;", "p5", "p6", "MyBillsEntityDataFactory", "(Lcom/twilio/verify/models/Factor;Lcom/twilio/verify/models/ChallengeStatus;ILcom/twilio/verify/models/ChallengeListOrder;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lcom/twilio/verify/domain/challenge/models/FactorChallenge;", "BuiltInFictitiousFunctionClassFactory", "(Lcom/twilio/verify/models/Challenge;)Lcom/twilio/verify/domain/challenge/models/FactorChallenge;", "(Lcom/twilio/verify/models/Challenge;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lcom/twilio/verify/api/ChallengeAPIClient;", "getAuthRequestContext", "Lcom/twilio/verify/api/ChallengeAPIClient;", "Lcom/twilio/verify/domain/challenge/ChallengeListMapper;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/twilio/verify/domain/challenge/ChallengeListMapper;", "Lcom/twilio/verify/domain/challenge/ChallengeMapper;", "Lcom/twilio/verify/domain/challenge/ChallengeMapper;", "<init>", "(Lcom/twilio/verify/api/ChallengeAPIClient;Lcom/twilio/verify/domain/challenge/ChallengeMapper;Lcom/twilio/verify/domain/challenge/ChallengeListMapper;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class ChallengeRepository implements ChallengeProvider {
    private final ChallengeMapper BuiltInFictitiousFunctionClassFactory;
    private final ChallengeListMapper KClassImpl$Data$declaredNonStaticMembers$2;
    private final ChallengeAPIClient getAuthRequestContext;

    private ChallengeRepository(ChallengeAPIClient challengeAPIClient, ChallengeMapper challengeMapper, ChallengeListMapper challengeListMapper) {
        Intrinsics.checkParameterIsNotNull(challengeAPIClient, "");
        Intrinsics.checkParameterIsNotNull(challengeMapper, "");
        Intrinsics.checkParameterIsNotNull(challengeListMapper, "");
        this.getAuthRequestContext = challengeAPIClient;
        this.BuiltInFictitiousFunctionClassFactory = challengeMapper;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = challengeListMapper;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r5v2, types: [kotlin.jvm.internal.DefaultConstructorMarker, com.twilio.verify.domain.challenge.ChallengeMapper] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ ChallengeRepository(com.twilio.verify.api.ChallengeAPIClient r1, com.twilio.verify.domain.challenge.ChallengeMapper r2, com.twilio.verify.domain.challenge.ChallengeListMapper r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r5 = r4 & 2
            if (r5 == 0) goto L9
            com.twilio.verify.domain.challenge.ChallengeMapper r2 = new com.twilio.verify.domain.challenge.ChallengeMapper
            r2.<init>()
        L9:
            r4 = r4 & 4
            if (r4 == 0) goto L14
            com.twilio.verify.domain.challenge.ChallengeListMapper r3 = new com.twilio.verify.domain.challenge.ChallengeListMapper
            r4 = 1
            r5 = 0
            r3.<init>(r5, r4, r5)
        L14:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twilio.verify.domain.challenge.ChallengeRepository.<init>(com.twilio.verify.api.ChallengeAPIClient, com.twilio.verify.domain.challenge.ChallengeMapper, com.twilio.verify.domain.challenge.ChallengeListMapper, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Override // com.twilio.verify.domain.challenge.ChallengeProvider
    public final void PlaceComponentResult(String p0, Factor p1, Function1<? super Challenge, Unit> p2, Function1<? super TwilioVerifyException, Unit> p3) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        Intrinsics.checkParameterIsNotNull(p3, "");
        ChallengeRepository$get$1 challengeRepository$get$1 = new ChallengeRepository$get$1(this, p1, p2, p3);
        ChallengeAPIClient challengeAPIClient = this.getAuthRequestContext;
        ChallengeRepository$get$2 challengeRepository$get$2 = new ChallengeRepository$get$2(challengeRepository$get$1);
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(challengeRepository$get$2, "");
        Intrinsics.checkParameterIsNotNull(p3, "");
        ChallengeAPIClient$get$1.invoke$default(new ChallengeAPIClient$get$1(challengeAPIClient, p1, p0, challengeRepository$get$2, p3), 0, 1, null);
    }

    @Override // com.twilio.verify.domain.challenge.ChallengeProvider
    public final void PlaceComponentResult(Challenge p0, final String p1, Function1<? super Challenge, Unit> p2, final Function1<? super TwilioVerifyException, Unit> p3) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        Intrinsics.checkParameterIsNotNull(p3, "");
        final ChallengeRepository$update$1 challengeRepository$update$1 = new ChallengeRepository$update$1(this, p2, p3);
        try {
            if (p0.getScheduleImpl() != ChallengeStatus.Pending) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Responded or expired challenge can not be updated");
                Logger logger = Logger.PlaceComponentResult;
                Logger.KClassImpl$Data$declaredNonStaticMembers$2(Level.Error, illegalArgumentException.toString(), illegalArgumentException);
                throw new TwilioVerifyException(illegalArgumentException, TwilioVerifyException.ErrorCode.InputError);
            }
            final FactorChallenge BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(p0);
            ChallengeAPIClient challengeAPIClient = this.getAuthRequestContext;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.twilio.verify.domain.challenge.ChallengeRepository$update$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    challengeRepository$update$1.invoke2(FactorChallenge.this);
                }
            };
            Intrinsics.checkParameterIsNotNull(BuiltInFictitiousFunctionClassFactory, "");
            Intrinsics.checkParameterIsNotNull(p1, "");
            Intrinsics.checkParameterIsNotNull(function0, "");
            Intrinsics.checkParameterIsNotNull(p3, "");
            ChallengeAPIClient$update$1.invoke$default(new ChallengeAPIClient$update$1(challengeAPIClient, BuiltInFictitiousFunctionClassFactory, p1, function0, p3), 0, 1, null);
        } catch (TwilioVerifyException e) {
            p3.invoke(e);
        }
    }

    @Override // com.twilio.verify.domain.challenge.ChallengeProvider
    public final void MyBillsEntityDataFactory(Factor p0, ChallengeStatus p1, int p2, ChallengeListOrder p3, String p4, Function1<? super ChallengeList, Unit> p5, Function1<? super TwilioVerifyException, Unit> p6) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p3, "");
        Intrinsics.checkParameterIsNotNull(p5, "");
        Intrinsics.checkParameterIsNotNull(p6, "");
        ChallengeRepository$getAll$1 challengeRepository$getAll$1 = new ChallengeRepository$getAll$1(this, p5, p6);
        ChallengeAPIClient challengeAPIClient = this.getAuthRequestContext;
        String value = p1 != null ? p1.getValue() : null;
        ChallengeRepository$getAll$2 challengeRepository$getAll$2 = new ChallengeRepository$getAll$2(challengeRepository$getAll$1);
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p3, "");
        Intrinsics.checkParameterIsNotNull(challengeRepository$getAll$2, "");
        Intrinsics.checkParameterIsNotNull(p6, "");
        ChallengeAPIClient$getAll$1.invoke$default(new ChallengeAPIClient$getAll$1(challengeAPIClient, p0, p2, p3, value, p4, challengeRepository$getAll$2, p6), 0, 1, null);
    }

    public static FactorChallenge BuiltInFictitiousFunctionClassFactory(Challenge p0) {
        if (!(p0 instanceof FactorChallenge)) {
            p0 = null;
        }
        FactorChallenge factorChallenge = (FactorChallenge) p0;
        if (factorChallenge != null) {
            return factorChallenge;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid challenge");
        Logger logger = Logger.PlaceComponentResult;
        Level level = Level.Error;
        String obj = illegalArgumentException.toString();
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        Logger.KClassImpl$Data$declaredNonStaticMembers$2(level, obj, illegalArgumentException2);
        throw new TwilioVerifyException(illegalArgumentException2, TwilioVerifyException.ErrorCode.InputError);
    }
}
