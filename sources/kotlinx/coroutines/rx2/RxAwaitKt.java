package kotlinx.coroutines.rx2;

import com.alipay.mobile.rome.syncsdk.transport.connection.d;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import java.util.NoSuchElementException;
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

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a#\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a1\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a7\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00018\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a+\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u000b\u001a\u00028\u0000H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a#\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a%\u0010\u0013\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0012\u001a\u001f\u0010\u0018\u001a\u00020\u0017*\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"T", "Lio/reactivex/SingleSource;", "await", "(Lio/reactivex/SingleSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/reactivex/ObservableSource;", "Lkotlin/Function0;", "defaultValue", "awaitFirstOrElse", "(Lio/reactivex/ObservableSource;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/rx2/Mode;", "mode", "default", "awaitOne", "(Lio/reactivex/ObservableSource;Lkotlinx/coroutines/rx2/Mode;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/reactivex/MaybeSource;", "awaitOrDefault", "(Lio/reactivex/MaybeSource;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSingle", "(Lio/reactivex/MaybeSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSingleOrNull", "Lkotlinx/coroutines/CancellableContinuation;", "Lio/reactivex/disposables/Disposable;", d.f7256a, "", "disposeOnCancellation", "(Lkotlinx/coroutines/CancellableContinuation;Lio/reactivex/disposables/Disposable;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RxAwaitKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object awaitSingle(io.reactivex.MaybeSource<T> r4, kotlin.coroutines.Continuation<? super T> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.rx2.RxAwaitKt$awaitSingle$1
            if (r0 == 0) goto L14
            r0 = r5
            kotlinx.coroutines.rx2.RxAwaitKt$awaitSingle$1 r0 = (kotlinx.coroutines.rx2.RxAwaitKt$awaitSingle$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 + r2
            r0.label = r5
            goto L19
        L14:
            kotlinx.coroutines.rx2.RxAwaitKt$awaitSingle$1 r0 = new kotlinx.coroutines.rx2.RxAwaitKt$awaitSingle$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L3e
        L2a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.label = r3
            java.lang.Object r5 = awaitSingleOrNull(r4, r0)
            if (r5 != r1) goto L3e
            return r1
        L3e:
            if (r5 == 0) goto L41
            return r5
        L41:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.RxAwaitKt.awaitSingle(io.reactivex.MaybeSource, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Deprecated in favor of awaitSingleOrNull()", replaceWith = @kotlin.ReplaceWith(expression = "this.awaitSingleOrNull() ?: default", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object awaitOrDefault(io.reactivex.MaybeSource<T> r4, T r5, kotlin.coroutines.Continuation<? super T> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.rx2.RxAwaitKt$awaitOrDefault$1
            if (r0 == 0) goto L14
            r0 = r6
            kotlinx.coroutines.rx2.RxAwaitKt$awaitOrDefault$1 r0 = (kotlinx.coroutines.rx2.RxAwaitKt$awaitOrDefault$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 + r2
            r0.label = r6
            goto L19
        L14:
            kotlinx.coroutines.rx2.RxAwaitKt$awaitOrDefault$1 r0 = new kotlinx.coroutines.rx2.RxAwaitKt$awaitOrDefault$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            java.lang.Object r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L42
        L2c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = awaitSingleOrNull(r4, r0)
            if (r6 != r1) goto L42
            return r1
        L42:
            if (r6 == 0) goto L45
            r5 = r6
        L45:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.RxAwaitKt.awaitOrDefault(io.reactivex.MaybeSource, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object awaitFirstOrElse(io.reactivex.ObservableSource<T> r7, kotlin.jvm.functions.Function0<? extends T> r8, kotlin.coroutines.Continuation<? super T> r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.rx2.RxAwaitKt$awaitFirstOrElse$1
            if (r0 == 0) goto L14
            r0 = r9
            kotlinx.coroutines.rx2.RxAwaitKt$awaitFirstOrElse$1 r0 = (kotlinx.coroutines.rx2.RxAwaitKt$awaitFirstOrElse$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 + r2
            r0.label = r9
            goto L19
        L14:
            kotlinx.coroutines.rx2.RxAwaitKt$awaitFirstOrElse$1 r0 = new kotlinx.coroutines.rx2.RxAwaitKt$awaitFirstOrElse$1
            r0.<init>(r9)
        L19:
            r4 = r0
            java.lang.Object r9 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L38
            if (r1 != r2) goto L30
            java.lang.Object r7 = r4.L$0
            r8 = r7
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L4d
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlinx.coroutines.rx2.Mode r9 = kotlinx.coroutines.rx2.Mode.FIRST_OR_DEFAULT
            r4.L$0 = r8
            r4.label = r2
            r3 = 0
            r5 = 2
            r6 = 0
            r1 = r7
            r2 = r9
            java.lang.Object r9 = awaitOne$default(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L4d
            return r0
        L4d:
            if (r9 != 0) goto L53
            java.lang.Object r9 = r8.invoke()
        L53:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.RxAwaitKt.awaitFirstOrElse(io.reactivex.ObservableSource, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void disposeOnCancellation(CancellableContinuation<?> cancellableContinuation, final Disposable disposable) {
        cancellableContinuation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.rx2.RxAwaitKt$disposeOnCancellation$1
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
                Disposable.this.dispose();
            }
        });
    }

    static /* synthetic */ Object awaitOne$default(ObservableSource observableSource, Mode mode, Object obj, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        return awaitOne(observableSource, mode, obj, continuation);
    }

    public static final <T> Object awaitSingleOrNull(MaybeSource<T> maybeSource, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        maybeSource.PlaceComponentResult((MaybeObserver) ((MaybeObserver<T>) new MaybeObserver<T>() { // from class: kotlinx.coroutines.rx2.RxAwaitKt$awaitSingleOrNull$2$1
            @Override // io.reactivex.MaybeObserver
            public final void onSubscribe(Disposable d) {
                RxAwaitKt.disposeOnCancellation(cancellableContinuationImpl2, d);
            }

            @Override // io.reactivex.MaybeObserver
            public final void onComplete() {
                CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m3179constructorimpl(null));
            }

            @Override // io.reactivex.MaybeObserver
            public final void onSuccess(T t) {
                CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m3179constructorimpl(t));
            }

            @Override // io.reactivex.MaybeObserver
            public final void onError(Throwable error) {
                CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(error)));
            }
        }));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final <T> Object await(SingleSource<T> singleSource, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        singleSource.MyBillsEntityDataFactory((SingleObserver) ((SingleObserver<T>) new SingleObserver<T>() { // from class: kotlinx.coroutines.rx2.RxAwaitKt$await$5$1
            @Override // io.reactivex.SingleObserver
            public final void onSubscribe(Disposable d) {
                RxAwaitKt.disposeOnCancellation(cancellableContinuationImpl2, d);
            }

            @Override // io.reactivex.SingleObserver
            public final void onSuccess(T t) {
                CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m3179constructorimpl(t));
            }

            @Override // io.reactivex.SingleObserver
            public final void onError(Throwable error) {
                CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(error)));
            }
        }));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private static final <T> Object awaitOne(ObservableSource<T> observableSource, final Mode mode, final T t, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        observableSource.subscribe((Observer) ((Observer<T>) new Observer<T>() { // from class: kotlinx.coroutines.rx2.RxAwaitKt$awaitOne$2$1
            private boolean seenValue;
            private Disposable subscription;
            private T value;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* loaded from: classes9.dex */
            public final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Mode.values().length];
                    iArr[Mode.FIRST.ordinal()] = 1;
                    iArr[Mode.FIRST_OR_DEFAULT.ordinal()] = 2;
                    iArr[Mode.LAST.ordinal()] = 3;
                    iArr[Mode.SINGLE.ordinal()] = 4;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // io.reactivex.Observer
            public final void onSubscribe(final Disposable sub) {
                this.subscription = sub;
                cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.rx2.RxAwaitKt$awaitOne$2$1$onSubscribe$1
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
                        Disposable.this.dispose();
                    }
                });
            }

            @Override // io.reactivex.Observer
            public final void onNext(T t2) {
                int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
                Disposable disposable = null;
                if (i == 1 || i == 2) {
                    if (this.seenValue) {
                        return;
                    }
                    this.seenValue = true;
                    CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m3179constructorimpl(t2));
                    Disposable disposable2 = this.subscription;
                    if (disposable2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        disposable = disposable2;
                    }
                    disposable.dispose();
                } else if (i == 3 || i == 4) {
                    if (mode == Mode.SINGLE && this.seenValue) {
                        if (cancellableContinuationImpl2.isActive()) {
                            CancellableContinuation<T> cancellableContinuation2 = cancellableContinuationImpl2;
                            Result.Companion companion2 = Result.INSTANCE;
                            StringBuilder sb = new StringBuilder();
                            sb.append("More than one onNext value for ");
                            sb.append(mode);
                            cancellableContinuation2.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(new IllegalArgumentException(sb.toString()))));
                        }
                        Disposable disposable3 = this.subscription;
                        if (disposable3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            disposable = disposable3;
                        }
                        disposable.dispose();
                        return;
                    }
                    this.value = t2;
                    this.seenValue = true;
                }
            }

            @Override // io.reactivex.Observer
            public final void onComplete() {
                if (this.seenValue) {
                    if (cancellableContinuationImpl2.isActive()) {
                        CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl2;
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m3179constructorimpl(this.value));
                    }
                } else if (mode == Mode.FIRST_OR_DEFAULT) {
                    CancellableContinuation<T> cancellableContinuation2 = cancellableContinuationImpl2;
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation2.resumeWith(Result.m3179constructorimpl(t));
                } else if (cancellableContinuationImpl2.isActive()) {
                    CancellableContinuation<T> cancellableContinuation3 = cancellableContinuationImpl2;
                    Result.Companion companion3 = Result.INSTANCE;
                    StringBuilder sb = new StringBuilder();
                    sb.append("No value received via onNext for ");
                    sb.append(mode);
                    cancellableContinuation3.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(new NoSuchElementException(sb.toString()))));
                }
            }

            @Override // io.reactivex.Observer
            public final void onError(Throwable e) {
                CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(e)));
            }
        }));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
