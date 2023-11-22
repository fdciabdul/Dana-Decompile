package kotlinx.coroutines.reactive;

import com.alibaba.ariver.kernel.RVEvents;
import com.ap.zoloz.hummer.biz.HummerConstants;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\n\u001a1\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a7\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00018\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a1\u0010\u0014\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", HummerConstants.CONTEXT, "", "signalName", "", "gotSignalInTerminalStateException", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/String;)V", "Lkotlinx/coroutines/reactive/Mode;", "mode", "moreThanOneValueProvidedException", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/reactive/Mode;)V", "T", "Lorg/reactivestreams/Publisher;", "Lkotlin/Function0;", "defaultValue", "awaitFirstOrElse", "(Lorg/reactivestreams/Publisher;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "default", "awaitOne", "(Lorg/reactivestreams/Publisher;Lkotlinx/coroutines/reactive/Mode;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSingleOrElse"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AwaitKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object awaitFirstOrElse(org.reactivestreams.Publisher<T> r7, kotlin.jvm.functions.Function0<? extends T> r8, kotlin.coroutines.Continuation<? super T> r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.reactive.AwaitKt$awaitFirstOrElse$1
            if (r0 == 0) goto L14
            r0 = r9
            kotlinx.coroutines.reactive.AwaitKt$awaitFirstOrElse$1 r0 = (kotlinx.coroutines.reactive.AwaitKt$awaitFirstOrElse$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 + r2
            r0.label = r9
            goto L19
        L14:
            kotlinx.coroutines.reactive.AwaitKt$awaitFirstOrElse$1 r0 = new kotlinx.coroutines.reactive.AwaitKt$awaitFirstOrElse$1
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
            kotlinx.coroutines.reactive.Mode r9 = kotlinx.coroutines.reactive.Mode.FIRST_OR_DEFAULT
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
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.AwaitKt.awaitFirstOrElse(org.reactivestreams.Publisher, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Deprecated without a replacement due to its name incorrectly conveying the behavior. Please consider using awaitFirstOrElse().")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object awaitSingleOrElse(org.reactivestreams.Publisher<T> r7, kotlin.jvm.functions.Function0<? extends T> r8, kotlin.coroutines.Continuation<? super T> r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.reactive.AwaitKt$awaitSingleOrElse$1
            if (r0 == 0) goto L14
            r0 = r9
            kotlinx.coroutines.reactive.AwaitKt$awaitSingleOrElse$1 r0 = (kotlinx.coroutines.reactive.AwaitKt$awaitSingleOrElse$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 + r2
            r0.label = r9
            goto L19
        L14:
            kotlinx.coroutines.reactive.AwaitKt$awaitSingleOrElse$1 r0 = new kotlinx.coroutines.reactive.AwaitKt$awaitSingleOrElse$1
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
            kotlinx.coroutines.reactive.Mode r9 = kotlinx.coroutines.reactive.Mode.SINGLE_OR_DEFAULT
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
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.AwaitKt.awaitSingleOrElse(org.reactivestreams.Publisher, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object awaitOne$default(Publisher publisher, Mode mode, Object obj, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        return awaitOne(publisher, mode, obj, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gotSignalInTerminalStateException(CoroutineContext coroutineContext, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append('\'');
        sb.append(str);
        sb.append("' was called after the publisher already signalled being in a terminal state");
        CoroutineExceptionHandlerKt.handleCoroutineException(coroutineContext, new IllegalStateException(sb.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void moreThanOneValueProvidedException(CoroutineContext coroutineContext, Mode mode) {
        StringBuilder sb = new StringBuilder();
        sb.append("Only a single value was requested in '");
        sb.append(mode);
        sb.append("', but the publisher provided more");
        CoroutineExceptionHandlerKt.handleCoroutineException(coroutineContext, new IllegalStateException(sb.toString()));
    }

    private static final <T> Object awaitOne(Publisher<T> publisher, final Mode mode, final T t, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        ReactiveFlowKt.injectCoroutineContext(publisher, cancellableContinuationImpl2.get$context()).subscribe((Subscriber) ((Subscriber<T>) new Subscriber<T>() { // from class: kotlinx.coroutines.reactive.AwaitKt$awaitOne$2$1
            private boolean inTerminalState;
            private boolean seenValue;
            private Subscription subscription;
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
                    iArr[Mode.SINGLE_OR_DEFAULT.ordinal()] = 5;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // org.reactivestreams.Subscriber
            public final void onSubscribe(final Subscription sub) {
                if (this.subscription != null) {
                    sub.cancel();
                    return;
                }
                this.subscription = sub;
                cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.reactive.AwaitKt$awaitOne$2$1$onSubscribe$1
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
                        Subscription.this.cancel();
                    }
                });
                sub.request((mode == Mode.FIRST || mode == Mode.FIRST_OR_DEFAULT) ? 1L : LongCompanionObject.MAX_VALUE);
            }

            @Override // org.reactivestreams.Subscriber
            public final void onNext(T t2) {
                Subscription subscription = this.subscription;
                CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl2;
                if (subscription == null) {
                    CoroutineExceptionHandlerKt.handleCoroutineException(cancellableContinuation.get$context(), new IllegalStateException("'onNext' was called before 'onSubscribe'"));
                } else if (this.inTerminalState) {
                    AwaitKt.gotSignalInTerminalStateException(cancellableContinuation.get$context(), "onNext");
                } else {
                    int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
                    if (i == 1 || i == 2) {
                        if (this.seenValue) {
                            AwaitKt.moreThanOneValueProvidedException(cancellableContinuationImpl2.get$context(), mode);
                            return;
                        }
                        this.seenValue = true;
                        subscription.cancel();
                        CancellableContinuation<T> cancellableContinuation2 = cancellableContinuationImpl2;
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation2.resumeWith(Result.m3179constructorimpl(t2));
                    } else if (i == 3 || i == 4 || i == 5) {
                        if ((mode == Mode.SINGLE || mode == Mode.SINGLE_OR_DEFAULT) && this.seenValue) {
                            subscription.cancel();
                            if (cancellableContinuationImpl2.isActive()) {
                                CancellableContinuation<T> cancellableContinuation3 = cancellableContinuationImpl2;
                                Result.Companion companion2 = Result.INSTANCE;
                                StringBuilder sb = new StringBuilder();
                                sb.append("More than one onNext value for ");
                                sb.append(mode);
                                cancellableContinuation3.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(new IllegalArgumentException(sb.toString()))));
                                return;
                            }
                            return;
                        }
                        this.value = t2;
                        this.seenValue = true;
                    }
                }
            }

            @Override // org.reactivestreams.Subscriber
            public final void onComplete() {
                if (tryEnterTerminalState("onComplete")) {
                    if (this.seenValue) {
                        if (mode == Mode.FIRST_OR_DEFAULT || mode == Mode.FIRST || !cancellableContinuationImpl2.isActive()) {
                            return;
                        }
                        CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl2;
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m3179constructorimpl(this.value));
                    } else if (mode == Mode.FIRST_OR_DEFAULT || mode == Mode.SINGLE_OR_DEFAULT) {
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
            }

            @Override // org.reactivestreams.Subscriber
            public final void onError(Throwable e) {
                if (tryEnterTerminalState(RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT)) {
                    CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(e)));
                }
            }

            private final boolean tryEnterTerminalState(String signalName) {
                if (this.inTerminalState) {
                    AwaitKt.gotSignalInTerminalStateException(cancellableContinuationImpl2.get$context(), signalName);
                    return false;
                }
                this.inTerminalState = true;
                return true;
            }
        }));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
