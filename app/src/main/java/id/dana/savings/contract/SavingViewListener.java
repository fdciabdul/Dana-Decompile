package id.dana.savings.contract;

import id.dana.base.AbstractContractKt;
import id.dana.core.ui.model.UiTextModel;
import id.dana.domain.saving.model.SavingCreateInit;
import id.dana.savings.contract.SavingContract;
import id.dana.savings.model.SavingEmptyStateModel;
import id.dana.savings.model.SavingSummaryModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0005\u0010\u000fJ\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\t\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0005\u0010\u0011J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0012J/\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0007\u0010\u0018J\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u0012J\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0012"}, d2 = {"Lid/dana/savings/contract/SavingViewListener;", "Lid/dana/savings/contract/SavingContract$View;", "", "p0", "", "getAuthRequestContext", "(Z)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/savings/model/SavingEmptyStateModel;", "PlaceComponentResult", "(Lid/dana/savings/model/SavingEmptyStateModel;)V", "Lid/dana/savings/model/SavingSummaryModel;", "MyBillsEntityDataFactory", "(Lid/dana/savings/model/SavingSummaryModel;)V", "Lid/dana/core/ui/model/UiTextModel;", "(Lid/dana/core/ui/model/UiTextModel;)V", "Lid/dana/domain/saving/model/SavingCreateInit;", "(Lid/dana/domain/saving/model/SavingCreateInit;)V", "()V", "", "", "p1", "p2", "p3", "(Ljava/lang/Throwable;Ljava/lang/String;Lid/dana/core/ui/model/UiTextModel;Ljava/lang/String;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class SavingViewListener implements SavingContract.View {
    @Override // id.dana.savings.contract.SavingContract.View
    public void KClassImpl$Data$declaredNonStaticMembers$2(Throwable p0, String p1, UiTextModel p2, String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
    }

    @Override // id.dana.savings.contract.SavingContract.View
    public void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
    }

    @Override // id.dana.savings.contract.SavingContract.View
    public void MyBillsEntityDataFactory() {
    }

    @Override // id.dana.savings.contract.SavingContract.View
    public void MyBillsEntityDataFactory(SavingSummaryModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.savings.contract.SavingContract.View
    public void PlaceComponentResult() {
    }

    @Override // id.dana.savings.contract.SavingContract.View
    public void PlaceComponentResult(UiTextModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.savings.contract.SavingContract.View
    public void PlaceComponentResult(SavingEmptyStateModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public /* synthetic */ void dismissProgress() {
        AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.savings.contract.SavingContract.View
    public void getAuthRequestContext() {
    }

    @Override // id.dana.savings.contract.SavingContract.View
    public void getAuthRequestContext(UiTextModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.savings.contract.SavingContract.View
    public void getAuthRequestContext(SavingCreateInit p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.savings.contract.SavingContract.View
    public void getAuthRequestContext(boolean p0) {
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
