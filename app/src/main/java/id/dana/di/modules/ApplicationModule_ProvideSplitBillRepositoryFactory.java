package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.splitbill.repository.SplitBillEntityRepository;
import id.dana.domain.splitbill.repository.SplitBillRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideSplitBillRepositoryFactory implements Factory<SplitBillRepository> {
    private final ApplicationModule PlaceComponentResult;
    private final Provider<SplitBillEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideSplitBillRepositoryFactory(ApplicationModule applicationModule, Provider<SplitBillEntityRepository> provider) {
        this.PlaceComponentResult = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideSplitBillRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<SplitBillEntityRepository> provider) {
        return new ApplicationModule_ProvideSplitBillRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SplitBillRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.get()));
    }
}
