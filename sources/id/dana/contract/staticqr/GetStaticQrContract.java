package id.dana.contract.staticqr;

import id.dana.base.AbstractContract;
import id.dana.myprofile.model.QrisTciCoConfigModel;

/* loaded from: classes4.dex */
public interface GetStaticQrContract {

    /* loaded from: classes2.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void PlaceComponentResult();

        void getAuthRequestContext();
    }

    /* loaded from: classes2.dex */
    public interface View extends AbstractContract.AbstractView {
        void KClassImpl$Data$declaredNonStaticMembers$2(String str);

        void PlaceComponentResult(String str, String str2, String str3, String str4, String str5);

        void getAuthRequestContext(QrisTciCoConfigModel qrisTciCoConfigModel);

        void getAuthRequestContext(Long l);
    }
}
