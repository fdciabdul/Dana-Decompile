package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Add missing generic type declarations: [R, T] */
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0005\u001a\u0004\u0018\u00018\u0001\"\b\b\u0000\u0010\u0000*\u00028\u0001\"\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00018\u00002\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u008a@"}, d2 = {"T", "", "R", "before", "after", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.paging.SeparatorsKt$insertEventSeparators$separatorState$1", f = "Separators.kt", i = {}, l = {580}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class SeparatorsKt$insertEventSeparators$separatorState$1<R, T> extends SuspendLambda implements Function3<T, T, Continuation<? super R>, Object> {
    final /* synthetic */ Function3<T, T, Continuation<? super R>, Object> $generator;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SeparatorsKt$insertEventSeparators$separatorState$1(Function3<? super T, ? super T, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super SeparatorsKt$insertEventSeparators$separatorState$1> continuation) {
        super(3, continuation);
        this.$generator = function3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function3
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(obj, obj2, (Continuation) ((Continuation) obj3));
    }

    public final Object invoke(T t, T t2, Continuation<? super R> continuation) {
        SeparatorsKt$insertEventSeparators$separatorState$1 separatorsKt$insertEventSeparators$separatorState$1 = new SeparatorsKt$insertEventSeparators$separatorState$1(this.$generator, continuation);
        separatorsKt$insertEventSeparators$separatorState$1.L$0 = t;
        separatorsKt$insertEventSeparators$separatorState$1.L$1 = t2;
        return separatorsKt$insertEventSeparators$separatorState$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.L$0;
            Object obj3 = this.L$1;
            Function3<T, T, Continuation<? super R>, Object> function3 = this.$generator;
            this.L$0 = null;
            this.label = 1;
            obj = function3.invoke(obj2, obj3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
