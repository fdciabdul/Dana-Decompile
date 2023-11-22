package id.dana.domain.twilio.interactor;

import dagger.internal.Factory;
import id.dana.domain.twilio.TwilioRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class IsTwilioForceLogout_Factory implements Factory<IsTwilioForceLogout> {
    private final Provider<TwilioRepository> twilioRepositoryProvider;

    public IsTwilioForceLogout_Factory(Provider<TwilioRepository> provider) {
        this.twilioRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final IsTwilioForceLogout get() {
        return newInstance(this.twilioRepositoryProvider.get());
    }

    public static IsTwilioForceLogout_Factory create(Provider<TwilioRepository> provider) {
        return new IsTwilioForceLogout_Factory(provider);
    }

    public static IsTwilioForceLogout newInstance(TwilioRepository twilioRepository) {
        return new IsTwilioForceLogout(twilioRepository);
    }
}
