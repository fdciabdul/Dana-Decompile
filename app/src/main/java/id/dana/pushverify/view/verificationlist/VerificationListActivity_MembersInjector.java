package id.dana.pushverify.view.verificationlist;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.pushverify.view.verificationlist.VerificationListMainContract;

/* loaded from: classes5.dex */
public final class VerificationListActivity_MembersInjector implements MembersInjector<VerificationListActivity> {
    public static void BuiltInFictitiousFunctionClassFactory(VerificationListActivity verificationListActivity, Lazy<VerificationListMainContract.Presenter> lazy) {
        verificationListActivity.presenter = lazy;
    }
}
