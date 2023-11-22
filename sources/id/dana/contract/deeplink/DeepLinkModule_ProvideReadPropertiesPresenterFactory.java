package id.dana.contract.deeplink;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DeepLinkModule_ProvideReadPropertiesPresenterFactory implements Factory<ReadLinkPropertiesContract.Presenter> {
    private final DeepLinkModule MyBillsEntityDataFactory;
    private final Provider<ReadLinkPropertiesPresenter> getAuthRequestContext;

    private DeepLinkModule_ProvideReadPropertiesPresenterFactory(DeepLinkModule deepLinkModule, Provider<ReadLinkPropertiesPresenter> provider) {
        this.MyBillsEntityDataFactory = deepLinkModule;
        this.getAuthRequestContext = provider;
    }

    public static DeepLinkModule_ProvideReadPropertiesPresenterFactory getAuthRequestContext(DeepLinkModule deepLinkModule, Provider<ReadLinkPropertiesPresenter> provider) {
        return new DeepLinkModule_ProvideReadPropertiesPresenterFactory(deepLinkModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ReadLinkPropertiesContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.get()));
    }
}
