package androidx.paging;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¸\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1;", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "p0", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "androidx/paging/PagingDataTransforms$transform$$inlined$map$1"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class PagingDataTransforms$map$$inlined$transform$2<R> implements Flow<PageEvent<R>> {
    final /* synthetic */ Function1 KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ Flow MyBillsEntityDataFactory;
    final /* synthetic */ Executor PlaceComponentResult;

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¸\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/flow/FlowKt__CollectKt$collect$3;", "Lkotlinx/coroutines/flow/FlowCollector;", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "androidx/paging/PagingDataTransforms$transform$$inlined$map$1$2"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: androidx.paging.PagingDataTransforms$map$$inlined$transform$2$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass2<T> implements FlowCollector<PageEvent<T>> {
        final /* synthetic */ Executor MyBillsEntityDataFactory;
        final /* synthetic */ FlowCollector PlaceComponentResult;
        final /* synthetic */ Function1 getAuthRequestContext;

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        @DebugMetadata(c = "androidx.paging.PagingDataTransforms$map$$inlined$transform$2$2", f = "PagingDataTransforms.kt", i = {}, l = {138, 138}, m = "emit", n = {}, s = {})
        /* renamed from: androidx.paging.PagingDataTransforms$map$$inlined$transform$2$2$1  reason: invalid class name */
        /* loaded from: classes6.dex */
        public static final class AnonymousClass1 extends ContinuationImpl {
            Object L$0;
            int label;
            /* synthetic */ Object result;

            public AnonymousClass1(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass2.this.emit(null, this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0071 A[RETURN] */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(java.lang.Object r10, kotlin.coroutines.Continuation r11) {
            /*
                r9 = this;
                boolean r0 = r11 instanceof androidx.paging.PagingDataTransforms$map$$inlined$transform$2.AnonymousClass2.AnonymousClass1
                if (r0 == 0) goto L14
                r0 = r11
                androidx.paging.PagingDataTransforms$map$$inlined$transform$2$2$1 r0 = (androidx.paging.PagingDataTransforms$map$$inlined$transform$2.AnonymousClass2.AnonymousClass1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r11 = r0.label
                int r11 = r11 + r2
                r0.label = r11
                goto L19
            L14:
                androidx.paging.PagingDataTransforms$map$$inlined$transform$2$2$1 r0 = new androidx.paging.PagingDataTransforms$map$$inlined$transform$2$2$1
                r0.<init>(r11)
            L19:
                java.lang.Object r11 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L3e
                if (r2 == r4) goto L36
                if (r2 != r3) goto L2e
                kotlin.ResultKt.throwOnFailure(r11)
                goto L72
            L2e:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L36:
                java.lang.Object r10 = r0.L$0
                kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
                kotlin.ResultKt.throwOnFailure(r11)
                goto L67
            L3e:
                kotlin.ResultKt.throwOnFailure(r11)
                kotlinx.coroutines.flow.FlowCollector r11 = r9.PlaceComponentResult
                androidx.paging.PageEvent r10 = (androidx.paging.PageEvent) r10
                r2 = r0
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                java.util.concurrent.Executor r2 = r9.MyBillsEntityDataFactory
                kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.ExecutorsKt.from(r2)
                kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
                androidx.paging.PagingDataTransforms$map$2$1 r6 = new androidx.paging.PagingDataTransforms$map$2$1
                kotlin.jvm.functions.Function1 r7 = r9.getAuthRequestContext
                r6.<init>(r10, r7, r5)
                kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
                r0.L$0 = r11
                r0.label = r4
                java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r2, r6, r0)
                if (r10 != r1) goto L64
                return r1
            L64:
                r8 = r11
                r11 = r10
                r10 = r8
            L67:
                r0.L$0 = r5
                r0.label = r3
                java.lang.Object r10 = r10.emit(r11, r0)
                if (r10 != r1) goto L72
                return r1
            L72:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PagingDataTransforms$map$$inlined$transform$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public AnonymousClass2(FlowCollector flowCollector, Executor executor, Function1 function1) {
            this.PlaceComponentResult = flowCollector;
            this.MyBillsEntityDataFactory = executor;
            this.getAuthRequestContext = function1;
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        Object collect = this.MyBillsEntityDataFactory.collect(new AnonymousClass2(flowCollector, this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }
}
