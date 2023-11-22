package id.dana.riskChallenges.ui.danaprotection;

import dagger.MembersInjector;
import id.dana.riskChallenges.domain.danaprotection.interactor.GetRiskChallengeStatus;

/* loaded from: classes9.dex */
public final class ActivityVerificationLauncher_MembersInjector implements MembersInjector<ActivityVerificationLauncher> {
    public static void getAuthRequestContext(ActivityVerificationLauncher activityVerificationLauncher, GetRiskChallengeStatus getRiskChallengeStatus) {
        activityVerificationLauncher.getRiskChallengeStatus = getRiskChallengeStatus;
    }
}
