package id.dana.bank.contract;

import id.dana.base.AbstractContractKt;
import id.dana.requestmoney.model.BankSelectorConfigModel;
import id.dana.sendmoney.model.BankModel;
import id.dana.sendmoney.model.WithdrawNameCheckModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/bank/contract/BankSelectorContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface BankSelectorContract {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/bank/contract/BankSelectorContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "Lid/dana/sendmoney/model/BankModel;", "p0", "Lid/dana/requestmoney/model/BankSelectorConfigModel;", "p1", "", "PlaceComponentResult", "(Lid/dana/sendmoney/model/BankModel;Lid/dana/requestmoney/model/BankSelectorConfigModel;)V", "", "MyBillsEntityDataFactory", "(Z)V", "(Lid/dana/requestmoney/model/BankSelectorConfigModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void MyBillsEntityDataFactory(BankSelectorConfigModel p0);

        void MyBillsEntityDataFactory(boolean p0);

        void PlaceComponentResult(BankModel p0, BankSelectorConfigModel p1);
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0003H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J$\u0010\u0013\u001a\u00020\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0017H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001bÀ\u0006\u0001"}, d2 = {"Lid/dana/bank/contract/BankSelectorContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "onBiztransferInitFailed", "", "onBiztransferInitSuccess", "onGetNameCheckConfig", "bankSelectorConfigModel", "Lid/dana/requestmoney/model/BankSelectorConfigModel;", "onNameCheck", "withdrawNameCheckModel", "Lid/dana/sendmoney/model/WithdrawNameCheckModel;", "onNameCheckCount", "count", "", "onNameCheckFreezeTime", "isFreeze", "", "onNameCheckSuccess", "onSavedBankExist", "onTrackDisplayedError", "throwable", "", "operationType", "", "displayedMessage", "showGeneralError", "message", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void BuiltInFictitiousFunctionClassFactory(WithdrawNameCheckModel withdrawNameCheckModel);

        void BuiltInFictitiousFunctionClassFactory(boolean z);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(int i);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(Throwable th, String str, String str2);

        void PlaceComponentResult(BankSelectorConfigModel bankSelectorConfigModel);

        void PlaceComponentResult(WithdrawNameCheckModel withdrawNameCheckModel);

        void getAuthRequestContext();
    }
}
