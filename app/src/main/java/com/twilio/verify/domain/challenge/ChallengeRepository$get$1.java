package com.twilio.verify.domain.challenge;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.twilio.security.logger.Level;
import com.twilio.security.logger.Logger;
import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.domain.challenge.models.FactorChallenge;
import com.twilio.verify.models.Challenge;
import com.twilio.verify.models.Factor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lorg/json/JSONObject;", "response", "", "signatureFieldsHeader", "", BridgeDSL.INVOKE, "(Lorg/json/JSONObject;Ljava/lang/String;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class ChallengeRepository$get$1 extends Lambda implements Function2<JSONObject, String, Unit> {
    final /* synthetic */ Function1 $$error;
    final /* synthetic */ Factor $$factor;
    final /* synthetic */ Function1 $$success;
    final /* synthetic */ ChallengeRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChallengeRepository$get$1(ChallengeRepository challengeRepository, Factor factor, Function1 function1, Function1 function12) {
        super(2);
        this.this$0 = challengeRepository;
        this.$$factor = factor;
        this.$$success = function1;
        this.$$error = function12;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
        invoke2(jSONObject, str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(JSONObject jSONObject, String str) {
        ChallengeMapper challengeMapper;
        FactorChallenge BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkParameterIsNotNull(jSONObject, "");
        try {
            challengeMapper = this.this$0.BuiltInFictitiousFunctionClassFactory;
            Challenge authRequestContext = challengeMapper.getAuthRequestContext(jSONObject, str);
            if ((!Intrinsics.areEqual(authRequestContext.getBuiltInFictitiousFunctionClassFactory(), this.$$factor.getLookAheadTest())) == false) {
                BuiltInFictitiousFunctionClassFactory = ChallengeRepository.BuiltInFictitiousFunctionClassFactory(authRequestContext);
                BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = this.$$factor;
                this.$$success.invoke(authRequestContext);
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong factor for challenge");
            Logger logger = Logger.PlaceComponentResult;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(Level.Error, illegalArgumentException.toString(), illegalArgumentException);
            throw new TwilioVerifyException(illegalArgumentException, TwilioVerifyException.ErrorCode.InputError);
        } catch (TwilioVerifyException e) {
            this.$$error.invoke(e);
        }
    }
}
