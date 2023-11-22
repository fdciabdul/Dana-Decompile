package id.dana.analytics.fullstory;

import com.fullstory.FS;
import id.dana.analytics.tracker.AnalyticsTracker;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJK\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\r0\f2\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\r0\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ3\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\r\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0012"}, d2 = {"Lid/dana/analytics/fullstory/FullStoryAnalytics;", "Lid/dana/analytics/tracker/AnalyticsTracker;", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/String;)V", "p1", "", "p2", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;J)V", "", "Lkotlin/Pair;", "MyBillsEntityDataFactory", "(Ljava/lang/String;[Lkotlin/Pair;[Lkotlin/Pair;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "", "(Ljava/lang/String;[Lkotlin/Pair;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FullStoryAnalytics implements AnalyticsTracker {
    @Inject
    public FullStoryAnalytics() {
    }

    @Override // id.dana.analytics.tracker.AnalyticsTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, Pair<String, Object>[] p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        FS.event(p0, p1 != null ? MapsKt.toMap(p1) : null);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.analytics.tracker.AnalyticsTracker
    public final void PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.analytics.tracker.AnalyticsTracker
    public final void MyBillsEntityDataFactory(String p0, Pair<String, String>[] p1, Pair<String, Long>[] p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        ?? r3 = 0;
        throw new NotImplementedError(r3, 1, r3);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.analytics.tracker.AnalyticsTracker
    public final void getAuthRequestContext(String p0, String p1, long p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        ?? r2 = 0;
        throw new NotImplementedError(r2, 1, r2);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.analytics.tracker.AnalyticsTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, long p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        ?? r2 = 0;
        throw new NotImplementedError(r2, 1, r2);
    }
}
