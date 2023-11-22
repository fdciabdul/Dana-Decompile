package id.dana.sendmoney_v2.smartfriction;

import dagger.MembersInjector;
import id.dana.sendmoney_v2.smartfriction.contract.SuspiciousAccountContract;

/* loaded from: classes5.dex */
public final class SuspiciousAccountActivity_MembersInjector implements MembersInjector<SuspiciousAccountActivity> {
    public static void PlaceComponentResult(SuspiciousAccountActivity suspiciousAccountActivity, SuspiciousAccountContract.Presenter presenter) {
        suspiciousAccountActivity.suspiciousAccountPresenter = presenter;
    }
}
