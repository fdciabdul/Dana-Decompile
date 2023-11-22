package id.dana.sendmoney.confirmation;

import id.dana.base.AbstractContract;
import id.dana.domain.sendmoney.model.SendMoneyConfirm;
import id.dana.sendmoney.model.ConfirmToBankParamModel;
import id.dana.sendmoney.model.RecentBankModel;

/* loaded from: classes5.dex */
public interface SendMoneyConfirmationBankContract {

    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory(RecentBankModel recentBankModel);

        void getAuthRequestContext(ConfirmToBankParamModel confirmToBankParamModel, String str, String str2);

        void getAuthRequestContext(String str);
    }

    /* loaded from: classes5.dex */
    public interface View extends AbstractContract.AbstractView {
        void BuiltInFictitiousFunctionClassFactory(SendMoneyConfirm sendMoneyConfirm);

        void BuiltInFictitiousFunctionClassFactory(boolean z);

        void getAuthRequestContext(String str);
    }
}
