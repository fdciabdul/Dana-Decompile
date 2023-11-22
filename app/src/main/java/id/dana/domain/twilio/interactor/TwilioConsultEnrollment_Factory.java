package id.dana.domain.twilio.interactor;

import dagger.internal.Factory;
import id.dana.domain.twilio.TwilioRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class TwilioConsultEnrollment_Factory implements Factory<TwilioConsultEnrollment> {
    private final Provider<TwilioRepository> twilioRepositoryProvider;

    public TwilioConsultEnrollment_Factory(Provider<TwilioRepository> provider) {
        this.twilioRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final TwilioConsultEnrollment get() {
        return newInstance(this.twilioRepositoryProvider.get());
    }

    public static TwilioConsultEnrollment_Factory create(Provider<TwilioRepository> provider) {
        return new TwilioConsultEnrollment_Factory(provider);
    }

    public static TwilioConsultEnrollment newInstance(TwilioRepository twilioRepository) {
        return new TwilioConsultEnrollment(twilioRepository);
    }
}
