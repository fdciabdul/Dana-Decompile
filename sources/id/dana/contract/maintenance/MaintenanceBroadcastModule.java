package id.dana.contract.maintenance;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.maintenance.MaintenanceBroadcastContract;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes4.dex */
public class MaintenanceBroadcastModule {
    private final MaintenanceBroadcastContract.View BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public MaintenanceBroadcastContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(MaintenanceBroadcastPresenter maintenanceBroadcastPresenter) {
        return maintenanceBroadcastPresenter;
    }

    public MaintenanceBroadcastModule(MaintenanceBroadcastContract.View view) {
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public MaintenanceBroadcastContract.View getAuthRequestContext() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
