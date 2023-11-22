package androidx.paging;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@"}, d2 = {"", "T", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/paging/NullPaddedDiffResult;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.paging.AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1", f = "AsyncPagingDataDiffer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super NullPaddedDiffResult>, Object> {
    final /* synthetic */ NullPaddedList<T> $newList;
    final /* synthetic */ NullPaddedList<T> $previousList;
    int label;
    final /* synthetic */ AsyncPagingDataDiffer<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1(NullPaddedList<T> nullPaddedList, NullPaddedList<T> nullPaddedList2, AsyncPagingDataDiffer<T> asyncPagingDataDiffer, Continuation<? super AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1> continuation) {
        super(2, continuation);
        this.$previousList = nullPaddedList;
        this.$newList = nullPaddedList2;
        this.this$0 = asyncPagingDataDiffer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1(this.$previousList, this.$newList, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super NullPaddedDiffResult> continuation) {
        return ((AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DiffUtil.ItemCallback itemCallback;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            NullPaddedList<T> nullPaddedList = this.$previousList;
            NullPaddedList<T> nullPaddedList2 = this.$newList;
            itemCallback = ((AsyncPagingDataDiffer) this.this$0).BuiltInFictitiousFunctionClassFactory;
            return NullPaddedListDiffHelperKt.BuiltInFictitiousFunctionClassFactory(nullPaddedList, nullPaddedList2, itemCallback);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
