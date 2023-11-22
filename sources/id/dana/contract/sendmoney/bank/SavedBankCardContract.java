package id.dana.contract.sendmoney.bank;

import id.dana.base.AbstractContract;
import id.dana.sendmoney.model.RecentBankModel;
import java.util.List;

/* loaded from: classes4.dex */
public interface SavedBankCardContract {

    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(String str);

        void PlaceComponentResult();
    }

    /* loaded from: classes4.dex */
    public interface View {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(List<RecentBankModel> list);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void PlaceComponentResult(List<RecentBankModel> list);

        void getAuthRequestContext();

        void getAuthRequestContext(int i);

        void getAuthRequestContext(List<RecentBankModel> list);
    }
}
