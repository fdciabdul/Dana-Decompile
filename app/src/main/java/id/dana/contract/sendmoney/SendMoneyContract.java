package id.dana.contract.sendmoney;

import id.dana.base.AbstractContract;
import id.dana.core.ui.model.UiTextModel;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.TransferAmountConfig;

/* loaded from: classes4.dex */
public interface SendMoneyContract {

    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void MyBillsEntityDataFactory(String str, String str2);

        void MyBillsEntityDataFactory(String str, boolean z);

        void PlaceComponentResult(TransferAmountConfig transferAmountConfig);

        void PlaceComponentResult(String str, RecipientModel recipientModel, String str2, String str3);

        void getAuthRequestContext(TransferInit transferInit, String str);

        void getAuthRequestContext(RecipientModel recipientModel, String str);
    }

    /* loaded from: classes4.dex */
    public interface View extends AbstractContract.AbstractView {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(UiTextModel uiTextModel);

        void BuiltInFictitiousFunctionClassFactory(RecipientModel recipientModel);

        void BuiltInFictitiousFunctionClassFactory(String str);

        void BuiltInFictitiousFunctionClassFactory(Throwable th);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(String str);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, String str3, String str4, String str5);

        void KClassImpl$Data$declaredNonStaticMembers$2(boolean z);

        void MyBillsEntityDataFactory(String str);

        void MyBillsEntityDataFactory(String str, String str2);

        void PlaceComponentResult(TransferInit transferInit);

        void PlaceComponentResult(RecipientModel recipientModel, String str);

        void PlaceComponentResult(Throwable th, String str, String str2, String str3);

        void getAuthRequestContext();

        void getAuthRequestContext(TransferInit transferInit);
    }
}
