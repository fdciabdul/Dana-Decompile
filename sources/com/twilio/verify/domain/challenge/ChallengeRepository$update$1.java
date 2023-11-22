package com.twilio.verify.domain.challenge;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.twilio.security.logger.Level;
import com.twilio.security.logger.Logger;
import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.domain.challenge.models.FactorChallenge;
import com.twilio.verify.models.Factor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/twilio/verify/domain/challenge/models/FactorChallenge;", "factorChallenge", "", BridgeDSL.INVOKE, "(Lcom/twilio/verify/domain/challenge/models/FactorChallenge;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
final class ChallengeRepository$update$1 extends Lambda implements Function1<FactorChallenge, Unit> {
    final /* synthetic */ Function1 $$error;
    final /* synthetic */ Function1 $$success;
    final /* synthetic */ ChallengeRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChallengeRepository$update$1(ChallengeRepository challengeRepository, Function1 function1, Function1 function12) {
        super(1);
        this.this$0 = challengeRepository;
        this.$$success = function1;
        this.$$error = function12;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(FactorChallenge factorChallenge) {
        invoke2(factorChallenge);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(FactorChallenge factorChallenge) {
        Intrinsics.checkParameterIsNotNull(factorChallenge, "");
        Factor factor = factorChallenge.KClassImpl$Data$declaredNonStaticMembers$2;
        if (factor != null) {
            this.this$0.PlaceComponentResult(factorChallenge.getErrorConfigVersion, factor, this.$$success, this.$$error);
            return;
        }
        Function1 function1 = this.$$error;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid factor");
        Logger logger = Logger.PlaceComponentResult;
        Level level = Level.Error;
        String obj = illegalArgumentException.toString();
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        Logger.KClassImpl$Data$declaredNonStaticMembers$2(level, obj, illegalArgumentException2);
        Unit unit = (Unit) function1.invoke(new TwilioVerifyException(illegalArgumentException2, TwilioVerifyException.ErrorCode.InputError));
    }
}
