package androidx.paging.rxjava2;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.rx2.RxAwaitKt;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@"}, d2 = {"", "T", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.paging.rxjava2.PagingRx__RxPagingDataKt$filterAsync$1", f = "RxPagingData.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class PagingRx__RxPagingDataKt$filterAsync$1<T> extends SuspendLambda implements Function2<T, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Function1<T, Single<Boolean>> $predicate;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PagingRx__RxPagingDataKt$filterAsync$1(Function1<? super T, ? extends Single<Boolean>> function1, Continuation<? super PagingRx__RxPagingDataKt$filterAsync$1> continuation) {
        super(2, continuation);
        this.$predicate = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PagingRx__RxPagingDataKt$filterAsync$1 pagingRx__RxPagingDataKt$filterAsync$1 = new PagingRx__RxPagingDataKt$filterAsync$1(this.$predicate, continuation);
        pagingRx__RxPagingDataKt$filterAsync$1.L$0 = obj;
        return pagingRx__RxPagingDataKt$filterAsync$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Boolean> continuation) {
        return invoke2((PagingRx__RxPagingDataKt$filterAsync$1<T>) obj, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(T t, Continuation<? super Boolean> continuation) {
        return ((PagingRx__RxPagingDataKt$filterAsync$1) create(t, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.L$0;
            this.label = 1;
            obj = RxAwaitKt.await((SingleSource) this.$predicate.invoke(obj2), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }
}
