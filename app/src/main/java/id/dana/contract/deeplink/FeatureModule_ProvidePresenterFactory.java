package id.dana.contract.deeplink;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.deeplink.path.FeaturePresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FeatureModule_ProvidePresenterFactory implements Factory<FeatureContract.Presenter> {
    private final Provider<FeaturePresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final FeatureModule getAuthRequestContext;

    private FeatureModule_ProvidePresenterFactory(FeatureModule featureModule, Provider<FeaturePresenter> provider) {
        this.getAuthRequestContext = featureModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static FeatureModule_ProvidePresenterFactory getAuthRequestContext(FeatureModule featureModule, Provider<FeaturePresenter> provider) {
        return new FeatureModule_ProvidePresenterFactory(featureModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FeatureContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
