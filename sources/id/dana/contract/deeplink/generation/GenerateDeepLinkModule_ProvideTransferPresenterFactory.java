package id.dana.contract.deeplink.generation;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GenerateDeepLinkModule_ProvideTransferPresenterFactory implements Factory<GenerateDeepLinkContract.TransferPresenter> {
    private final GenerateDeepLinkModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<TransferQrDeepLinkPresenter> getAuthRequestContext;

    private GenerateDeepLinkModule_ProvideTransferPresenterFactory(GenerateDeepLinkModule generateDeepLinkModule, Provider<TransferQrDeepLinkPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = generateDeepLinkModule;
        this.getAuthRequestContext = provider;
    }

    public static GenerateDeepLinkModule_ProvideTransferPresenterFactory getAuthRequestContext(GenerateDeepLinkModule generateDeepLinkModule, Provider<TransferQrDeepLinkPresenter> provider) {
        return new GenerateDeepLinkModule_ProvideTransferPresenterFactory(generateDeepLinkModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GenerateDeepLinkContract.TransferPresenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.getAuthRequestContext.get()));
    }
}
