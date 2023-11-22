package id.dana.explore.data.sku.repository;

import id.dana.data.foundation.utils.CookieUtil;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.explore.data.sku.ProfileKeyNotFoundException;
import id.dana.explore.data.sku.repository.source.network.NetworkProductInfoEntityData;
import id.dana.explore.data.sku.repository.source.network.ProductInfoFacade;
import id.dana.explore.data.sku.repository.source.network.request.BizDestinationInquiryRequest;
import id.dana.explore.data.sku.repository.source.network.request.CreateProductOrderRequest;
import id.dana.explore.data.sku.repository.source.network.request.QueryLastSuccessfulTransactionRequest;
import id.dana.explore.data.sku.repository.source.network.response.BizDestinationInquiryResult;
import id.dana.explore.data.sku.repository.source.network.response.CreateProductOrderResult;
import id.dana.explore.data.sku.repository.source.network.response.QueryLastSuccessfulTransactionResponse;
import id.dana.explore.data.toggle.ExploreConfigEntityData;
import id.dana.explore.data.toggle.source.ExploreConfigEntityDataFactory;
import id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData;
import id.dana.explore.domain.sku.ProductInfoRepository;
import id.dana.explore.domain.sku.model.CategoryExploreModel;
import id.dana.explore.domain.sku.model.SkuExploreConfig;
import id.dana.network.base.ResultResponse;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0014\u0012\u0006\u0010\u0019\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0011¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00040\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0007J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0006\u0010\u000bR\u0014\u0010\n\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0015R\u0013\u0010\r\u001a\u00020\u0017X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0018"}, d2 = {"Lid/dana/explore/data/sku/repository/ProductInfoEntityRepository;", "Lid/dana/explore/domain/sku/ProductInfoRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "Lio/reactivex/Observable;", "", "Lid/dana/explore/domain/sku/model/CategoryExploreModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lio/reactivex/Observable;", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/explore/domain/sku/model/SkuExploreConfig;", "PlaceComponentResult", "Lid/dana/explore/data/sku/repository/source/network/response/QueryLastSuccessfulTransactionResponse;", "Lid/dana/explore/data/toggle/source/ExploreConfigEntityDataFactory;", "Lid/dana/explore/data/toggle/source/ExploreConfigEntityDataFactory;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "getAuthRequestContext", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/explore/data/sku/repository/source/network/NetworkProductInfoEntityData;", "Lid/dana/explore/data/sku/repository/source/network/NetworkProductInfoEntityData;", "MyBillsEntityDataFactory", "Lid/dana/explore/data/toggle/ExploreConfigEntityData;", "Lkotlin/Lazy;", "p1", "p2", "<init>", "(Lid/dana/explore/data/sku/repository/source/network/NetworkProductInfoEntityData;Lid/dana/explore/data/toggle/source/ExploreConfigEntityDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProductInfoEntityRepository implements ProductInfoRepository, HoldLoginV1Repository {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ExploreConfigEntityDataFactory BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final NetworkProductInfoEntityData MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final HoldLoginV1EntityRepository KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public ProductInfoEntityRepository(NetworkProductInfoEntityData networkProductInfoEntityData, ExploreConfigEntityDataFactory exploreConfigEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(networkProductInfoEntityData, "");
        Intrinsics.checkNotNullParameter(exploreConfigEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.MyBillsEntityDataFactory = networkProductInfoEntityData;
        this.BuiltInFictitiousFunctionClassFactory = exploreConfigEntityDataFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = holdLoginV1EntityRepository;
        this.PlaceComponentResult = LazyKt.lazy(new Function0<ExploreConfigEntityData>() { // from class: id.dana.explore.data.sku.repository.ProductInfoEntityRepository$splitExploreConfigEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExploreConfigEntityData invoke() {
                ExploreConfigEntityDataFactory exploreConfigEntityDataFactory2;
                exploreConfigEntityDataFactory2 = ProductInfoEntityRepository.this.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullParameter("split", "");
                SplitExploreConfigEntityData splitExploreConfigEntityData = exploreConfigEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2.get();
                Intrinsics.checkNotNullExpressionValue(splitExploreConfigEntityData, "");
                return splitExploreConfigEntityData;
            }
        });
    }

    @Override // id.dana.explore.domain.sku.ProductInfoRepository
    public final Observable<String> BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (!Intrinsics.areEqual(p0, "MOBILE_RECHARGE_PHONE_NUMBER_LIST")) {
            if (!Intrinsics.areEqual(p0, "ELECTRICITY_PLN_LAST_RECHARGE_ID")) {
                Observable<String> error = Observable.error(new ProfileKeyNotFoundException());
                Intrinsics.checkNotNullExpressionValue(error, "");
                return error;
            }
            Observable flatMap = KClassImpl$Data$declaredNonStaticMembers$2("ELECTRICITY_PLN_LAST_RECHARGE_ID").flatMap(new Function() { // from class: id.dana.explore.data.sku.repository.ProductInfoEntityRepository$$ExternalSyntheticLambda3
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return ProductInfoEntityRepository.getAuthRequestContext(ProductInfoEntityRepository.this, (QueryLastSuccessfulTransactionResponse) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(flatMap, "");
            return flatMap;
        }
        Observable flatMap2 = KClassImpl$Data$declaredNonStaticMembers$2("MOBILE_RECHARGE_PHONE_NUMBER_LIST").flatMap(new Function() { // from class: id.dana.explore.data.sku.repository.ProductInfoEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ProductInfoEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(ProductInfoEntityRepository.this, (QueryLastSuccessfulTransactionResponse) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap2, "");
        return flatMap2;
    }

    private final Observable<QueryLastSuccessfulTransactionResponse> KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        NetworkProductInfoEntityData networkProductInfoEntityData = this.MyBillsEntityDataFactory;
        QueryLastSuccessfulTransactionRequest queryLastSuccessfulTransactionRequest = new QueryLastSuccessfulTransactionRequest(p0);
        Intrinsics.checkNotNullParameter(queryLastSuccessfulTransactionRequest, "");
        Observable<R> map = networkProductInfoEntityData.getAuthRequestContext.MyBillsEntityDataFactory(CookieUtil.getAuthRequestContext().toString(), queryLastSuccessfulTransactionRequest).map(new Function() { // from class: id.dana.explore.data.sku.repository.source.network.NetworkProductInfoEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkProductInfoEntityData.getAuthRequestContext((ResultResponse) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Observable<QueryLastSuccessfulTransactionResponse> flatMap = map.flatMap(new Function() { // from class: id.dana.explore.data.sku.repository.ProductInfoEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ProductInfoEntityRepository.MyBillsEntityDataFactory((QueryLastSuccessfulTransactionResponse) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(ProductInfoEntityRepository productInfoEntityRepository, QueryLastSuccessfulTransactionResponse queryLastSuccessfulTransactionResponse) {
        Intrinsics.checkNotNullParameter(productInfoEntityRepository, "");
        Intrinsics.checkNotNullParameter(queryLastSuccessfulTransactionResponse, "");
        ObservableSource map = productInfoEntityRepository.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(CreateProductOrderRequest.INSTANCE.fromLastSuccesfulTransaction(queryLastSuccessfulTransactionResponse)).map(new ProductInfoEntityRepository$$ExternalSyntheticLambda0());
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(ProductInfoEntityRepository productInfoEntityRepository, QueryLastSuccessfulTransactionResponse queryLastSuccessfulTransactionResponse, BizDestinationInquiryResult bizDestinationInquiryResult) {
        Intrinsics.checkNotNullParameter(productInfoEntityRepository, "");
        Intrinsics.checkNotNullParameter(queryLastSuccessfulTransactionResponse, "");
        Intrinsics.checkNotNullParameter(bizDestinationInquiryResult, "");
        ObservableSource map = productInfoEntityRepository.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(CreateProductOrderRequest.INSTANCE.forElectricity(bizDestinationInquiryResult, queryLastSuccessfulTransactionResponse)).map(new ProductInfoEntityRepository$$ExternalSyntheticLambda0());
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    public static /* synthetic */ String getAuthRequestContext(CreateProductOrderResult createProductOrderResult) {
        Intrinsics.checkNotNullParameter(createProductOrderResult, "");
        String checkoutUrl = createProductOrderResult.getCheckoutUrl();
        return checkoutUrl == null ? "" : checkoutUrl;
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(QueryLastSuccessfulTransactionResponse queryLastSuccessfulTransactionResponse) {
        Observable just;
        Intrinsics.checkNotNullParameter(queryLastSuccessfulTransactionResponse, "");
        if (queryLastSuccessfulTransactionResponse.isInvalid()) {
            just = Observable.error(new LastTransactionInvalidException());
        } else {
            just = Observable.just(queryLastSuccessfulTransactionResponse);
        }
        return just;
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(ProductInfoEntityRepository productInfoEntityRepository, final QueryLastSuccessfulTransactionResponse queryLastSuccessfulTransactionResponse) {
        Intrinsics.checkNotNullParameter(productInfoEntityRepository, "");
        Intrinsics.checkNotNullParameter(queryLastSuccessfulTransactionResponse, "");
        BizDestinationInquiryRequest fromLastSuccessfulTransaction = BizDestinationInquiryRequest.INSTANCE.fromLastSuccessfulTransaction(queryLastSuccessfulTransactionResponse);
        NetworkProductInfoEntityData networkProductInfoEntityData = productInfoEntityRepository.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullParameter(fromLastSuccessfulTransaction, "");
        ProductInfoFacade productInfoFacade = networkProductInfoEntityData.getAuthRequestContext;
        String obj = CookieUtil.getAuthRequestContext().toString();
        fromLastSuccessfulTransaction.envInfo = networkProductInfoEntityData.generateMobileEnvInfo();
        Unit unit = Unit.INSTANCE;
        Observable<R> map = productInfoFacade.MyBillsEntityDataFactory(obj, fromLastSuccessfulTransaction).map(new Function() { // from class: id.dana.explore.data.sku.repository.source.network.NetworkProductInfoEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj2) {
                return NetworkProductInfoEntityData.PlaceComponentResult((ResultResponse) obj2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map.flatMap(new Function() { // from class: id.dana.explore.data.sku.repository.ProductInfoEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj2) {
                return ProductInfoEntityRepository.PlaceComponentResult(ProductInfoEntityRepository.this, queryLastSuccessfulTransactionResponse, (BizDestinationInquiryResult) obj2);
            }
        });
    }

    @Override // id.dana.explore.domain.sku.ProductInfoRepository
    public final Observable<List<CategoryExploreModel>> KClassImpl$Data$declaredNonStaticMembers$2() {
        return ((ExploreConfigEntityData) this.PlaceComponentResult.getValue()).BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.explore.domain.sku.ProductInfoRepository
    public final Observable<List<SkuExploreConfig>> PlaceComponentResult() {
        return ((ExploreConfigEntityData) this.PlaceComponentResult.getValue()).getAuthRequestContext();
    }
}
