package androidx.paging;

import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¸\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/flow/FlowKt__CollectKt$collect$3;", "Lkotlinx/coroutines/flow/FlowCollector;", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CachedPageEventFlow$job$1$invokeSuspend$$inlined$collect$1<T> implements FlowCollector<IndexedValue<? extends PageEvent<T>>> {
    final /* synthetic */ CachedPageEventFlow KClassImpl$Data$declaredNonStaticMembers$2;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "androidx.paging.CachedPageEventFlow$job$1$invokeSuspend$$inlined$collect$1", f = "CachedPageEventFlow.kt", i = {0, 0}, l = {135, 136}, m = "emit", n = {"this", "it"}, s = {"L$0", "L$1"})
    /* renamed from: androidx.paging.CachedPageEventFlow$job$1$invokeSuspend$$inlined$collect$1$1  reason: invalid class name */
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
            return CachedPageEventFlow$job$1$invokeSuspend$$inlined$collect$1.this.emit(null, this);
        }
    }

    public CachedPageEventFlow$job$1$invokeSuspend$$inlined$collect$1(CachedPageEventFlow cachedPageEventFlow) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cachedPageEventFlow;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070 A[RETURN] */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object emit(kotlin.collections.IndexedValue<? extends androidx.paging.PageEvent<T>> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.paging.CachedPageEventFlow$job$1$invokeSuspend$$inlined$collect$1.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r7
            androidx.paging.CachedPageEventFlow$job$1$invokeSuspend$$inlined$collect$1$1 r0 = (androidx.paging.CachedPageEventFlow$job$1$invokeSuspend$$inlined$collect$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 + r2
            r0.label = r7
            goto L19
        L14:
            androidx.paging.CachedPageEventFlow$job$1$invokeSuspend$$inlined$collect$1$1 r0 = new androidx.paging.CachedPageEventFlow$job$1$invokeSuspend$$inlined$collect$1$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L71
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            java.lang.Object r6 = r0.L$1
            kotlin.collections.IndexedValue r6 = (kotlin.collections.IndexedValue) r6
            java.lang.Object r2 = r0.L$0
            androidx.paging.CachedPageEventFlow$job$1$invokeSuspend$$inlined$collect$1 r2 = (androidx.paging.CachedPageEventFlow$job$1$invokeSuspend$$inlined$collect$1) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5d
        L41:
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r0
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            kotlin.collections.IndexedValue r6 = (kotlin.collections.IndexedValue) r6
            androidx.paging.CachedPageEventFlow r7 = r5.KClassImpl$Data$declaredNonStaticMembers$2
            kotlinx.coroutines.flow.MutableSharedFlow r7 = androidx.paging.CachedPageEventFlow.BuiltInFictitiousFunctionClassFactory(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r7.emit(r6, r0)
            if (r7 != r1) goto L5c
            return r1
        L5c:
            r2 = r5
        L5d:
            androidx.paging.CachedPageEventFlow r7 = r2.KClassImpl$Data$declaredNonStaticMembers$2
            androidx.paging.FlattenedPageController r7 = androidx.paging.CachedPageEventFlow.MyBillsEntityDataFactory(r7)
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r6 = r7.KClassImpl$Data$declaredNonStaticMembers$2(r6, r0)
            if (r6 != r1) goto L71
            return r1
        L71:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.CachedPageEventFlow$job$1$invokeSuspend$$inlined$collect$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
