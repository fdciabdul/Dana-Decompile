package id.dana.cashier;

import id.dana.base.AbstractContractKt;
import id.dana.cashier.CashierUserRelatedContract;
import id.dana.domain.useragreement.model.AgreementInfo;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0006\u0010\t"}, d2 = {"Lid/dana/cashier/CashierUserRelatedViewListener;", "Lid/dana/cashier/CashierUserRelatedContract$View;", "", "Lid/dana/domain/useragreement/model/AgreementInfo;", "p0", "", "PlaceComponentResult", "(Ljava/util/List;)V", "", "(Z)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class CashierUserRelatedViewListener implements CashierUserRelatedContract.View {
    @Override // id.dana.cashier.CashierUserRelatedContract.View
    public void PlaceComponentResult(List<AgreementInfo> p0) {
    }

    @Override // id.dana.cashier.CashierUserRelatedContract.View
    public void PlaceComponentResult(boolean p0) {
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public /* synthetic */ void dismissProgress() {
        AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public /* synthetic */ void onError(String str) {
        AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public /* synthetic */ void showProgress() {
        AbstractContractKt.AbstractView.CC.PlaceComponentResult();
    }
}
