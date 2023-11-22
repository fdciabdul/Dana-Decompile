package androidx.paging;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@"}, d2 = {"", "T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.paging.AsyncPagingDataDiffer$submitData$2", f = "AsyncPagingDataDiffer.kt", i = {}, l = {163}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class AsyncPagingDataDiffer$submitData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $id;
    final /* synthetic */ PagingData<T> $pagingData;
    int label;
    final /* synthetic */ AsyncPagingDataDiffer<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AsyncPagingDataDiffer$submitData$2(AsyncPagingDataDiffer<T> asyncPagingDataDiffer, int i, PagingData<T> pagingData, Continuation<? super AsyncPagingDataDiffer$submitData$2> continuation) {
        super(2, continuation);
        this.this$0 = asyncPagingDataDiffer;
        this.$id = i;
        this.$pagingData = pagingData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AsyncPagingDataDiffer$submitData$2(this.this$0, this.$id, this.$pagingData, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AsyncPagingDataDiffer$submitData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AtomicInteger atomicInteger;
        AsyncPagingDataDiffer$differBase$1 asyncPagingDataDiffer$differBase$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            atomicInteger = this.this$0.lookAheadTest;
            if (atomicInteger.get() == this.$id) {
                asyncPagingDataDiffer$differBase$1 = this.this$0.PlaceComponentResult;
                this.label = 1;
                if (asyncPagingDataDiffer$differBase$1.BuiltInFictitiousFunctionClassFactory((PagingData) this.$pagingData, (Continuation<? super Unit>) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
