package id.dana.domain.twilio.interactor;

import dagger.internal.Factory;
import id.dana.domain.twilio.TwilioSdkRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetTwilioChallengeHiddenDetails_Factory implements Factory<GetTwilioChallengeHiddenDetails> {
    private final Provider<TwilioSdkRepository> twilioSdkRepositoryProvider;

    public GetTwilioChallengeHiddenDetails_Factory(Provider<TwilioSdkRepository> provider) {
        this.twilioSdkRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetTwilioChallengeHiddenDetails get() {
        return newInstance(this.twilioSdkRepositoryProvider.get());
    }

    public static GetTwilioChallengeHiddenDetails_Factory create(Provider<TwilioSdkRepository> provider) {
        return new GetTwilioChallengeHiddenDetails_Factory(provider);
    }

    public static GetTwilioChallengeHiddenDetails newInstance(TwilioSdkRepository twilioSdkRepository) {
        return new GetTwilioChallengeHiddenDetails(twilioSdkRepository);
    }
}
