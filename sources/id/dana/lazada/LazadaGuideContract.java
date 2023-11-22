package id.dana.lazada;

import id.dana.base.AbstractContract;
import id.dana.domain.lazada.LazadaRegistrationUrl;
import id.dana.lazada.model.MiniAppParamsModel;

/* loaded from: classes5.dex */
public interface LazadaGuideContract {

    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory(String str, String str2);

        void MyBillsEntityDataFactory();

        void getAuthRequestContext();

        void getAuthRequestContext(MiniAppParamsModel miniAppParamsModel);
    }

    /* loaded from: classes5.dex */
    public interface View extends AbstractContract.AbstractView {
        void BuiltInFictitiousFunctionClassFactory(String str);

        void KClassImpl$Data$declaredNonStaticMembers$2(boolean z);

        void MyBillsEntityDataFactory(LazadaRegistrationUrl lazadaRegistrationUrl);

        void getAuthRequestContext(String str);
    }
}
