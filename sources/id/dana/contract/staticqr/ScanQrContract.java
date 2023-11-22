package id.dana.contract.staticqr;

import id.dana.base.AbstractContract;
import id.dana.cashier.model.featureTime.FeatureTimeModel;
import id.dana.domain.oauth.model.QrBindingConfig;
import id.dana.model.ScanModel;
import java.util.List;

/* loaded from: classes4.dex */
public interface ScanQrContract {

    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory(String str, String str2, String str3, boolean z, boolean z2);

        void PlaceComponentResult();

        void getAuthRequestContext();

        void getAuthRequestContext(String str, String str2);

        boolean getAuthRequestContext(String str);
    }

    /* loaded from: classes4.dex */
    public interface View extends AbstractContract.AbstractView {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(ScanModel scanModel);

        void BuiltInFictitiousFunctionClassFactory(String str);

        void BuiltInFictitiousFunctionClassFactory(boolean z, String str);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(List<String> list);

        FeatureTimeModel MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(boolean z);

        String PlaceComponentResult();

        void PlaceComponentResult(ScanModel scanModel);

        void PlaceComponentResult(String str);

        void PlaceComponentResult(String str, String str2, String str3, Throwable th);

        void PlaceComponentResult(boolean z);

        void getAuthRequestContext();

        void getAuthRequestContext(QrBindingConfig qrBindingConfig);

        void getAuthRequestContext(ScanModel scanModel, boolean z);

        void getErrorConfigVersion();

        void moveToNextValue();
    }
}
