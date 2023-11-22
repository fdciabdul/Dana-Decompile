package id.dana.contract.paylater;

import id.dana.base.AbstractContractKt;
import id.dana.contract.paylater.PayLaterContract;
import id.dana.model.ThirdPartyService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004"}, d2 = {"Lid/dana/contract/paylater/PayLaterViewListener;", "Lid/dana/contract/paylater/PayLaterContract$View;", "", "getAuthRequestContext", "()V", "", "Lid/dana/model/ThirdPartyService;", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;)V", "MyBillsEntityDataFactory", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class PayLaterViewListener implements PayLaterContract.View {
    @Override // id.dana.contract.paylater.PayLaterContract.View
    public void BuiltInFictitiousFunctionClassFactory(List<ThirdPartyService> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.contract.paylater.PayLaterContract.View
    public void MyBillsEntityDataFactory() {
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public /* synthetic */ void dismissProgress() {
        AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.contract.paylater.PayLaterContract.View
    public void getAuthRequestContext() {
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
