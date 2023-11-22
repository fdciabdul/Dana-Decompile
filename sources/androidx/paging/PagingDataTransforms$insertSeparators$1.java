package androidx.paging;

import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: Add missing generic type declarations: [R, T] */
@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00028\u00002\b\u0010\u0003\u001a\u0004\u0018\u00018\u00012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0001H\u008a@"}, d2 = {"", "R", "T", "before", "after", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.paging.PagingDataTransforms$insertSeparators$1", f = "PagingDataTransforms.kt", i = {}, l = {DeepRecoverARiverProxy.TYPE_ENTITY_ONLINE_PAGE}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class PagingDataTransforms$insertSeparators$1<R, T> extends SuspendLambda implements Function3<T, T, Continuation<? super R>, Object> {
    final /* synthetic */ Executor $executor;
    final /* synthetic */ Function2<T, T, R> $generator;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PagingDataTransforms$insertSeparators$1(Executor executor, Function2<? super T, ? super T, ? extends R> function2, Continuation<? super PagingDataTransforms$insertSeparators$1> continuation) {
        super(3, continuation);
        this.$executor = executor;
        this.$generator = function2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function3
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(obj, obj2, (Continuation) ((Continuation) obj3));
    }

    public final Object invoke(T t, T t2, Continuation<? super R> continuation) {
        PagingDataTransforms$insertSeparators$1 pagingDataTransforms$insertSeparators$1 = new PagingDataTransforms$insertSeparators$1(this.$executor, this.$generator, continuation);
        pagingDataTransforms$insertSeparators$1.L$0 = t;
        pagingDataTransforms$insertSeparators$1.L$1 = t2;
        return pagingDataTransforms$insertSeparators$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00028\u0000*\u00020\u0003H\u008a@"}, d2 = {"", "R", "T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "androidx.paging.PagingDataTransforms$insertSeparators$1$1", f = "PagingDataTransforms.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.paging.PagingDataTransforms$insertSeparators$1$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
        final /* synthetic */ T $after;
        final /* synthetic */ T $before;
        final /* synthetic */ Function2<T, T, R> $generator;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function2<? super T, ? super T, ? extends R> function2, T t, T t2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$generator = function2;
            this.$before = t;
            this.$after = t2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$generator, this.$before, this.$after, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object obj) {
            return invoke(coroutineScope, (Continuation) ((Continuation) obj));
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return this.$generator.invoke(this.$before, this.$after);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.L$0;
            Object obj3 = this.L$1;
            this.L$0 = null;
            this.label = 1;
            obj = BuildersKt.withContext(ExecutorsKt.from(this.$executor), new AnonymousClass1(this.$generator, obj2, obj3, null), this);
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
