package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.referraltracker.ReferralTrackerEntityRepository;
import id.dana.domain.referraltracker.ReferralTrackerRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ReferralTrackerRepositoryFactory implements Factory<ReferralTrackerRepository> {
    private final Provider<ReferralTrackerEntityRepository> MyBillsEntityDataFactory;
    private final ApplicationModule PlaceComponentResult;

    private ApplicationModule_ReferralTrackerRepositoryFactory(ApplicationModule applicationModule, Provider<ReferralTrackerEntityRepository> provider) {
        this.PlaceComponentResult = applicationModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ApplicationModule_ReferralTrackerRepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<ReferralTrackerEntityRepository> provider) {
        return new ApplicationModule_ReferralTrackerRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ReferralTrackerRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.get()));
    }
}
