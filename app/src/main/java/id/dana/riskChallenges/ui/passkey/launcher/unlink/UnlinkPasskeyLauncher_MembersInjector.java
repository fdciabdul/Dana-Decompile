package id.dana.riskChallenges.ui.passkey.launcher.unlink;

import dagger.MembersInjector;
import id.dana.riskChallenges.domain.passkey.interactor.PasskeyRemoveCredential;

/* loaded from: classes5.dex */
public final class UnlinkPasskeyLauncher_MembersInjector implements MembersInjector<UnlinkPasskeyLauncher> {
    public static void PlaceComponentResult(UnlinkPasskeyLauncher unlinkPasskeyLauncher, PasskeyRemoveCredential passkeyRemoveCredential) {
        unlinkPasskeyLauncher.passkeyRemoveCredential = passkeyRemoveCredential;
    }
}
