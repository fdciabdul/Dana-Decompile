package id.dana.domain.expresspurchase.repository;

import id.dana.cashier.utils.CashierKeyParams;
import id.dana.data.constant.UrlParam;
import id.dana.domain.expresspurchase.interaction.model.AddonInfo;
import id.dana.domain.expresspurchase.interaction.model.DealsShopInfo;
import id.dana.domain.expresspurchase.interaction.model.ExpressPurchaseConfig;
import id.dana.domain.expresspurchase.interaction.model.ExpressPurchasePaylaterConfig;
import id.dana.domain.expresspurchase.interaction.model.GoldValidationInfo;
import id.dana.domain.expresspurchase.interaction.model.LatestExpressPurchaseAction;
import id.dana.domain.expresspurchase.interaction.model.OrderQueryResult;
import id.dana.domain.expresspurchase.interaction.model.QuickBuyDeals;
import id.dana.domain.expresspurchase.interaction.model.QuickBuyGold;
import id.dana.domain.expresspurchase.interaction.model.QuickBuyInsurance;
import id.dana.domain.expresspurchase.interaction.model.ServiceEmasConfig;
import id.dana.domain.expresspurchase.interaction.model.ValidateProduct;
import id.dana.domain.paylater.model.PaylaterAgreementConfig;
import id.dana.domain.paylater.model.PaylaterHomeInfo;
import id.dana.domain.promotion.Space;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006H&J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H&J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u000f\u001a\u00020\u0006H&J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003H&J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003H&J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003H&J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H&J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0003H&J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00032\u0006\u0010\u001c\u001a\u00020\u001dH&J.\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00032\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H&JR\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060&2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H&J2\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060&H&J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u0003H&J$\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00032\u0006\u0010/\u001a\u00020\u00062\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000601H&J\u001e\u00102\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H&J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\u0006\u0010\u000b\u001a\u00020\u0006H&JD\u00104\u001a\b\u0012\u0004\u0012\u0002050\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u00106\u001a\u0004\u0018\u00010\u00062\b\u0010!\u001a\u0004\u0018\u00010\u00062\b\u00107\u001a\u0004\u0018\u00010\u00062\u0006\u00108\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u0006H&J8\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u0006012\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010&H&J\u001e\u0010>\u001a\b\u0012\u0004\u0012\u0002050\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006?À\u0006\u0001"}, d2 = {"Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;", "", "dealsQueryShopLocation", "Lio/reactivex/Observable;", "Lid/dana/domain/expresspurchase/interaction/model/DealsShopInfo;", "goodsId", "", "latitude", "longitude", "getCashierAddonInfo", "Lid/dana/domain/expresspurchase/interaction/model/AddonInfo;", "addonId", CashierKeyParams.CASHIER_ORDER_ID, "getExpressPurchaseCdpContent", "Lid/dana/domain/promotion/Space;", "spaceCode", "getExpressPurchaseConfig", "Lid/dana/domain/expresspurchase/interaction/model/ExpressPurchaseConfig;", "getExpressPurchaseGoldConfig", "getExpressPurchasePaylaterConfig", "Lid/dana/domain/expresspurchase/interaction/model/ExpressPurchasePaylaterConfig;", "getLastExpressPurchaseAction", "Lid/dana/domain/expresspurchase/interaction/model/LatestExpressPurchaseAction;", "type", "getPaylaterAgreementConfig", "Lid/dana/domain/paylater/model/PaylaterAgreementConfig;", "getPaylaterHomeInfo", "Lid/dana/domain/paylater/model/PaylaterHomeInfo;", "skipBillInfo", "", "getQuickBuyDeals", "Lid/dana/domain/expresspurchase/interaction/model/QuickBuyDeals;", "epTemplateType", "aggregatorGoodsId", UrlParam.REQUEST_ID, "getQuickBuyGold", "Lid/dana/domain/expresspurchase/interaction/model/QuickBuyGold;", "extendInfo", "", "thirdRefId", "authCode", "getQuickBuyInsurance", "Lid/dana/domain/expresspurchase/interaction/model/QuickBuyInsurance;", "getServiceEmasConfig", "Lid/dana/domain/expresspurchase/interaction/model/ServiceEmasConfig;", "orderQueryByCondition", "Lid/dana/domain/expresspurchase/interaction/model/OrderQueryResult;", "acquirementId", "tableSet", "", "saveLastOfferCancelTransaction", "saveLastOfferSucceedTransaction", "validateBundleProduct", "Lid/dana/domain/expresspurchase/interaction/model/ValidateProduct;", "aggregatorId", "finType", "bizOrderId", "merchantTransId", "validateGoldProduct", "Lid/dana/domain/expresspurchase/interaction/model/GoldValidationInfo;", "validationTypes", "validationInfo", "validateStandaloneProduct", "domain_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ExpressPurchaseRepository {
    Observable<DealsShopInfo> dealsQueryShopLocation(String goodsId, String latitude, String longitude);

    Observable<AddonInfo> getCashierAddonInfo(String addonId, String cashierOrderId);

    Observable<Space> getExpressPurchaseCdpContent(String spaceCode);

    Observable<ExpressPurchaseConfig> getExpressPurchaseConfig();

    Observable<ExpressPurchaseConfig> getExpressPurchaseGoldConfig();

    Observable<ExpressPurchasePaylaterConfig> getExpressPurchasePaylaterConfig();

    Observable<LatestExpressPurchaseAction> getLastExpressPurchaseAction(String addonId, String type);

    Observable<PaylaterAgreementConfig> getPaylaterAgreementConfig();

    Observable<PaylaterHomeInfo> getPaylaterHomeInfo(boolean skipBillInfo);

    Observable<QuickBuyDeals> getQuickBuyDeals(String epTemplateType, String goodsId, String aggregatorGoodsId, String requestId);

    Observable<QuickBuyGold> getQuickBuyGold(String goodsId, String aggregatorGoodsId, Map<String, String> extendInfo, String cashierOrderId, String epTemplateType, String thirdRefId, String authCode);

    Observable<QuickBuyInsurance> getQuickBuyInsurance(String goodsId, String aggregatorGoodsId, Map<String, String> extendInfo);

    Observable<ServiceEmasConfig> getServiceEmasConfig();

    Observable<OrderQueryResult> orderQueryByCondition(String acquirementId, List<String> tableSet);

    Observable<Boolean> saveLastOfferCancelTransaction(String addonId, String type);

    Observable<Boolean> saveLastOfferSucceedTransaction(String addonId);

    Observable<ValidateProduct> validateBundleProduct(String goodsId, String aggregatorId, String aggregatorGoodsId, String finType, String bizOrderId, String merchantTransId);

    Observable<GoldValidationInfo> validateGoldProduct(String goodsId, List<String> validationTypes, Map<String, ? extends Object> validationInfo);

    Observable<ValidateProduct> validateStandaloneProduct(String goodsId, String aggregatorGoodsId);

    /* renamed from: id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository$-CC  reason: invalid class name */
    /* loaded from: classes8.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Observable dealsQueryShopLocation$default(ExpressPurchaseRepository expressPurchaseRepository, String str, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = "";
                }
                if ((i & 4) != 0) {
                    str3 = "";
                }
                return expressPurchaseRepository.dealsQueryShopLocation(str, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dealsQueryShopLocation");
        }
    }
}
