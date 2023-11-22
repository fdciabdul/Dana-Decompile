package id.dana.expresspurchase.presenter;

import id.dana.base.AbstractContractKt;
import id.dana.domain.expresspurchase.interaction.model.DealsShopInfo;
import id.dana.expresspurchase.model.ExpressPurchaseModel;
import id.dana.expresspurchase.model.OfferExpressPurchaseModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/expresspurchase/presenter/ExpressPurchaseContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ExpressPurchaseContract {

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J:\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0005H&J,\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0015H&J \u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0011H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006 À\u0006\u0001"}, d2 = {"Lid/dana/expresspurchase/presenter/ExpressPurchaseContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "getDealsShopLocation", "", "goodsId", "", "latitude", "longitude", "getOfferExpressPurchase", "offerExpressPurchaseModel", "Lid/dana/expresspurchase/model/OfferExpressPurchaseModel;", "queryOrder", "acquirementId", "expressPurchaseModel", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$Deals;", "quickBuyDeals", "quickBuyGold", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$Gold;", "validationTypes", "", "validationInfo", "", "", "thirdRefId", "quickBuyInsurance", "aggregatorGoodsId", "extendInfo", "saveLastActionToPref", "addonId", "action", "type", "validateGoldProduct", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2(OfferExpressPurchaseModel offerExpressPurchaseModel);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, String str3);

        void PlaceComponentResult(ExpressPurchaseModel.Deals deals);

        void PlaceComponentResult(ExpressPurchaseModel.Gold gold, List<String> list, Map<String, ? extends Object> map, String str);

        void getAuthRequestContext(ExpressPurchaseModel.Gold gold);

        void getAuthRequestContext(String str, String str2, String str3);

        void getAuthRequestContext(String str, String str2, Map<String, String> map);
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016JJ\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J$\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0019H\u0016J\u001a\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0019H\u0016J\u001a\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0019H\u0016J\"\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020 H\u0016J0\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010 H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006%À\u0006\u0001"}, d2 = {"Lid/dana/expresspurchase/presenter/ExpressPurchaseContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "dismissLoadingDialog", "", "goBackToConfirmationPage", "isPriceChange", "", "newPrice", "", "expressPurchaseModel", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$Gold;", "validationTypes", "", "validationInfo", "", "", "thirdRefId", "hideLoadingScreen", "onGetDealsShopLocationFailed", "onGetDealsShopLocationSuccess", "dealsShopInfo", "Lid/dana/domain/expresspurchase/interaction/model/DealsShopInfo;", "quickBuyDealsError", "errorMessage", "productCode", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$Deals;", "quickBuyDealsFail", "quickBuyDealsPending", "quickBuyDealsSuccess", "showChangedPriceDialog", "showLoadingScreen", "showOffer", "Lid/dana/expresspurchase/model/ExpressPurchaseModel;", "showPurchaseResult", "prevScreen", "result", "bizOrderId", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(String str, ExpressPurchaseModel.Deals deals);

        void BuiltInFictitiousFunctionClassFactory(String str, ExpressPurchaseModel.Gold gold, List<String> list, Map<String, ? extends Object> map, String str2);

        void BuiltInFictitiousFunctionClassFactory(String str, String str2, String str3, ExpressPurchaseModel expressPurchaseModel);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(ExpressPurchaseModel expressPurchaseModel);

        void MyBillsEntityDataFactory(DealsShopInfo dealsShopInfo);

        void MyBillsEntityDataFactory(String str, ExpressPurchaseModel.Deals deals);

        void PlaceComponentResult();

        void PlaceComponentResult(String str, ExpressPurchaseModel.Deals deals);

        void PlaceComponentResult(String str, String str2, ExpressPurchaseModel.Deals deals);

        void getAuthRequestContext();

        void getAuthRequestContext(boolean z, String str, ExpressPurchaseModel.Gold gold);

        /* renamed from: id.dana.expresspurchase.presenter.ExpressPurchaseContract$View$-CC  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
            public static void BuiltInFictitiousFunctionClassFactory() {
            }

            public static void BuiltInFictitiousFunctionClassFactory(ExpressPurchaseModel expressPurchaseModel) {
                Intrinsics.checkNotNullParameter(expressPurchaseModel, "");
            }

            public static void BuiltInFictitiousFunctionClassFactory(String str, ExpressPurchaseModel.Gold gold) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(gold, "");
            }

            public static void KClassImpl$Data$declaredNonStaticMembers$2() {
            }

            public static void KClassImpl$Data$declaredNonStaticMembers$2(String str, ExpressPurchaseModel.Deals deals) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(deals, "");
            }

            public static void MyBillsEntityDataFactory() {
            }

            public static void MyBillsEntityDataFactory(String str, ExpressPurchaseModel.Gold gold, List list, Map map, String str2) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(gold, "");
                Intrinsics.checkNotNullParameter(list, "");
                Intrinsics.checkNotNullParameter(map, "");
                Intrinsics.checkNotNullParameter(str2, "");
            }

            public static void PlaceComponentResult(String str, ExpressPurchaseModel.Deals deals) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(deals, "");
            }

            public static void getAuthRequestContext() {
            }

            public static void getAuthRequestContext(DealsShopInfo dealsShopInfo) {
                Intrinsics.checkNotNullParameter(dealsShopInfo, "");
            }

            public static void getAuthRequestContext(String str, ExpressPurchaseModel.Deals deals) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(deals, "");
            }

            public static void getAuthRequestContext(String str, String str2) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(str2, "");
            }

            public static void getAuthRequestContext(String str, String str2, ExpressPurchaseModel.Deals deals) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(str2, "");
                Intrinsics.checkNotNullParameter(deals, "");
            }

            public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(View view, String str, String str2, String str3, ExpressPurchaseModel expressPurchaseModel, int i) {
                if ((i & 4) != 0) {
                    str3 = "";
                }
                if ((i & 8) != 0) {
                    expressPurchaseModel = null;
                }
                view.BuiltInFictitiousFunctionClassFactory(str, str2, str3, expressPurchaseModel);
            }

            public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(View view, String str, String str2, ExpressPurchaseModel.Deals deals, int i) {
                if ((i & 1) != 0) {
                    str = "";
                }
                if ((i & 2) != 0) {
                    str2 = "";
                }
                view.PlaceComponentResult(str, str2, deals);
            }
        }
    }
}
