package id.dana.danah5.twilioverifysecurityproduct;

import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class TwilioVerifySecurityProductBridge_MembersInjector implements MembersInjector<TwilioVerifySecurityProductBridge> {
    private final Provider<TwilioVerifySecurityProductManager> twilioVerifySecurityProductManagerProvider;

    public TwilioVerifySecurityProductBridge_MembersInjector(Provider<TwilioVerifySecurityProductManager> provider) {
        this.twilioVerifySecurityProductManagerProvider = provider;
    }

    public static MembersInjector<TwilioVerifySecurityProductBridge> create(Provider<TwilioVerifySecurityProductManager> provider) {
        return new TwilioVerifySecurityProductBridge_MembersInjector(provider);
    }

    public final void injectMembers(TwilioVerifySecurityProductBridge twilioVerifySecurityProductBridge) {
        injectTwilioVerifySecurityProductManager(twilioVerifySecurityProductBridge, this.twilioVerifySecurityProductManagerProvider.get());
    }

    public static void injectTwilioVerifySecurityProductManager(TwilioVerifySecurityProductBridge twilioVerifySecurityProductBridge, TwilioVerifySecurityProductManager twilioVerifySecurityProductManager) {
        twilioVerifySecurityProductBridge.twilioVerifySecurityProductManager = twilioVerifySecurityProductManager;
    }
}
