package id.dana.analytics.mixpanel;

import android.content.Context;
import id.dana.analytics.mixpanel.MixPanelEvent;
import id.dana.analytics.tracker.AnalyticsTracker;
import id.dana.analytics.tracker.EventStrategy;
import id.dana.analytics.tracker.EventTrackerQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0013\u0012\u0006\u0010\u0007\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJK\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\r0\f2\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\r0\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ3\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\r\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0012R\u0014\u0010\u000e\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0014R+\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00150\u0015X\u0000¢\u0006\u0006\n\u0004\b\n\u0010\u0016R\u0014\u0010\n\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0015X\u0000¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016"}, d2 = {"Lid/dana/analytics/mixpanel/MixpanelAnalytics;", "Lid/dana/analytics/tracker/AnalyticsTracker;", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/String;)V", "p1", "", "p2", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;J)V", "", "Lkotlin/Pair;", "MyBillsEntityDataFactory", "(Ljava/lang/String;[Lkotlin/Pair;[Lkotlin/Pair;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "", "(Ljava/lang/String;[Lkotlin/Pair;)V", "Landroid/content/Context;", "Landroid/content/Context;", "", "Ljava/util/Map;", "Lid/dana/analytics/tracker/EventTrackerQueue;", "Lid/dana/analytics/tracker/EventTrackerQueue;", "<init>", "(Landroid/content/Context;Lid/dana/analytics/tracker/EventTrackerQueue;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MixpanelAnalytics implements AnalyticsTracker {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Context MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Map<String, Long> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final EventTrackerQueue getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Map<String, Map<String, Object>> PlaceComponentResult;

    @Inject
    public MixpanelAnalytics(Context context, EventTrackerQueue eventTrackerQueue) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(eventTrackerQueue, "");
        this.MyBillsEntityDataFactory = context;
        this.getAuthRequestContext = eventTrackerQueue;
        this.PlaceComponentResult = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
    }

    @Override // id.dana.analytics.tracker.AnalyticsTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, Pair<String, Object>[] p1) {
        Map<String, Object> map;
        Intrinsics.checkNotNullParameter(p0, "");
        MixPanelEvent.Builder authRequestContext = MixPanelEvent.Builder.getAuthRequestContext(this.MyBillsEntityDataFactory);
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
        if (p1 != null) {
            authRequestContext.MyBillsEntityDataFactory(p1);
        }
        Intrinsics.checkNotNullParameter(p0, "");
        byte b = 0;
        Pair<String, Object>[] pairArr = null;
        if (this.PlaceComponentResult.containsKey(p0) && (map = this.PlaceComponentResult.get(p0)) != null) {
            Set<Map.Entry<String, Object>> entrySet = map.entrySet();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = entrySet.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Pair pair = entry.getValue() != null ? new Pair(entry.getKey(), entry.getValue()) : null;
                if (pair != null) {
                    arrayList.add(pair);
                }
            }
            Object[] array = arrayList.toArray(new Pair[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            pairArr = (Pair[]) array;
        }
        if (pairArr != null) {
            authRequestContext.MyBillsEntityDataFactory(pairArr);
        }
        EventTrackerQueue eventTrackerQueue = this.getAuthRequestContext;
        MixPanelEvent mixPanelEvent = new MixPanelEvent(authRequestContext, b);
        Intrinsics.checkNotNullExpressionValue(mixPanelEvent, "");
        EventTrackerQueue.MyBillsEntityDataFactory(eventTrackerQueue, new EventStrategy[]{mixPanelEvent});
        this.PlaceComponentResult.remove(p0);
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

    @Override // id.dana.analytics.tracker.AnalyticsTracker
    public final void getAuthRequestContext(String p0, String p1, long p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (!this.PlaceComponentResult.containsKey(p0)) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.put(p1, Long.valueOf(p2));
            this.PlaceComponentResult.put(p0, MapsKt.mutableMapOf(TuplesKt.to(p1, null)));
            return;
        }
        Map<String, Object> map = this.PlaceComponentResult.get(p0);
        if (map == null || map.containsKey(p1)) {
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.put(p1, Long.valueOf(p2));
        map.put(p1, null);
        this.PlaceComponentResult.put(p0, map);
    }

    @Override // id.dana.analytics.tracker.AnalyticsTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, long p2) {
        Map<String, Object> map;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (!this.PlaceComponentResult.containsKey(p0) || (map = this.PlaceComponentResult.get(p0)) == null) {
            return;
        }
        Long l = this.KClassImpl$Data$declaredNonStaticMembers$2.get(p1);
        if (!map.containsKey(p1) || l == null) {
            return;
        }
        map.put(p1, Long.valueOf(p2 - l.longValue()));
        this.PlaceComponentResult.put(p0, map);
        this.KClassImpl$Data$declaredNonStaticMembers$2.remove(p1);
    }
}
