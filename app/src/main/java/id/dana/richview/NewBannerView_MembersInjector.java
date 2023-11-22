package id.dana.richview;

import dagger.MembersInjector;
import id.dana.announcement.AnnouncementContract;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.paylater.PayLaterContract;
import id.dana.contract.shortener.RestoreUrlContract;
import id.dana.contract.staticqr.ScanQrContract;
import id.dana.data.config.source.HomeWidgetEntityData;

/* loaded from: classes5.dex */
public final class NewBannerView_MembersInjector implements MembersInjector<NewBannerView> {
    public static void MyBillsEntityDataFactory(NewBannerView newBannerView, FeatureContract.Presenter presenter) {
        newBannerView.featurePresenter = presenter;
    }

    public static void getAuthRequestContext(NewBannerView newBannerView, ReadLinkPropertiesContract.Presenter presenter) {
        newBannerView.readDeepLinkPropertiesPresenter = presenter;
    }

    public static void getAuthRequestContext(NewBannerView newBannerView, RestoreUrlContract.Presenter presenter) {
        newBannerView.restorePresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(NewBannerView newBannerView, ScanQrContract.Presenter presenter) {
        newBannerView.scanQrPresenter = presenter;
    }

    public static void getAuthRequestContext(NewBannerView newBannerView, AnnouncementContract.Presenter presenter) {
        newBannerView.announcementPresenter = presenter;
    }

    public static void PlaceComponentResult(NewBannerView newBannerView, HomeWidgetEntityData homeWidgetEntityData) {
        newBannerView.homeWidgetCache = homeWidgetEntityData;
    }

    public static void getAuthRequestContext(NewBannerView newBannerView, PayLaterContract.Presenter presenter) {
        newBannerView.payLaterPresenter = presenter;
    }
}
