package id.dana.challenge.pin;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.challenge.botprotection.BotProtectionChallenge;
import id.dana.challenge.pin.AbstractPinContract;
import id.dana.data.dynamicurl.DynamicUrlWrapper;

/* loaded from: classes4.dex */
public final class PinChallengeFragment_MembersInjector implements MembersInjector<PinChallengeFragment> {
    public static void getAuthRequestContext(PinChallengeFragment pinChallengeFragment, DynamicUrlWrapper dynamicUrlWrapper) {
        pinChallengeFragment.dynamicUrlWrapper = dynamicUrlWrapper;
    }

    public static void MyBillsEntityDataFactory(PinChallengeFragment pinChallengeFragment, AbstractPinContract.Presenter presenter) {
        pinChallengeFragment.presenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(PinChallengeFragment pinChallengeFragment, Lazy<BotProtectionChallenge> lazy) {
        pinChallengeFragment.botProtectionChallenge = lazy;
    }
}
