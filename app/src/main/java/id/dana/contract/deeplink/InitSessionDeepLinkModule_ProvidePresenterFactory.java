package id.dana.contract.deeplink;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.deeplink.InitSessionDeepLinkContract;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class InitSessionDeepLinkModule_ProvidePresenterFactory implements Factory<InitSessionDeepLinkContract.Presenter> {
    private final InitSessionDeepLinkModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<InitSessionDeepLinkPresenter> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (InitSessionDeepLinkContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.get()));
    }
}
