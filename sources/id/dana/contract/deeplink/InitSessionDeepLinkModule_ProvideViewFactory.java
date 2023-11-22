package id.dana.contract.deeplink;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.deeplink.DeepLinkContract;

/* loaded from: classes8.dex */
public final class InitSessionDeepLinkModule_ProvideViewFactory implements Factory<DeepLinkContract.View> {
    private final InitSessionDeepLinkModule getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DeepLinkContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory());
    }
}
