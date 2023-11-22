package id.dana.pushverify.view.verificationlist.list;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.pushverify.tracker.PushVerifyTracker;
import id.dana.pushverify.view.verificationlist.list.VerificationListContract;

/* loaded from: classes5.dex */
public final class VerificationListHistoryFragment_MembersInjector implements MembersInjector<VerificationListHistoryFragment> {
    public static void BuiltInFictitiousFunctionClassFactory(VerificationListHistoryFragment verificationListHistoryFragment, Lazy<VerificationListContract.Presenter> lazy) {
        verificationListHistoryFragment.presenter = lazy;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(VerificationListHistoryFragment verificationListHistoryFragment, Lazy<PushVerifyTracker> lazy) {
        verificationListHistoryFragment.pushVerifyTracker = lazy;
    }
}
