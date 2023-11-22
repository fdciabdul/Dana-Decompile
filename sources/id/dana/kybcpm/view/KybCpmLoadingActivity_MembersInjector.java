package id.dana.kybcpm.view;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.kybcpm.KybCpmContract;

/* loaded from: classes5.dex */
public final class KybCpmLoadingActivity_MembersInjector implements MembersInjector<KybCpmLoadingActivity> {
    public static void getAuthRequestContext(KybCpmLoadingActivity kybCpmLoadingActivity, Lazy<KybCpmContract.Presenter> lazy) {
        kybCpmLoadingActivity.presenter = lazy;
    }
}
