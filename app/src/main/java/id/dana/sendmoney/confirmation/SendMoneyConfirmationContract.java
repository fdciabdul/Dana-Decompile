package id.dana.sendmoney.confirmation;

import id.dana.base.AbstractContract;
import id.dana.domain.sendmoney.model.SendMoneyConfirm;
import id.dana.sendmoney.model.ConfirmToPeerParamModel;
import id.dana.sendmoney.model.ConfirmationModel;

/* loaded from: classes5.dex */
public interface SendMoneyConfirmationContract {

    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void KClassImpl$Data$declaredNonStaticMembers$2(ConfirmToPeerParamModel confirmToPeerParamModel, String str, String str2);

        void MyBillsEntityDataFactory(String str, String str2);

        void MyBillsEntityDataFactory(String str, String str2, String str3, String str4, String str5, int i, boolean z, String str6);

        void PlaceComponentResult(ConfirmationModel confirmationModel, String str);
    }

    /* loaded from: classes5.dex */
    public interface View extends AbstractContract.AbstractView {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(String str);

        void BuiltInFictitiousFunctionClassFactory(String str, String str2, String str3, Throwable th);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory(Long l);

        void MyBillsEntityDataFactory(boolean z);

        void PlaceComponentResult(SendMoneyConfirm sendMoneyConfirm);

        void PlaceComponentResult(String str);
    }
}
