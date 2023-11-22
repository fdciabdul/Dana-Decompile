package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
/* loaded from: classes9.dex */
public final class SafeCollector_commonKt$unsafeFlow$1$collect$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SafeCollector_commonKt$unsafeFlow$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeCollector_commonKt$unsafeFlow$1$collect$1(SafeCollector_commonKt$unsafeFlow$1 safeCollector_commonKt$unsafeFlow$1, Continuation<? super SafeCollector_commonKt$unsafeFlow$1$collect$1> continuation) {
        super(continuation);
        this.this$0 = safeCollector_commonKt$unsafeFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collect(null, this);
    }
}
