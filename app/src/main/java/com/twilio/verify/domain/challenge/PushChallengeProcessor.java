package com.twilio.verify.domain.challenge;

import com.twilio.security.crypto.key.template.SignerTemplate;
import com.twilio.security.logger.Level;
import com.twilio.security.logger.Logger;
import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.data.jwt.JwtGenerator;
import com.twilio.verify.domain.factor.models.PushFactor;
import com.twilio.verify.models.Challenge;
import com.twilio.verify.models.ChallengeStatus;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0013\u0012\u0006\u0010\u0006\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ5\u0010\u000b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJE\u0010\u000b\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\r2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u000b\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u000b\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lcom/twilio/verify/domain/challenge/PushChallengeProcessor;", "", "", "", "p0", "Lorg/json/JSONObject;", "p1", "Lcom/twilio/verify/models/ChallengeStatus;", "p2", "Lcom/twilio/security/crypto/key/template/SignerTemplate;", "p3", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;Lorg/json/JSONObject;Lcom/twilio/verify/models/ChallengeStatus;Lcom/twilio/security/crypto/key/template/SignerTemplate;)Ljava/lang/String;", "Lcom/twilio/verify/domain/factor/models/PushFactor;", "Lkotlin/Function1;", "Lcom/twilio/verify/models/Challenge;", "", "Lcom/twilio/verify/TwilioVerifyException;", "(Ljava/lang/String;Lcom/twilio/verify/domain/factor/models/PushFactor;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lcom/twilio/verify/domain/challenge/ChallengeProvider;", "PlaceComponentResult", "Lcom/twilio/verify/domain/challenge/ChallengeProvider;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/twilio/verify/data/jwt/JwtGenerator;", "MyBillsEntityDataFactory", "Lcom/twilio/verify/data/jwt/JwtGenerator;", "<init>", "(Lcom/twilio/verify/domain/challenge/ChallengeProvider;Lcom/twilio/verify/data/jwt/JwtGenerator;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class PushChallengeProcessor {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final JwtGenerator BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final ChallengeProvider KClassImpl$Data$declaredNonStaticMembers$2;

    public PushChallengeProcessor(ChallengeProvider challengeProvider, JwtGenerator jwtGenerator) {
        Intrinsics.checkParameterIsNotNull(challengeProvider, "");
        Intrinsics.checkParameterIsNotNull(jwtGenerator, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = challengeProvider;
        this.BuiltInFictitiousFunctionClassFactory = jwtGenerator;
    }

    public final void BuiltInFictitiousFunctionClassFactory(String p0, PushFactor p1, final Function1<? super Challenge, Unit> p2, final Function1<? super TwilioVerifyException, Unit> p3) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        Intrinsics.checkParameterIsNotNull(p3, "");
        Logger logger = Logger.PlaceComponentResult;
        Level level = Level.Info;
        StringBuilder sb = new StringBuilder();
        sb.append("Getting challenge ");
        sb.append(p0);
        sb.append(" with factor ");
        sb.append(p1.lookAheadTest);
        Logger.MyBillsEntityDataFactory(level, sb.toString());
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(p0, p1, new Function1<Challenge, Unit>() { // from class: com.twilio.verify.domain.challenge.PushChallengeProcessor$get$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Challenge challenge) {
                invoke2(challenge);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Challenge challenge) {
                Intrinsics.checkParameterIsNotNull(challenge, "");
                Function1.this.invoke(challenge);
            }
        }, new Function1<TwilioVerifyException, Unit>() { // from class: com.twilio.verify.domain.challenge.PushChallengeProcessor$get$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(TwilioVerifyException twilioVerifyException) {
                invoke2(twilioVerifyException);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(TwilioVerifyException twilioVerifyException) {
                Intrinsics.checkParameterIsNotNull(twilioVerifyException, "");
                Function1.this.invoke(twilioVerifyException);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String BuiltInFictitiousFunctionClassFactory(List<String> p0, JSONObject p1, ChallengeStatus p2, SignerTemplate p3) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : p0) {
                jSONObject.put(str, p1.get(str));
            }
            jSONObject.put("status", p2.getValue());
            Logger logger = Logger.PlaceComponentResult;
            Level level = Level.Debug;
            StringBuilder sb = new StringBuilder();
            sb.append("Update challenge with payload ");
            sb.append(jSONObject);
            Logger.MyBillsEntityDataFactory(level, sb.toString());
            return this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(p3, new JSONObject(), jSONObject);
        } catch (Exception e) {
            Logger logger2 = Logger.PlaceComponentResult;
            Level level2 = Level.Error;
            String obj = e.toString();
            Exception exc = e;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(level2, obj, exc);
            throw new TwilioVerifyException(exc, TwilioVerifyException.ErrorCode.InputError);
        }
    }
}
