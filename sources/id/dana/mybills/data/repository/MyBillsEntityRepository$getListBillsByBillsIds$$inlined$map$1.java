package id.dana.mybills.data.repository;

import id.dana.mybills.domain.model.MyBillPaylater;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¸\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1;", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "p0", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class MyBillsEntityRepository$getListBillsByBillsIds$$inlined$map$1 implements Flow<List<? extends MyBillPaylater>> {
    final /* synthetic */ Flow MyBillsEntityDataFactory;

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super List<? extends MyBillPaylater>> flowCollector, Continuation continuation) {
        Object collect = this.MyBillsEntityDataFactory.collect(new AnonymousClass2(flowCollector), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: id.dana.mybills.data.repository.MyBillsEntityRepository$getListBillsByBillsIds$$inlined$map$1$2  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ FlowCollector $MyBillsEntityDataFactory;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "id.dana.mybills.data.repository.MyBillsEntityRepository$getListBillsByBillsIds$$inlined$map$1$2", f = "MyBillsEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
        /* renamed from: id.dana.mybills.data.repository.MyBillsEntityRepository$getListBillsByBillsIds$$inlined$map$1$2$1  reason: invalid class name */
        /* loaded from: classes9.dex */
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

        public AnonymousClass2(FlowCollector flowCollector) {
            this.$MyBillsEntityDataFactory = flowCollector;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof id.dana.mybills.data.repository.MyBillsEntityRepository$getListBillsByBillsIds$$inlined$map$1.AnonymousClass2.AnonymousClass1
                if (r0 == 0) goto L14
                r0 = r6
                id.dana.mybills.data.repository.MyBillsEntityRepository$getListBillsByBillsIds$$inlined$map$1$2$1 r0 = (id.dana.mybills.data.repository.MyBillsEntityRepository$getListBillsByBillsIds$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r6 = r0.label
                int r6 = r6 + r2
                r0.label = r6
                goto L19
            L14:
                id.dana.mybills.data.repository.MyBillsEntityRepository$getListBillsByBillsIds$$inlined$map$1$2$1 r0 = new id.dana.mybills.data.repository.MyBillsEntityRepository$getListBillsByBillsIds$$inlined$map$1$2$1
                r0.<init>(r6)
            L19:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L32
                if (r2 != r3) goto L2a
                kotlin.ResultKt.throwOnFailure(r6)
                goto L49
            L2a:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L32:
                kotlin.ResultKt.throwOnFailure(r6)
                kotlinx.coroutines.flow.FlowCollector r6 = r4.$MyBillsEntityDataFactory
                r2 = r0
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                id.dana.mybills.data.model.response.ListBillPaylaterResult r5 = (id.dana.mybills.data.model.response.ListBillPaylaterResult) r5
                java.util.List r5 = id.dana.mybills.data.model.response.ListBillPaylaterResultKt.toListMyBillPaylater(r5)
                r0.label = r3
                java.lang.Object r5 = r6.emit(r5, r0)
                if (r5 != r1) goto L49
                return r1
            L49:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.data.repository.MyBillsEntityRepository$getListBillsByBillsIds$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
