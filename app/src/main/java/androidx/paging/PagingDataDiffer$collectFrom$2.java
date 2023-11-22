package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\u008a@"}, d2 = {"", "T", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.paging.PagingDataDiffer$collectFrom$2", f = "PagingDataDiffer.kt", i = {}, l = {467}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class PagingDataDiffer$collectFrom$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ PagingData<T> $pagingData;
    int label;
    final /* synthetic */ PagingDataDiffer<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagingDataDiffer$collectFrom$2(PagingDataDiffer<T> pagingDataDiffer, PagingData<T> pagingData, Continuation<? super PagingDataDiffer$collectFrom$2> continuation) {
        super(1, continuation);
        this.this$0 = pagingDataDiffer;
        this.$pagingData = pagingData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new PagingDataDiffer$collectFrom$2(this.this$0, this.$pagingData, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((PagingDataDiffer$collectFrom$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.initRecordTimeStamp = this.$pagingData.MyBillsEntityDataFactory;
            Flow<PageEvent<T>> flow = this.$pagingData.KClassImpl$Data$declaredNonStaticMembers$2;
            final PagingDataDiffer<T> pagingDataDiffer = this.this$0;
            this.label = 1;
            if (flow.collect(new FlowCollector<PageEvent<T>>() { // from class: androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(PageEvent<T> pageEvent, Continuation<? super Unit> continuation) {
                    CoroutineDispatcher coroutineDispatcher;
                    coroutineDispatcher = PagingDataDiffer.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    Object withContext = BuildersKt.withContext(coroutineDispatcher, new PagingDataDiffer$collectFrom$2$1$1(pageEvent, PagingDataDiffer.this, null), continuation);
                    return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
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
