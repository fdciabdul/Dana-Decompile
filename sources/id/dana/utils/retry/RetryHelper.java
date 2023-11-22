package id.dana.utils.retry;

import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.holdlogin.v2.interceptor.HoldLoginV2Starting;
import id.dana.utils.retry.RetryException;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Predicate;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b#\u0010$J-\u0010\b\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJM\u0010\b\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\n2$\u0010\u0010\u001a \u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0002¢\u0006\u0004\b\b\u0010\u0011J\u0093\u0001\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\"\b\b\u0000\u0010\u0012*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062$\u0010\u0016\u001a \u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0004\b\u0018\u0010\u0019J\u0097\u0001\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0012*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\n2\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00022\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062$\u0010\u0016\u001a \u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ¹\u0001\u0010\u0018\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001c2\u0006\u0010\u0005\u001a\u00020\n2\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00132\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\u001e2$\u0010\u001f\u001a \u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010 R\u0011\u0010\"\u001a\u00020\u00068\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010!\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/utils/retry/RetryHelper;", "", "Lkotlin/Function0;", "Lio/reactivex/Observable;", "", "p0", "", "p1", "MyBillsEntityDataFactory", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Long;)Z", "", "", "p2", "Lkotlin/Function4;", "", "", "p3", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/jvm/functions/Function4;)V", "S", "Lkotlin/Function1;", "p4", "p5", "p6", "Lkotlinx/coroutines/flow/Flow;", "PlaceComponentResult", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Ljava/lang/Long;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Ljava/lang/Long;Lkotlin/jvm/functions/Function4;)Lio/reactivex/Observable;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/Function2;", "p7", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;ILjava/lang/Long;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "J", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RetryHelper {
    public static final RetryHelper INSTANCE = new RetryHelper();

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public static final long BuiltInFictitiousFunctionClassFactory = TimeUnit.SECONDS.toMillis(10);

    private RetryHelper() {
    }

    public static <S> Flow<S> PlaceComponentResult(String str, Function0<? extends S> function0, Function0<? extends Observable<Boolean>> function02, Function1<? super Throwable, Boolean> function1, Long l, Function4<? super String, ? super String, ? super String, ? super Throwable, Unit> function4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(function02, "");
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function4, "");
        return FlowKt.flow(new RetryHelper$retryFlow$1(function0, 1, function02, l, str, function4, function1, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:192:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x025e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:292:0x025f A[PHI: r0
      0x025f: PHI (r0v47 java.lang.Object) = (r0v28 java.lang.Object), (r0v1 java.lang.Object) binds: [B:290:0x025c, B:208:0x0092] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0319 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:324:0x031a A[PHI: r0
      0x031a: PHI (r0v53 java.lang.Object) = (r0v52 java.lang.Object), (r0v1 java.lang.Object) binds: [B:322:0x0317, B:197:0x003c] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:326:0x031c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:297:0x0264 -> B:298:0x0278). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <T> java.lang.Object PlaceComponentResult(java.lang.String r20, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r21, kotlin.jvm.functions.Function0<? extends io.reactivex.Observable<java.lang.Boolean>> r22, kotlin.jvm.functions.Function1<? super java.lang.Throwable, java.lang.Boolean> r23, int r24, java.lang.Long r25, kotlin.jvm.functions.Function2<? super java.lang.Throwable, ? super java.lang.String, kotlin.Unit> r26, kotlin.jvm.functions.Function4<? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Throwable, kotlin.Unit> r27, kotlin.coroutines.Continuation<? super T> r28) {
        /*
            Method dump skipped, instructions count: 798
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.utils.retry.RetryHelper.PlaceComponentResult(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, int, java.lang.Long, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function4, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static boolean MyBillsEntityDataFactory(Function0<? extends Observable<Boolean>> p0, Long p1) {
        Observable<Boolean> takeUntil = p0.invoke().filter(new Predicate() { // from class: id.dana.utils.retry.RetryHelper$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean PlaceComponentResult;
                PlaceComponentResult = RetryHelper.PlaceComponentResult((Boolean) obj);
                return PlaceComponentResult;
            }
        }).takeUntil(new Predicate() { // from class: id.dana.utils.retry.RetryHelper$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean MyBillsEntityDataFactory;
                MyBillsEntityDataFactory = RetryHelper.MyBillsEntityDataFactory((Boolean) obj);
                return MyBillsEntityDataFactory;
            }
        });
        if (p1 != null && p1.longValue() >= 1000) {
            takeUntil = takeUntil.timeout(p1.longValue(), TimeUnit.MILLISECONDS);
        }
        Boolean blockingFirst = takeUntil.blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        return blockingFirst.booleanValue();
    }

    public static final boolean PlaceComponentResult(Boolean bool) {
        Intrinsics.checkNotNullParameter(bool, "");
        return !bool.booleanValue();
    }

    public static final boolean MyBillsEntityDataFactory(Boolean bool) {
        Intrinsics.checkNotNullParameter(bool, "");
        return !bool.booleanValue();
    }

    @JvmStatic
    public static final <S> Observable<S> KClassImpl$Data$declaredNonStaticMembers$2(final String str, final Function0<? extends S> function0, final Function0<? extends Observable<Boolean>> function02, final Function1<? super Throwable, Boolean> function1, final Long l, final Function4<? super String, ? super String, ? super String, ? super Throwable, Unit> function4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(function02, "");
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function4, "");
        Observable<S> create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.utils.retry.RetryHelper$$ExternalSyntheticLambda0
            public final /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2 = 1;

            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                RetryHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, str, function4, function0, function1, function02, l, observableEmitter);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        return create;
    }

    public static void MyBillsEntityDataFactory(String p0, int p1, String p2, Function4<? super String, ? super String, ? super String, ? super Throwable, Unit> p3) {
        RetryException retryException;
        try {
            if (p1 == 1) {
                retryException = RetryException.FirstRetry.INSTANCE;
            } else if (p1 == 2) {
                retryException = RetryException.SecondRetry.INSTANCE;
            } else if (p1 == 3) {
                retryException = RetryException.ThirdRetry.INSTANCE;
            } else {
                retryException = RetryException.UnknownRetry.INSTANCE;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Retry ");
            sb.append(p0);
            sb.append(" because of RpcException 2000");
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Attempt ");
            sb2.append(p1);
            String obj2 = sb2.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("From ");
            sb3.append(p2);
            p3.invoke(obj, obj2, sb3.toString(), retryException);
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ void PlaceComponentResult(int i, String str, Function4 function4, Function0 function0, Function1 function1, Function0 function02, Long l, ObservableEmitter observableEmitter) {
        Object m3179constructorimpl;
        Object m3179constructorimpl2;
        Object m3179constructorimpl3;
        Object m3179constructorimpl4;
        Object m3179constructorimpl5;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(function4, "");
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function02, "");
        Intrinsics.checkNotNullParameter(observableEmitter, "");
        try {
            Result.Companion companion = Result.INSTANCE;
            Object invoke = function0.invoke();
            Intrinsics.checkNotNull(invoke);
            m3179constructorimpl = Result.m3179constructorimpl(invoke);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m3186isSuccessimpl(m3179constructorimpl)) {
            observableEmitter.onNext(m3179constructorimpl);
            return;
        }
        Throwable m3182exceptionOrNullimpl = Result.m3182exceptionOrNullimpl(m3179constructorimpl);
        if (m3182exceptionOrNullimpl != null) {
            if (!((Boolean) function1.invoke(m3182exceptionOrNullimpl)).booleanValue()) {
                observableEmitter.tryOnError(m3182exceptionOrNullimpl);
                return;
            }
            HoldLoginV2Starting.MyBillsEntityDataFactory(str);
        }
        int i2 = 0;
        while (i2 < i - 1) {
            i2++;
            try {
                Result.Companion companion3 = Result.INSTANCE;
                m3179constructorimpl4 = Result.m3179constructorimpl(Boolean.valueOf(MyBillsEntityDataFactory(function02, l)));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                m3179constructorimpl4 = Result.m3179constructorimpl(ResultKt.createFailure(th2));
            }
            Throwable m3182exceptionOrNullimpl2 = Result.m3182exceptionOrNullimpl(m3179constructorimpl4);
            if (m3182exceptionOrNullimpl2 != null) {
                observableEmitter.tryOnError(m3182exceptionOrNullimpl2);
                return;
            }
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                DanaLog.BuiltInFictitiousFunctionClassFactory("RetryHelper", e.getMessage(), e);
            }
            MyBillsEntityDataFactory(str, i2, "RxJava", function4);
            try {
                Result.Companion companion5 = Result.INSTANCE;
                Object invoke2 = function0.invoke();
                Intrinsics.checkNotNull(invoke2);
                m3179constructorimpl5 = Result.m3179constructorimpl(invoke2);
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.INSTANCE;
                m3179constructorimpl5 = Result.m3179constructorimpl(ResultKt.createFailure(th3));
            }
            if (Result.m3186isSuccessimpl(m3179constructorimpl5)) {
                observableEmitter.onNext(m3179constructorimpl5);
                return;
            }
            Throwable m3182exceptionOrNullimpl3 = Result.m3182exceptionOrNullimpl(m3179constructorimpl5);
            if (m3182exceptionOrNullimpl3 != null && !((Boolean) function1.invoke(m3182exceptionOrNullimpl3)).booleanValue()) {
                observableEmitter.tryOnError(m3182exceptionOrNullimpl3);
                return;
            }
        }
        try {
            Result.Companion companion7 = Result.INSTANCE;
            m3179constructorimpl2 = Result.m3179constructorimpl(Boolean.valueOf(MyBillsEntityDataFactory(function02, l)));
        } catch (Throwable th4) {
            Result.Companion companion8 = Result.INSTANCE;
            m3179constructorimpl2 = Result.m3179constructorimpl(ResultKt.createFailure(th4));
        }
        Throwable m3182exceptionOrNullimpl4 = Result.m3182exceptionOrNullimpl(m3179constructorimpl2);
        if (m3182exceptionOrNullimpl4 != null) {
            observableEmitter.tryOnError(m3182exceptionOrNullimpl4);
            return;
        }
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e2) {
            DanaLog.BuiltInFictitiousFunctionClassFactory("RetryHelper", e2.getMessage(), e2);
        }
        MyBillsEntityDataFactory(str, i, "RxJava", function4);
        try {
            Result.Companion companion9 = Result.INSTANCE;
            Object invoke3 = function0.invoke();
            Intrinsics.checkNotNull(invoke3);
            m3179constructorimpl3 = Result.m3179constructorimpl(invoke3);
        } catch (Throwable th5) {
            Result.Companion companion10 = Result.INSTANCE;
            m3179constructorimpl3 = Result.m3179constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m3186isSuccessimpl(m3179constructorimpl3)) {
            observableEmitter.onNext(m3179constructorimpl3);
            return;
        }
        Throwable m3182exceptionOrNullimpl5 = Result.m3182exceptionOrNullimpl(m3179constructorimpl3);
        if (m3182exceptionOrNullimpl5 == null || ((Boolean) function1.invoke(m3182exceptionOrNullimpl5)).booleanValue()) {
            return;
        }
        observableEmitter.tryOnError(m3182exceptionOrNullimpl5);
    }
}
