package id.dana.data.base;

import androidx.room.RoomDatabase;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.data.geofence.repository.source.persistence.dao.GeofenceDao;
import id.dana.data.home.repository.source.presistence.dao.MoreForYouDao;
import id.dana.data.home.repository.source.presistence.dao.NewsWidgetActivityDao;
import id.dana.data.home.repository.source.presistence.dao.PromoBannerAnnouncementDao;
import id.dana.data.home.repository.source.presistence.dao.PromoBannerContentDao;
import id.dana.data.home.repository.source.presistence.dao.SingleBalanceDao;
import id.dana.data.loyalty.repository.source.local.dao.LoyaltyReceiptDao;
import id.dana.data.recentcontact.repository.source.persistence.dao.DanaUserContactDao;
import id.dana.data.recentcontact.repository.source.persistence.dao.UserContactDao;
import id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao;
import id.dana.data.social.repository.source.persistence.dao.ActivityDao;
import id.dana.data.social.repository.source.persistence.dao.FollowerDao;
import id.dana.data.social.repository.source.persistence.dao.FollowingDao;
import id.dana.data.splitbill.repository.source.persistence.dao.RecentPayerSplitBillDao;
import id.dana.data.splitbill.repository.source.persistence.dao.SplitBillHistoryDao;
import id.dana.data.user.source.persistence.dao.UserInfoDao;
import id.dana.data.wallet_v3.repository.source.persistence.dao.UserIdentityAssetsDao;
import id.dana.data.wallet_v3.repository.source.persistence.dao.UserPaymentAssetsDao;
import id.dana.data.wallet_v3.repository.source.persistence.dao.UserPocketAssetsDao;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class BasePersistenceDao extends RoomDatabase {
    public abstract ActivityDao activityDao();

    public abstract DanaUserContactDao danaUserContactDao();

    public abstract FollowerDao followerDao();

    public abstract FollowingDao followingDao();

    public abstract GeofenceDao geofenceDao();

    public abstract LoyaltyReceiptDao loyaltyReceiptDao();

    public abstract MoreForYouDao moreForYouDao();

    public abstract NewsWidgetActivityDao newsWidgetActivityDao();

    public abstract PromoBannerAnnouncementDao promoBannerAnnouncementDao();

    public abstract PromoBannerContentDao promoBannerContentDao();

    public abstract RecentPayerSplitBillDao recentPayerSplitBillDao();

    public abstract RecentRecipientDao recentRecipientDao();

    public abstract SingleBalanceDao singleBalanceDao();

    public abstract SplitBillHistoryDao splitBillHistoryDao();

    public abstract UserContactDao userContactDao();

    public abstract UserIdentityAssetsDao userIdentityAssetsDao();

    public abstract UserInfoDao userInfoDao();

    public abstract UserPaymentAssetsDao userPaymentAssetsDao();

    public abstract UserPocketAssetsDao userPocketAssetsDao();

    @Override // androidx.room.RoomDatabase
    public void endTransaction() {
        try {
            super.endTransaction();
        } catch (Exception e) {
            if (e.getClass().getName().contains("CursorWindowAllocationException")) {
                Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
                Intrinsics.checkNotNullParameter(e, "");
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(e);
                return;
            }
            throw e;
        }
    }
}
