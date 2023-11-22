package com.twilio.verify.domain.challenge;

import android.content.Context;
import com.twilio.security.logger.Level;
import com.twilio.security.logger.Logger;
import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.data.jwt.JwtGenerator;
import com.twilio.verify.domain.factor.FactorFacade;
import com.twilio.verify.domain.factor.models.PushFactor;
import com.twilio.verify.models.ChallengeStatus;
import com.twilio.verify.models.UpdateChallengePayload;
import com.twilio.verify.models.UpdatePushChallengePayload;
import com.twilio.verify.networking.Authentication;
import com.twilio.verify.networking.NetworkProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0011B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lcom/twilio/verify/domain/challenge/ChallengeFacade;", "", "Lcom/twilio/verify/domain/factor/FactorFacade;", "PlaceComponentResult", "Lcom/twilio/verify/domain/factor/FactorFacade;", "BuiltInFictitiousFunctionClassFactory", "Lcom/twilio/verify/domain/challenge/PushChallengeProcessor;", "MyBillsEntityDataFactory", "Lcom/twilio/verify/domain/challenge/PushChallengeProcessor;", "Lcom/twilio/verify/domain/challenge/ChallengeProvider;", "getAuthRequestContext", "Lcom/twilio/verify/domain/challenge/ChallengeProvider;", "p0", "p1", "p2", "<init>", "(Lcom/twilio/verify/domain/challenge/PushChallengeProcessor;Lcom/twilio/verify/domain/factor/FactorFacade;Lcom/twilio/verify/domain/challenge/ChallengeProvider;)V", "Builder"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class ChallengeFacade {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final PushChallengeProcessor PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final FactorFacade BuiltInFictitiousFunctionClassFactory;
    private final ChallengeProvider getAuthRequestContext;

    public ChallengeFacade(PushChallengeProcessor pushChallengeProcessor, FactorFacade factorFacade, ChallengeProvider challengeProvider) {
        Intrinsics.checkParameterIsNotNull(pushChallengeProcessor, "");
        Intrinsics.checkParameterIsNotNull(factorFacade, "");
        Intrinsics.checkParameterIsNotNull(challengeProvider, "");
        this.PlaceComponentResult = pushChallengeProcessor;
        this.BuiltInFictitiousFunctionClassFactory = factorFacade;
        this.getAuthRequestContext = challengeProvider;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\b\u0010\u000eR\u0016\u0010\n\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lcom/twilio/verify/domain/challenge/ChallengeFacade$Builder;", "", "Landroid/content/Context;", "getAuthRequestContext", "Landroid/content/Context;", "MyBillsEntityDataFactory", "Lcom/twilio/verify/networking/Authentication;", "Lcom/twilio/verify/networking/Authentication;", "PlaceComponentResult", "Lcom/twilio/verify/domain/factor/FactorFacade;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/twilio/verify/domain/factor/FactorFacade;", "BuiltInFictitiousFunctionClassFactory", "Lcom/twilio/verify/data/jwt/JwtGenerator;", "Lcom/twilio/verify/data/jwt/JwtGenerator;", "Lcom/twilio/verify/networking/NetworkProvider;", "Lcom/twilio/verify/networking/NetworkProvider;", "", "moveToNextValue", "Ljava/lang/String;", "scheduleImpl", "<init>", "()V"}, k = 1, mv = {1, 8, 0})
    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public NetworkProvider KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public FactorFacade BuiltInFictitiousFunctionClassFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public Authentication PlaceComponentResult;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public JwtGenerator getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public Context MyBillsEntityDataFactory;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        public String scheduleImpl;

        public static final /* synthetic */ Context BuiltInFictitiousFunctionClassFactory(Builder builder) {
            Context context = builder.MyBillsEntityDataFactory;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            return context;
        }

        public static final /* synthetic */ FactorFacade KClassImpl$Data$declaredNonStaticMembers$2(Builder builder) {
            FactorFacade factorFacade = builder.BuiltInFictitiousFunctionClassFactory;
            if (factorFacade == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            return factorFacade;
        }

        public static final /* synthetic */ Authentication MyBillsEntityDataFactory(Builder builder) {
            Authentication authentication = builder.PlaceComponentResult;
            if (authentication == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            return authentication;
        }

        public static final /* synthetic */ String NetworkUserEntityData$$ExternalSyntheticLambda0(Builder builder) {
            String str = builder.scheduleImpl;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            return str;
        }

        public static final /* synthetic */ NetworkProvider PlaceComponentResult(Builder builder) {
            NetworkProvider networkProvider = builder.KClassImpl$Data$declaredNonStaticMembers$2;
            if (networkProvider == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            return networkProvider;
        }

        public static final /* synthetic */ JwtGenerator getAuthRequestContext(Builder builder) {
            JwtGenerator jwtGenerator = builder.getAuthRequestContext;
            if (jwtGenerator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            return jwtGenerator;
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ChallengeFacade challengeFacade, UpdateChallengePayload updateChallengePayload, PushFactor pushFactor, Function0 function0, Function1 function1) {
        ChallengeStatus challengeStatus;
        try {
            UpdatePushChallengePayload updatePushChallengePayload = (UpdatePushChallengePayload) (!(updateChallengePayload instanceof UpdatePushChallengePayload) ? null : updateChallengePayload);
            if (updatePushChallengePayload == null || (challengeStatus = updatePushChallengePayload.BuiltInFictitiousFunctionClassFactory) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid update challenge input for factor ");
                sb.append(pushFactor.scheduleImpl);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(sb.toString());
                Logger logger = Logger.PlaceComponentResult;
                Logger.KClassImpl$Data$declaredNonStaticMembers$2(Level.Error, illegalArgumentException.toString(), illegalArgumentException);
                throw new TwilioVerifyException(illegalArgumentException, TwilioVerifyException.ErrorCode.InputError);
            }
            PushChallengeProcessor pushChallengeProcessor = challengeFacade.PlaceComponentResult;
            String kClassImpl$Data$declaredNonStaticMembers$2 = updateChallengePayload.getKClassImpl$Data$declaredNonStaticMembers$2();
            Intrinsics.checkParameterIsNotNull(kClassImpl$Data$declaredNonStaticMembers$2, "");
            Intrinsics.checkParameterIsNotNull(pushFactor, "");
            Intrinsics.checkParameterIsNotNull(challengeStatus, "");
            Intrinsics.checkParameterIsNotNull(function0, "");
            Intrinsics.checkParameterIsNotNull(function1, "");
            PushChallengeProcessor$update$1 pushChallengeProcessor$update$1 = new PushChallengeProcessor$update$1(pushChallengeProcessor, pushFactor, challengeStatus, function0, function1);
            Logger logger2 = Logger.PlaceComponentResult;
            Level level = Level.Info;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Updating challenge ");
            sb2.append(kClassImpl$Data$declaredNonStaticMembers$2);
            sb2.append(" with factor ");
            sb2.append(pushFactor.lookAheadTest);
            sb2.append(" to new status ");
            sb2.append(challengeStatus.getValue());
            Logger.MyBillsEntityDataFactory(level, sb2.toString());
            pushChallengeProcessor.BuiltInFictitiousFunctionClassFactory(kClassImpl$Data$declaredNonStaticMembers$2, pushFactor, new PushChallengeProcessor$update$2(pushChallengeProcessor$update$1), function1);
        } catch (TwilioVerifyException e) {
            function1.invoke(e);
        }
    }
}
