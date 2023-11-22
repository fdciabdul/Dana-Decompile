package id.dana.cardbinding.contract;

import id.dana.base.AbstractContractKt;
import id.dana.cashier.utils.CashierKeyParams;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cardbinding/contract/CardBindingContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public interface CardBindingContract {

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cardbinding/contract/CardBindingContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0007H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006'À\u0006\u0001"}, d2 = {"Lid/dana/cardbinding/contract/CardBindingContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "onErrorBindingCardAdd", "", "onErrorCardNotSupported", "onErrorCashierPay", "errorCode", "", "onErrorGetCashierMain", "onErrorQueryCardPolicy", "errorMessage", "onGetCardInfoSuccess", "cardInfo", "Lid/dana/cardbinding/model/BankCardInfoModel;", "onGetOneklikRedirectUrlError", "throwable", "", "onGetOneklikRedirectUrlSuccess", "url", "onIsFirstTimeOpenCardBinding", "isFirstTime", "", "scenario", "onSuccessBindingCardAdd", "checkoutUrl", "onSuccessCashierPay", CashierKeyParams.CASHIER_PAY_MODEL, "Lid/dana/cashier/model/CashierPayModel;", "onSuccessGetCashierMain", "cashierCheckoutModel", "Lid/dana/cashier/model/CashierCheckoutModel;", "onSuccessGetSupportedCardsConfig", "supportedCardsConfig", "Lid/dana/cardbinding/model/SupportedCardsConfigModel;", "onSuccessPayQuery", "onSuccessQueryCardPolicy", "queryCardPolicyInfoModel", "Lid/dana/cashier/model/QueryCardPolicyInfoModel;", "cardNumber", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public interface View extends AbstractContractKt.AbstractView {
    }
}
