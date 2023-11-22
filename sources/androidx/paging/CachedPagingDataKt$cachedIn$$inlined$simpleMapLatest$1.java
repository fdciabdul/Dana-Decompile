package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u008a@¨\u0006\u0005"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "androidx/paging/FlowExtKt$simpleMapLatest$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.paging.CachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1", f = "CachedPagingData.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class CachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1<T> extends SuspendLambda implements Function3<FlowCollector<? super MulticastedPagingData<T>>, PagingData<T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $scope$inlined;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1(Continuation continuation, CoroutineScope coroutineScope) {
        super(3, continuation);
        this.$scope$inlined = coroutineScope;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function3
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Continuation<? super Unit> continuation) {
        return invoke((FlowCollector) ((FlowCollector) obj), obj2, continuation);
    }

    public final Object invoke(FlowCollector<? super MulticastedPagingData<T>> flowCollector, PagingData<T> pagingData, Continuation<? super Unit> continuation) {
        CachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1 cachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1 = new CachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1(continuation, this.$scope$inlined);
        cachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1.L$0 = flowCollector;
        cachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1.L$1 = pagingData;
        return cachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            MulticastedPagingData multicastedPagingData = new MulticastedPagingData(this.$scope$inlined, (PagingData) this.L$1, null, 4, null);
            this.label = 1;
            if (flowCollector.emit(multicastedPagingData, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
