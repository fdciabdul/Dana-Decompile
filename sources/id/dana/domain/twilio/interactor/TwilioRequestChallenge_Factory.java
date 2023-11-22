package id.dana.domain.twilio.interactor;

import dagger.internal.Factory;
import id.dana.domain.twilio.TwilioRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class TwilioRequestChallenge_Factory implements Factory<TwilioRequestChallenge> {
    private final Provider<TwilioRepository> twilioRepositoryProvider;

    public TwilioRequestChallenge_Factory(Provider<TwilioRepository> provider) {
        this.twilioRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final TwilioRequestChallenge get() {
        return newInstance(this.twilioRepositoryProvider.get());
    }

    public static TwilioRequestChallenge_Factory create(Provider<TwilioRepository> provider) {
        return new TwilioRequestChallenge_Factory(provider);
    }

    public static TwilioRequestChallenge newInstance(TwilioRepository twilioRepository) {
        return new TwilioRequestChallenge(twilioRepository);
    }
}
