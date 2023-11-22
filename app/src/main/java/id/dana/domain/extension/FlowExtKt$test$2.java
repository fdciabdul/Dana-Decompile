package id.dana.domain.extension;

import id.dana.domain.social.Result;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "Lid/dana/domain/social/Result;", "result", "", "emit", "(Lid/dana/domain/social/Result;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 176)
/* loaded from: classes8.dex */
public final class FlowExtKt$test$2<T> implements FlowCollector {
    final /* synthetic */ Function1<T, Unit> $$assertion;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowExtKt$test$2(Function1<? super T, Unit> function1) {
        this.$$assertion = function1;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit((Result) ((Result) obj), (Continuation<? super Unit>) continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object emit(Result<? extends T> result, Continuation<? super Unit> continuation) {
        Object data;
        Unit unit = null;
        Result.Success success = result instanceof Result.Success ? (Result.Success) result : null;
        if (success != null && (data = success.getData()) != null) {
            this.$$assertion.invoke(data);
            unit = Unit.INSTANCE;
        }
        return (unit == null || unit != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : unit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object emit$$forInline(Result<? extends T> result, final Continuation<? super Unit> continuation) {
        Object data;
        InlineMarker.mark(4);
        new ContinuationImpl(this, continuation) { // from class: id.dana.domain.extension.FlowExtKt$test$2$emit$1
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ FlowExtKt$test$2<T> this$0;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.this$0 = this;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.emit((Result) null, (Continuation<? super Unit>) this);
            }
        };
        InlineMarker.mark(5);
        Result.Success success = result instanceof Result.Success ? (Result.Success) result : null;
        if (success != null && (data = success.getData()) != null) {
            this.$$assertion.invoke(data);
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
