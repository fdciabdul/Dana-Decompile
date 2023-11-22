package id.dana.pushverify.view.verificationdetail;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.pushverify.view.verificationdetail.PushVerifyContract;

/* loaded from: classes5.dex */
public final class PushVerifyActivity_MembersInjector implements MembersInjector<PushVerifyActivity> {
    public static void BuiltInFictitiousFunctionClassFactory(PushVerifyActivity pushVerifyActivity, Lazy<PushVerifyContract.Presenter> lazy) {
        pushVerifyActivity.presenter = lazy;
    }
}
