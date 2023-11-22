package id.dana.data.twilio.repository;

import dagger.internal.Factory;
import id.dana.data.config.repository.FeatureConfigEntityRepository;
import id.dana.data.twilio.TwilioSdkEntityRepository;
import id.dana.data.twilio.repository.source.TwilioConsultBackendPreferencesDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class TwilioEnrollmentEligibilityEntityRepository_Factory implements Factory<TwilioEnrollmentEligibilityEntityRepository> {
    private final Provider<TwilioSdkEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<TwilioEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FeatureConfigEntityRepository> MyBillsEntityDataFactory;
    private final Provider<TwilioConsultBackendPreferencesDataFactory> PlaceComponentResult;

    private TwilioEnrollmentEligibilityEntityRepository_Factory(Provider<FeatureConfigEntityRepository> provider, Provider<TwilioSdkEntityRepository> provider2, Provider<TwilioEntityRepository> provider3, Provider<TwilioConsultBackendPreferencesDataFactory> provider4) {
        this.MyBillsEntityDataFactory = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.PlaceComponentResult = provider4;
    }

    public static TwilioEnrollmentEligibilityEntityRepository_Factory PlaceComponentResult(Provider<FeatureConfigEntityRepository> provider, Provider<TwilioSdkEntityRepository> provider2, Provider<TwilioEntityRepository> provider3, Provider<TwilioConsultBackendPreferencesDataFactory> provider4) {
        return new TwilioEnrollmentEligibilityEntityRepository_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TwilioEnrollmentEligibilityEntityRepository(this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get());
    }
}
