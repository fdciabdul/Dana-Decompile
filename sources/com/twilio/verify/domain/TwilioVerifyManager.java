package com.twilio.verify.domain;

import com.twilio.security.logger.Level;
import com.twilio.security.logger.Logger;
import com.twilio.verify.TwilioVerify;
import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.data.KeyStorage;
import com.twilio.verify.data.StorageException;
import com.twilio.verify.domain.challenge.ChallengeFacade;
import com.twilio.verify.domain.factor.FactorFacade;
import com.twilio.verify.domain.factor.models.CreateFactorPayload;
import com.twilio.verify.domain.factor.models.PushFactor;
import com.twilio.verify.domain.service.ServiceFacade;
import com.twilio.verify.models.Challenge;
import com.twilio.verify.models.ChallengeList;
import com.twilio.verify.models.ChallengeListPayload;
import com.twilio.verify.models.Factor;
import com.twilio.verify.models.FactorPayload;
import com.twilio.verify.models.FactorType;
import com.twilio.verify.models.PushFactorPayload;
import com.twilio.verify.models.UpdateChallengePayload;
import com.twilio.verify.models.UpdateFactorPayload;
import com.twilio.verify.models.UpdatePushFactorPayload;
import com.twilio.verify.models.VerifyFactorPayload;
import com.twilio.verify.models.VerifyPushFactorPayload;
import com.twilio.verify.threading.ExecutorKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\"\u0012\u0006\u0010\n\u001a\u00020 \u0012\u0006\u0010\f\u001a\u00020$¢\u0006\u0004\b'\u0010(J\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J?\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ?\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000f2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00030\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J=\u0010\u0005\u001a\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0013\u0012\u0004\u0012\u00020\u00030\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\bH\u0016¢\u0006\u0004\b\u0005\u0010\u0014JG\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u00152\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00030\b2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0018J9\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00192\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\bH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ?\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u001c2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\bH\u0016¢\u0006\u0004\b\u0005\u0010\u001dJ?\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u001e2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\bH\u0016¢\u0006\u0004\b\u0011\u0010\u001fR\u0014\u0010\u0005\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010!R\u0014\u0010\r\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&"}, d2 = {"Lcom/twilio/verify/domain/TwilioVerifyManager;", "Lcom/twilio/verify/TwilioVerify;", "Lkotlin/Function0;", "", "p0", "getAuthRequestContext", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/twilio/verify/models/FactorPayload;", "Lkotlin/Function1;", "Lcom/twilio/verify/models/Factor;", "p1", "Lcom/twilio/verify/TwilioVerifyException;", "p2", "BuiltInFictitiousFunctionClassFactory", "(Lcom/twilio/verify/models/FactorPayload;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lcom/twilio/verify/models/ChallengeListPayload;", "Lcom/twilio/verify/models/ChallengeList;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lcom/twilio/verify/models/ChallengeListPayload;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "", "Lcom/twilio/verify/models/Challenge;", "p3", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lcom/twilio/verify/models/UpdateChallengePayload;", "MyBillsEntityDataFactory", "(Lcom/twilio/verify/models/UpdateChallengePayload;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "Lcom/twilio/verify/models/UpdateFactorPayload;", "(Lcom/twilio/verify/models/UpdateFactorPayload;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lcom/twilio/verify/models/VerifyFactorPayload;", "(Lcom/twilio/verify/models/VerifyFactorPayload;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lcom/twilio/verify/domain/challenge/ChallengeFacade;", "Lcom/twilio/verify/domain/challenge/ChallengeFacade;", "Lcom/twilio/verify/domain/factor/FactorFacade;", "Lcom/twilio/verify/domain/factor/FactorFacade;", "Lcom/twilio/verify/domain/service/ServiceFacade;", "PlaceComponentResult", "Lcom/twilio/verify/domain/service/ServiceFacade;", "<init>", "(Lcom/twilio/verify/domain/factor/FactorFacade;Lcom/twilio/verify/domain/challenge/ChallengeFacade;Lcom/twilio/verify/domain/service/ServiceFacade;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class TwilioVerifyManager implements TwilioVerify {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final FactorFacade BuiltInFictitiousFunctionClassFactory;
    private final ServiceFacade PlaceComponentResult;
    private final ChallengeFacade getAuthRequestContext;

    public TwilioVerifyManager(FactorFacade factorFacade, ChallengeFacade challengeFacade, ServiceFacade serviceFacade) {
        Intrinsics.checkParameterIsNotNull(factorFacade, "");
        Intrinsics.checkParameterIsNotNull(challengeFacade, "");
        Intrinsics.checkParameterIsNotNull(serviceFacade, "");
        this.BuiltInFictitiousFunctionClassFactory = factorFacade;
        this.getAuthRequestContext = challengeFacade;
        this.PlaceComponentResult = serviceFacade;
    }

    @Override // com.twilio.verify.TwilioVerify
    public final void BuiltInFictitiousFunctionClassFactory(final FactorPayload p0, Function1<? super Factor, Unit> p1, Function1<? super TwilioVerifyException, Unit> p2) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        final FactorFacade factorFacade = this.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        ExecutorKt.PlaceComponentResult(p1, p2, new Function2<Function1<? super Factor, ? extends Unit>, Function1<? super TwilioVerifyException, ? extends Unit>, Unit>() { // from class: com.twilio.verify.domain.factor.FactorFacade$createFactor$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Unit invoke(Function1<? super Factor, ? extends Unit> function1, Function1<? super TwilioVerifyException, ? extends Unit> function12) {
                invoke2((Function1<? super Factor, Unit>) function1, (Function1<? super TwilioVerifyException, Unit>) function12);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super Factor, Unit> function1, final Function1<? super TwilioVerifyException, Unit> function12) {
                final PushFactory pushFactory;
                Intrinsics.checkParameterIsNotNull(function1, "");
                Intrinsics.checkParameterIsNotNull(function12, "");
                if (p0 instanceof PushFactorPayload) {
                    pushFactory = FactorFacade.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    String str = ((PushFactorPayload) p0).getAuthRequestContext;
                    String placeComponentResult = p0.getPlaceComponentResult();
                    String str2 = ((PushFactorPayload) p0).MyBillsEntityDataFactory;
                    String kClassImpl$Data$declaredNonStaticMembers$2 = p0.getKClassImpl$Data$declaredNonStaticMembers$2();
                    String builtInFictitiousFunctionClassFactory = p0.getBuiltInFictitiousFunctionClassFactory();
                    Intrinsics.checkParameterIsNotNull(str, "");
                    Intrinsics.checkParameterIsNotNull(placeComponentResult, "");
                    Intrinsics.checkParameterIsNotNull(str2, "");
                    Intrinsics.checkParameterIsNotNull(kClassImpl$Data$declaredNonStaticMembers$2, "");
                    Intrinsics.checkParameterIsNotNull(builtInFictitiousFunctionClassFactory, "");
                    Intrinsics.checkParameterIsNotNull(function1, "");
                    Intrinsics.checkParameterIsNotNull(function12, "");
                    try {
                        Logger logger = Logger.PlaceComponentResult;
                        Level level = Level.Info;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Creating push factor ");
                        sb.append(placeComponentResult);
                        Logger.MyBillsEntityDataFactory(level, sb.toString());
                        final String MyBillsEntityDataFactory = PushFactory.MyBillsEntityDataFactory();
                        Map<String, String> authRequestContext = PushFactory.getAuthRequestContext(pushFactory.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory));
                        CreateFactorPayload createFactorPayload = new CreateFactorPayload(placeComponentResult, FactorType.PUSH, kClassImpl$Data$declaredNonStaticMembers$2, builtInFictitiousFunctionClassFactory, pushFactory.PlaceComponentResult(str2), authRequestContext, str);
                        Logger logger2 = Logger.PlaceComponentResult;
                        Level level2 = Level.Debug;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Create push factor for ");
                        sb2.append(createFactorPayload);
                        Logger.MyBillsEntityDataFactory(level2, sb2.toString());
                        pushFactory.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(createFactorPayload, new PushFactory$create$2(new PushFactory$create$1(pushFactory, MyBillsEntityDataFactory, function1, function12)), new Function1<TwilioVerifyException, Unit>() { // from class: com.twilio.verify.domain.factor.PushFactory$create$3
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                KeyStorage keyStorage;
                                Intrinsics.checkParameterIsNotNull(twilioVerifyException, "");
                                keyStorage = PushFactory.this.PlaceComponentResult;
                                keyStorage.MyBillsEntityDataFactory(MyBillsEntityDataFactory);
                                function12.invoke(twilioVerifyException);
                            }
                        });
                    } catch (TwilioVerifyException e) {
                        function12.invoke(e);
                    }
                }
            }
        });
    }

    @Override // com.twilio.verify.TwilioVerify
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final VerifyFactorPayload p0, Function1<? super Factor, Unit> p1, Function1<? super TwilioVerifyException, Unit> p2) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        final FactorFacade factorFacade = this.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        ExecutorKt.PlaceComponentResult(p1, p2, new Function2<Function1<? super Factor, ? extends Unit>, Function1<? super TwilioVerifyException, ? extends Unit>, Unit>() { // from class: com.twilio.verify.domain.factor.FactorFacade$verifyFactor$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Unit invoke(Function1<? super Factor, ? extends Unit> function1, Function1<? super TwilioVerifyException, ? extends Unit> function12) {
                invoke2((Function1<? super Factor, Unit>) function1, (Function1<? super TwilioVerifyException, Unit>) function12);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(final Function1<? super Factor, Unit> function1, final Function1<? super TwilioVerifyException, Unit> function12) {
                final PushFactory pushFactory;
                Intrinsics.checkParameterIsNotNull(function1, "");
                Intrinsics.checkParameterIsNotNull(function12, "");
                if (p0 instanceof VerifyPushFactorPayload) {
                    pushFactory = FactorFacade.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    final String builtInFictitiousFunctionClassFactory = p0.getBuiltInFictitiousFunctionClassFactory();
                    Intrinsics.checkParameterIsNotNull(builtInFictitiousFunctionClassFactory, "");
                    Intrinsics.checkParameterIsNotNull(function1, "");
                    Intrinsics.checkParameterIsNotNull(function12, "");
                    Function1<PushFactor, Unit> function13 = new Function1<PushFactor, Unit>() { // from class: com.twilio.verify.domain.factor.PushFactory$verify$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(PushFactor pushFactor) {
                            invoke2(pushFactor);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(PushFactor pushFactor) {
                            KeyStorage keyStorage;
                            FactorProvider factorProvider;
                            Intrinsics.checkParameterIsNotNull(pushFactor, "");
                            String str = pushFactor.getErrorConfigVersion;
                            if (str != null) {
                                keyStorage = PushFactory.this.PlaceComponentResult;
                                String BuiltInFictitiousFunctionClassFactory = keyStorage.BuiltInFictitiousFunctionClassFactory(str, builtInFictitiousFunctionClassFactory);
                                Logger logger = Logger.PlaceComponentResult;
                                Level level = Level.Debug;
                                StringBuilder sb = new StringBuilder();
                                sb.append("Verify factor with payload ");
                                sb.append(BuiltInFictitiousFunctionClassFactory);
                                Logger.MyBillsEntityDataFactory(level, sb.toString());
                                factorProvider = PushFactory.this.BuiltInFictitiousFunctionClassFactory;
                                factorProvider.MyBillsEntityDataFactory(pushFactor, BuiltInFictitiousFunctionClassFactory, function1, function12);
                                return;
                            }
                            Function1 function14 = function12;
                            IllegalStateException illegalStateException = new IllegalStateException("Alias not found");
                            Logger logger2 = Logger.PlaceComponentResult;
                            Level level2 = Level.Error;
                            String obj = illegalStateException.toString();
                            IllegalStateException illegalStateException2 = illegalStateException;
                            Logger.KClassImpl$Data$declaredNonStaticMembers$2(level2, obj, illegalStateException2);
                            function14.invoke(new TwilioVerifyException(illegalStateException2, TwilioVerifyException.ErrorCode.KeyStorageError));
                        }
                    };
                    try {
                        Logger logger = Logger.PlaceComponentResult;
                        Level level = Level.Info;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Verifying push factor ");
                        sb.append(builtInFictitiousFunctionClassFactory);
                        Logger.MyBillsEntityDataFactory(level, sb.toString());
                        Factor PlaceComponentResult = pushFactory.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(builtInFictitiousFunctionClassFactory);
                        if (!(PlaceComponentResult instanceof PushFactor)) {
                            PlaceComponentResult = null;
                        }
                        PushFactor pushFactor = (PushFactor) PlaceComponentResult;
                        if (pushFactor != null) {
                            function13.invoke2(pushFactor);
                            return;
                        }
                        PushFactory pushFactory2 = pushFactory;
                        StorageException storageException = new StorageException("Factor not found");
                        Logger logger2 = Logger.PlaceComponentResult;
                        Logger.KClassImpl$Data$declaredNonStaticMembers$2(Level.Error, storageException.toString(), storageException);
                        throw new TwilioVerifyException(storageException, TwilioVerifyException.ErrorCode.StorageError);
                    } catch (TwilioVerifyException e) {
                        function12.invoke(e);
                    }
                }
            }
        });
    }

    @Override // com.twilio.verify.TwilioVerify
    public final void getAuthRequestContext(final UpdateFactorPayload p0, Function1<? super Factor, Unit> p1, Function1<? super TwilioVerifyException, Unit> p2) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        final FactorFacade factorFacade = this.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        ExecutorKt.PlaceComponentResult(p1, p2, new Function2<Function1<? super Factor, ? extends Unit>, Function1<? super TwilioVerifyException, ? extends Unit>, Unit>() { // from class: com.twilio.verify.domain.factor.FactorFacade$updateFactor$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Unit invoke(Function1<? super Factor, ? extends Unit> function1, Function1<? super TwilioVerifyException, ? extends Unit> function12) {
                invoke2((Function1<? super Factor, Unit>) function1, (Function1<? super TwilioVerifyException, Unit>) function12);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(final Function1<? super Factor, Unit> function1, final Function1<? super TwilioVerifyException, Unit> function12) {
                final PushFactory pushFactory;
                Intrinsics.checkParameterIsNotNull(function1, "");
                Intrinsics.checkParameterIsNotNull(function12, "");
                if (p0 instanceof UpdatePushFactorPayload) {
                    pushFactory = FactorFacade.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    String placeComponentResult = p0.getPlaceComponentResult();
                    final String str = ((UpdatePushFactorPayload) p0).getAuthRequestContext;
                    Intrinsics.checkParameterIsNotNull(placeComponentResult, "");
                    Intrinsics.checkParameterIsNotNull(str, "");
                    Intrinsics.checkParameterIsNotNull(function1, "");
                    Intrinsics.checkParameterIsNotNull(function12, "");
                    Function1<PushFactor, Unit> function13 = new Function1<PushFactor, Unit>() { // from class: com.twilio.verify.domain.factor.PushFactory$update$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(PushFactor pushFactor) {
                            invoke2(pushFactor);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(PushFactor pushFactor) {
                            Map PlaceComponentResult;
                            FactorProvider factorProvider;
                            Intrinsics.checkParameterIsNotNull(pushFactor, "");
                            String str2 = pushFactor.KClassImpl$Data$declaredNonStaticMembers$2;
                            FactorType factorType = FactorType.PUSH;
                            String str3 = pushFactor.moveToNextValue;
                            String str4 = pushFactor.BuiltInFictitiousFunctionClassFactory;
                            PlaceComponentResult = PushFactory.this.PlaceComponentResult(str);
                            com.twilio.verify.domain.factor.models.UpdateFactorPayload updateFactorPayload = new com.twilio.verify.domain.factor.models.UpdateFactorPayload(str2, factorType, str3, str4, PlaceComponentResult, pushFactor.lookAheadTest);
                            Logger logger = Logger.PlaceComponentResult;
                            Level level = Level.Debug;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Update push factor with payload ");
                            sb.append(updateFactorPayload);
                            Logger.MyBillsEntityDataFactory(level, sb.toString());
                            factorProvider = PushFactory.this.BuiltInFictitiousFunctionClassFactory;
                            factorProvider.getAuthRequestContext(updateFactorPayload, function1, function12);
                        }
                    };
                    try {
                        Logger logger = Logger.PlaceComponentResult;
                        Level level = Level.Info;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Updating push factor ");
                        sb.append(placeComponentResult);
                        Logger.MyBillsEntityDataFactory(level, sb.toString());
                        Factor PlaceComponentResult = pushFactory.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(placeComponentResult);
                        if (!(PlaceComponentResult instanceof PushFactor)) {
                            PlaceComponentResult = null;
                        }
                        PushFactor pushFactor = (PushFactor) PlaceComponentResult;
                        if (pushFactor != null) {
                            function13.invoke2(pushFactor);
                            return;
                        }
                        PushFactory pushFactory2 = pushFactory;
                        StorageException storageException = new StorageException("Factor not found");
                        Logger logger2 = Logger.PlaceComponentResult;
                        Logger.KClassImpl$Data$declaredNonStaticMembers$2(Level.Error, storageException.toString(), storageException);
                        throw new TwilioVerifyException(storageException, TwilioVerifyException.ErrorCode.StorageError);
                    } catch (TwilioVerifyException e) {
                        function12.invoke(e);
                    }
                }
            }
        });
    }

    @Override // com.twilio.verify.TwilioVerify
    public final void getAuthRequestContext(Function1<? super List<? extends Factor>, Unit> p0, Function1<? super TwilioVerifyException, Unit> p1) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        FactorFacade factorFacade = this.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        try {
            p0.invoke(factorFacade.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2());
        } catch (TwilioVerifyException e) {
            p1.invoke(e);
        }
    }

    @Override // com.twilio.verify.TwilioVerify
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String p0, final String p1, Function1<? super Challenge, Unit> p2, Function1<? super TwilioVerifyException, Unit> p3) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        Intrinsics.checkParameterIsNotNull(p3, "");
        final ChallengeFacade challengeFacade = this.getAuthRequestContext;
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        Intrinsics.checkParameterIsNotNull(p3, "");
        ExecutorKt.PlaceComponentResult(p2, p3, new Function2<Function1<? super Challenge, ? extends Unit>, Function1<? super TwilioVerifyException, ? extends Unit>, Unit>() { // from class: com.twilio.verify.domain.challenge.ChallengeFacade$getChallenge$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Unit invoke(Function1<? super Challenge, ? extends Unit> function1, Function1<? super TwilioVerifyException, ? extends Unit> function12) {
                invoke2((Function1<? super Challenge, Unit>) function1, (Function1<? super TwilioVerifyException, Unit>) function12);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(final Function1<? super Challenge, Unit> function1, final Function1<? super TwilioVerifyException, Unit> function12) {
                FactorFacade factorFacade;
                Intrinsics.checkParameterIsNotNull(function1, "");
                Intrinsics.checkParameterIsNotNull(function12, "");
                factorFacade = ChallengeFacade.this.BuiltInFictitiousFunctionClassFactory;
                factorFacade.MyBillsEntityDataFactory(p1, new Function1<Factor, Unit>() { // from class: com.twilio.verify.domain.challenge.ChallengeFacade$getChallenge$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Factor factor) {
                        invoke2(factor);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Factor factor) {
                        PushChallengeProcessor pushChallengeProcessor;
                        Intrinsics.checkParameterIsNotNull(factor, "");
                        if (factor instanceof PushFactor) {
                            pushChallengeProcessor = ChallengeFacade.this.PlaceComponentResult;
                            pushChallengeProcessor.BuiltInFictitiousFunctionClassFactory(p0, (PushFactor) factor, function1, function12);
                        }
                    }
                }, function12);
            }
        });
    }

    @Override // com.twilio.verify.TwilioVerify
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final ChallengeListPayload p0, final Function1<? super ChallengeList, Unit> p1, final Function1<? super TwilioVerifyException, Unit> p2) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        final ChallengeFacade challengeFacade = this.getAuthRequestContext;
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        challengeFacade.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(p0.BuiltInFictitiousFunctionClassFactory, new Function1<Factor, Unit>() { // from class: com.twilio.verify.domain.challenge.ChallengeFacade$getAllChallenges$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Factor factor) {
                invoke2(factor);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(final Factor factor) {
                Intrinsics.checkParameterIsNotNull(factor, "");
                ExecutorKt.PlaceComponentResult(p1, p2, new Function2<Function1<? super ChallengeList, ? extends Unit>, Function1<? super TwilioVerifyException, ? extends Unit>, Unit>() { // from class: com.twilio.verify.domain.challenge.ChallengeFacade$getAllChallenges$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final /* bridge */ /* synthetic */ Unit invoke(Function1<? super ChallengeList, ? extends Unit> function1, Function1<? super TwilioVerifyException, ? extends Unit> function12) {
                        invoke2((Function1<? super ChallengeList, Unit>) function1, (Function1<? super TwilioVerifyException, Unit>) function12);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(final Function1<? super ChallengeList, Unit> function1, final Function1<? super TwilioVerifyException, Unit> function12) {
                        ChallengeProvider challengeProvider;
                        Intrinsics.checkParameterIsNotNull(function1, "");
                        Intrinsics.checkParameterIsNotNull(function12, "");
                        challengeProvider = ChallengeFacade.this.getAuthRequestContext;
                        challengeProvider.MyBillsEntityDataFactory(factor, p0.KClassImpl$Data$declaredNonStaticMembers$2, p0.PlaceComponentResult, p0.MyBillsEntityDataFactory, p0.getAuthRequestContext, new Function1<ChallengeList, Unit>() { // from class: com.twilio.verify.domain.challenge.ChallengeFacade.getAllChallenges.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(ChallengeList challengeList) {
                                invoke2(challengeList);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(ChallengeList challengeList) {
                                Intrinsics.checkParameterIsNotNull(challengeList, "");
                                Function1.this.invoke(challengeList);
                            }
                        }, new Function1<TwilioVerifyException, Unit>() { // from class: com.twilio.verify.domain.challenge.ChallengeFacade.getAllChallenges.1.1.2
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
                });
            }
        }, p2);
    }

    @Override // com.twilio.verify.TwilioVerify
    public final void MyBillsEntityDataFactory(final UpdateChallengePayload p0, Function0<Unit> p1, Function1<? super TwilioVerifyException, Unit> p2) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        final ChallengeFacade challengeFacade = this.getAuthRequestContext;
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        ExecutorKt.PlaceComponentResult(p1, p2, new Function2<Function0<? extends Unit>, Function1<? super TwilioVerifyException, ? extends Unit>, Unit>() { // from class: com.twilio.verify.domain.challenge.ChallengeFacade$updateChallenge$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0, Function1<? super TwilioVerifyException, ? extends Unit> function1) {
                invoke2((Function0<Unit>) function0, (Function1<? super TwilioVerifyException, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(final Function0<Unit> function0, final Function1<? super TwilioVerifyException, Unit> function1) {
                FactorFacade factorFacade;
                Intrinsics.checkParameterIsNotNull(function0, "");
                Intrinsics.checkParameterIsNotNull(function1, "");
                factorFacade = ChallengeFacade.this.BuiltInFictitiousFunctionClassFactory;
                factorFacade.MyBillsEntityDataFactory(p0.getPlaceComponentResult(), new Function1<Factor, Unit>() { // from class: com.twilio.verify.domain.challenge.ChallengeFacade$updateChallenge$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Factor factor) {
                        invoke2(factor);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Factor factor) {
                        Intrinsics.checkParameterIsNotNull(factor, "");
                        if (factor instanceof PushFactor) {
                            ChallengeFacade.BuiltInFictitiousFunctionClassFactory(ChallengeFacade.this, p0, (PushFactor) factor, function0, function1);
                        }
                    }
                }, function1);
            }
        });
    }

    @Override // com.twilio.verify.TwilioVerify
    public final void getAuthRequestContext(Function0<Unit> p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        final FactorFacade factorFacade = this.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkParameterIsNotNull(p0, "");
        ExecutorKt.PlaceComponentResult(p0, new Function1<TwilioVerifyException, Unit>() { // from class: com.twilio.verify.domain.factor.FactorFacade$clearLocalStorage$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(TwilioVerifyException twilioVerifyException) {
                Intrinsics.checkParameterIsNotNull(twilioVerifyException, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(TwilioVerifyException twilioVerifyException) {
                invoke2(twilioVerifyException);
                return Unit.INSTANCE;
            }
        }, new Function2<Function0<? extends Unit>, Function1<? super TwilioVerifyException, ? extends Unit>, Unit>() { // from class: com.twilio.verify.domain.factor.FactorFacade$clearLocalStorage$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0, Function1<? super TwilioVerifyException, ? extends Unit> function1) {
                invoke2((Function0<Unit>) function0, (Function1<? super TwilioVerifyException, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Function0<Unit> function0, Function1<? super TwilioVerifyException, Unit> function1) {
                FactorProvider factorProvider;
                PushFactory pushFactory;
                Intrinsics.checkParameterIsNotNull(function0, "");
                Intrinsics.checkParameterIsNotNull(function1, "");
                try {
                    pushFactory = FactorFacade.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    Intrinsics.checkParameterIsNotNull(function0, "");
                    List<Factor> KClassImpl$Data$declaredNonStaticMembers$2 = pushFactory.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
                    ArrayList<PushFactor> arrayList = new ArrayList();
                    for (Factor factor : KClassImpl$Data$declaredNonStaticMembers$2) {
                        if (!(factor instanceof PushFactor)) {
                            factor = null;
                        }
                        PushFactor pushFactor = (PushFactor) factor;
                        if (pushFactor != null) {
                            arrayList.add(pushFactor);
                        }
                    }
                    for (PushFactor pushFactor2 : arrayList) {
                        pushFactory.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(pushFactor2);
                        String str = pushFactor2.getErrorConfigVersion;
                        if (str != null) {
                            pushFactory.PlaceComponentResult.MyBillsEntityDataFactory(str);
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    function0.invoke();
                } catch (Exception unused) {
                    factorProvider = FactorFacade.this.BuiltInFictitiousFunctionClassFactory;
                    factorProvider.MyBillsEntityDataFactory();
                    function0.invoke();
                }
            }
        });
    }
}
