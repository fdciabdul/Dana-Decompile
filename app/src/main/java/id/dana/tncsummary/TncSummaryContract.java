package id.dana.tncsummary;

import id.dana.base.AbstractContract;
import id.dana.domain.useragreement.model.AgreementInfo;
import java.util.List;

/* loaded from: classes5.dex */
public interface TncSummaryContract {

    /* loaded from: classes3.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2(List<String> list);

        void MyBillsEntityDataFactory();

        void getAuthRequestContext();
    }

    /* loaded from: classes3.dex */
    public interface View extends AbstractContract.AbstractView {
        void KClassImpl$Data$declaredNonStaticMembers$2(List<AgreementInfo> list);

        void PlaceComponentResult(boolean z);
    }
}
