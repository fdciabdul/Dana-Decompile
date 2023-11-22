package id.dana.mybills.domain.interactor;

import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.mybills.domain.MyBillsRepository;
import id.dana.mybills.domain.interactor.GetProductMobileRecharge;
import id.dana.mybills.domain.model.MobileRechargeProduct;
import id.dana.mybills.domain.model.ProductProviderInfo;
import id.dana.mybills.domain.model.ProductQueryRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/mybills/domain/interactor/GetProductMobileRecharge;", "Lid/dana/domain/core/usecase/BaseFlowUseCase;", "Lid/dana/mybills/domain/interactor/GetProductMobileRecharge$Params;", "Lid/dana/mybills/domain/model/ProductProviderInfo;", "Lid/dana/mybills/domain/MyBillsRepository;", "MyBillsEntityDataFactory", "Lid/dana/mybills/domain/MyBillsRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lid/dana/mybills/domain/MyBillsRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetProductMobileRecharge extends BaseFlowUseCase<Params, ProductProviderInfo> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final MyBillsRepository KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.domain.core.usecase.BaseFlowUseCase
    public final /* synthetic */ Flow<ProductProviderInfo> buildUseCase(Params params) {
        final Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        final Flow<MobileRechargeProduct> authRequestContext = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(params2.PlaceComponentResult);
        return new Flow<ProductProviderInfo>() { // from class: id.dana.mybills.domain.interactor.GetProductMobileRecharge$buildUseCase$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super ProductProviderInfo> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this, params2), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.mybills.domain.interactor.GetProductMobileRecharge$buildUseCase$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ GetProductMobileRecharge.Params $KClassImpl$Data$declaredNonStaticMembers$2;
                final /* synthetic */ FlowCollector $getAuthRequestContext;
                final /* synthetic */ GetProductMobileRecharge PlaceComponentResult;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.mybills.domain.interactor.GetProductMobileRecharge$buildUseCase$$inlined$map$1$2", f = "GetProductMobileRecharge.kt", i = {}, l = {228}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.mybills.domain.interactor.GetProductMobileRecharge$buildUseCase$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, GetProductMobileRecharge getProductMobileRecharge, GetProductMobileRecharge.Params params) {
                    this.$getAuthRequestContext = flowCollector;
                    this.PlaceComponentResult = getProductMobileRecharge;
                    this.$KClassImpl$Data$declaredNonStaticMembers$2 = params;
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
                        boolean r0 = r7 instanceof id.dana.mybills.domain.interactor.GetProductMobileRecharge$buildUseCase$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r7
                        id.dana.mybills.domain.interactor.GetProductMobileRecharge$buildUseCase$$inlined$map$1$2$1 r0 = (id.dana.mybills.domain.interactor.GetProductMobileRecharge$buildUseCase$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r7 = r0.label
                        int r7 = r7 + r2
                        r0.label = r7
                        goto L19
                    L14:
                        id.dana.mybills.domain.interactor.GetProductMobileRecharge$buildUseCase$$inlined$map$1$2$1 r0 = new id.dana.mybills.domain.interactor.GetProductMobileRecharge$buildUseCase$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L19:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L68
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
                        id.dana.mybills.domain.model.MobileRechargeProduct r6 = (id.dana.mybills.domain.model.MobileRechargeProduct) r6
                        java.util.Map r6 = r6.getProducts()
                        id.dana.mybills.domain.interactor.GetProductMobileRecharge$Params r2 = r5.$KClassImpl$Data$declaredNonStaticMembers$2
                        id.dana.mybills.domain.model.ProductQueryRequest r2 = r2.PlaceComponentResult
                        java.lang.String r2 = r2.getProviderName()
                        id.dana.mybills.domain.model.ProductProviderInfo r6 = id.dana.mybills.domain.interactor.GetProductMobileRecharge.BuiltInFictitiousFunctionClassFactory(r6, r2)
                        if (r6 != 0) goto L5f
                        id.dana.mybills.domain.model.ProductProviderInfo r6 = new id.dana.mybills.domain.model.ProductProviderInfo
                        id.dana.mybills.domain.interactor.GetProductMobileRecharge$Params r2 = r5.$KClassImpl$Data$declaredNonStaticMembers$2
                        id.dana.mybills.domain.model.ProductQueryRequest r2 = r2.PlaceComponentResult
                        java.lang.String r2 = r2.getProviderName()
                        java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
                        r6.<init>(r2, r4)
                    L5f:
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L68
                        return r1
                    L68:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.domain.interactor.GetProductMobileRecharge$buildUseCase$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
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
    public GetProductMobileRecharge(id.dana.mybills.domain.MyBillsRepository r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            r2.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.domain.interactor.GetProductMobileRecharge.<init>(id.dana.mybills.domain.MyBillsRepository):void");
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/mybills/domain/interactor/GetProductMobileRecharge$Params;", "", "Lid/dana/mybills/domain/model/ProductQueryRequest;", "MyBillsEntityDataFactory", "Lid/dana/mybills/domain/model/ProductQueryRequest;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/mybills/domain/model/ProductQueryRequest;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final ProductQueryRequest PlaceComponentResult;

        public Params(ProductQueryRequest productQueryRequest) {
            Intrinsics.checkNotNullParameter(productQueryRequest, "");
            this.PlaceComponentResult = productQueryRequest;
        }
    }

    public static final /* synthetic */ ProductProviderInfo BuiltInFictitiousFunctionClassFactory(Map map, String str) {
        if (map != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (Intrinsics.areEqual(entry.getKey(), str)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return (ProductProviderInfo) linkedHashMap.get(str);
        }
        return null;
    }
}
