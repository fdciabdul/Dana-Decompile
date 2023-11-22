package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.twilio.TwilioSdkEntityRepository;
import id.dana.domain.twilio.TwilioSdkRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideTwilioRepositoryFactory implements Factory<TwilioSdkRepository> {
    private final Provider<TwilioSdkEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule MyBillsEntityDataFactory;

    private ApplicationModule_ProvideTwilioRepositoryFactory(ApplicationModule applicationModule, Provider<TwilioSdkEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvideTwilioRepositoryFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<TwilioSdkEntityRepository> provider) {
        return new ApplicationModule_ProvideTwilioRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TwilioSdkRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
