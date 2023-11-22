package id.dana.data.electronicmoney;

import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ElectronicmoneyEntityRepository_Factory implements Factory<ElectronicmoneyEntityRepository> {
    private final Provider<ConfigEntityDataFactory> BuiltInFictitiousFunctionClassFactory;
    private final Provider<HoldLoginV1EntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ElectronicmoneyEntityDataFactory> getAuthRequestContext;

    private ElectronicmoneyEntityRepository_Factory(Provider<ElectronicmoneyEntityDataFactory> provider, Provider<ConfigEntityDataFactory> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        this.getAuthRequestContext = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
    }

    public static ElectronicmoneyEntityRepository_Factory getAuthRequestContext(Provider<ElectronicmoneyEntityDataFactory> provider, Provider<ConfigEntityDataFactory> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        return new ElectronicmoneyEntityRepository_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ElectronicmoneyEntityRepository(this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
