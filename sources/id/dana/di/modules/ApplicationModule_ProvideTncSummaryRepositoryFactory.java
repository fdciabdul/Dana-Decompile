package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.dialogtnc.TncEntitySummaryRepository;
import id.dana.domain.tncsummary.TncSummaryRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideTncSummaryRepositoryFactory implements Factory<TncSummaryRepository> {
    private final Provider<TncEntitySummaryRepository> MyBillsEntityDataFactory;
    private final ApplicationModule PlaceComponentResult;

    private ApplicationModule_ProvideTncSummaryRepositoryFactory(ApplicationModule applicationModule, Provider<TncEntitySummaryRepository> provider) {
        this.PlaceComponentResult = applicationModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ApplicationModule_ProvideTncSummaryRepositoryFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<TncEntitySummaryRepository> provider) {
        return new ApplicationModule_ProvideTncSummaryRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TncSummaryRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.PlaceComponentResult(this.MyBillsEntityDataFactory.get()));
    }
}
