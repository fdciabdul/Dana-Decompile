package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.richview.profile.switchautoroute.SwitchAutoRouteContract;
import id.dana.richview.profile.switchautoroute.SwitchAutoRoutePresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SwitchAutoRouteModule_ProvidePresenter$app_productionReleaseFactory implements Factory<SwitchAutoRouteContract.Presenter> {
    private final SwitchAutoRouteModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<SwitchAutoRoutePresenter> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SwitchAutoRouteContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.MyBillsEntityDataFactory.get()));
    }
}
