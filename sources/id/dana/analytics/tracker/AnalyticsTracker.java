package id.dana.analytics.tracker;

import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import id.dana.analytics.tracker.TrackerDataKey;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&J&\u0010\u0006\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH&JO\u0010\n\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\r0\f2\u001a\b\u0002\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\r0\fH&¢\u0006\u0002\u0010\u000fJ&\u0010\u0010\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\tH&J5\u0010\u0012\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u001c\b\u0002\u0010\u0013\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\r\u0018\u00010\fH&¢\u0006\u0002\u0010\u0014ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Lid/dana/analytics/tracker/AnalyticsTracker;", "", "startEvent", "", IpcMessageConstants.EXTRA_EVENT, "", "startProperty", "propertyName", "startTimeInMillis", "", "stopEvent", "attributes", "", "Lkotlin/Pair;", "metrics", "(Ljava/lang/String;[Lkotlin/Pair;[Lkotlin/Pair;)V", "stopProperty", "endTimeInMillis", "track", "properties", "(Ljava/lang/String;[Lkotlin/Pair;)V", "core-analytics_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface AnalyticsTracker {
    void KClassImpl$Data$declaredNonStaticMembers$2(@TrackerDataKey.Event String str, @TrackerDataKey.Property String str2, long j);

    void KClassImpl$Data$declaredNonStaticMembers$2(@TrackerDataKey.Event String str, Pair<String, Object>[] pairArr);

    void MyBillsEntityDataFactory(@TrackerDataKey.Event String str, Pair<String, String>[] pairArr, Pair<String, Long>[] pairArr2);

    void PlaceComponentResult(@TrackerDataKey.Event String str);

    void getAuthRequestContext(@TrackerDataKey.Event String str, @TrackerDataKey.Property String str2, long j);

    /* renamed from: id.dana.analytics.tracker.AnalyticsTracker$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void getAuthRequestContext(AnalyticsTracker analyticsTracker, String str) {
            analyticsTracker.KClassImpl$Data$declaredNonStaticMembers$2(str, null);
        }
    }
}
