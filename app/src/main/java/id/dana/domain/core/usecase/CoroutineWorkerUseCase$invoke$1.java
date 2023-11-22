package id.dana.domain.core.usecase;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.domain.core.usecase.CoroutineWorkerUseCase", f = "CoroutineWorkerUseCase.kt", i = {}, l = {23}, m = BridgeDSL.INVOKE, n = {}, s = {})
/* loaded from: classes4.dex */
public final class CoroutineWorkerUseCase$invoke$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoroutineWorkerUseCase<P, R> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CoroutineWorkerUseCase$invoke$1(CoroutineWorkerUseCase<? super P, R> coroutineWorkerUseCase, Continuation<? super CoroutineWorkerUseCase$invoke$1> continuation) {
        super(continuation);
        this.this$0 = coroutineWorkerUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, this);
    }
}
