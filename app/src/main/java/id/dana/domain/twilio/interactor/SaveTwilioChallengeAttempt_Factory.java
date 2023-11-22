package id.dana.domain.twilio.interactor;

import dagger.internal.Factory;
import id.dana.domain.twilio.TwilioSdkRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveTwilioChallengeAttempt_Factory implements Factory<SaveTwilioChallengeAttempt> {
    private final Provider<TwilioSdkRepository> twilioSdkRepositoryProvider;

    public SaveTwilioChallengeAttempt_Factory(Provider<TwilioSdkRepository> provider) {
        this.twilioSdkRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveTwilioChallengeAttempt get() {
        return newInstance(this.twilioSdkRepositoryProvider.get());
    }

    public static SaveTwilioChallengeAttempt_Factory create(Provider<TwilioSdkRepository> provider) {
        return new SaveTwilioChallengeAttempt_Factory(provider);
    }

    public static SaveTwilioChallengeAttempt newInstance(TwilioSdkRepository twilioSdkRepository) {
        return new SaveTwilioChallengeAttempt(twilioSdkRepository);
    }
}
