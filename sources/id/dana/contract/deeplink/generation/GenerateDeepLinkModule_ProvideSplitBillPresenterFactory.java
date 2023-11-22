package id.dana.contract.deeplink.generation;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GenerateDeepLinkModule_ProvideSplitBillPresenterFactory implements Factory<GenerateDeepLinkContract.SplitBillPresenter> {
    private final Provider<SplitBillQrDeepLinkPresenter> BuiltInFictitiousFunctionClassFactory;
    private final GenerateDeepLinkModule PlaceComponentResult;

    private GenerateDeepLinkModule_ProvideSplitBillPresenterFactory(GenerateDeepLinkModule generateDeepLinkModule, Provider<SplitBillQrDeepLinkPresenter> provider) {
        this.PlaceComponentResult = generateDeepLinkModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GenerateDeepLinkModule_ProvideSplitBillPresenterFactory getAuthRequestContext(GenerateDeepLinkModule generateDeepLinkModule, Provider<SplitBillQrDeepLinkPresenter> provider) {
        return new GenerateDeepLinkModule_ProvideSplitBillPresenterFactory(generateDeepLinkModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GenerateDeepLinkContract.SplitBillPresenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
