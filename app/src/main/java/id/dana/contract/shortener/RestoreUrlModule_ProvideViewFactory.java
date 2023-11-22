package id.dana.contract.shortener;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.shortener.RestoreUrlContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RestoreUrlModule_ProvideViewFactory implements Factory<RestoreUrlContract.View> {
    private final Provider<RestoreUrlView> BuiltInFictitiousFunctionClassFactory;
    private final RestoreUrlModule getAuthRequestContext;

    private RestoreUrlModule_ProvideViewFactory(RestoreUrlModule restoreUrlModule, Provider<RestoreUrlView> provider) {
        this.getAuthRequestContext = restoreUrlModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static RestoreUrlModule_ProvideViewFactory PlaceComponentResult(RestoreUrlModule restoreUrlModule, Provider<RestoreUrlView> provider) {
        return new RestoreUrlModule_ProvideViewFactory(restoreUrlModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (RestoreUrlContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
