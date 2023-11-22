package id.dana.cashier;

import id.dana.base.AbstractContractKt;
import id.dana.cashier.CashierAddOnContract;
import id.dana.cashier.model.CashierAddOnModalContentModel;
import id.dana.cashier.model.CashierAddOnModalTooltipModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/cashier/CashierAddOnViewListener;", "Lid/dana/cashier/CashierAddOnContract$View;", "Lid/dana/cashier/model/CashierAddOnModalTooltipModel;", "p0", "Lid/dana/cashier/model/CashierAddOnModalContentModel;", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/cashier/model/CashierAddOnModalTooltipModel;Lid/dana/cashier/model/CashierAddOnModalContentModel;)V", "", "p2", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class CashierAddOnViewListener implements CashierAddOnContract.View {
    @Override // id.dana.cashier.CashierAddOnContract.View
    public void BuiltInFictitiousFunctionClassFactory(String p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
    }

    @Override // id.dana.cashier.CashierAddOnContract.View
    public void KClassImpl$Data$declaredNonStaticMembers$2(CashierAddOnModalTooltipModel p0, CashierAddOnModalContentModel p1) {
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
