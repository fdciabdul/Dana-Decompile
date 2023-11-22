package id.dana.mybills;

import id.dana.base.AbstractContractKt;
import id.dana.contract.services.ServicesContract;
import id.dana.model.ThirdPartyService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0006"}, d2 = {"Lid/dana/mybills/ServiceModuleViewListener;", "Lid/dana/contract/services/ServicesContract$View;", "Lid/dana/model/ThirdPartyService;", "p0", "", "onActionGet", "(Lid/dana/model/ThirdPartyService;)V", "", "p1", "onActionPost", "(Lid/dana/model/ThirdPartyService;Ljava/lang/String;)V", "", "onCheckFavoriteServicesFeature", "(Z)V", "", "onFeatureServices", "(Ljava/util/List;)V", "", "onGetThirdPartyServices", "onMaintenanceAction", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ServiceModuleViewListener implements ServicesContract.View {
    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void dismissProgress() {
        AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.contract.services.ServicesContract.View
    public final /* synthetic */ void onActionFailed(String str) {
        ServicesContract.View.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.contract.services.ServicesContract.View
    public final void onActionGet(ThirdPartyService p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.contract.services.ServicesContract.View
    public final /* synthetic */ void onActionMiniApp(ThirdPartyService thirdPartyService) {
        ServicesContract.View.CC.PlaceComponentResult(thirdPartyService);
    }

    @Override // id.dana.contract.services.ServicesContract.View
    public final void onActionPost(ThirdPartyService p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.contract.services.ServicesContract.View
    public final void onCheckFavoriteServicesFeature(boolean p0) {
    }

    @Override // id.dana.contract.services.ServicesContract.View
    public final /* synthetic */ void onDirectOpen(ThirdPartyService thirdPartyService, Map map) {
        Intrinsics.checkNotNullParameter(thirdPartyService, "");
    }

    @Override // id.dana.contract.services.ServicesContract.View
    public final /* synthetic */ void onEmptySearchService() {
        ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void onError(String str) {
        AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.contract.services.ServicesContract.View
    public final void onFeatureServices(List<ThirdPartyService> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.contract.services.ServicesContract.View
    public final /* synthetic */ void onGetFilteredThirdPartyServices(List list) {
        ServicesContract.View.CC.MyBillsEntityDataFactory(list);
    }

    @Override // id.dana.contract.services.ServicesContract.View
    public final /* synthetic */ void onGetInitThirdPartyServices(List list) {
        Intrinsics.checkNotNullParameter(list, "");
    }

    @Override // id.dana.contract.services.ServicesContract.View
    public final void onGetThirdPartyServices(List<ThirdPartyService> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.contract.services.ServicesContract.View
    public final void onMaintenanceAction(ThirdPartyService p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.contract.services.ServicesContract.View
    public final /* synthetic */ void onShowTooltip(boolean z) {
        ServicesContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void showProgress() {
        AbstractContractKt.AbstractView.CC.PlaceComponentResult();
    }
}
