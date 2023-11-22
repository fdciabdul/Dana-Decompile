package id.dana.contract.deeplink.generation;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;

/* loaded from: classes4.dex */
public final class GenerateDeepLinkModule_ProvideTransferViewFactory implements Factory<GenerateDeepLinkContract.TransferView> {
    private final GenerateDeepLinkModule KClassImpl$Data$declaredNonStaticMembers$2;

    private GenerateDeepLinkModule_ProvideTransferViewFactory(GenerateDeepLinkModule generateDeepLinkModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = generateDeepLinkModule;
    }

    public static GenerateDeepLinkModule_ProvideTransferViewFactory BuiltInFictitiousFunctionClassFactory(GenerateDeepLinkModule generateDeepLinkModule) {
        return new GenerateDeepLinkModule_ProvideTransferViewFactory(generateDeepLinkModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GenerateDeepLinkContract.TransferView) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext());
    }
}
