package id.dana.data.expresspurchase.source.network;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.data.constant.UrlParam;
import id.dana.data.expresspurchase.source.ExpressPurchaseEntityData;
import id.dana.data.expresspurchase.source.network.pojo.request.GetExpressPurchaseRequest;
import id.dana.data.expresspurchase.source.network.pojo.request.OrderQueryByConditionRequest;
import id.dana.data.expresspurchase.source.network.pojo.request.QuickBuyDealsRequest;
import id.dana.data.expresspurchase.source.network.pojo.request.QuickBuyGoldRequest;
import id.dana.data.expresspurchase.source.network.pojo.request.QuickBuyInsuranceRequest;
import id.dana.data.expresspurchase.source.network.pojo.request.ValidateProductGoldRequest;
import id.dana.data.expresspurchase.source.network.pojo.request.ValidateProductQuickRequest;
import id.dana.data.expresspurchase.source.network.pojo.request.ValidateProductRequest;
import id.dana.data.expresspurchase.source.network.pojo.response.GetExpressPurchaseResponse;
import id.dana.data.expresspurchase.source.network.pojo.response.OrderQueryByConditionResponse;
import id.dana.data.expresspurchase.source.network.pojo.response.QuickBuyDealsResponse;
import id.dana.data.expresspurchase.source.network.pojo.response.QuickBuyResponse;
import id.dana.data.expresspurchase.source.network.pojo.response.ValidateProductQuickResponse;
import id.dana.data.expresspurchase.source.network.pojo.response.ValidateProductResponse;
import id.dana.network.base.BaseSecureRestNetwork;
import id.dana.network.base.ResultResponse;
import id.dana.network.response.expresspurchase.ValidateProductGoldResponse;
import id.dana.utils.foundation.facede.ApSecurity;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00018B!\b\u0007\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u00100\u001a\u00020\u0002¢\u0006\u0004\b6\u00107J%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ-\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010Ja\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018JA\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0012H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00072\u0006\u0010\u001b\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 JK\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u00072\u0006\u0010\f\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010'J?\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u00072\u0006\u0010\f\u001a\u00020\u00042\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020)0\u0012H\u0016¢\u0006\u0004\b,\u0010-J%\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u00072\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b/\u0010\nR\u0014\u00100\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b0\u00101"}, d2 = {"Lid/dana/data/expresspurchase/source/network/NetworkExpressPurchaseEntityData;", "Lid/dana/network/base/BaseSecureRestNetwork;", "Lid/dana/data/expresspurchase/source/network/ExpressPurchaseApi;", "Lid/dana/data/expresspurchase/source/ExpressPurchaseEntityData;", "", "addonId", CashierKeyParams.CASHIER_ORDER_ID, "Lio/reactivex/Observable;", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse;", "getExpressPurchase", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "epTemplateType", "goodsId", UrlParam.REQUEST_ID, "Lid/dana/data/expresspurchase/source/network/pojo/response/QuickBuyDealsResponse;", "getQuickBuyDeals", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "aggregatorGoodsId", "", "extendInfo", "thirdRefId", "authCode", "Lid/dana/data/expresspurchase/source/network/pojo/response/QuickBuyResponse;", "getQuickBuyGold", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "getQuickBuyInsurance", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/Observable;", "acquirementId", "", "tableSet", "Lid/dana/data/expresspurchase/source/network/pojo/response/OrderQueryByConditionResponse;", "orderQueryByCondition", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "aggregatorId", "finType", "bizOrderId", "merchantTransId", "Lid/dana/data/expresspurchase/source/network/pojo/response/ValidateProductResponse;", "validateBundleProduct", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "validationTypes", "", "validationInfo", "Lid/dana/network/response/expresspurchase/ValidateProductGoldResponse;", "validateGoldProduct", "(Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)Lio/reactivex/Observable;", "Lid/dana/data/expresspurchase/source/network/pojo/response/ValidateProductQuickResponse;", "validateStandaloneProduct", "expressPurchaseApi", "Lid/dana/data/expresspurchase/source/network/ExpressPurchaseApi;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/utils/foundation/facede/ApSecurity;", "apSecurity", "<init>", "(Landroid/content/Context;Lid/dana/utils/foundation/facede/ApSecurity;Lid/dana/data/expresspurchase/source/network/ExpressPurchaseApi;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkExpressPurchaseEntityData extends BaseSecureRestNetwork<ExpressPurchaseApi> implements ExpressPurchaseEntityData {
    public static final String FLEXIBLE_CAPABILITY = "FLEXIBLE_CAPABILITY";
    private final ExpressPurchaseApi expressPurchaseApi;

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable getBottomSheetExpressPurchaseConfig() {
        return ExpressPurchaseEntityData.CC.$default$getBottomSheetExpressPurchaseConfig(this);
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable getBottomSheetExpressPurchaseGoldConfig() {
        return ExpressPurchaseEntityData.CC.$default$getBottomSheetExpressPurchaseGoldConfig(this);
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable getBottomSheetExpressPurchasePaylaterConfig() {
        return ExpressPurchaseEntityData.CC.$default$getBottomSheetExpressPurchasePaylaterConfig(this);
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable getLastOfferCancelAction(String str, String str2, String str3) {
        return ExpressPurchaseEntityData.CC.$default$getLastOfferCancelAction(this, str, str2, str3);
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable getLastOfferSucceedAction(String str, String str2) {
        return ExpressPurchaseEntityData.CC.$default$getLastOfferSucceedAction(this, str, str2);
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable getServiceEmasConfig() {
        return ExpressPurchaseEntityData.CC.$default$getServiceEmasConfig(this);
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable saveLastOfferCancelAction(String str, String str2, String str3) {
        return ExpressPurchaseEntityData.CC.$default$saveLastOfferCancelAction(this, str, str2, str3);
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable saveLastOfferSucceedAction(String str, String str2) {
        return ExpressPurchaseEntityData.CC.$default$saveLastOfferSucceedAction(this, str, str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkExpressPurchaseEntityData(Context context, ApSecurity apSecurity, ExpressPurchaseApi expressPurchaseApi) {
        super(context, apSecurity);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(apSecurity, "");
        Intrinsics.checkNotNullParameter(expressPurchaseApi, "");
        this.expressPurchaseApi = expressPurchaseApi;
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final Observable<GetExpressPurchaseResponse> getExpressPurchase(String addonId, String cashierOrderId) {
        Intrinsics.checkNotNullParameter(addonId, "");
        Intrinsics.checkNotNullParameter(cashierOrderId, "");
        final GetExpressPurchaseRequest getExpressPurchaseRequest = new GetExpressPurchaseRequest(addonId, cashierOrderId, FLEXIBLE_CAPABILITY);
        return wrapper(this.expressPurchaseApi, new Function1<ExpressPurchaseApi, Observable<ResultResponse<GetExpressPurchaseResponse>>>() { // from class: id.dana.data.expresspurchase.source.network.NetworkExpressPurchaseEntityData$getExpressPurchase$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Observable<ResultResponse<GetExpressPurchaseResponse>> invoke(ExpressPurchaseApi expressPurchaseApi) {
                Intrinsics.checkNotNullParameter(expressPurchaseApi, "");
                return expressPurchaseApi.getExpressPurchase(GetExpressPurchaseRequest.this);
            }
        });
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final Observable<ValidateProductQuickResponse> validateStandaloneProduct(String goodsId, String aggregatorGoodsId) {
        Intrinsics.checkNotNullParameter(goodsId, "");
        Intrinsics.checkNotNullParameter(aggregatorGoodsId, "");
        final ValidateProductQuickRequest validateProductQuickRequest = new ValidateProductQuickRequest(goodsId, aggregatorGoodsId);
        return wrapper(this.expressPurchaseApi, new Function1<ExpressPurchaseApi, Observable<ResultResponse<ValidateProductQuickResponse>>>() { // from class: id.dana.data.expresspurchase.source.network.NetworkExpressPurchaseEntityData$validateStandaloneProduct$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Observable<ResultResponse<ValidateProductQuickResponse>> invoke(ExpressPurchaseApi expressPurchaseApi) {
                Intrinsics.checkNotNullParameter(expressPurchaseApi, "");
                return expressPurchaseApi.validateProductQuick(ValidateProductQuickRequest.this);
            }
        });
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final Observable<ValidateProductResponse> validateBundleProduct(String goodsId, String aggregatorId, String aggregatorGoodsId, String finType, String bizOrderId, String merchantTransId) {
        Intrinsics.checkNotNullParameter(goodsId, "");
        Intrinsics.checkNotNullParameter(bizOrderId, "");
        Intrinsics.checkNotNullParameter(merchantTransId, "");
        final ValidateProductRequest validateProductRequest = new ValidateProductRequest(goodsId, aggregatorId, aggregatorGoodsId, finType, bizOrderId, merchantTransId);
        return wrapper(this.expressPurchaseApi, new Function1<ExpressPurchaseApi, Observable<ResultResponse<ValidateProductResponse>>>() { // from class: id.dana.data.expresspurchase.source.network.NetworkExpressPurchaseEntityData$validateBundleProduct$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Observable<ResultResponse<ValidateProductResponse>> invoke(ExpressPurchaseApi expressPurchaseApi) {
                Intrinsics.checkNotNullParameter(expressPurchaseApi, "");
                return expressPurchaseApi.validateProduct(ValidateProductRequest.this);
            }
        });
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final Observable<QuickBuyResponse> getQuickBuyInsurance(String goodsId, String requestId, String aggregatorGoodsId, Map<String, String> extendInfo) {
        Intrinsics.checkNotNullParameter(goodsId, "");
        Intrinsics.checkNotNullParameter(requestId, "");
        Intrinsics.checkNotNullParameter(aggregatorGoodsId, "");
        Intrinsics.checkNotNullParameter(extendInfo, "");
        final QuickBuyInsuranceRequest quickBuyInsuranceRequest = new QuickBuyInsuranceRequest(goodsId, requestId, aggregatorGoodsId, extendInfo);
        return wrapper(this.expressPurchaseApi, new Function1<ExpressPurchaseApi, Observable<ResultResponse<QuickBuyResponse>>>() { // from class: id.dana.data.expresspurchase.source.network.NetworkExpressPurchaseEntityData$getQuickBuyInsurance$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Observable<ResultResponse<QuickBuyResponse>> invoke(ExpressPurchaseApi expressPurchaseApi) {
                Intrinsics.checkNotNullParameter(expressPurchaseApi, "");
                return expressPurchaseApi.getQuickBuyInsurance(QuickBuyInsuranceRequest.this);
            }
        });
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final Observable<QuickBuyResponse> getQuickBuyGold(String goodsId, String requestId, String aggregatorGoodsId, Map<String, String> extendInfo, String cashierOrderId, String epTemplateType, String thirdRefId, String authCode) {
        Intrinsics.checkNotNullParameter(goodsId, "");
        Intrinsics.checkNotNullParameter(requestId, "");
        Intrinsics.checkNotNullParameter(aggregatorGoodsId, "");
        Intrinsics.checkNotNullParameter(extendInfo, "");
        Intrinsics.checkNotNullParameter(cashierOrderId, "");
        Intrinsics.checkNotNullParameter(epTemplateType, "");
        Intrinsics.checkNotNullParameter(thirdRefId, "");
        Intrinsics.checkNotNullParameter(authCode, "");
        final QuickBuyGoldRequest quickBuyGoldRequest = new QuickBuyGoldRequest(goodsId, requestId, aggregatorGoodsId, extendInfo, cashierOrderId, epTemplateType, thirdRefId, authCode);
        return wrapper(this.expressPurchaseApi, new Function1<ExpressPurchaseApi, Observable<ResultResponse<QuickBuyResponse>>>() { // from class: id.dana.data.expresspurchase.source.network.NetworkExpressPurchaseEntityData$getQuickBuyGold$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Observable<ResultResponse<QuickBuyResponse>> invoke(ExpressPurchaseApi expressPurchaseApi) {
                Intrinsics.checkNotNullParameter(expressPurchaseApi, "");
                return expressPurchaseApi.getQuickBuyGold(QuickBuyGoldRequest.this);
            }
        });
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final Observable<ValidateProductGoldResponse> validateGoldProduct(String goodsId, List<String> validationTypes, Map<String, ? extends Object> validationInfo) {
        Intrinsics.checkNotNullParameter(goodsId, "");
        Intrinsics.checkNotNullParameter(validationTypes, "");
        Intrinsics.checkNotNullParameter(validationInfo, "");
        final ValidateProductGoldRequest validateProductGoldRequest = new ValidateProductGoldRequest(goodsId, null, null, validationTypes, validationInfo, 6, null);
        return wrapper(this.expressPurchaseApi, new Function1<ExpressPurchaseApi, Observable<ResultResponse<ValidateProductGoldResponse>>>() { // from class: id.dana.data.expresspurchase.source.network.NetworkExpressPurchaseEntityData$validateGoldProduct$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Observable<ResultResponse<ValidateProductGoldResponse>> invoke(ExpressPurchaseApi expressPurchaseApi) {
                Intrinsics.checkNotNullParameter(expressPurchaseApi, "");
                return expressPurchaseApi.validateProductGold(ValidateProductGoldRequest.this);
            }
        });
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final Observable<QuickBuyDealsResponse> getQuickBuyDeals(String epTemplateType, String goodsId, String requestId) {
        Intrinsics.checkNotNullParameter(epTemplateType, "");
        Intrinsics.checkNotNullParameter(goodsId, "");
        Intrinsics.checkNotNullParameter(requestId, "");
        final QuickBuyDealsRequest quickBuyDealsRequest = new QuickBuyDealsRequest(epTemplateType, goodsId, requestId);
        return wrapper(this.expressPurchaseApi, new Function1<ExpressPurchaseApi, Observable<ResultResponse<QuickBuyDealsResponse>>>() { // from class: id.dana.data.expresspurchase.source.network.NetworkExpressPurchaseEntityData$getQuickBuyDeals$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Observable<ResultResponse<QuickBuyDealsResponse>> invoke(ExpressPurchaseApi expressPurchaseApi) {
                Intrinsics.checkNotNullParameter(expressPurchaseApi, "");
                return expressPurchaseApi.getQuickBuyDeals(QuickBuyDealsRequest.this);
            }
        });
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final Observable<OrderQueryByConditionResponse> orderQueryByCondition(String acquirementId, List<String> tableSet) {
        Intrinsics.checkNotNullParameter(acquirementId, "");
        Intrinsics.checkNotNullParameter(tableSet, "");
        final OrderQueryByConditionRequest orderQueryByConditionRequest = new OrderQueryByConditionRequest(acquirementId, tableSet);
        return wrapper(this.expressPurchaseApi, new Function1<ExpressPurchaseApi, Observable<ResultResponse<OrderQueryByConditionResponse>>>() { // from class: id.dana.data.expresspurchase.source.network.NetworkExpressPurchaseEntityData$orderQueryByCondition$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Observable<ResultResponse<OrderQueryByConditionResponse>> invoke(ExpressPurchaseApi expressPurchaseApi) {
                Intrinsics.checkNotNullParameter(expressPurchaseApi, "");
                return expressPurchaseApi.orderQueryByCondition(OrderQueryByConditionRequest.this);
            }
        });
    }
}
