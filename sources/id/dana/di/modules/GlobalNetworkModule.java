package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.globalnetwork.currency.GlobalNetworkContract;
import id.dana.globalnetwork.currency.GlobalNetworkPresenter;

@Module(includes = {GlobalNetworkTrackerModule.class})
/* loaded from: classes2.dex */
public class GlobalNetworkModule {
    private final GlobalNetworkContract.View MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public GlobalNetworkContract.Presenter BuiltInFictitiousFunctionClassFactory(GlobalNetworkPresenter globalNetworkPresenter) {
        return globalNetworkPresenter;
    }

    public GlobalNetworkModule(GlobalNetworkContract.View view) {
        this.MyBillsEntityDataFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public GlobalNetworkContract.View PlaceComponentResult() {
        return this.MyBillsEntityDataFactory;
    }
}
