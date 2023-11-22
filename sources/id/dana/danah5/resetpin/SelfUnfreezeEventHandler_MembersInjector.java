package id.dana.danah5.resetpin;

import dagger.MembersInjector;
import id.dana.domain.resetpin.interactor.GetResetAndChangePinNativeEntryConfig;
import id.dana.domain.resetpin.interactor.GetTempRegistrationPhoneNumber;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SelfUnfreezeEventHandler_MembersInjector implements MembersInjector<SelfUnfreezeEventHandler> {
    private final Provider<GetResetAndChangePinNativeEntryConfig> getResetAndChangePinNativeEntryConfigProvider;
    private final Provider<GetTempRegistrationPhoneNumber> getTempRegistrationPhoneNumberProvider;

    public SelfUnfreezeEventHandler_MembersInjector(Provider<GetResetAndChangePinNativeEntryConfig> provider, Provider<GetTempRegistrationPhoneNumber> provider2) {
        this.getResetAndChangePinNativeEntryConfigProvider = provider;
        this.getTempRegistrationPhoneNumberProvider = provider2;
    }

    public static MembersInjector<SelfUnfreezeEventHandler> create(Provider<GetResetAndChangePinNativeEntryConfig> provider, Provider<GetTempRegistrationPhoneNumber> provider2) {
        return new SelfUnfreezeEventHandler_MembersInjector(provider, provider2);
    }

    public final void injectMembers(SelfUnfreezeEventHandler selfUnfreezeEventHandler) {
        injectGetResetAndChangePinNativeEntryConfig(selfUnfreezeEventHandler, this.getResetAndChangePinNativeEntryConfigProvider.get());
        injectGetTempRegistrationPhoneNumber(selfUnfreezeEventHandler, this.getTempRegistrationPhoneNumberProvider.get());
    }

    public static void injectGetResetAndChangePinNativeEntryConfig(SelfUnfreezeEventHandler selfUnfreezeEventHandler, GetResetAndChangePinNativeEntryConfig getResetAndChangePinNativeEntryConfig) {
        selfUnfreezeEventHandler.getResetAndChangePinNativeEntryConfig = getResetAndChangePinNativeEntryConfig;
    }

    public static void injectGetTempRegistrationPhoneNumber(SelfUnfreezeEventHandler selfUnfreezeEventHandler, GetTempRegistrationPhoneNumber getTempRegistrationPhoneNumber) {
        selfUnfreezeEventHandler.getTempRegistrationPhoneNumber = getTempRegistrationPhoneNumber;
    }
}
