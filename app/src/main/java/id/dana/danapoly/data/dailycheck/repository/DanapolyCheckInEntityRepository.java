package id.dana.danapoly.data.dailycheck.repository;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.danapoly.data.dailycheck.model.response.CheckInInfoResponse;
import id.dana.danapoly.data.dailycheck.repository.source.DanapolyCheckInData;
import id.dana.danapoly.data.dailycheck.repository.source.DanapolyCheckInDataFactory;
import id.dana.danapoly.domain.dailycheck.DanapolyCheckInRepository;
import id.dana.danapoly.domain.dailycheck.model.CheckInInfo;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\tR\u0013\u0010\u0007\u001a\u00020\u000bX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/danapoly/data/dailycheck/repository/DanapolyCheckInEntityRepository;", "Lid/dana/danapoly/domain/dailycheck/DanapolyCheckInRepository;", "Lkotlinx/coroutines/flow/Flow;", "", "getAuthRequestContext", "()Lkotlinx/coroutines/flow/Flow;", "Lid/dana/danapoly/domain/dailycheck/model/CheckInInfo;", "MyBillsEntityDataFactory", "Lid/dana/danapoly/data/dailycheck/repository/source/DanapolyCheckInDataFactory;", "Lid/dana/danapoly/data/dailycheck/repository/source/DanapolyCheckInDataFactory;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/danapoly/data/dailycheck/repository/source/DanapolyCheckInData;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Lazy;", "p0", "<init>", "(Lid/dana/danapoly/data/dailycheck/repository/source/DanapolyCheckInDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyCheckInEntityRepository implements DanapolyCheckInRepository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final DanapolyCheckInDataFactory KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public DanapolyCheckInEntityRepository(DanapolyCheckInDataFactory danapolyCheckInDataFactory) {
        Intrinsics.checkNotNullParameter(danapolyCheckInDataFactory, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danapolyCheckInDataFactory;
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<DanapolyCheckInData>() { // from class: id.dana.danapoly.data.dailycheck.repository.DanapolyCheckInEntityRepository$networkData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DanapolyCheckInData invoke() {
                DanapolyCheckInDataFactory danapolyCheckInDataFactory2;
                danapolyCheckInDataFactory2 = DanapolyCheckInEntityRepository.this.KClassImpl$Data$declaredNonStaticMembers$2;
                return danapolyCheckInDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2;
            }
        });
    }

    @Override // id.dana.danapoly.domain.dailycheck.DanapolyCheckInRepository
    public final Flow<Boolean> getAuthRequestContext() {
        final Flow<BaseRpcResult> KClassImpl$Data$declaredNonStaticMembers$2 = ((DanapolyCheckInData) this.MyBillsEntityDataFactory.getValue()).KClassImpl$Data$declaredNonStaticMembers$2();
        return new Flow<Boolean>() { // from class: id.dana.danapoly.data.dailycheck.repository.DanapolyCheckInEntityRepository$doCheckIn$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.danapoly.data.dailycheck.repository.DanapolyCheckInEntityRepository$doCheckIn$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $PlaceComponentResult;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.danapoly.data.dailycheck.repository.DanapolyCheckInEntityRepository$doCheckIn$$inlined$map$1$2", f = "DanapolyCheckInEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.danapoly.data.dailycheck.repository.DanapolyCheckInEntityRepository$doCheckIn$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes4.dex */
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
                    this.$PlaceComponentResult = flowCollector;
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
                        boolean r0 = r6 instanceof id.dana.danapoly.data.dailycheck.repository.DanapolyCheckInEntityRepository$doCheckIn$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.danapoly.data.dailycheck.repository.DanapolyCheckInEntityRepository$doCheckIn$$inlined$map$1$2$1 r0 = (id.dana.danapoly.data.dailycheck.repository.DanapolyCheckInEntityRepository$doCheckIn$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.danapoly.data.dailycheck.repository.DanapolyCheckInEntityRepository$doCheckIn$$inlined$map$1$2$1 r0 = new id.dana.danapoly.data.dailycheck.repository.DanapolyCheckInEntityRepository$doCheckIn$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L4b
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$PlaceComponentResult
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        com.alipayplus.mobile.component.domain.model.result.BaseRpcResult r5 = (com.alipayplus.mobile.component.domain.model.result.BaseRpcResult) r5
                        boolean r5 = r5.success
                        java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L4b
                        return r1
                    L4b:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.data.dailycheck.repository.DanapolyCheckInEntityRepository$doCheckIn$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }

    @Override // id.dana.danapoly.domain.dailycheck.DanapolyCheckInRepository
    public final Flow<CheckInInfo> MyBillsEntityDataFactory() {
        final Flow<CheckInInfoResponse> PlaceComponentResult = ((DanapolyCheckInData) this.MyBillsEntityDataFactory.getValue()).PlaceComponentResult();
        return new Flow<CheckInInfo>() { // from class: id.dana.danapoly.data.dailycheck.repository.DanapolyCheckInEntityRepository$fetchCheckInHistory$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super CheckInInfo> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.danapoly.data.dailycheck.repository.DanapolyCheckInEntityRepository$fetchCheckInHistory$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $PlaceComponentResult;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.danapoly.data.dailycheck.repository.DanapolyCheckInEntityRepository$fetchCheckInHistory$$inlined$map$1$2", f = "DanapolyCheckInEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.danapoly.data.dailycheck.repository.DanapolyCheckInEntityRepository$fetchCheckInHistory$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes4.dex */
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
                    this.$PlaceComponentResult = flowCollector;
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
                        boolean r0 = r6 instanceof id.dana.danapoly.data.dailycheck.repository.DanapolyCheckInEntityRepository$fetchCheckInHistory$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.danapoly.data.dailycheck.repository.DanapolyCheckInEntityRepository$fetchCheckInHistory$$inlined$map$1$2$1 r0 = (id.dana.danapoly.data.dailycheck.repository.DanapolyCheckInEntityRepository$fetchCheckInHistory$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.danapoly.data.dailycheck.repository.DanapolyCheckInEntityRepository$fetchCheckInHistory$$inlined$map$1$2$1 r0 = new id.dana.danapoly.data.dailycheck.repository.DanapolyCheckInEntityRepository$fetchCheckInHistory$$inlined$map$1$2$1
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
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$PlaceComponentResult
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        id.dana.danapoly.data.dailycheck.model.response.CheckInInfoResponse r5 = (id.dana.danapoly.data.dailycheck.model.response.CheckInInfoResponse) r5
                        id.dana.danapoly.domain.dailycheck.model.CheckInInfo r5 = id.dana.danapoly.data.dailycheck.model.mapper.CheckInInfoMapperKt.toCheckInInfo(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.data.dailycheck.repository.DanapolyCheckInEntityRepository$fetchCheckInHistory$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }
}
