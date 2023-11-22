package id.dana.contract.payasset;

import id.dana.base.AbstractContract;
import id.dana.pay.PayCardInfo;
import id.dana.pay.model.PayCardConfigModel;
import java.util.List;

/* loaded from: classes4.dex */
public interface QueryPayMethodContract {

    /* loaded from: classes2.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(boolean z);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void PlaceComponentResult();

        void PlaceComponentResult(boolean z);

        void getAuthRequestContext();
    }

    /* loaded from: classes2.dex */
    public interface View extends AbstractContract.AbstractView {
        void BuiltInFictitiousFunctionClassFactory(String str, String str2, List<PayCardInfo> list);

        void MyBillsEntityDataFactory(int i);

        void MyBillsEntityDataFactory(Boolean bool);

        void PlaceComponentResult(PayCardConfigModel payCardConfigModel);

        void getAuthRequestContext();
    }
}
