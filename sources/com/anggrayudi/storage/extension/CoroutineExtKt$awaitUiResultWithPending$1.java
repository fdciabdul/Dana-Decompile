package com.anggrayudi.storage.extension;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata(bv = {}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"R", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.anggrayudi.storage.extension.CoroutineExtKt$awaitUiResultWithPending$1", f = "CoroutineExt.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
public final class CoroutineExtKt$awaitUiResultWithPending$1<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
    final /* synthetic */ Function1<CancellableContinuation<? super R>, Unit> $action;
    final /* synthetic */ CoroutineScope $uiScope;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CoroutineExtKt$awaitUiResultWithPending$1(CoroutineScope coroutineScope, Function1<? super CancellableContinuation<? super R>, Unit> function1, Continuation<? super CoroutineExtKt$awaitUiResultWithPending$1> continuation) {
        super(2, continuation);
        this.$uiScope = coroutineScope;
        this.$action = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoroutineExtKt$awaitUiResultWithPending$1(this.$uiScope, this.$action, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object obj) {
        return invoke(coroutineScope, (Continuation) ((Continuation) obj));
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
        return ((CoroutineExtKt$awaitUiResultWithPending$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.$uiScope;
            Function1<CancellableContinuation<? super R>, Unit> function1 = this.$action;
            this.L$0 = coroutineScope;
            this.L$1 = function1;
            this.label = 1;
            CoroutineExtKt$awaitUiResultWithPending$1<R> coroutineExtKt$awaitUiResultWithPending$1 = this;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(coroutineExtKt$awaitUiResultWithPending$1), 1);
            cancellableContinuationImpl.initCancellability();
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new CoroutineExtKt$awaitUiResultWithPending$1$1$1(function1, cancellableContinuationImpl, null), 2, null);
            obj = cancellableContinuationImpl.getResult();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(coroutineExtKt$awaitUiResultWithPending$1);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Function1 function12 = (Function1) this.L$1;
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        CoroutineScope coroutineScope = this.$uiScope;
        Function1<CancellableContinuation<? super R>, Unit> function1 = this.$action;
        InlineMarker.mark(0);
        CoroutineExtKt$awaitUiResultWithPending$1<R> coroutineExtKt$awaitUiResultWithPending$1 = this;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(coroutineExtKt$awaitUiResultWithPending$1), 1);
        cancellableContinuationImpl.initCancellability();
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new CoroutineExtKt$awaitUiResultWithPending$1$1$1(function1, cancellableContinuationImpl, null), 2, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(coroutineExtKt$awaitUiResultWithPending$1);
        }
        InlineMarker.mark(1);
        return result;
    }
}
