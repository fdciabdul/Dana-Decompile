package id.dana.contract.deeplink.generation;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GenerateDeepLinkModule_ProvideProfilePresenterFactory implements Factory<GenerateDeepLinkContract.ProfilePresenter> {
    private final GenerateDeepLinkModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ProfileQrDeepLinkPresenter> MyBillsEntityDataFactory;

    private GenerateDeepLinkModule_ProvideProfilePresenterFactory(GenerateDeepLinkModule generateDeepLinkModule, Provider<ProfileQrDeepLinkPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = generateDeepLinkModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static GenerateDeepLinkModule_ProvideProfilePresenterFactory PlaceComponentResult(GenerateDeepLinkModule generateDeepLinkModule, Provider<ProfileQrDeepLinkPresenter> provider) {
        return new GenerateDeepLinkModule_ProvideProfilePresenterFactory(generateDeepLinkModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GenerateDeepLinkContract.ProfilePresenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get()));
    }
}
