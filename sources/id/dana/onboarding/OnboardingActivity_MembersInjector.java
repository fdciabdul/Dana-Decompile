package id.dana.onboarding;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.onboarding.OnboardingContract;

/* loaded from: classes5.dex */
public final class OnboardingActivity_MembersInjector implements MembersInjector<OnboardingActivity> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(OnboardingActivity onboardingActivity, Lazy<OnboardingContract.Presenter> lazy) {
        onboardingActivity.presenter = lazy;
    }
}
