package id.dana.data.expresspurchase.source;

import id.dana.cashier.utils.CashierKeyParams;
import id.dana.data.constant.UrlParam;
import id.dana.data.expresspurchase.model.ExpressPurchaseConfigResult;
import id.dana.data.expresspurchase.model.ExpressPurchasePaylaterConfigResult;
import id.dana.data.expresspurchase.model.ServiceEmasConfigResult;
import id.dana.data.expresspurchase.source.network.pojo.response.GetExpressPurchaseResponse;
import id.dana.data.expresspurchase.source.network.pojo.response.OrderQueryByConditionResponse;
import id.dana.data.expresspurchase.source.network.pojo.response.QuickBuyDealsResponse;
import id.dana.data.expresspurchase.source.network.pojo.response.QuickBuyResponse;
import id.dana.data.expresspurchase.source.network.pojo.response.ValidateProductQuickResponse;
import id.dana.data.expresspurchase.source.network.pojo.response.ValidateProductResponse;
import id.dana.network.response.expresspurchase.ValidateProductGoldResponse;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\u0016J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J&\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0016JZ\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J:\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001bH\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0003H\u0016J$\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00032\u0006\u0010#\u001a\u00020\u000b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0%H\u0016J&\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00032\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u00032\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0016JD\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00032\u0006\u0010\u0015\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\b\u0010,\u001a\u0004\u0018\u00010\u000b2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000bH\u0016J8\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00032\u0006\u0010\u0015\u001a\u00020\u000b2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000b0%2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u001bH\u0016J\u001e\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00032\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00065À\u0006\u0001"}, d2 = {"Lid/dana/data/expresspurchase/source/ExpressPurchaseEntityData;", "", "getBottomSheetExpressPurchaseConfig", "Lio/reactivex/Observable;", "Lid/dana/data/expresspurchase/model/ExpressPurchaseConfigResult;", "getBottomSheetExpressPurchaseGoldConfig", "getBottomSheetExpressPurchasePaylaterConfig", "Lid/dana/data/expresspurchase/model/ExpressPurchasePaylaterConfigResult;", "getExpressPurchase", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse;", "addonId", "", CashierKeyParams.CASHIER_ORDER_ID, "getLastOfferCancelAction", "", "refUserId", "type", "getLastOfferSucceedAction", "getQuickBuyDeals", "Lid/dana/data/expresspurchase/source/network/pojo/response/QuickBuyDealsResponse;", "epTemplateType", "goodsId", UrlParam.REQUEST_ID, "getQuickBuyGold", "Lid/dana/data/expresspurchase/source/network/pojo/response/QuickBuyResponse;", "aggregatorGoodsId", "extendInfo", "", "thirdRefId", "authCode", "getQuickBuyInsurance", "getServiceEmasConfig", "Lid/dana/data/expresspurchase/model/ServiceEmasConfigResult;", "orderQueryByCondition", "Lid/dana/data/expresspurchase/source/network/pojo/response/OrderQueryByConditionResponse;", "acquirementId", "tableSet", "", "saveLastOfferCancelAction", "", "saveLastOfferSucceedAction", "validateBundleProduct", "Lid/dana/data/expresspurchase/source/network/pojo/response/ValidateProductResponse;", "aggregatorId", "finType", "bizOrderId", "merchantTransId", "validateGoldProduct", "Lid/dana/network/response/expresspurchase/ValidateProductGoldResponse;", "validationTypes", "validationInfo", "validateStandaloneProduct", "Lid/dana/data/expresspurchase/source/network/pojo/response/ValidateProductQuickResponse;", "data_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ExpressPurchaseEntityData {
    Observable<ExpressPurchaseConfigResult> getBottomSheetExpressPurchaseConfig();

    Observable<ExpressPurchaseConfigResult> getBottomSheetExpressPurchaseGoldConfig();

    Observable<ExpressPurchasePaylaterConfigResult> getBottomSheetExpressPurchasePaylaterConfig();

    Observable<GetExpressPurchaseResponse> getExpressPurchase(String addonId, String cashierOrderId);

    Observable<Long> getLastOfferCancelAction(String refUserId, String addonId, String type);

    Observable<Long> getLastOfferSucceedAction(String refUserId, String addonId);

    Observable<QuickBuyDealsResponse> getQuickBuyDeals(String epTemplateType, String goodsId, String requestId);

    Observable<QuickBuyResponse> getQuickBuyGold(String goodsId, String requestId, String aggregatorGoodsId, Map<String, String> extendInfo, String cashierOrderId, String epTemplateType, String thirdRefId, String authCode);

    Observable<QuickBuyResponse> getQuickBuyInsurance(String goodsId, String requestId, String aggregatorGoodsId, Map<String, String> extendInfo);

    Observable<ServiceEmasConfigResult> getServiceEmasConfig();

    Observable<OrderQueryByConditionResponse> orderQueryByCondition(String acquirementId, List<String> tableSet);

    Observable<Boolean> saveLastOfferCancelAction(String refUserId, String addonId, String type);

    Observable<Boolean> saveLastOfferSucceedAction(String refUserId, String addonId);

    Observable<ValidateProductResponse> validateBundleProduct(String goodsId, String aggregatorId, String aggregatorGoodsId, String finType, String bizOrderId, String merchantTransId);

    Observable<ValidateProductGoldResponse> validateGoldProduct(String goodsId, List<String> validationTypes, Map<String, ? extends Object> validationInfo);

    Observable<ValidateProductQuickResponse> validateStandaloneProduct(String goodsId, String aggregatorGoodsId);

    /* renamed from: id.dana.data.expresspurchase.source.ExpressPurchaseEntityData$-CC  reason: invalid class name */
    /* loaded from: classes4.dex */
    public final /* synthetic */ class CC {
        public static Observable $default$getBottomSheetExpressPurchaseConfig(ExpressPurchaseEntityData expressPurchaseEntityData) {
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getServiceEmasConfig(ExpressPurchaseEntityData expressPurchaseEntityData) {
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getBottomSheetExpressPurchaseGoldConfig(ExpressPurchaseEntityData expressPurchaseEntityData) {
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getBottomSheetExpressPurchasePaylaterConfig(ExpressPurchaseEntityData expressPurchaseEntityData) {
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getLastOfferCancelAction(ExpressPurchaseEntityData expressPurchaseEntityData, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getLastOfferSucceedAction(ExpressPurchaseEntityData expressPurchaseEntityData, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$saveLastOfferCancelAction(ExpressPurchaseEntityData expressPurchaseEntityData, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$saveLastOfferSucceedAction(ExpressPurchaseEntityData expressPurchaseEntityData, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getExpressPurchase(ExpressPurchaseEntityData expressPurchaseEntityData, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$validateStandaloneProduct(ExpressPurchaseEntityData expressPurchaseEntityData, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$validateBundleProduct(ExpressPurchaseEntityData expressPurchaseEntityData, String str, String str2, String str3, String str4, String str5, String str6) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str5, "");
            Intrinsics.checkNotNullParameter(str6, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getQuickBuyInsurance(ExpressPurchaseEntityData expressPurchaseEntityData, String str, String str2, String str3, Map map) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(map, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getQuickBuyGold(ExpressPurchaseEntityData expressPurchaseEntityData, String str, String str2, String str3, Map map, String str4, String str5, String str6, String str7) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(map, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            Intrinsics.checkNotNullParameter(str6, "");
            Intrinsics.checkNotNullParameter(str7, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$validateGoldProduct(ExpressPurchaseEntityData expressPurchaseEntityData, String str, List list, Map map) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(list, "");
            Intrinsics.checkNotNullParameter(map, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getQuickBuyDeals(ExpressPurchaseEntityData expressPurchaseEntityData, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$orderQueryByCondition(ExpressPurchaseEntityData expressPurchaseEntityData, String str, List list) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(list, "");
            throw new UnsupportedOperationException();
        }
    }
}
