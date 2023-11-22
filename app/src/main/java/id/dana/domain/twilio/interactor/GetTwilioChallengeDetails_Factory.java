package id.dana.domain.twilio.interactor;

import dagger.internal.Factory;
import id.dana.domain.twilio.TwilioSdkRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetTwilioChallengeDetails_Factory implements Factory<GetTwilioChallengeDetails> {
    private final Provider<TwilioSdkRepository> twilioSdkRepositoryProvider;

    public GetTwilioChallengeDetails_Factory(Provider<TwilioSdkRepository> provider) {
        this.twilioSdkRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetTwilioChallengeDetails get() {
        return newInstance(this.twilioSdkRepositoryProvider.get());
    }

    public static GetTwilioChallengeDetails_Factory create(Provider<TwilioSdkRepository> provider) {
        return new GetTwilioChallengeDetails_Factory(provider);
    }

    public static GetTwilioChallengeDetails newInstance(TwilioSdkRepository twilioSdkRepository) {
        return new GetTwilioChallengeDetails(twilioSdkRepository);
    }
}
