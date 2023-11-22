package id.dana.mybills.domain.interactor;

import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.mybills.domain.MyBillsRepository;
import id.dana.mybills.domain.model.BizProduct;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\fB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/mybills/domain/interactor/GetQuickBuyMyBills;", "Lid/dana/domain/core/usecase/BaseFlowUseCase;", "Lid/dana/mybills/domain/interactor/GetQuickBuyMyBills$Params;", "", "Lid/dana/mybills/domain/model/BizProduct;", "Lid/dana/mybills/domain/MyBillsRepository;", "getAuthRequestContext", "Lid/dana/mybills/domain/MyBillsRepository;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/mybills/domain/MyBillsRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetQuickBuyMyBills extends BaseFlowUseCase<Params, List<? extends BizProduct>> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final MyBillsRepository MyBillsEntityDataFactory;

    @Override // id.dana.domain.core.usecase.BaseFlowUseCase
    public final /* synthetic */ Flow<List<? extends BizProduct>> buildUseCase(Params params) {
        Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        final Flow<List<BizProduct>> PlaceComponentResult = this.MyBillsEntityDataFactory.PlaceComponentResult(params2.BuiltInFictitiousFunctionClassFactory);
        return new Flow<List<? extends BizProduct>>() { // from class: id.dana.mybills.domain.interactor.GetQuickBuyMyBills$buildUseCase$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super List<? extends BizProduct>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.mybills.domain.interactor.GetQuickBuyMyBills$buildUseCase$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $KClassImpl$Data$declaredNonStaticMembers$2;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.mybills.domain.interactor.GetQuickBuyMyBills$buildUseCase$$inlined$map$1$2", f = "GetQuickBuyMyBills.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.mybills.domain.interactor.GetQuickBuyMyBills$buildUseCase$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
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
                    this.$KClassImpl$Data$declaredNonStaticMembers$2 = flowCollector;
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
                        boolean r0 = r6 instanceof id.dana.mybills.domain.interactor.GetQuickBuyMyBills$buildUseCase$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.mybills.domain.interactor.GetQuickBuyMyBills$buildUseCase$$inlined$map$1$2$1 r0 = (id.dana.mybills.domain.interactor.GetQuickBuyMyBills$buildUseCase$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.mybills.domain.interactor.GetQuickBuyMyBills$buildUseCase$$inlined$map$1$2$1 r0 = new id.dana.mybills.domain.interactor.GetQuickBuyMyBills$buildUseCase$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L52
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$KClassImpl$Data$declaredNonStaticMembers$2
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        java.util.List r5 = (java.util.List) r5
                        java.lang.Iterable r5 = (java.lang.Iterable) r5
                        id.dana.mybills.domain.interactor.GetQuickBuyMyBills$buildUseCase$lambda-1$$inlined$sortedByDescending$1 r2 = new id.dana.mybills.domain.interactor.GetQuickBuyMyBills$buildUseCase$lambda-1$$inlined$sortedByDescending$1
                        r2.<init>()
                        java.util.Comparator r2 = (java.util.Comparator) r2
                        java.util.List r5 = kotlin.collections.CollectionsKt.sortedWith(r5, r2)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L52
                        return r1
                    L52:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.domain.interactor.GetQuickBuyMyBills$buildUseCase$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GetQuickBuyMyBills(id.dana.mybills.domain.MyBillsRepository r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            r2.MyBillsEntityDataFactory = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.domain.interactor.GetQuickBuyMyBills.<init>(id.dana.mybills.domain.MyBillsRepository):void");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/mybills/domain/interactor/GetQuickBuyMyBills$Params;", "", "", "", "MyBillsEntityDataFactory", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Params {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final List<String> BuiltInFictitiousFunctionClassFactory;

        public Params(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "");
            this.BuiltInFictitiousFunctionClassFactory = list;
        }
    }
}
