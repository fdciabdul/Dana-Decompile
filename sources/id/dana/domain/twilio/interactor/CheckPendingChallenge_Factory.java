package id.dana.domain.twilio.interactor;

import dagger.internal.Factory;
import id.dana.domain.twilio.TwilioSdkRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckPendingChallenge_Factory implements Factory<CheckPendingChallenge> {
    private final Provider<TwilioSdkRepository> twilioSdkRepositoryProvider;

    public CheckPendingChallenge_Factory(Provider<TwilioSdkRepository> provider) {
        this.twilioSdkRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckPendingChallenge get() {
        return newInstance(this.twilioSdkRepositoryProvider.get());
    }

    public static CheckPendingChallenge_Factory create(Provider<TwilioSdkRepository> provider) {
        return new CheckPendingChallenge_Factory(provider);
    }

    public static CheckPendingChallenge newInstance(TwilioSdkRepository twilioSdkRepository) {
        return new CheckPendingChallenge(twilioSdkRepository);
    }
}
