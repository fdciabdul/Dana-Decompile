package id.dana.riskChallenges.ui.passkey;

import dagger.internal.Factory;
import id.dana.analytics.tracker.passkey.PasskeyTrackerImpl;
import id.dana.riskChallenges.domain.otp.interactor.VerifyOtp;
import id.dana.riskChallenges.domain.passkey.interactor.PasskeyCeremonyStart;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class PasskeyVerificationViewModel_Factory implements Factory<PasskeyVerificationViewModel> {
    private final Provider<PasskeyCeremonyStart> MyBillsEntityDataFactory;
    private final Provider<PasskeyTrackerImpl> PlaceComponentResult;
    private final Provider<VerifyOtp> getAuthRequestContext;

    private PasskeyVerificationViewModel_Factory(Provider<PasskeyCeremonyStart> provider, Provider<VerifyOtp> provider2, Provider<PasskeyTrackerImpl> provider3) {
        this.MyBillsEntityDataFactory = provider;
        this.getAuthRequestContext = provider2;
        this.PlaceComponentResult = provider3;
    }

    public static PasskeyVerificationViewModel_Factory MyBillsEntityDataFactory(Provider<PasskeyCeremonyStart> provider, Provider<VerifyOtp> provider2, Provider<PasskeyTrackerImpl> provider3) {
        return new PasskeyVerificationViewModel_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PasskeyVerificationViewModel(this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get());
    }
}
