package id.dana.danah5.twilioverifysecurityproduct;

import dagger.internal.Factory;
import id.dana.domain.twilio.interactor.CheckTwilioEnrollmentStatus;
import id.dana.domain.twilio.interactor.TwilioRequestChallenge;
import id.dana.domain.twilio.interactor.TwilioVerifySecurityProduct;
import id.dana.domain.twilio.interactor.UpdateTwilioChallenge;
import id.dana.twilio.tracker.TwilioMixpanelTracker;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class TwilioVerifySecurityProductManager_Factory implements Factory<TwilioVerifySecurityProductManager> {
    private final Provider<CheckTwilioEnrollmentStatus> checkTwilioEnrollmentStatusProvider;
    private final Provider<TwilioMixpanelTracker> twilioMixpanelTrackerProvider;
    private final Provider<TwilioRequestChallenge> twilioRequestChallengeProvider;
    private final Provider<TwilioVerifySecurityProduct> twilioVerifySecurityProductProvider;
    private final Provider<UpdateTwilioChallenge> updateTwilioChallengeProvider;

    public TwilioVerifySecurityProductManager_Factory(Provider<CheckTwilioEnrollmentStatus> provider, Provider<TwilioRequestChallenge> provider2, Provider<TwilioVerifySecurityProduct> provider3, Provider<UpdateTwilioChallenge> provider4, Provider<TwilioMixpanelTracker> provider5) {
        this.checkTwilioEnrollmentStatusProvider = provider;
        this.twilioRequestChallengeProvider = provider2;
        this.twilioVerifySecurityProductProvider = provider3;
        this.updateTwilioChallengeProvider = provider4;
        this.twilioMixpanelTrackerProvider = provider5;
    }

    @Override // javax.inject.Provider
    public final TwilioVerifySecurityProductManager get() {
        return newInstance(this.checkTwilioEnrollmentStatusProvider.get(), this.twilioRequestChallengeProvider.get(), this.twilioVerifySecurityProductProvider.get(), this.updateTwilioChallengeProvider.get(), this.twilioMixpanelTrackerProvider.get());
    }

    public static TwilioVerifySecurityProductManager_Factory create(Provider<CheckTwilioEnrollmentStatus> provider, Provider<TwilioRequestChallenge> provider2, Provider<TwilioVerifySecurityProduct> provider3, Provider<UpdateTwilioChallenge> provider4, Provider<TwilioMixpanelTracker> provider5) {
        return new TwilioVerifySecurityProductManager_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static TwilioVerifySecurityProductManager newInstance(CheckTwilioEnrollmentStatus checkTwilioEnrollmentStatus, TwilioRequestChallenge twilioRequestChallenge, TwilioVerifySecurityProduct twilioVerifySecurityProduct, UpdateTwilioChallenge updateTwilioChallenge, TwilioMixpanelTracker twilioMixpanelTracker) {
        return new TwilioVerifySecurityProductManager(checkTwilioEnrollmentStatus, twilioRequestChallenge, twilioVerifySecurityProduct, updateTwilioChallenge, twilioMixpanelTracker);
    }
}
