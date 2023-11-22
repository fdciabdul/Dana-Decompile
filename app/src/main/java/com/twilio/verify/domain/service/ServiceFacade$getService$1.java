package com.twilio.verify.domain.service;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.models.Factor;
import com.twilio.verify.models.Service;
import com.twilio.verify.threading.ExecutorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/twilio/verify/models/Factor;", "factor", "", BridgeDSL.INVOKE, "(Lcom/twilio/verify/models/Factor;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes8.dex */
final class ServiceFacade$getService$1 extends Lambda implements Function1<Factor, Unit> {
    final /* synthetic */ Function1 $$error;
    final /* synthetic */ String $$serviceSid;
    final /* synthetic */ Function1 $$success;
    final /* synthetic */ ServiceFacade this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ServiceFacade$getService$1(ServiceFacade serviceFacade, Function1 function1, Function1 function12, String str) {
        super(1);
        this.this$0 = serviceFacade;
        this.$$success = function1;
        this.$$error = function12;
        this.$$serviceSid = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Factor factor) {
        invoke2(factor);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(final Factor factor) {
        Intrinsics.checkParameterIsNotNull(factor, "");
        ExecutorKt.PlaceComponentResult(this.$$success, this.$$error, new Function2<Function1<? super Service, ? extends Unit>, Function1<? super TwilioVerifyException, ? extends Unit>, Unit>() { // from class: com.twilio.verify.domain.service.ServiceFacade$getService$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Unit invoke(Function1<? super Service, ? extends Unit> function1, Function1<? super TwilioVerifyException, ? extends Unit> function12) {
                invoke2((Function1<? super Service, Unit>) function1, (Function1<? super TwilioVerifyException, Unit>) function12);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super Service, Unit> function1, Function1<? super TwilioVerifyException, Unit> function12) {
                ServiceProvider serviceProvider;
                Intrinsics.checkParameterIsNotNull(function1, "");
                Intrinsics.checkParameterIsNotNull(function12, "");
                try {
                    serviceProvider = ServiceFacade$getService$1.this.this$0.KClassImpl$Data$declaredNonStaticMembers$2;
                    serviceProvider.MyBillsEntityDataFactory(ServiceFacade$getService$1.this.$$serviceSid, factor, function1, function12);
                } catch (TwilioVerifyException e) {
                    function12.invoke(e);
                }
            }
        });
    }
}
