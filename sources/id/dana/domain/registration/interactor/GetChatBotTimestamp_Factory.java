package id.dana.domain.registration.interactor;

import dagger.internal.Factory;
import id.dana.domain.registration.RegistrationRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetChatBotTimestamp_Factory implements Factory<GetChatBotTimestamp> {
    private final Provider<RegistrationRepository> registrationRepositoryProvider;

    public GetChatBotTimestamp_Factory(Provider<RegistrationRepository> provider) {
        this.registrationRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetChatBotTimestamp get() {
        return newInstance(this.registrationRepositoryProvider.get());
    }

    public static GetChatBotTimestamp_Factory create(Provider<RegistrationRepository> provider) {
        return new GetChatBotTimestamp_Factory(provider);
    }

    public static GetChatBotTimestamp newInstance(RegistrationRepository registrationRepository) {
        return new GetChatBotTimestamp(registrationRepository);
    }
}
