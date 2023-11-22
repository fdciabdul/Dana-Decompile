package id.dana.contract.deeplink.generation;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;

/* loaded from: classes4.dex */
public final class GenerateDeepLinkModule_ProvideProfileViewFactory implements Factory<GenerateDeepLinkContract.ProfileView> {
    private final GenerateDeepLinkModule getAuthRequestContext;

    private GenerateDeepLinkModule_ProvideProfileViewFactory(GenerateDeepLinkModule generateDeepLinkModule) {
        this.getAuthRequestContext = generateDeepLinkModule;
    }

    public static GenerateDeepLinkModule_ProvideProfileViewFactory MyBillsEntityDataFactory(GenerateDeepLinkModule generateDeepLinkModule) {
        return new GenerateDeepLinkModule_ProvideProfileViewFactory(generateDeepLinkModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GenerateDeepLinkContract.ProfileView) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2());
    }
}
