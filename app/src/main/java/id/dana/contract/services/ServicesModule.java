package id.dana.contract.services;

import dagger.Module;
import dagger.Provides;
import id.dana.base.AbstractContractKt;
import id.dana.contract.services.ServicesContract;
import id.dana.model.ThirdPartyService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\bR\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/contract/services/ServicesModule;", "", "Lid/dana/contract/services/ServicesPresenter;", "p0", "Lid/dana/contract/services/ServicesContract$Presenter;", "MyBillsEntityDataFactory", "(Lid/dana/contract/services/ServicesPresenter;)Lid/dana/contract/services/ServicesContract$Presenter;", "Lid/dana/contract/services/ServicesContract$View;", "()Lid/dana/contract/services/ServicesContract$View;", "PlaceComponentResult", "Lid/dana/contract/services/ServicesContract$View;", "<init>", "(Lid/dana/contract/services/ServicesContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes.dex */
public final class ServicesModule {
    private final ServicesContract.View PlaceComponentResult;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.contract.services.ServicesContract$View, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ServicesModule() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.services.ServicesModule.<init>():void");
    }

    public ServicesModule(ServicesContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.PlaceComponentResult = view;
    }

    public /* synthetic */ ServicesModule(ServicesContract.View view, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ServicesContract.View() { // from class: id.dana.contract.services.ServicesModule.1
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
            public final /* synthetic */ void onActionGet(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.MyBillsEntityDataFactory(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionMiniApp(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.PlaceComponentResult(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionPost(ThirdPartyService thirdPartyService, String str) {
                ServicesContract.View.CC.getAuthRequestContext(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onCheckFavoriteServicesFeature(boolean z) {
                ServicesContract.View.CC.PlaceComponentResult();
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
            public final /* synthetic */ void onFeatureServices(List list) {
                ServicesContract.View.CC.PlaceComponentResult(list);
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
            public final /* synthetic */ void onGetThirdPartyServices(List list) {
                ServicesContract.View.CC.getAuthRequestContext(list);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onMaintenanceAction(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onShowTooltip(boolean z) {
                ServicesContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }
        } : view);
    }

    @Provides
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final ServicesContract.View getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Provides
    public final ServicesContract.Presenter MyBillsEntityDataFactory(ServicesPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
