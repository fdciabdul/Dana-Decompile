package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.H5Launcher;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MerchantDetailMenuModule_ProvideH5LauncherFactory implements Factory<H5Launcher> {
    private final MerchantDetailMenuModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<DynamicUrlWrapper> MyBillsEntityDataFactory;

    private MerchantDetailMenuModule_ProvideH5LauncherFactory(MerchantDetailMenuModule merchantDetailMenuModule, Provider<DynamicUrlWrapper> provider) {
        this.BuiltInFictitiousFunctionClassFactory = merchantDetailMenuModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static MerchantDetailMenuModule_ProvideH5LauncherFactory BuiltInFictitiousFunctionClassFactory(MerchantDetailMenuModule merchantDetailMenuModule, Provider<DynamicUrlWrapper> provider) {
        return new MerchantDetailMenuModule_ProvideH5LauncherFactory(merchantDetailMenuModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (H5Launcher) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.MyBillsEntityDataFactory.get()));
    }
}
