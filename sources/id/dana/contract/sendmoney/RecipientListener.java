package id.dana.contract.sendmoney;

import id.dana.base.AbstractContractKt;
import id.dana.contract.sendmoney.RecipientContract;
import id.dana.domain.sendmoney.model.SmartFrictionConfig;
import id.dana.sendmoney.model.RecentRecipientModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\fJ!\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/contract/sendmoney/RecipientListener;", "Lid/dana/contract/sendmoney/RecipientContract$View;", "", "dismissProgress", "()V", "", "p0", "", "p1", "onFinishCheckReferralSendMoney", "(ZLjava/lang/String;)V", "onGetFeatureBelowKitkatConfigSuccess", "(Z)V", "Lid/dana/domain/sendmoney/model/SmartFrictionConfig;", "onGetSmartFrictionConfig", "(Lid/dana/domain/sendmoney/model/SmartFrictionConfig;)V", "onSuccessRemoveOldFavoriteState", "Lid/dana/sendmoney/model/RecentRecipientModel;", "onSuccessUpdateFavoriteState", "(ZLid/dana/sendmoney/model/RecentRecipientModel;)V", "showProgress"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public class RecipientListener implements RecipientContract.View {
    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public /* synthetic */ void onError(String str) {
        AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.contract.sendmoney.RecipientContract.View
    public void onFinishCheckReferralSendMoney(boolean p0, String p1) {
        Intrinsics.checkNotNullParameter(p1, "");
    }

    @Override // id.dana.contract.sendmoney.RecipientContract.View
    public void onGetFeatureBelowKitkatConfigSuccess(boolean p0) {
    }

    @Override // id.dana.contract.sendmoney.RecipientContract.View
    public void onGetSmartFrictionConfig(SmartFrictionConfig p0) {
    }

    @Override // id.dana.contract.sendmoney.RecipientContract.View
    public void onSuccessRemoveOldFavoriteState(boolean p0) {
    }

    @Override // id.dana.contract.sendmoney.RecipientContract.View
    public void onSuccessUpdateFavoriteState(boolean p0, RecentRecipientModel p1) {
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
    }
}
