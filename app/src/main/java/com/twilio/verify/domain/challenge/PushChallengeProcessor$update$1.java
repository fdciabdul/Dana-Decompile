package com.twilio.verify.domain.challenge;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.twilio.security.logger.Level;
import com.twilio.security.logger.Logger;
import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.data.KeyStoreAdapterKt;
import com.twilio.verify.domain.challenge.models.FactorChallenge;
import com.twilio.verify.domain.factor.models.PushFactor;
import com.twilio.verify.models.Challenge;
import com.twilio.verify.models.ChallengeStatus;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/twilio/verify/models/Challenge;", ClientData.KEY_CHALLENGE, "", BridgeDSL.INVOKE, "(Lcom/twilio/verify/models/Challenge;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class PushChallengeProcessor$update$1 extends Lambda implements Function1<Challenge, Unit> {
    final /* synthetic */ Function1 $$error;
    final /* synthetic */ PushFactor $$factor;
    final /* synthetic */ ChallengeStatus $$status;
    final /* synthetic */ Function0 $$success;
    final /* synthetic */ PushChallengeProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushChallengeProcessor$update$1(PushChallengeProcessor pushChallengeProcessor, PushFactor pushFactor, ChallengeStatus challengeStatus, Function0 function0, Function1 function1) {
        super(1);
        this.this$0 = pushChallengeProcessor;
        this.$$factor = pushFactor;
        this.$$status = challengeStatus;
        this.$$success = function0;
        this.$$error = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Challenge challenge) {
        invoke2(challenge);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Challenge challenge) {
        String BuiltInFictitiousFunctionClassFactory;
        ChallengeProvider challengeProvider;
        Intrinsics.checkParameterIsNotNull(challenge, "");
        try {
            FactorChallenge factorChallenge = (FactorChallenge) (!(challenge instanceof FactorChallenge) ? null : challenge);
            if (factorChallenge == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid challenge");
                Logger logger = Logger.PlaceComponentResult;
                Logger.KClassImpl$Data$declaredNonStaticMembers$2(Level.Error, illegalArgumentException.toString(), illegalArgumentException);
                throw new TwilioVerifyException(illegalArgumentException, TwilioVerifyException.ErrorCode.InputError);
            }
            if (((FactorChallenge) challenge).KClassImpl$Data$declaredNonStaticMembers$2 != null && (((FactorChallenge) challenge).KClassImpl$Data$declaredNonStaticMembers$2 instanceof PushFactor)) {
                if ((!Intrinsics.areEqual(((FactorChallenge) challenge).KClassImpl$Data$declaredNonStaticMembers$2 != null ? r2.getLookAheadTest() : null, this.$$factor.lookAheadTest)) == false) {
                    String str = this.$$factor.getErrorConfigVersion;
                    if (str != null) {
                        if ((!StringsKt.isBlank(str)) == false) {
                            str = null;
                        }
                        if (str != null) {
                            List<String> list = factorChallenge.lookAheadTest;
                            if (list != null) {
                                if ((!list.isEmpty()) == false) {
                                    list = null;
                                }
                                if (list != null) {
                                    JSONObject jSONObject = factorChallenge.moveToNextValue;
                                    if (jSONObject != null) {
                                        JSONObject jSONObject2 = jSONObject.length() > 0 ? jSONObject : null;
                                        if (jSONObject2 != null) {
                                            BuiltInFictitiousFunctionClassFactory = this.this$0.BuiltInFictitiousFunctionClassFactory(list, jSONObject2, this.$$status, KeyStoreAdapterKt.KClassImpl$Data$declaredNonStaticMembers$2(str, true));
                                            Logger logger2 = Logger.PlaceComponentResult;
                                            Level level = Level.Debug;
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("Update challenge with auth payload ");
                                            sb.append(BuiltInFictitiousFunctionClassFactory);
                                            Logger.MyBillsEntityDataFactory(level, sb.toString());
                                            challengeProvider = this.this$0.KClassImpl$Data$declaredNonStaticMembers$2;
                                            challengeProvider.PlaceComponentResult(challenge, BuiltInFictitiousFunctionClassFactory, new Function1<Challenge, Unit>() { // from class: com.twilio.verify.domain.challenge.PushChallengeProcessor$update$1.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final /* bridge */ /* synthetic */ Unit invoke(Challenge challenge2) {
                                                    invoke2(challenge2);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                public final void invoke2(Challenge challenge2) {
                                                    Intrinsics.checkParameterIsNotNull(challenge2, "");
                                                    if (!(challenge2.getScheduleImpl() == PushChallengeProcessor$update$1.this.$$status)) {
                                                        challenge2 = null;
                                                    }
                                                    if (challenge2 != null) {
                                                        PushChallengeProcessor$update$1.this.$$success.invoke();
                                                        return;
                                                    }
                                                    Function1 function1 = PushChallengeProcessor$update$1.this.$$error;
                                                    IllegalStateException illegalStateException = new IllegalStateException("Challenge was not updated");
                                                    Logger logger3 = Logger.PlaceComponentResult;
                                                    Level level2 = Level.Error;
                                                    String obj = illegalStateException.toString();
                                                    IllegalStateException illegalStateException2 = illegalStateException;
                                                    Logger.KClassImpl$Data$declaredNonStaticMembers$2(level2, obj, illegalStateException2);
                                                    Unit unit = (Unit) function1.invoke(new TwilioVerifyException(illegalStateException2, TwilioVerifyException.ErrorCode.InputError));
                                                }
                                            }, this.$$error);
                                            return;
                                        }
                                    }
                                    IllegalStateException illegalStateException = new IllegalStateException("Challenge response not set");
                                    Logger logger3 = Logger.PlaceComponentResult;
                                    Logger.KClassImpl$Data$declaredNonStaticMembers$2(Level.Error, illegalStateException.toString(), illegalStateException);
                                    throw new TwilioVerifyException(illegalStateException, TwilioVerifyException.ErrorCode.InputError);
                                }
                            }
                            IllegalStateException illegalStateException2 = new IllegalStateException("Signature fields not set");
                            Logger logger4 = Logger.PlaceComponentResult;
                            Logger.KClassImpl$Data$declaredNonStaticMembers$2(Level.Error, illegalStateException2.toString(), illegalStateException2);
                            throw new TwilioVerifyException(illegalStateException2, TwilioVerifyException.ErrorCode.InputError);
                        }
                    }
                    IllegalStateException illegalStateException3 = new IllegalStateException("Key pair not set");
                    Logger logger5 = Logger.PlaceComponentResult;
                    Logger.KClassImpl$Data$declaredNonStaticMembers$2(Level.Error, illegalStateException3.toString(), illegalStateException3);
                    throw new TwilioVerifyException(illegalStateException3, TwilioVerifyException.ErrorCode.KeyStorageError);
                }
            }
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Wrong factor for challenge");
            Logger logger6 = Logger.PlaceComponentResult;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(Level.Error, illegalArgumentException2.toString(), illegalArgumentException2);
            throw new TwilioVerifyException(illegalArgumentException2, TwilioVerifyException.ErrorCode.InputError);
        } catch (TwilioVerifyException e) {
            this.$$error.invoke(e);
        }
    }
}
