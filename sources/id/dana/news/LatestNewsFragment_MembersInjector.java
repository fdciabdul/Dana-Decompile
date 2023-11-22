package id.dana.news;

import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.news.LatestNewsContract;

/* loaded from: classes5.dex */
public final class LatestNewsFragment_MembersInjector implements MembersInjector<LatestNewsFragment> {
    public static void PlaceComponentResult(LatestNewsFragment latestNewsFragment, LatestNewsContract.Presenter presenter) {
        latestNewsFragment.latestNewsPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(LatestNewsFragment latestNewsFragment, ReadLinkPropertiesContract.Presenter presenter) {
        latestNewsFragment.readDeepLinkPropertiesPresenter = presenter;
    }
}
