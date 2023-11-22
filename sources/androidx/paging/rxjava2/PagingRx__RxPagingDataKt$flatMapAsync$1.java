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

/* JADX INFO: Add missing generic type declarations: [R, T] */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0003\u001a\u00028\u0000H\u008a@"}, d2 = {"", "T", "R", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.paging.rxjava2.PagingRx__RxPagingDataKt$flatMapAsync$1", f = "RxPagingData.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class PagingRx__RxPagingDataKt$flatMapAsync$1<R, T> extends SuspendLambda implements Function2<T, Continuation<? super Iterable<? extends R>>, Object> {
    final /* synthetic */ Function1<T, Single<Iterable<R>>> $transform;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PagingRx__RxPagingDataKt$flatMapAsync$1(Function1<? super T, ? extends Single<Iterable<R>>> function1, Continuation<? super PagingRx__RxPagingDataKt$flatMapAsync$1> continuation) {
        super(2, continuation);
        this.$transform = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PagingRx__RxPagingDataKt$flatMapAsync$1 pagingRx__RxPagingDataKt$flatMapAsync$1 = new PagingRx__RxPagingDataKt$flatMapAsync$1(this.$transform, continuation);
        pagingRx__RxPagingDataKt$flatMapAsync$1.L$0 = obj;
        return pagingRx__RxPagingDataKt$flatMapAsync$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((PagingRx__RxPagingDataKt$flatMapAsync$1<R, T>) obj, (Continuation) ((Continuation) obj2));
    }

    public final Object invoke(T t, Continuation<? super Iterable<? extends R>> continuation) {
        return ((PagingRx__RxPagingDataKt$flatMapAsync$1) create(t, continuation)).invokeSuspend(Unit.INSTANCE);
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
            obj = RxAwaitKt.await((SingleSource) this.$transform.invoke(obj2), this);
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
