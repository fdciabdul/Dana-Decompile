package id.dana.contract.deeplink.generation;

import id.dana.base.AbstractContract;
import id.dana.domain.splitbill.model.SplitBill;

/* loaded from: classes4.dex */
public interface GenerateDeepLinkContract {

    /* loaded from: classes2.dex */
    public interface ProfilePresenter extends AbstractContract.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, String str3, boolean z);
    }

    /* loaded from: classes2.dex */
    public interface ProfileView extends AbstractContract.AbstractView {
        void KClassImpl$Data$declaredNonStaticMembers$2(String str);

        void MyBillsEntityDataFactory(Long l);

        void PlaceComponentResult();
    }

    /* loaded from: classes4.dex */
    public interface SplitBillPresenter extends AbstractContract.AbstractPresenter {
        void MyBillsEntityDataFactory(SplitBill splitBill, String str, String str2);
    }

    /* loaded from: classes4.dex */
    public interface SplitBillView extends AbstractContract.AbstractView {
        void MyBillsEntityDataFactory(String str, String str2);

        void PlaceComponentResult(String str, String str2, String str3, String str4);
    }

    /* loaded from: classes4.dex */
    public interface TransferPresenter extends AbstractContract.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, String str3);
    }

    /* loaded from: classes4.dex */
    public interface TransferView extends AbstractContract.AbstractView {
        void BuiltInFictitiousFunctionClassFactory(String str);

        void getAuthRequestContext(Long l);
    }
}
