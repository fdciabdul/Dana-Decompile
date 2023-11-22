package id.dana.pushverify.view.verificationlist.list;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.pushverify.tracker.PushVerifyTracker;
import id.dana.pushverify.view.verificationlist.list.VerificationListContract;

/* loaded from: classes5.dex */
public final class VerificationListActiveFragment_MembersInjector implements MembersInjector<VerificationListActiveFragment> {
    public static void BuiltInFictitiousFunctionClassFactory(VerificationListActiveFragment verificationListActiveFragment, Lazy<VerificationListContract.Presenter> lazy) {
        verificationListActiveFragment.presenter = lazy;
    }

    public static void PlaceComponentResult(VerificationListActiveFragment verificationListActiveFragment, Lazy<PushVerifyTracker> lazy) {
        verificationListActiveFragment.pushVerifyTracker = lazy;
    }
}
