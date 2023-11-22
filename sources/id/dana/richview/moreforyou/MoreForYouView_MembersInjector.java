package id.dana.richview.moreforyou;

import dagger.Lazy;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import id.dana.animation.tracker.HomeTrackerImpl;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.richview.moreforyou.MoreForYouContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MoreForYouView_MembersInjector implements MembersInjector<MoreForYouView> {
    private final Provider<HomeTrackerImpl> homeTrackerImplProvider;
    private final Provider<MoreForYouContract.Presenter> presenterProvider;
    private final Provider<ReadLinkPropertiesContract.Presenter> readDeepLinkPropertiesPresenterProvider;

    public MoreForYouView_MembersInjector(Provider<MoreForYouContract.Presenter> provider, Provider<ReadLinkPropertiesContract.Presenter> provider2, Provider<HomeTrackerImpl> provider3) {
        this.presenterProvider = provider;
        this.readDeepLinkPropertiesPresenterProvider = provider2;
        this.homeTrackerImplProvider = provider3;
    }

    public static MembersInjector<MoreForYouView> create(Provider<MoreForYouContract.Presenter> provider, Provider<ReadLinkPropertiesContract.Presenter> provider2, Provider<HomeTrackerImpl> provider3) {
        return new MoreForYouView_MembersInjector(provider, provider2, provider3);
    }

    public final void injectMembers(MoreForYouView moreForYouView) {
        injectPresenter(moreForYouView, DoubleCheck.MyBillsEntityDataFactory(this.presenterProvider));
        injectReadDeepLinkPropertiesPresenter(moreForYouView, DoubleCheck.MyBillsEntityDataFactory(this.readDeepLinkPropertiesPresenterProvider));
        injectHomeTrackerImpl(moreForYouView, DoubleCheck.MyBillsEntityDataFactory(this.homeTrackerImplProvider));
    }

    public static void injectPresenter(MoreForYouView moreForYouView, Lazy<MoreForYouContract.Presenter> lazy) {
        moreForYouView.presenter = lazy;
    }

    public static void injectReadDeepLinkPropertiesPresenter(MoreForYouView moreForYouView, Lazy<ReadLinkPropertiesContract.Presenter> lazy) {
        moreForYouView.readDeepLinkPropertiesPresenter = lazy;
    }

    public static void injectHomeTrackerImpl(MoreForYouView moreForYouView, Lazy<HomeTrackerImpl> lazy) {
        moreForYouView.homeTrackerImpl = lazy;
    }
}
