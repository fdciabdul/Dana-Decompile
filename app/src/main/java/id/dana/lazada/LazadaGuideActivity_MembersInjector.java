package id.dana.lazada;

import dagger.MembersInjector;
import id.dana.lazada.LazadaGuideContract;

/* loaded from: classes5.dex */
public final class LazadaGuideActivity_MembersInjector implements MembersInjector<LazadaGuideActivity> {
    public static void getAuthRequestContext(LazadaGuideActivity lazadaGuideActivity, LazadaGuideContract.Presenter presenter) {
        lazadaGuideActivity.lazadaPresenter = presenter;
    }
}
