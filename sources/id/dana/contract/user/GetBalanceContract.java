package id.dana.contract.user;

import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.domain.user.DanaHomeBalanceConfigModel;
import id.dana.model.CurrencyAmountModel;
import java.util.List;

/* loaded from: classes4.dex */
public interface GetBalanceContract {

    /* loaded from: classes2.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(String str);

        void PlaceComponentResult();

        void PlaceComponentResult(Boolean bool);
    }

    /* loaded from: classes2.dex */
    public interface View extends AbstractContractKt.AbstractView {

        /* renamed from: id.dana.contract.user.GetBalanceContract$View$-CC  reason: invalid class name */
        /* loaded from: classes4.dex */
        public final /* synthetic */ class CC {
            public static void BuiltInFictitiousFunctionClassFactory() {
            }

            public static void KClassImpl$Data$declaredNonStaticMembers$2() {
            }

            public static void MyBillsEntityDataFactory() {
            }

            public static void PlaceComponentResult() {
            }

            public static void getAuthRequestContext() {
            }

            public static void moveToNextValue() {
            }
        }

        void onGetAllBalanceState(List<Boolean> list);

        void onGetBalance(CurrencyAmountModel currencyAmountModel);

        void onGetBalanceDanaPlusActive(String str, String str2, DanaHomeBalanceConfigModel danaHomeBalanceConfigModel);

        void onGetBalanceDanaPlusError();

        void onGetBalanceDanaPlusUnActive(DanaHomeBalanceConfigModel danaHomeBalanceConfigModel);

        void onGetBalanceError();

        void onGetBalanceState(Boolean bool);
    }
}
