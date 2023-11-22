package androidx.view;

import androidx.view.Lifecycle;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aC\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0080@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"R", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/Lifecycle$State;", "p0", "", "p1", "Lkotlinx/coroutines/CoroutineDispatcher;", "p2", "Lkotlin/Function0;", "p3", "getAuthRequestContext", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;ZLkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WithLifecycleStateKt {
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1] */
    public static final <R> Object getAuthRequestContext(final Lifecycle lifecycle, final Lifecycle.State state, boolean z, final CoroutineDispatcher coroutineDispatcher, final Function0<? extends R> function0, Continuation<? super R> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        final ?? r2 = new LifecycleEventObserver() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1
            @Override // androidx.view.LifecycleEventObserver
            public final void BuiltInFictitiousFunctionClassFactory(LifecycleOwner p0, Lifecycle.Event p1) {
                Object m3179constructorimpl;
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                if (p1 == Lifecycle.Event.upTo(Lifecycle.State.this)) {
                    lifecycle.KClassImpl$Data$declaredNonStaticMembers$2(this);
                    Continuation continuation2 = cancellableContinuationImpl2;
                    Function0<R> function02 = function0;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        m3179constructorimpl = Result.m3179constructorimpl(function02.invoke());
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th));
                    }
                    continuation2.resumeWith(m3179constructorimpl);
                } else if (p1 == Lifecycle.Event.ON_DESTROY) {
                    lifecycle.KClassImpl$Data$declaredNonStaticMembers$2(this);
                    Continuation continuation3 = cancellableContinuationImpl2;
                    Result.Companion companion3 = Result.INSTANCE;
                    continuation3.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(new LifecycleDestroyedException())));
                }
            }
        };
        if (z) {
            coroutineDispatcher.mo4661dispatch(EmptyCoroutineContext.INSTANCE, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$1
                @Override // java.lang.Runnable
                public final void run() {
                    Lifecycle.this.BuiltInFictitiousFunctionClassFactory(r2);
                }
            });
        } else {
            lifecycle.BuiltInFictitiousFunctionClassFactory((LifecycleObserver) r2);
        }
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                if (CoroutineDispatcher.this.isDispatchNeeded(EmptyCoroutineContext.INSTANCE)) {
                    CoroutineDispatcher coroutineDispatcher2 = CoroutineDispatcher.this;
                    EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
                    final Lifecycle lifecycle2 = lifecycle;
                    final WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 = r2;
                    coroutineDispatcher2.mo4661dispatch(emptyCoroutineContext, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            Lifecycle.this.KClassImpl$Data$declaredNonStaticMembers$2(withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1);
                        }
                    });
                    return;
                }
                lifecycle.KClassImpl$Data$declaredNonStaticMembers$2(r2);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
