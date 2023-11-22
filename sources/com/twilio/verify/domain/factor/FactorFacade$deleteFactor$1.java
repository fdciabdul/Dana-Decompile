package com.twilio.verify.domain.factor;

import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.twilio.security.logger.Level;
import com.twilio.security.logger.Logger;
import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.data.KeyStorage;
import com.twilio.verify.data.StorageException;
import com.twilio.verify.domain.factor.models.PushFactor;
import com.twilio.verify.models.Factor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00012\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00010\u0000j\u0002`\u00022\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlin/Function0;", "", "Lcom/twilio/verify/threading/SafeSuccess;", "onSuccess", "Lkotlin/Function1;", "Lcom/twilio/verify/TwilioVerifyException;", "Lcom/twilio/verify/threading/SafeError;", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, BridgeDSL.INVOKE, "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
final class FactorFacade$deleteFactor$1 extends Lambda implements Function2<Function0<? extends Unit>, Function1<? super TwilioVerifyException, ? extends Unit>, Unit> {
    final /* synthetic */ Function1 $$error;
    final /* synthetic */ String $$factorSid;
    final /* synthetic */ FactorFacade this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FactorFacade$deleteFactor$1(FactorFacade factorFacade, String str, Function1 function1) {
        super(2);
        this.this$0 = factorFacade;
        this.$$factorSid = str;
        this.$$error = function1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0, Function1<? super TwilioVerifyException, ? extends Unit> function1) {
        invoke2((Function0<Unit>) function0, (Function1<? super TwilioVerifyException, Unit>) function1);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(final Function0<Unit> function0, final Function1<? super TwilioVerifyException, Unit> function1) {
        final PushFactory pushFactory;
        Intrinsics.checkParameterIsNotNull(function0, "");
        Intrinsics.checkParameterIsNotNull(function1, "");
        try {
            pushFactory = this.this$0.KClassImpl$Data$declaredNonStaticMembers$2;
            String str = this.$$factorSid;
            Intrinsics.checkParameterIsNotNull(str, "");
            Intrinsics.checkParameterIsNotNull(function0, "");
            Intrinsics.checkParameterIsNotNull(function1, "");
            Function1<PushFactor, Unit> function12 = new Function1<PushFactor, Unit>() { // from class: com.twilio.verify.domain.factor.PushFactory$delete$1
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
                public final void invoke2(final PushFactor pushFactor) {
                    FactorProvider factorProvider;
                    Intrinsics.checkParameterIsNotNull(pushFactor, "");
                    factorProvider = PushFactory.this.BuiltInFictitiousFunctionClassFactory;
                    factorProvider.BuiltInFictitiousFunctionClassFactory(pushFactor, new Function0<Unit>() { // from class: com.twilio.verify.domain.factor.PushFactory$delete$1.1
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
                            KeyStorage keyStorage;
                            String str2 = pushFactor.getErrorConfigVersion;
                            if (str2 != null) {
                                keyStorage = PushFactory.this.PlaceComponentResult;
                                keyStorage.MyBillsEntityDataFactory(str2);
                            }
                            function0.invoke();
                        }
                    }, function1);
                }
            };
            try {
                Logger logger = Logger.PlaceComponentResult;
                Level level = Level.Info;
                StringBuilder sb = new StringBuilder();
                sb.append("Deleting push factor ");
                sb.append(str);
                Logger.MyBillsEntityDataFactory(level, sb.toString());
                Factor PlaceComponentResult = pushFactory.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(str);
                if (!(PlaceComponentResult instanceof PushFactor)) {
                    PlaceComponentResult = null;
                }
                PushFactor pushFactor = (PushFactor) PlaceComponentResult;
                if (pushFactor != null) {
                    function12.invoke2(pushFactor);
                    return;
                }
                PushFactory pushFactory2 = pushFactory;
                StorageException storageException = new StorageException("Factor not found");
                Logger logger2 = Logger.PlaceComponentResult;
                Logger.KClassImpl$Data$declaredNonStaticMembers$2(Level.Error, storageException.toString(), storageException);
                throw new TwilioVerifyException(storageException, TwilioVerifyException.ErrorCode.StorageError);
            } catch (TwilioVerifyException e) {
                function1.invoke(e);
            }
        } catch (TwilioVerifyException e2) {
            this.$$error.invoke(e2);
        }
    }
}
