package id.dana.challenge.verifypush;

import dagger.MembersInjector;
import id.dana.twilio.tracker.TwilioMixpanelTracker;

/* loaded from: classes4.dex */
public final class VerifyPushChallengeFragment_MembersInjector implements MembersInjector<VerifyPushChallengeFragment> {
    public static void PlaceComponentResult(VerifyPushChallengeFragment verifyPushChallengeFragment, VerifyPushLoginPresenter verifyPushLoginPresenter) {
        verifyPushChallengeFragment.verifyPushLoginPresenter = verifyPushLoginPresenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(VerifyPushChallengeFragment verifyPushChallengeFragment, TwilioMixpanelTracker twilioMixpanelTracker) {
        verifyPushChallengeFragment.twilioMixpanelTracker = twilioMixpanelTracker;
    }
}
