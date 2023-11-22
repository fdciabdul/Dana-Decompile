package id.dana.requestmoney;

import id.dana.base.AbstractContract;
import id.dana.model.HomeInfo;
import id.dana.myprofile.model.QrisTciCoConfigModel;
import id.dana.requestmoney.model.RequestMoneyInfoModel;

/* loaded from: classes5.dex */
public interface RequestMoneyQrContract {

    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(String str, String str2);

        void PlaceComponentResult();

        void getAuthRequestContext();
    }

    /* loaded from: classes5.dex */
    public interface View {
        void BuiltInFictitiousFunctionClassFactory(QrisTciCoConfigModel qrisTciCoConfigModel);

        void BuiltInFictitiousFunctionClassFactory(RequestMoneyInfoModel requestMoneyInfoModel);

        void BuiltInFictitiousFunctionClassFactory(Long l);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str);

        void MyBillsEntityDataFactory(Long l);

        void PlaceComponentResult(HomeInfo homeInfo, String str);

        void getAuthRequestContext(String str);

        void getAuthRequestContext(String str, String str2, String str3, String str4, String str5);

        void getAuthRequestContext(boolean z);
    }
}
