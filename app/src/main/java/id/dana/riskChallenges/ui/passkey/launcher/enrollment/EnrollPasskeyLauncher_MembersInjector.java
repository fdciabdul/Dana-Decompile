package id.dana.riskChallenges.ui.passkey.launcher.enrollment;

import dagger.MembersInjector;
import id.dana.riskChallenges.domain.passkey.interactor.PasskeyEligibility;
import id.dana.riskChallenges.domain.passkey.interactor.PasskeyEnrollmentStatus;

/* loaded from: classes5.dex */
public final class EnrollPasskeyLauncher_MembersInjector implements MembersInjector<EnrollPasskeyLauncher> {
    public static void BuiltInFictitiousFunctionClassFactory(EnrollPasskeyLauncher enrollPasskeyLauncher, PasskeyEnrollmentStatus passkeyEnrollmentStatus) {
        enrollPasskeyLauncher.passkeyEnrollmentStatus = passkeyEnrollmentStatus;
    }

    public static void BuiltInFictitiousFunctionClassFactory(EnrollPasskeyLauncher enrollPasskeyLauncher, PasskeyEligibility passkeyEligibility) {
        enrollPasskeyLauncher.passkeyEligibility = passkeyEligibility;
    }
}
