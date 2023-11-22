package id.dana.feeds.domain.timeline;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&J^\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H&J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&Jf\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u0011H&J&\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH&J*\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH&J@\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH&J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;", "", "getCachedFeedTimelineVersion", "Lio/reactivex/Observable;", "", "getCachedFeeds", "Lid/dana/feeds/domain/timeline/model/SocialFeed;", "userId", "", SecurityConstants.KEY_PAGE_SIZE, "maxId", "minId", "feedVersion", "activityIds", "", "feedType", "fetchCache", "", "getFeedVersion", "getFeeds", "fromFeedsPage", "loadCache", "getGlobalNotification", "getMyFeeds", "getMyProfileFeed", "getShareFeedsConfig", "feature-feeds_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FeedsTimelineRepository {
    Observable<SocialFeed> KClassImpl$Data$declaredNonStaticMembers$2();

    Observable<Integer> MyBillsEntityDataFactory();

    Observable<SocialFeed> MyBillsEntityDataFactory(int i, String str, String str2);

    Observable<SocialFeed> MyBillsEntityDataFactory(int i, String str, String str2, int i2, List<String> list, String str3, boolean z);

    Observable<SocialFeed> MyBillsEntityDataFactory(String str, int i, String str2, String str3, String str4, int i2, List<String> list, boolean z, boolean z2);

    Observable<SocialFeed> PlaceComponentResult(int i, String str, String str2);

    Observable<Integer> getAuthRequestContext();

    /* renamed from: id.dana.feeds.domain.timeline.FeedsTimelineRepository$-CC  reason: invalid class name */
    /* loaded from: classes5.dex */
    public final /* synthetic */ class CC {
    }
}
