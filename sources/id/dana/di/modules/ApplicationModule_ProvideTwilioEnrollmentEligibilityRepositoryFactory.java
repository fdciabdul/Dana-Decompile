package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.twilio.repository.TwilioEnrollmentEligibilityEntityRepository;
import id.dana.domain.twilio.TwilioEnrollmentEligibilityRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideTwilioEnrollmentEligibilityRepositoryFactory implements Factory<TwilioEnrollmentEligibilityRepository> {
    private final Provider<TwilioEnrollmentEligibilityEntityRepository> PlaceComponentResult;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvideTwilioEnrollmentEligibilityRepositoryFactory(ApplicationModule applicationModule, Provider<TwilioEnrollmentEligibilityEntityRepository> provider) {
        this.getAuthRequestContext = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvideTwilioEnrollmentEligibilityRepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<TwilioEnrollmentEligibilityEntityRepository> provider) {
        return new ApplicationModule_ProvideTwilioEnrollmentEligibilityRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TwilioEnrollmentEligibilityRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}
