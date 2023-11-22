package androidx.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¸\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/flow/FlowKt__CollectKt$collect$3;", "Lkotlinx/coroutines/flow/FlowCollector;", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class FlowExtKt$combineWithoutBatching$2$1$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<Object> {
    final /* synthetic */ UnbatchedFlowCombiner MyBillsEntityDataFactory;
    final /* synthetic */ int getAuthRequestContext;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1$invokeSuspend$$inlined$collect$1", f = "FlowExt.kt", i = {}, l = {135, 138}, m = "emit", n = {}, s = {})
    /* renamed from: androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1$invokeSuspend$$inlined$collect$1$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowExtKt$combineWithoutBatching$2$1$1$invokeSuspend$$inlined$collect$1.this.emit(null, this);
        }
    }

    public FlowExtKt$combineWithoutBatching$2$1$1$invokeSuspend$$inlined$collect$1(UnbatchedFlowCombiner unbatchedFlowCombiner, int i) {
        this.MyBillsEntityDataFactory = unbatchedFlowCombiner;
        this.getAuthRequestContext = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0054 A[RETURN] */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1$invokeSuspend$$inlined$collect$1.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r7
            androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1$invokeSuspend$$inlined$collect$1$1 r0 = (androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1$invokeSuspend$$inlined$collect$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 + r2
            r0.label = r7
            goto L19
        L14:
            androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1$invokeSuspend$$inlined$collect$1$1 r0 = new androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1$invokeSuspend$$inlined$collect$1$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L55
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4c
        L39:
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r0
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            androidx.paging.UnbatchedFlowCombiner r7 = r5.MyBillsEntityDataFactory
            int r2 = r5.getAuthRequestContext
            r0.label = r4
            java.lang.Object r6 = r7.MyBillsEntityDataFactory(r2, r6, r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.YieldKt.yield(r0)
            if (r6 != r1) goto L55
            return r1
        L55:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1$invokeSuspend$$inlined$collect$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
