package id.dana.contract.deeplink;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.deeplink.path.FeatureView;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FeatureModule_ProvideViewFactory implements Factory<FeatureContract.View> {
    private final FeatureModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FeatureView> getAuthRequestContext;

    private FeatureModule_ProvideViewFactory(FeatureModule featureModule, Provider<FeatureView> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = featureModule;
        this.getAuthRequestContext = provider;
    }

    public static FeatureModule_ProvideViewFactory PlaceComponentResult(FeatureModule featureModule, Provider<FeatureView> provider) {
        return new FeatureModule_ProvideViewFactory(featureModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FeatureContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.get()));
    }
}
