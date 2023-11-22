package id.dana.savings.contract;

import id.dana.base.AbstractContractKt;
import id.dana.savings.contract.SavingCreateContract;
import id.dana.savings.model.SavingModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\nJ1\u0010\u0010\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/savings/contract/SavingCreateListener;", "Lid/dana/savings/contract/SavingCreateContract$View;", "Lid/dana/savings/model/SavingModel;", "p0", "", "MyBillsEntityDataFactory", "(Lid/dana/savings/model/SavingModel;)V", "", "PlaceComponentResult", "(Z)V", "()V", "", "", "p1", "p2", "p3", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class SavingCreateListener implements SavingCreateContract.View {
    @Override // id.dana.savings.contract.SavingCreateContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Throwable p0, String p1, String p2, String p3) {
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
    }

    @Override // id.dana.savings.contract.SavingCreateContract.View
    public final void MyBillsEntityDataFactory(SavingModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.savings.contract.SavingCreateContract.View
    public final void PlaceComponentResult() {
    }

    @Override // id.dana.savings.contract.SavingCreateContract.View
    public final void PlaceComponentResult(boolean p0) {
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
