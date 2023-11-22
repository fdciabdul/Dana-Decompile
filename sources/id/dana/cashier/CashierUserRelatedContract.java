package id.dana.cashier;

import id.dana.base.AbstractContractKt;
import id.dana.domain.useragreement.model.AgreementInfo;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cashier/CashierUserRelatedContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface CashierUserRelatedContract {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cashier/CashierUserRelatedContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;)V", "MyBillsEntityDataFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory(List<String> p0);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\bH&¢\u0006\u0004\b\u0006\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cashier/CashierUserRelatedContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "Lid/dana/domain/useragreement/model/AgreementInfo;", "p0", "", "PlaceComponentResult", "(Ljava/util/List;)V", "", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void PlaceComponentResult(List<AgreementInfo> p0);

        void PlaceComponentResult(boolean p0);
    }
}
