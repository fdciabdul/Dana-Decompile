package id.dana.domain.twilio.interactor;

import dagger.internal.Factory;
import id.dana.domain.twilio.TwilioRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SubmitTwilioDeroll_Factory implements Factory<SubmitTwilioDeroll> {
    private final Provider<TwilioRepository> twilioRepositoryProvider;

    public SubmitTwilioDeroll_Factory(Provider<TwilioRepository> provider) {
        this.twilioRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SubmitTwilioDeroll get() {
        return newInstance(this.twilioRepositoryProvider.get());
    }

    public static SubmitTwilioDeroll_Factory create(Provider<TwilioRepository> provider) {
        return new SubmitTwilioDeroll_Factory(provider);
    }

    public static SubmitTwilioDeroll newInstance(TwilioRepository twilioRepository) {
        return new SubmitTwilioDeroll(twilioRepository);
    }
}
