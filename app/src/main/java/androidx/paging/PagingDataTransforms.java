package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aX\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"", "T", "R", "Landroidx/paging/PagingData;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "p0", "PlaceComponentResult", "(Landroidx/paging/PagingData;Lkotlin/jvm/functions/Function2;)Landroidx/paging/PagingData;"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class PagingDataTransforms {
    public static final /* synthetic */ PagingData PlaceComponentResult(PagingData pagingData, final Function2 function2) {
        Intrinsics.checkNotNullParameter(pagingData, "");
        Intrinsics.checkNotNullParameter(function2, "");
        final Flow<PageEvent<T>> flow = pagingData.KClassImpl$Data$declaredNonStaticMembers$2;
        return new PagingData(new Flow<PageEvent<R>>() { // from class: androidx.paging.PagingDataTransforms$map$$inlined$transform$1

            /* JADX INFO: Add missing generic type declarations: [T] */
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¸\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/flow/FlowKt__CollectKt$collect$3;", "Lkotlinx/coroutines/flow/FlowCollector;", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "androidx/paging/PagingDataTransforms$transform$$inlined$map$1$2"}, k = 1, mv = {1, 5, 1}, xi = 48)
            /* renamed from: androidx.paging.PagingDataTransforms$map$$inlined$transform$1$2  reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector<PageEvent<T>> {
                final /* synthetic */ FlowCollector KClassImpl$Data$declaredNonStaticMembers$2;
                final /* synthetic */ Function2 MyBillsEntityDataFactory;

                @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
                @DebugMetadata(c = "androidx.paging.PagingDataTransforms$map$$inlined$transform$1$2", f = "PagingDataTransforms.kt", i = {}, l = {138, 138}, m = "emit", n = {}, s = {})
                /* renamed from: androidx.paging.PagingDataTransforms$map$$inlined$transform$1$2$1  reason: invalid class name */
                /* loaded from: classes3.dex */
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

                /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
                /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x0062 A[RETURN] */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof androidx.paging.PagingDataTransforms$map$$inlined$transform$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r8
                        androidx.paging.PagingDataTransforms$map$$inlined$transform$1$2$1 r0 = (androidx.paging.PagingDataTransforms$map$$inlined$transform$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r8 = r0.label
                        int r8 = r8 + r2
                        r0.label = r8
                        goto L19
                    L14:
                        androidx.paging.PagingDataTransforms$map$$inlined$transform$1$2$1 r0 = new androidx.paging.PagingDataTransforms$map$$inlined$transform$1$2$1
                        r0.<init>(r8)
                    L19:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L3d
                        if (r2 == r4) goto L35
                        if (r2 != r3) goto L2d
                        kotlin.ResultKt.throwOnFailure(r8)
                        goto L63
                    L2d:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L35:
                        java.lang.Object r7 = r0.L$0
                        kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                        kotlin.ResultKt.throwOnFailure(r8)
                        goto L57
                    L3d:
                        kotlin.ResultKt.throwOnFailure(r8)
                        kotlinx.coroutines.flow.FlowCollector r8 = r6.KClassImpl$Data$declaredNonStaticMembers$2
                        androidx.paging.PageEvent r7 = (androidx.paging.PageEvent) r7
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        kotlin.jvm.functions.Function2 r2 = r6.MyBillsEntityDataFactory
                        r0.L$0 = r8
                        r0.label = r4
                        java.lang.Object r7 = r7.KClassImpl$Data$declaredNonStaticMembers$2(r2, r0)
                        if (r7 != r1) goto L54
                        return r1
                    L54:
                        r5 = r8
                        r8 = r7
                        r7 = r5
                    L57:
                        r2 = 0
                        r0.L$0 = r2
                        r0.label = r3
                        java.lang.Object r7 = r7.emit(r8, r0)
                        if (r7 != r1) goto L63
                        return r1
                    L63:
                        kotlin.Unit r7 = kotlin.Unit.INSTANCE
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PagingDataTransforms$map$$inlined$transform$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }

                public AnonymousClass2(FlowCollector flowCollector, Function2 function2) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = flowCollector;
                    this.MyBillsEntityDataFactory = function2;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, function2), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }, pagingData.MyBillsEntityDataFactory);
    }
}
