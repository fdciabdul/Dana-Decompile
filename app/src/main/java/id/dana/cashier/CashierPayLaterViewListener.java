package id.dana.cashier;

import id.dana.base.AbstractContractKt;
import id.dana.cashier.CashierPayLaterContract;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.PaylaterOnboardingContentModel;
import id.dana.cashier.model.QueryInstallmentModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u0012J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0012J%\u0010\u0014\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00130\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0007J\u0019\u0010\u0015\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0018J!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00192\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0006\u0010\u001aJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u001bJ\u001d\u0010\u0015\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0007"}, d2 = {"Lid/dana/cashier/CashierPayLaterViewListener;", "Lid/dana/cashier/CashierPayLaterContract$View;", "", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;)V", "", "", "p1", "", "p2", "PlaceComponentResult", "(IZLjava/lang/Throwable;)V", "p3", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V", "()V", "Lid/dana/cashier/model/CashierPayMethodModel;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "Lid/dana/cashier/model/PaylaterOnboardingContentModel;", "(Lid/dana/cashier/model/PaylaterOnboardingContentModel;IZ)V", "Lid/dana/cashier/model/QueryInstallmentModel;", "(Lid/dana/cashier/model/QueryInstallmentModel;Ljava/lang/Throwable;)V", "(IZ)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class CashierPayLaterViewListener implements CashierPayLaterContract.View {
    @Override // id.dana.cashier.CashierPayLaterContract.View
    public void BuiltInFictitiousFunctionClassFactory() {
    }

    @Override // id.dana.cashier.CashierPayLaterContract.View
    public void BuiltInFictitiousFunctionClassFactory(QueryInstallmentModel p0, Throwable p1) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.CashierPayLaterContract.View
    public void BuiltInFictitiousFunctionClassFactory(List<String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.CashierPayLaterContract.View
    public void KClassImpl$Data$declaredNonStaticMembers$2(int p0, boolean p1) {
    }

    @Override // id.dana.cashier.CashierPayLaterContract.View
    public void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
    }

    @Override // id.dana.cashier.CashierPayLaterContract.View
    public void KClassImpl$Data$declaredNonStaticMembers$2(List<String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.CashierPayLaterContract.View
    public void MyBillsEntityDataFactory() {
    }

    @Override // id.dana.cashier.CashierPayLaterContract.View
    public void MyBillsEntityDataFactory(String p0, Throwable p1, String p2, String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
    }

    @Override // id.dana.cashier.CashierPayLaterContract.View
    public void PlaceComponentResult(int p0, boolean p1, Throwable p2) {
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public /* synthetic */ void dismissProgress() {
        AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.cashier.CashierPayLaterContract.View
    public void getAuthRequestContext(PaylaterOnboardingContentModel p0, int p1, boolean p2) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.CashierPayLaterContract.View
    public void getAuthRequestContext(List<? extends CashierPayMethodModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
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
