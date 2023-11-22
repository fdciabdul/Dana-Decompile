package id.dana.splitbill;

import id.dana.base.AbstractContract;
import id.dana.splitbill.model.SplitBillHistoryModel;
import java.util.List;

/* loaded from: classes5.dex */
public interface SplitBillDetailContract {

    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2(String str);

        void getAuthRequestContext(List<String> list, String str);
    }

    /* loaded from: classes5.dex */
    public interface View extends AbstractContract.AbstractView {
        void BuiltInFictitiousFunctionClassFactory(boolean z);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(SplitBillHistoryModel splitBillHistoryModel);

        void MyBillsEntityDataFactory(String str, String str2, String str3, String str4);
    }
}
