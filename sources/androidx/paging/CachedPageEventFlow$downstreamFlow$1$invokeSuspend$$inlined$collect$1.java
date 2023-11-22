package androidx.paging;

import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¸\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/flow/FlowKt__CollectKt$collect$3;", "Lkotlinx/coroutines/flow/FlowCollector;", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CachedPageEventFlow$downstreamFlow$1$invokeSuspend$$inlined$collect$1<T> implements FlowCollector<IndexedValue<? extends PageEvent<T>>> {
    final /* synthetic */ FlowCollector KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ Ref.IntRef MyBillsEntityDataFactory;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "androidx.paging.CachedPageEventFlow$downstreamFlow$1$invokeSuspend$$inlined$collect$1", f = "CachedPageEventFlow.kt", i = {0, 0}, l = {136}, m = "emit", n = {"this", "indexedValue"}, s = {"L$0", "L$1"})
    /* renamed from: androidx.paging.CachedPageEventFlow$downstreamFlow$1$invokeSuspend$$inlined$collect$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CachedPageEventFlow$downstreamFlow$1$invokeSuspend$$inlined$collect$1.this.emit(null, this);
        }
    }

    public CachedPageEventFlow$downstreamFlow$1$invokeSuspend$$inlined$collect$1(Ref.IntRef intRef, FlowCollector flowCollector) {
        this.MyBillsEntityDataFactory = intRef;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object emit(kotlin.collections.IndexedValue<? extends androidx.paging.PageEvent<T>> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.paging.CachedPageEventFlow$downstreamFlow$1$invokeSuspend$$inlined$collect$1.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r6
            androidx.paging.CachedPageEventFlow$downstreamFlow$1$invokeSuspend$$inlined$collect$1$1 r0 = (androidx.paging.CachedPageEventFlow$downstreamFlow$1$invokeSuspend$$inlined$collect$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 + r2
            r0.label = r6
            goto L19
        L14:
            androidx.paging.CachedPageEventFlow$downstreamFlow$1$invokeSuspend$$inlined$collect$1$1 r0 = new androidx.paging.CachedPageEventFlow$downstreamFlow$1$invokeSuspend$$inlined$collect$1$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r5 = r0.L$1
            kotlin.collections.IndexedValue r5 = (kotlin.collections.IndexedValue) r5
            java.lang.Object r0 = r0.L$0
            androidx.paging.CachedPageEventFlow$downstreamFlow$1$invokeSuspend$$inlined$collect$1 r0 = (androidx.paging.CachedPageEventFlow$downstreamFlow$1$invokeSuspend$$inlined$collect$1) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L63
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r0
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            kotlin.collections.IndexedValue r5 = (kotlin.collections.IndexedValue) r5
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            int r6 = r5.getIndex()
            kotlin.jvm.internal.Ref$IntRef r2 = r4.MyBillsEntityDataFactory
            int r2 = r2.element
            if (r6 <= r2) goto L6b
            kotlinx.coroutines.flow.FlowCollector r6 = r4.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.Object r2 = r5.getValue()
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r6.emit(r2, r0)
            if (r6 != r1) goto L62
            return r1
        L62:
            r0 = r4
        L63:
            kotlin.jvm.internal.Ref$IntRef r6 = r0.MyBillsEntityDataFactory
            int r5 = r5.getIndex()
            r6.element = r5
        L6b:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.CachedPageEventFlow$downstreamFlow$1$invokeSuspend$$inlined$collect$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
