package com.twilio.verify.threading;

import com.twilio.verify.TwilioVerifyException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a}\u0010\u000b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032J\u0010\n\u001aF\u0012\u0017\u0012\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000j\u0004\u0018\u0001`\u0007¢\u0006\u0002\b\b\u0012#\u0012!\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\t¢\u0006\u0002\b\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0095\u0001\u0010\u000b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\r2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032V\u0010\n\u001aR\u0012#\u0012!\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000e¢\u0006\u0002\b\b\u0012#\u0012!\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\t¢\u0006\u0002\b\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0000¢\u0006\u0004\b\u000b\u0010\u000f\"\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012*(\u0010\u0015\u001a\u0004\b\u0000\u0010\u0014\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00010\u0003*\u0016\u0010\u0016\"\b\u0012\u0004\u0012\u00020\u00010\u00002\b\u0012\u0004\u0012\u00020\u00010\u0000*(\u0010\u0017\u001a\u0004\b\u0000\u0010\r\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00010\u0003"}, d2 = {"Lkotlin/Function0;", "", "p0", "Lkotlin/Function1;", "Lcom/twilio/verify/TwilioVerifyException;", "p1", "Lkotlin/Function2;", "Lcom/twilio/verify/threading/SafeSuccess;", "Lkotlin/ParameterName;", "Lcom/twilio/verify/threading/SafeError;", "p2", "PlaceComponentResult", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "T", "Lcom/twilio/verify/threading/SafeSuccessResult;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "Ljava/util/concurrent/ExecutorService;", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/concurrent/ExecutorService;", "getAuthRequestContext", "E", "SafeError", "SafeSuccess", "SafeSuccessResult"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public final class ExecutorKt {
    private static final ExecutorService BuiltInFictitiousFunctionClassFactory;

    static {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
        Intrinsics.checkExpressionValueIsNotNull(newFixedThreadPool, "");
        BuiltInFictitiousFunctionClassFactory = newFixedThreadPool;
    }

    public static final <T> void PlaceComponentResult(Function1<? super T, Unit> function1, Function1<? super TwilioVerifyException, Unit> function12, Function2<? super Function1<? super T, Unit>, ? super Function1<? super TwilioVerifyException, Unit>, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(function1, "");
        Intrinsics.checkParameterIsNotNull(function12, "");
        Intrinsics.checkParameterIsNotNull(function2, "");
        BuiltInFictitiousFunctionClassFactory.execute(new Task(function2, function1, function12, null, 8, null));
    }

    public static final void PlaceComponentResult(final Function0<Unit> function0, Function1<? super TwilioVerifyException, Unit> function1, final Function2<? super Function0<Unit>, ? super Function1<? super TwilioVerifyException, Unit>, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(function0, "");
        Intrinsics.checkParameterIsNotNull(function1, "");
        Intrinsics.checkParameterIsNotNull(function2, "");
        BuiltInFictitiousFunctionClassFactory.execute(new Task(new Function2<Function1<? super Unit, ? extends Unit>, Function1<? super TwilioVerifyException, ? extends Unit>, Unit>() { // from class: com.twilio.verify.threading.ExecutorKt$execute$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Unit invoke(Function1<? super Unit, ? extends Unit> function12, Function1<? super TwilioVerifyException, ? extends Unit> function13) {
                invoke2((Function1<? super Unit, Unit>) function12, (Function1<? super TwilioVerifyException, Unit>) function13);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(final Function1<? super Unit, Unit> function12, Function1<? super TwilioVerifyException, Unit> function13) {
                Intrinsics.checkParameterIsNotNull(function12, "");
                Intrinsics.checkParameterIsNotNull(function13, "");
                Function2.this.invoke(new Function0<Unit>() { // from class: com.twilio.verify.threading.ExecutorKt$execute$1.1
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
                        Function1.this.invoke(Unit.INSTANCE);
                    }
                }, function13);
            }
        }, new Function1<Unit, Unit>() { // from class: com.twilio.verify.threading.ExecutorKt$execute$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                Intrinsics.checkParameterIsNotNull(unit, "");
                Function0.this.invoke();
            }
        }, function1, null, 8, null));
    }
}
