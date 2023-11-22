package id.dana.contract.deeplink.generation;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;

/* loaded from: classes4.dex */
public final class GenerateDeepLinkModule_ProvideSplitBillViewFactory implements Factory<GenerateDeepLinkContract.SplitBillView> {
    private final GenerateDeepLinkModule BuiltInFictitiousFunctionClassFactory;

    private GenerateDeepLinkModule_ProvideSplitBillViewFactory(GenerateDeepLinkModule generateDeepLinkModule) {
        this.BuiltInFictitiousFunctionClassFactory = generateDeepLinkModule;
    }

    public static GenerateDeepLinkModule_ProvideSplitBillViewFactory MyBillsEntityDataFactory(GenerateDeepLinkModule generateDeepLinkModule) {
        return new GenerateDeepLinkModule_ProvideSplitBillViewFactory(generateDeepLinkModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GenerateDeepLinkContract.SplitBillView) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory());
    }
}
