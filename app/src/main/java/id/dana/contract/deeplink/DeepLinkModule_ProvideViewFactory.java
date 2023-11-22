package id.dana.contract.deeplink;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.deeplink.DeepLinkContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DeepLinkModule_ProvideViewFactory implements Factory<DeepLinkContract.View> {
    private final DeepLinkModule PlaceComponentResult;
    private final Provider<DeepLinkView> getAuthRequestContext;

    private DeepLinkModule_ProvideViewFactory(DeepLinkModule deepLinkModule, Provider<DeepLinkView> provider) {
        this.PlaceComponentResult = deepLinkModule;
        this.getAuthRequestContext = provider;
    }

    public static DeepLinkModule_ProvideViewFactory PlaceComponentResult(DeepLinkModule deepLinkModule, Provider<DeepLinkView> provider) {
        return new DeepLinkModule_ProvideViewFactory(deepLinkModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DeepLinkContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.get()));
    }
}
