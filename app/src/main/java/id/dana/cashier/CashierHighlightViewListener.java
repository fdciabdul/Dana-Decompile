package id.dana.cashier;

import id.dana.base.AbstractContractKt;
import id.dana.cashier.CashierHighlightContract;
import id.dana.cashier.domain.model.CashierHighlightCache;
import id.dana.cashier.model.CashierHighlightConfigModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u000e"}, d2 = {"Lid/dana/cashier/CashierHighlightViewListener;", "Lid/dana/cashier/CashierHighlightContract$View;", "Lid/dana/cashier/model/CashierHighlightConfigModel;", "p0", "", "p1", "p2", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cashier/model/CashierHighlightConfigModel;ZZ)V", "Lid/dana/cashier/domain/model/CashierHighlightCache;", "getAuthRequestContext", "(Lid/dana/cashier/domain/model/CashierHighlightCache;Z)V", "", "(Ljava/lang/String;Z)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class CashierHighlightViewListener implements CashierHighlightContract.View {
    @Override // id.dana.cashier.CashierHighlightContract.View
    public void BuiltInFictitiousFunctionClassFactory(CashierHighlightConfigModel p0, boolean p1, boolean p2) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.CashierHighlightContract.View
    public void BuiltInFictitiousFunctionClassFactory(String p0, boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public /* synthetic */ void dismissProgress() {
        AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.cashier.CashierHighlightContract.View
    public void getAuthRequestContext(CashierHighlightCache cashierHighlightCache, boolean z) {
        Intrinsics.checkNotNullParameter(cashierHighlightCache, "");
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
