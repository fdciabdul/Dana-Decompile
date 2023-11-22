package retrofit2;

import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\u001a'\u0010\u0003\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a+\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a)\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0004\u001a\u001b\u0010\u0005\u001a\u00020\n*\u00060\bj\u0002`\tH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"", "T", "Lretrofit2/Call;", "MyBillsEntityDataFactory", "(Lretrofit2/Call;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PlaceComponentResult", "Lretrofit2/Response;", "getAuthRequestContext", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "(Ljava/lang/Exception;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class KotlinExtensions {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object PlaceComponentResult(final java.lang.Exception r4, kotlin.coroutines.Continuation<?> r5) {
        /*
            boolean r0 = r5 instanceof retrofit2.KotlinExtensions$suspendAndThrow$1
            if (r0 == 0) goto L14
            r0 = r5
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = (retrofit2.KotlinExtensions$suspendAndThrow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 + r2
            r0.label = r5
            goto L19
        L14:
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = new retrofit2.KotlinExtensions$suspendAndThrow$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            java.lang.Exception r4 = (java.lang.Exception) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L61
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
            kotlinx.coroutines.CoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.getDefault()
            kotlin.coroutines.CoroutineContext r2 = r0.get$context()
            retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1 r3 = new retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1
            r3.<init>()
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            r5.mo4661dispatch(r2, r3)
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r4 != r5) goto L5e
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L5e:
            if (r4 != r1) goto L61
            return r1
        L61:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.KotlinExtensions.PlaceComponentResult(java.lang.Exception, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final <T> Object MyBillsEntityDataFactory(final Call<T> call, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Call.this.getAuthRequestContext();
            }
        });
        call.MyBillsEntityDataFactory(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$2$2
            @Override // retrofit2.Callback
            public final void PlaceComponentResult(Call<T> p0, Response<T> p1) {
                Intrinsics.checkParameterIsNotNull(p0, "");
                Intrinsics.checkParameterIsNotNull(p1, "");
                if (!p1.MyBillsEntityDataFactory()) {
                    CancellableContinuation cancellableContinuation = CancellableContinuation.this;
                    HttpException httpException = new HttpException(p1);
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(httpException)));
                    return;
                }
                T t = p1.KClassImpl$Data$declaredNonStaticMembers$2;
                if (t == null) {
                    Object tag = p0.KClassImpl$Data$declaredNonStaticMembers$2().tag(Invocation.class);
                    if (tag == null) {
                        Intrinsics.throwNpe();
                    }
                    Intrinsics.checkExpressionValueIsNotNull(tag, "");
                    Method method = ((Invocation) tag).KClassImpl$Data$declaredNonStaticMembers$2;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Response from ");
                    Intrinsics.checkExpressionValueIsNotNull(method, "");
                    Class<?> declaringClass = method.getDeclaringClass();
                    Intrinsics.checkExpressionValueIsNotNull(declaringClass, "");
                    sb.append(declaringClass.getName());
                    sb.append('.');
                    sb.append(method.getName());
                    sb.append(" was null but response body type was declared as non-null");
                    KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(sb.toString());
                    CancellableContinuation cancellableContinuation2 = CancellableContinuation.this;
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation2.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(kotlinNullPointerException)));
                    return;
                }
                CancellableContinuation cancellableContinuation3 = CancellableContinuation.this;
                Result.Companion companion3 = Result.INSTANCE;
                cancellableContinuation3.resumeWith(Result.m3179constructorimpl(t));
            }

            @Override // retrofit2.Callback
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Call<T> p0, Throwable p1) {
                Intrinsics.checkParameterIsNotNull(p0, "");
                Intrinsics.checkParameterIsNotNull(p1, "");
                CancellableContinuation cancellableContinuation = CancellableContinuation.this;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(p1)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final <T> Object PlaceComponentResult(final Call<T> call, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Call.this.getAuthRequestContext();
            }
        });
        call.MyBillsEntityDataFactory(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$4$2
            @Override // retrofit2.Callback
            public final void PlaceComponentResult(Call<T> p0, Response<T> p1) {
                Intrinsics.checkParameterIsNotNull(p0, "");
                Intrinsics.checkParameterIsNotNull(p1, "");
                if (p1.MyBillsEntityDataFactory()) {
                    CancellableContinuation cancellableContinuation = CancellableContinuation.this;
                    T t = p1.KClassImpl$Data$declaredNonStaticMembers$2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m3179constructorimpl(t));
                    return;
                }
                CancellableContinuation cancellableContinuation2 = CancellableContinuation.this;
                HttpException httpException = new HttpException(p1);
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuation2.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(httpException)));
            }

            @Override // retrofit2.Callback
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Call<T> p0, Throwable p1) {
                Intrinsics.checkParameterIsNotNull(p0, "");
                Intrinsics.checkParameterIsNotNull(p1, "");
                CancellableContinuation cancellableContinuation = CancellableContinuation.this;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(p1)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final <T> Object getAuthRequestContext(final Call<T> call, Continuation<? super Response<T>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Call.this.getAuthRequestContext();
            }
        });
        call.MyBillsEntityDataFactory(new Callback<T>() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$2
            @Override // retrofit2.Callback
            public final void PlaceComponentResult(Call<T> p0, Response<T> p1) {
                Intrinsics.checkParameterIsNotNull(p0, "");
                Intrinsics.checkParameterIsNotNull(p1, "");
                CancellableContinuation cancellableContinuation = CancellableContinuation.this;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m3179constructorimpl(p1));
            }

            @Override // retrofit2.Callback
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Call<T> p0, Throwable p1) {
                Intrinsics.checkParameterIsNotNull(p0, "");
                Intrinsics.checkParameterIsNotNull(p1, "");
                CancellableContinuation cancellableContinuation = CancellableContinuation.this;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(p1)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
