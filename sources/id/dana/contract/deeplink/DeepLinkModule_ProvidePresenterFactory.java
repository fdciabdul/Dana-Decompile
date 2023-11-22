package id.dana.contract.deeplink;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.deeplink.DeepLinkContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DeepLinkModule_ProvidePresenterFactory implements Factory<DeepLinkContract.Presenter> {
    private final Provider<DeepLinkPresenter> BuiltInFictitiousFunctionClassFactory;
    private final DeepLinkModule KClassImpl$Data$declaredNonStaticMembers$2;

    private DeepLinkModule_ProvidePresenterFactory(DeepLinkModule deepLinkModule, Provider<DeepLinkPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = deepLinkModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static DeepLinkModule_ProvidePresenterFactory getAuthRequestContext(DeepLinkModule deepLinkModule, Provider<DeepLinkPresenter> provider) {
        return new DeepLinkModule_ProvidePresenterFactory(deepLinkModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DeepLinkContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
