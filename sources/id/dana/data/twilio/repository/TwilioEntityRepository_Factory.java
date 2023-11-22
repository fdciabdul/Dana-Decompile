package id.dana.data.twilio.repository;

import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.security.source.SecurityEntityDataFactory;
import id.dana.data.twilio.repository.source.TwilioEnrollmentEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class TwilioEntityRepository_Factory implements Factory<TwilioEntityRepository> {
    private final Provider<TwilioEnrollmentEntityDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SecurityEntityDataFactory> MyBillsEntityDataFactory;
    private final Provider<ConfigEntityDataFactory> PlaceComponentResult;

    private TwilioEntityRepository_Factory(Provider<TwilioEnrollmentEntityDataFactory> provider, Provider<ConfigEntityDataFactory> provider2, Provider<SecurityEntityDataFactory> provider3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.PlaceComponentResult = provider2;
        this.MyBillsEntityDataFactory = provider3;
    }

    public static TwilioEntityRepository_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<TwilioEnrollmentEntityDataFactory> provider, Provider<ConfigEntityDataFactory> provider2, Provider<SecurityEntityDataFactory> provider3) {
        return new TwilioEntityRepository_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TwilioEntityRepository(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get());
    }
}
