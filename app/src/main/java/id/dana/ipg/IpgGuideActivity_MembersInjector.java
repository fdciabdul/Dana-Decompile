package id.dana.ipg;

import dagger.MembersInjector;
import id.dana.ipg.IpgGuideContract;

/* loaded from: classes5.dex */
public final class IpgGuideActivity_MembersInjector implements MembersInjector<IpgGuideActivity> {
    public static void MyBillsEntityDataFactory(IpgGuideActivity ipgGuideActivity, IpgGuideContract.Presenter presenter) {
        ipgGuideActivity.ipgPresenter = presenter;
    }
}
