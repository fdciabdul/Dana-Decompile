package id.dana.contract.feeds;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.feeds.GlobalFeedsContract;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes4.dex */
public class GlobalFeedsModule {
    private final GlobalFeedsContract.View BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public GlobalFeedsContract.Presenter PlaceComponentResult(GlobalFeedsPresenter globalFeedsPresenter) {
        return globalFeedsPresenter;
    }

    public GlobalFeedsModule(GlobalFeedsContract.View view) {
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public GlobalFeedsContract.View BuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
