package id.dana.contract.deeplink;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.deeplink.DeepLinkContract;
import id.dana.contract.deeplink.InitSessionDeepLinkContract;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes8.dex */
public class InitSessionDeepLinkModule {
    private final DeepLinkContract.View PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public InitSessionDeepLinkContract.Presenter BuiltInFictitiousFunctionClassFactory(InitSessionDeepLinkPresenter initSessionDeepLinkPresenter) {
        return initSessionDeepLinkPresenter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public DeepLinkContract.View BuiltInFictitiousFunctionClassFactory() {
        return this.PlaceComponentResult;
    }
}
