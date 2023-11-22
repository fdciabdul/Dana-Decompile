package id.dana.savings.contract;

import id.dana.base.AbstractContractKt;
import id.dana.savings.contract.SavingUpdateContract;
import id.dana.savings.model.SavingModel;
import id.dana.savings.model.SavingUpdateInitModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/savings/contract/SavingUpdateListener;", "Lid/dana/savings/contract/SavingUpdateContract$View;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Z)V", "Lid/dana/savings/model/SavingUpdateInitModel;", "MyBillsEntityDataFactory", "(Lid/dana/savings/model/SavingUpdateInitModel;)V", "Lid/dana/savings/model/SavingModel;", "getAuthRequestContext", "(Lid/dana/savings/model/SavingModel;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class SavingUpdateListener implements SavingUpdateContract.View {
    @Override // id.dana.savings.contract.SavingUpdateContract.View
    public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
    }

    @Override // id.dana.savings.contract.SavingUpdateContract.View
    public final void MyBillsEntityDataFactory(SavingUpdateInitModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public /* synthetic */ void dismissProgress() {
        AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.savings.contract.SavingUpdateContract.View
    public final void getAuthRequestContext(SavingModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
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
