package id.dana.danah5.resetpin;

import dagger.MembersInjector;
import id.dana.domain.registration.interactor.GetPhoneNumberAttempt;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPhoneNumberBridge_MembersInjector implements MembersInjector<GetPhoneNumberBridge> {
    private final Provider<GetPhoneNumberAttempt> getPhoneNumberProvider;

    public GetPhoneNumberBridge_MembersInjector(Provider<GetPhoneNumberAttempt> provider) {
        this.getPhoneNumberProvider = provider;
    }

    public static MembersInjector<GetPhoneNumberBridge> create(Provider<GetPhoneNumberAttempt> provider) {
        return new GetPhoneNumberBridge_MembersInjector(provider);
    }

    public final void injectMembers(GetPhoneNumberBridge getPhoneNumberBridge) {
        injectGetPhoneNumber(getPhoneNumberBridge, this.getPhoneNumberProvider.get());
    }

    public static void injectGetPhoneNumber(GetPhoneNumberBridge getPhoneNumberBridge, GetPhoneNumberAttempt getPhoneNumberAttempt) {
        getPhoneNumberBridge.getPhoneNumber = getPhoneNumberAttempt;
    }
}
