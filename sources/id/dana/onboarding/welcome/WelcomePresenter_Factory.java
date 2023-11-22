package id.dana.onboarding.welcome;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.analytics.tracker.register.RegistrationTracker;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class WelcomePresenter_Factory implements Factory<WelcomePresenter> {
    private final Provider<RegistrationTracker> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new WelcomePresenter(DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
    }
}
