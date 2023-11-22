package id.dana.mybills.domain.interactor;

import id.dana.analytics.executiontime.TrackerExecutionCounter;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.mybills.data.model.response.GeneralProductResult;
import id.dana.mybills.data.model.response.ProductGoodsResult;
import id.dana.mybills.domain.MyBillsRepository;
import id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination;
import id.dana.mybills.domain.model.BizProductDestination;
import id.dana.mybills.domain.model.ProductQueryRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001:\u0002\u0019\u001aB\u0011\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR.\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004`\u0010X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R:\u0010\u0014\u001a*\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00020\u000ej\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0002`\u0010X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0016"}, d2 = {"Lid/dana/mybills/domain/interactor/GetInquirySubscriptionPaylaterWithDestination;", "Lid/dana/domain/core/usecase/BaseFlowUseCase;", "", "Lid/dana/mybills/domain/interactor/GetInquirySubscriptionPaylaterWithDestination$Params;", "Lid/dana/mybills/domain/model/BizProductDestination;", "p0", "Lid/dana/mybills/data/model/response/ProductGoodsResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/mybills/domain/interactor/GetInquirySubscriptionPaylaterWithDestination$Params;)Lid/dana/mybills/data/model/response/ProductGoodsResult;", "p1", "(Lid/dana/mybills/domain/interactor/GetInquirySubscriptionPaylaterWithDestination$Params;Lid/dana/mybills/data/model/response/ProductGoodsResult;)Lid/dana/mybills/domain/model/BizProductDestination;", "Lid/dana/mybills/domain/MyBillsRepository;", "getAuthRequestContext", "Lid/dana/mybills/domain/MyBillsRepository;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "MyBillsEntityDataFactory", "Ljava/util/HashMap;", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "Lid/dana/analytics/executiontime/TrackerExecutionCounter;", "Lid/dana/analytics/executiontime/TrackerExecutionCounter;", "<init>", "(Lid/dana/mybills/domain/MyBillsRepository;)V", "Companion", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetInquirySubscriptionPaylaterWithDestination extends BaseFlowUseCase<List<? extends Params>, List<? extends BizProductDestination>> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    HashMap<String, List<ProductGoodsResult>> PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    HashMap<String, BizProductDestination> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final TrackerExecutionCounter BuiltInFictitiousFunctionClassFactory;
    private final MyBillsRepository getAuthRequestContext;

    @Override // id.dana.domain.core.usecase.BaseFlowUseCase
    public final /* synthetic */ Flow<List<? extends BizProductDestination>> buildUseCase(List<? extends Params> list) {
        List<? extends Params> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "");
        this.BuiltInFictitiousFunctionClassFactory.initiateStartTime();
        return FlowKt.flow(new GetInquirySubscriptionPaylaterWithDestination$buildUseCase$1(list2, this, null));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GetInquirySubscriptionPaylaterWithDestination(id.dana.mybills.domain.MyBillsRepository r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            r2.getAuthRequestContext = r3
            id.dana.analytics.executiontime.TrackerExecutionCounter r3 = new id.dana.analytics.executiontime.TrackerExecutionCounter
            r3.<init>()
            r2.BuiltInFictitiousFunctionClassFactory = r3
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r2.PlaceComponentResult = r3
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r2.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination.<init>(id.dana.mybills.domain.MyBillsRepository):void");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\n\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\tR\u0011\u0010\u000b\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004"}, d2 = {"Lid/dana/mybills/domain/interactor/GetInquirySubscriptionPaylaterWithDestination$Params;", "", "", "PlaceComponentResult", "Ljava/lang/String;", "getAuthRequestContext", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "()Z", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "p2", "p3", "p4", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final String PlaceComponentResult;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private final boolean MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final String getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;

        public Params(String str, String str2, String str3, boolean z, String str4) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.getAuthRequestContext = str2;
            this.PlaceComponentResult = str3;
            this.MyBillsEntityDataFactory = z;
            this.BuiltInFictitiousFunctionClassFactory = str4;
        }

        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext  reason: from getter */
        public final boolean getMyBillsEntityDataFactory() {
            return this.MyBillsEntityDataFactory;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProductGoodsResult KClassImpl$Data$declaredNonStaticMembers$2(Params p0) {
        List<ProductGoodsResult> list = this.PlaceComponentResult.get(p0.PlaceComponentResult);
        Object obj = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(p0.KClassImpl$Data$declaredNonStaticMembers$2, ((ProductGoodsResult) next).getGoodsId())) {
                    obj = next;
                    break;
                }
            }
            return (ProductGoodsResult) obj;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    public static final /* synthetic */ Flow getAuthRequestContext(final GetInquirySubscriptionPaylaterWithDestination getInquirySubscriptionPaylaterWithDestination, final Params params) {
        List<ProductGoodsResult> list = getInquirySubscriptionPaylaterWithDestination.PlaceComponentResult.get(params.PlaceComponentResult);
        if (list == null || list.isEmpty()) {
            ?? r4 = 0;
            final Flow<GeneralProductResult> MyBillsEntityDataFactory = getInquirySubscriptionPaylaterWithDestination.getAuthRequestContext.MyBillsEntityDataFactory(new ProductQueryRequest(params.PlaceComponentResult, r4, 2, r4));
            final Flow<ProductGoodsResult> flow = new Flow<ProductGoodsResult>() { // from class: id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$1
                @Override // kotlinx.coroutines.flow.Flow
                public final Object collect(FlowCollector<? super ProductGoodsResult> flowCollector, Continuation continuation) {
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, getInquirySubscriptionPaylaterWithDestination, params), continuation);
                    return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                }

                @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
                /* renamed from: id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$1$2  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ GetInquirySubscriptionPaylaterWithDestination.Params $BuiltInFictitiousFunctionClassFactory;
                    final /* synthetic */ FlowCollector $getAuthRequestContext;
                    final /* synthetic */ GetInquirySubscriptionPaylaterWithDestination PlaceComponentResult;

                    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                    @DebugMetadata(c = "id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$1$2", f = "GetInquirySubscriptionPaylaterWithDestination.kt", i = {}, l = {225}, m = "emit", n = {}, s = {})
                    /* renamed from: id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$1$2$1  reason: invalid class name */
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

                    public AnonymousClass2(FlowCollector flowCollector, GetInquirySubscriptionPaylaterWithDestination getInquirySubscriptionPaylaterWithDestination, GetInquirySubscriptionPaylaterWithDestination.Params params) {
                        this.$getAuthRequestContext = flowCollector;
                        this.PlaceComponentResult = getInquirySubscriptionPaylaterWithDestination;
                        this.$BuiltInFictitiousFunctionClassFactory = params;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                        /*
                            r5 = this;
                            boolean r0 = r7 instanceof id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L14
                            r0 = r7
                            id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$1$2$1 r0 = (id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r1 = r1 & r2
                            if (r1 == 0) goto L14
                            int r7 = r0.label
                            int r7 = r7 + r2
                            r0.label = r7
                            goto L19
                        L14:
                            id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$1$2$1 r0 = new id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$1$2$1
                            r0.<init>(r7)
                        L19:
                            java.lang.Object r7 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L32
                            if (r2 != r3) goto L2a
                            kotlin.ResultKt.throwOnFailure(r7)
                            goto L64
                        L2a:
                            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                            r6.<init>(r7)
                            throw r6
                        L32:
                            kotlin.ResultKt.throwOnFailure(r7)
                            kotlinx.coroutines.flow.FlowCollector r7 = r5.$getAuthRequestContext
                            r2 = r0
                            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                            id.dana.mybills.data.model.response.GeneralProductResult r6 = (id.dana.mybills.data.model.response.GeneralProductResult) r6
                            id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination r2 = r5.PlaceComponentResult
                            java.util.HashMap<java.lang.String, java.util.List<id.dana.mybills.data.model.response.ProductGoodsResult>> r2 = r2.PlaceComponentResult
                            java.util.Map r2 = (java.util.Map) r2
                            id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$Params r4 = r5.$BuiltInFictitiousFunctionClassFactory
                            java.lang.String r4 = r4.PlaceComponentResult
                            java.util.List r6 = r6.getGoods()
                            if (r6 != 0) goto L50
                            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
                        L50:
                            r2.put(r4, r6)
                            id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination r6 = r5.PlaceComponentResult
                            id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$Params r2 = r5.$BuiltInFictitiousFunctionClassFactory
                            id.dana.mybills.data.model.response.ProductGoodsResult r6 = id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination.MyBillsEntityDataFactory(r6, r2)
                            r0.label = r3
                            java.lang.Object r6 = r7.emit(r6, r0)
                            if (r6 != r1) goto L64
                            return r1
                        L64:
                            kotlin.Unit r6 = kotlin.Unit.INSTANCE
                            return r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }
            };
            final Flow<BizProductDestination> flow2 = new Flow<BizProductDestination>() { // from class: id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$2
                @Override // kotlinx.coroutines.flow.Flow
                public final Object collect(FlowCollector<? super BizProductDestination> flowCollector, Continuation continuation) {
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, getInquirySubscriptionPaylaterWithDestination, params), continuation);
                    return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                }

                @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
                /* renamed from: id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$2$2  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ GetInquirySubscriptionPaylaterWithDestination.Params $BuiltInFictitiousFunctionClassFactory;
                    final /* synthetic */ FlowCollector $KClassImpl$Data$declaredNonStaticMembers$2;
                    final /* synthetic */ GetInquirySubscriptionPaylaterWithDestination getAuthRequestContext;

                    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                    @DebugMetadata(c = "id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$2$2", f = "GetInquirySubscriptionPaylaterWithDestination.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                    /* renamed from: id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$2$2$1  reason: invalid class name */
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

                    public AnonymousClass2(FlowCollector flowCollector, GetInquirySubscriptionPaylaterWithDestination getInquirySubscriptionPaylaterWithDestination, GetInquirySubscriptionPaylaterWithDestination.Params params) {
                        this.$KClassImpl$Data$declaredNonStaticMembers$2 = flowCollector;
                        this.getAuthRequestContext = getInquirySubscriptionPaylaterWithDestination;
                        this.$BuiltInFictitiousFunctionClassFactory = params;
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
                            boolean r0 = r6 instanceof id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$2.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L14
                            r0 = r6
                            id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$2$2$1 r0 = (id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$2.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r1 = r1 & r2
                            if (r1 == 0) goto L14
                            int r6 = r0.label
                            int r6 = r6 + r2
                            r0.label = r6
                            goto L19
                        L14:
                            id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$2$2$1 r0 = new id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$2$2$1
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
                            kotlinx.coroutines.flow.FlowCollector r6 = r4.$KClassImpl$Data$declaredNonStaticMembers$2
                            r2 = r0
                            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                            id.dana.mybills.data.model.response.ProductGoodsResult r5 = (id.dana.mybills.data.model.response.ProductGoodsResult) r5
                            id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$Params r2 = r4.$BuiltInFictitiousFunctionClassFactory
                            id.dana.mybills.domain.model.BizProductDestination r5 = id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination.getAuthRequestContext(r2, r5)
                            r0.label = r3
                            java.lang.Object r5 = r6.emit(r5, r0)
                            if (r5 != r1) goto L4b
                            return r1
                        L4b:
                            kotlin.Unit r5 = kotlin.Unit.INSTANCE
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }
            };
            return FlowKt.m4649catch(new Flow<BizProductDestination>() { // from class: id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$3
                @Override // kotlinx.coroutines.flow.Flow
                public final Object collect(FlowCollector<? super BizProductDestination> flowCollector, Continuation continuation) {
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                    return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                }

                @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
                /* renamed from: id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$3$2  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $MyBillsEntityDataFactory;

                    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                    @DebugMetadata(c = "id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$3$2", f = "GetInquirySubscriptionPaylaterWithDestination.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                    /* renamed from: id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$3$2$1  reason: invalid class name */
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
                            boolean r0 = r6 instanceof id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$3.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L14
                            r0 = r6
                            id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$3$2$1 r0 = (id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$3.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r1 = r1 & r2
                            if (r1 == 0) goto L14
                            int r6 = r0.label
                            int r6 = r6 + r2
                            r0.label = r6
                            goto L19
                        L14:
                            id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$3$2$1 r0 = new id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$3$2$1
                            r0.<init>(r6)
                        L19:
                            java.lang.Object r6 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L32
                            if (r2 != r3) goto L2a
                            kotlin.ResultKt.throwOnFailure(r6)
                            goto L45
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
                            id.dana.mybills.domain.model.BizProductDestination r5 = (id.dana.mybills.domain.model.BizProductDestination) r5
                            r0.label = r3
                            java.lang.Object r5 = r6.emit(r5, r0)
                            if (r5 != r1) goto L45
                            return r1
                        L45:
                            kotlin.Unit r5 = kotlin.Unit.INSTANCE
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$$inlined$map$3.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }
            }, new GetInquirySubscriptionPaylaterWithDestination$getInquiryGeneralProduct$4(null));
        }
        return FlowKt.flowOf(KClassImpl$Data$declaredNonStaticMembers$2(params, getInquirySubscriptionPaylaterWithDestination.KClassImpl$Data$declaredNonStaticMembers$2(params)));
    }

    public static final /* synthetic */ Flow KClassImpl$Data$declaredNonStaticMembers$2(GetInquirySubscriptionPaylaterWithDestination getInquirySubscriptionPaylaterWithDestination, final Params params) {
        final Flow<BizProductDestination> PlaceComponentResult = getInquirySubscriptionPaylaterWithDestination.getAuthRequestContext.PlaceComponentResult(params.KClassImpl$Data$declaredNonStaticMembers$2, params.getAuthRequestContext);
        return FlowKt.m4649catch(new Flow<BizProductDestination>() { // from class: id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquirySubscription$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super BizProductDestination> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, params), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquirySubscription$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $MyBillsEntityDataFactory;
                final /* synthetic */ GetInquirySubscriptionPaylaterWithDestination.Params $PlaceComponentResult;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquirySubscription$$inlined$map$1$2", f = "GetInquirySubscriptionPaylaterWithDestination.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquirySubscription$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, GetInquirySubscriptionPaylaterWithDestination.Params params) {
                    this.$MyBillsEntityDataFactory = flowCollector;
                    this.$PlaceComponentResult = params;
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
                        boolean r0 = r6 instanceof id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquirySubscription$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquirySubscription$$inlined$map$1$2$1 r0 = (id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquirySubscription$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquirySubscription$$inlined$map$1$2$1 r0 = new id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquirySubscription$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L4c
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
                        id.dana.mybills.domain.model.BizProductDestination r5 = (id.dana.mybills.domain.model.BizProductDestination) r5
                        id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$Params r2 = r4.$PlaceComponentResult
                        java.lang.String r2 = r2.getAuthRequestContext
                        r5.setBillId(r2)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L4c
                        return r1
                    L4c:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquirySubscription$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        }, new GetInquirySubscriptionPaylaterWithDestination$getInquirySubscription$2(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BizProductDestination KClassImpl$Data$declaredNonStaticMembers$2(Params p0, ProductGoodsResult p1) {
        String str = p0.getAuthRequestContext;
        String goodsTitle = p1 != null ? p1.getGoodsTitle() : null;
        String str2 = goodsTitle == null ? "" : goodsTitle;
        String provider = p1 != null ? p1.getProvider() : null;
        return new BizProductDestination(str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str2, null, null, null, null, null, null, null, null, null, null, null, null, provider == null ? "" : provider, null, null, null, null, null, null, null, null, null, null, null, null, p1 != null ? "SUCCESS" : "FAILED", null, null, -16777218, 1834975, null);
    }
}
