package id.dana.domain.twilio.interactor;

import dagger.internal.Factory;
import id.dana.domain.twilio.TwilioRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class TwilioEnrollment_Factory implements Factory<TwilioEnrollment> {
    private final Provider<TwilioRepository> twilioRepositoryProvider;

    public TwilioEnrollment_Factory(Provider<TwilioRepository> provider) {
        this.twilioRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final TwilioEnrollment get() {
        return newInstance(this.twilioRepositoryProvider.get());
    }

    public static TwilioEnrollment_Factory create(Provider<TwilioRepository> provider) {
        return new TwilioEnrollment_Factory(provider);
    }

    public static TwilioEnrollment newInstance(TwilioRepository twilioRepository) {
        return new TwilioEnrollment(twilioRepository);
    }
}
