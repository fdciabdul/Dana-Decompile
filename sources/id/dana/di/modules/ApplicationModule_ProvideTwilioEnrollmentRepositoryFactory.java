package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.twilio.repository.TwilioEntityRepository;
import id.dana.domain.twilio.TwilioRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideTwilioEnrollmentRepositoryFactory implements Factory<TwilioRepository> {
    private final ApplicationModule PlaceComponentResult;
    private final Provider<TwilioEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideTwilioEnrollmentRepositoryFactory(ApplicationModule applicationModule, Provider<TwilioEntityRepository> provider) {
        this.PlaceComponentResult = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideTwilioEnrollmentRepositoryFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<TwilioEntityRepository> provider) {
        return new ApplicationModule_ProvideTwilioEnrollmentRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TwilioRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.MyBillsEntityDataFactory(this.getAuthRequestContext.get()));
    }
}
