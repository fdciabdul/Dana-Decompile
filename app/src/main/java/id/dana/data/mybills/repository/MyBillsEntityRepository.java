package id.dana.data.mybills.repository;

import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.mybills.mapper.BizProductMapperKt;
import id.dana.data.mybills.mapper.BizProductOrderMapperKt;
import id.dana.data.mybills.mapper.HighlightTransactionPayRequestMapperKt;
import id.dana.data.mybills.mapper.HighlightTransactionPayResultMapperKt;
import id.dana.data.mybills.model.request.BizDestinationParam;
import id.dana.data.mybills.model.request.HighlightSubscriptionRequestKt;
import id.dana.data.mybills.model.request.InquiryBizDestinationRequest;
import id.dana.data.mybills.model.request.ListPaylaterByBillRequest;
import id.dana.data.mybills.model.request.MonthlyAmountSubscriptionRequest;
import id.dana.data.mybills.model.result.CreateOrderResult;
import id.dana.data.mybills.model.result.HighlightSubscriptionResult;
import id.dana.data.mybills.model.result.HighlightSubscriptionResultKt;
import id.dana.data.mybills.model.result.HighlightTransactionPayResult;
import id.dana.data.mybills.model.result.InquiryBizDestinationResult;
import id.dana.data.mybills.model.result.InquiryBizDestinationResultKt;
import id.dana.data.mybills.model.result.ListBillPaylaterResult;
import id.dana.data.mybills.model.result.ListBillPaylaterResultKt;
import id.dana.data.mybills.model.result.MonthlyAmountSubscriptionResult;
import id.dana.data.mybills.model.result.MonthlyAmountSubscriptionResultKt;
import id.dana.data.mybills.model.result.QuickBuyResult;
import id.dana.domain.mybills.MyBillsRepository;
import id.dana.domain.mybills.model.BizProduct;
import id.dana.domain.mybills.model.BizProductDestination;
import id.dana.domain.mybills.model.BizProductOrder;
import id.dana.domain.mybills.model.BizProductOrderRequest;
import id.dana.domain.mybills.model.HighlightTransactionPay;
import id.dana.domain.mybills.model.HighlightTransactionPayRequest;
import id.dana.domain.mybills.model.MyBillPaylater;
import id.dana.domain.mybills.model.MyBillsHighlight;
import id.dana.domain.mybills.model.MyBillsHighlightRequestModel;
import id.dana.domain.mybills.model.MyBillsMonthlyAmount;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020*\u0012\u0006\u0010\u0012\u001a\u00020.\u0012\u0006\u0010\u001a\u001a\u00020$¢\u0006\u0004\b1\u00102J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u0004\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\u0006\u0010\u0004\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00052\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J1\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00052\u0006\u0010\u0004\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00052\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00160\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00110\u0016H\u0016¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00052\u0006\u0010\u0004\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0013\u0010(\u001a\u00020'X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020*8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b-\u0010/"}, d2 = {"Lid/dana/data/mybills/repository/MyBillsEntityRepository;", "Lid/dana/domain/mybills/MyBillsRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "Lid/dana/domain/mybills/model/BizProductOrderRequest;", "p0", "Lio/reactivex/Observable;", "Lid/dana/domain/mybills/model/BizProductOrder;", "getCreateBizProductOrder", "(Lid/dana/domain/mybills/model/BizProductOrderRequest;)Lio/reactivex/Observable;", "Lid/dana/domain/mybills/model/MyBillsHighlightRequestModel;", "Lid/dana/domain/mybills/model/MyBillsHighlight;", "getHighlightSubscription", "(Lid/dana/domain/mybills/model/MyBillsHighlightRequestModel;)Lio/reactivex/Observable;", "Lid/dana/domain/mybills/model/HighlightTransactionPayRequest;", "Lid/dana/domain/mybills/model/HighlightTransactionPay;", "getHighlightTransactionPay", "(Lid/dana/domain/mybills/model/HighlightTransactionPayRequest;)Lio/reactivex/Observable;", "", "p1", "Lid/dana/domain/mybills/model/BizProductDestination;", "getInquirySubscriptionDestination", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "", "Lid/dana/domain/mybills/model/MyBillPaylater;", "getListBillsByBillsIds", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "p2", "Lid/dana/domain/mybills/model/MyBillsMonthlyAmount;", "getMonthlyAmountSubscription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/mybills/model/BizProduct;", "getQuickBuySubscription", "(Ljava/util/List;)Lio/reactivex/Observable;", "", "isServiceEnable", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "PlaceComponentResult", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/mybills/repository/MyBillsEntityData;", "getAuthRequestContext", "Lkotlin/Lazy;", "Lid/dana/data/mybills/repository/MyBillsEntityDataFactory;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/mybills/repository/MyBillsEntityDataFactory;", "MyBillsEntityDataFactory", "Lid/dana/data/config/source/split/SplitConfigEntityData;", "Lid/dana/data/config/source/split/SplitConfigEntityData;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Lid/dana/data/mybills/repository/MyBillsEntityDataFactory;Lid/dana/data/config/source/split/SplitConfigEntityData;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MyBillsEntityRepository implements MyBillsRepository, HoldLoginV1Repository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final MyBillsEntityDataFactory MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final SplitConfigEntityData KClassImpl$Data$declaredNonStaticMembers$2;
    private final HoldLoginV1EntityRepository PlaceComponentResult;
    private final Lazy getAuthRequestContext;

    @Inject
    public MyBillsEntityRepository(MyBillsEntityDataFactory myBillsEntityDataFactory, SplitConfigEntityData splitConfigEntityData, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(myBillsEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(splitConfigEntityData, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.MyBillsEntityDataFactory = myBillsEntityDataFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = splitConfigEntityData;
        this.PlaceComponentResult = holdLoginV1EntityRepository;
        this.getAuthRequestContext = LazyKt.lazy(new Function0<MyBillsEntityData>() { // from class: id.dana.data.mybills.repository.MyBillsEntityRepository$myBillsEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MyBillsEntityData invoke() {
                MyBillsEntityDataFactory myBillsEntityDataFactory2;
                myBillsEntityDataFactory2 = MyBillsEntityRepository.this.MyBillsEntityDataFactory;
                return myBillsEntityDataFactory2.MyBillsEntityDataFactory;
            }
        });
    }

    @Override // id.dana.domain.mybills.MyBillsRepository
    public final Observable<Boolean> isServiceEnable(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return this.KClassImpl$Data$declaredNonStaticMembers$2.isServiceEnabled(p0);
    }

    public static /* synthetic */ BizProductOrder KClassImpl$Data$declaredNonStaticMembers$2(CreateOrderResult createOrderResult) {
        Intrinsics.checkNotNullParameter(createOrderResult, "");
        return BizProductOrderMapperKt.MyBillsEntityDataFactory(createOrderResult);
    }

    public static /* synthetic */ List PlaceComponentResult(QuickBuyResult quickBuyResult) {
        Intrinsics.checkNotNullParameter(quickBuyResult, "");
        return BizProductMapperKt.getAuthRequestContext(quickBuyResult.getBizIds());
    }

    public static /* synthetic */ BizProductDestination getAuthRequestContext(InquiryBizDestinationResult inquiryBizDestinationResult) {
        Intrinsics.checkNotNullParameter(inquiryBizDestinationResult, "");
        return InquiryBizDestinationResultKt.KClassImpl$Data$declaredNonStaticMembers$2(inquiryBizDestinationResult);
    }

    public static /* synthetic */ MyBillsHighlight MyBillsEntityDataFactory(HighlightSubscriptionResult highlightSubscriptionResult) {
        Intrinsics.checkNotNullParameter(highlightSubscriptionResult, "");
        return HighlightSubscriptionResultKt.PlaceComponentResult(highlightSubscriptionResult);
    }

    public static /* synthetic */ HighlightTransactionPay KClassImpl$Data$declaredNonStaticMembers$2(HighlightTransactionPayResult highlightTransactionPayResult) {
        Intrinsics.checkNotNullParameter(highlightTransactionPayResult, "");
        return HighlightTransactionPayResultMapperKt.BuiltInFictitiousFunctionClassFactory(highlightTransactionPayResult);
    }

    public static /* synthetic */ MyBillsMonthlyAmount PlaceComponentResult(MonthlyAmountSubscriptionResult monthlyAmountSubscriptionResult) {
        Intrinsics.checkNotNullParameter(monthlyAmountSubscriptionResult, "");
        return MonthlyAmountSubscriptionResultKt.KClassImpl$Data$declaredNonStaticMembers$2(monthlyAmountSubscriptionResult);
    }

    public static /* synthetic */ List getAuthRequestContext(ListBillPaylaterResult listBillPaylaterResult) {
        Intrinsics.checkNotNullParameter(listBillPaylaterResult, "");
        return ListBillPaylaterResultKt.MyBillsEntityDataFactory(listBillPaylaterResult);
    }

    @Override // id.dana.domain.mybills.MyBillsRepository
    public final Observable<BizProductOrder> getCreateBizProductOrder(BizProductOrderRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ObservableSource map = ((MyBillsEntityData) this.getAuthRequestContext.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(BizProductOrderMapperKt.PlaceComponentResult(p0)).map(new Function() { // from class: id.dana.data.mybills.repository.MyBillsEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MyBillsEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2((CreateOrderResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Intrinsics.checkNotNullParameter(map, "");
        Observable<BizProductOrder> authenticatedRequest = this.PlaceComponentResult.authenticatedRequest(map);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }

    @Override // id.dana.domain.mybills.MyBillsRepository
    public final Observable<MyBillsHighlight> getHighlightSubscription(MyBillsHighlightRequestModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ObservableSource map = ((MyBillsEntityData) this.getAuthRequestContext.getValue()).MyBillsEntityDataFactory(HighlightSubscriptionRequestKt.PlaceComponentResult(p0)).map(new Function() { // from class: id.dana.data.mybills.repository.MyBillsEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MyBillsEntityRepository.MyBillsEntityDataFactory((HighlightSubscriptionResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Intrinsics.checkNotNullParameter(map, "");
        Observable<MyBillsHighlight> authenticatedRequest = this.PlaceComponentResult.authenticatedRequest(map);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }

    @Override // id.dana.domain.mybills.MyBillsRepository
    public final Observable<HighlightTransactionPay> getHighlightTransactionPay(HighlightTransactionPayRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ObservableSource map = ((MyBillsEntityData) this.getAuthRequestContext.getValue()).getAuthRequestContext(HighlightTransactionPayRequestMapperKt.BuiltInFictitiousFunctionClassFactory(p0)).map(new Function() { // from class: id.dana.data.mybills.repository.MyBillsEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MyBillsEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2((HighlightTransactionPayResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Intrinsics.checkNotNullParameter(map, "");
        Observable<HighlightTransactionPay> authenticatedRequest = this.PlaceComponentResult.authenticatedRequest(map);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }

    @Override // id.dana.domain.mybills.MyBillsRepository
    public final Observable<BizProductDestination> getInquirySubscriptionDestination(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        ObservableSource map = ((MyBillsEntityData) this.getAuthRequestContext.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(new InquiryBizDestinationRequest(p0, CollectionsKt.listOf(new BizDestinationParam(p1)))).map(new Function() { // from class: id.dana.data.mybills.repository.MyBillsEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MyBillsEntityRepository.getAuthRequestContext((InquiryBizDestinationResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Intrinsics.checkNotNullParameter(map, "");
        Observable<BizProductDestination> authenticatedRequest = this.PlaceComponentResult.authenticatedRequest(map);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }

    @Override // id.dana.domain.mybills.MyBillsRepository
    public final Observable<List<MyBillPaylater>> getListBillsByBillsIds(String p0, List<String> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        ObservableSource map = ((MyBillsEntityData) this.getAuthRequestContext.getValue()).getAuthRequestContext(new ListPaylaterByBillRequest(p0, p1)).map(new Function() { // from class: id.dana.data.mybills.repository.MyBillsEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MyBillsEntityRepository.getAuthRequestContext((ListBillPaylaterResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Intrinsics.checkNotNullParameter(map, "");
        Observable<List<MyBillPaylater>> authenticatedRequest = this.PlaceComponentResult.authenticatedRequest(map);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }

    @Override // id.dana.domain.mybills.MyBillsRepository
    public final Observable<MyBillsMonthlyAmount> getMonthlyAmountSubscription(String p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        ObservableSource map = ((MyBillsEntityData) this.getAuthRequestContext.getValue()).PlaceComponentResult(new MonthlyAmountSubscriptionRequest(p1, p0, p2)).map(new Function() { // from class: id.dana.data.mybills.repository.MyBillsEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MyBillsEntityRepository.PlaceComponentResult((MonthlyAmountSubscriptionResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Intrinsics.checkNotNullParameter(map, "");
        Observable<MyBillsMonthlyAmount> authenticatedRequest = this.PlaceComponentResult.authenticatedRequest(map);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }

    @Override // id.dana.domain.mybills.MyBillsRepository
    public final Observable<List<BizProduct>> getQuickBuySubscription(List<String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ObservableSource map = ((MyBillsEntityData) this.getAuthRequestContext.getValue()).MyBillsEntityDataFactory(p0).map(new Function() { // from class: id.dana.data.mybills.repository.MyBillsEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MyBillsEntityRepository.PlaceComponentResult((QuickBuyResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Intrinsics.checkNotNullParameter(map, "");
        Observable<List<BizProduct>> authenticatedRequest = this.PlaceComponentResult.authenticatedRequest(map);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }
}
