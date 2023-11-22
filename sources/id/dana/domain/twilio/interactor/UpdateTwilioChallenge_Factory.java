package id.dana.domain.twilio.interactor;

import dagger.internal.Factory;
import id.dana.domain.twilio.TwilioSdkRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class UpdateTwilioChallenge_Factory implements Factory<UpdateTwilioChallenge> {
    private final Provider<TwilioSdkRepository> twilioSdkRepositoryProvider;

    public UpdateTwilioChallenge_Factory(Provider<TwilioSdkRepository> provider) {
        this.twilioSdkRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final UpdateTwilioChallenge get() {
        return newInstance(this.twilioSdkRepositoryProvider.get());
    }

    public static UpdateTwilioChallenge_Factory create(Provider<TwilioSdkRepository> provider) {
        return new UpdateTwilioChallenge_Factory(provider);
    }

    public static UpdateTwilioChallenge newInstance(TwilioSdkRepository twilioSdkRepository) {
        return new UpdateTwilioChallenge(twilioSdkRepository);
    }
}
