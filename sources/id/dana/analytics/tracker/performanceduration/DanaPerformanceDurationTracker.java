package id.dana.analytics.tracker.performanceduration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0007\"\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ5\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000b0\u00072\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0007\"\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\rJ5\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000b0\u00072\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0007\"\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\rJ#\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0007\"\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0005\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0005\u0010\u0014J'\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u0014J'\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0014J'\u0010\t\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\t\u0010\u0014J#\u0010\u0015\u001a\u00020\f2\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0007\"\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0017\u001a\u00020\f2\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0007\"\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0015\u001a\u00020\u0018X\u0000¢\u0006\u0006\n\u0004\b\t\u0010\u0019R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001aX\u0000¢\u0006\u0006\n\u0004\b\u000e\u0010\u001b"}, d2 = {"Lid/dana/analytics/tracker/performanceduration/DanaPerformanceDurationTracker;", "Lid/dana/analytics/tracker/performanceduration/PerformanceDurationTracker;", "", "p0", "Lid/dana/analytics/tracker/performanceduration/PerformanceDurationModel;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Lid/dana/analytics/tracker/performanceduration/PerformanceDurationModel;", "", "", "getAuthRequestContext", "([Ljava/lang/String;)Ljava/util/List;", "Lkotlin/Pair;", "", "([Ljava/lang/String;)[Lkotlin/Pair;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "MyBillsEntityDataFactory", "([Ljava/lang/String;)V", "p1", "p2", "(Ljava/lang/String;Ljava/lang/String;J)V", "PlaceComponentResult", "([Ljava/lang/String;)J", "lookAheadTest", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "", "Ljava/util/Map;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanaPerformanceDurationTracker implements PerformanceDurationTracker {
    public static final DanaPerformanceDurationTracker INSTANCE = new DanaPerformanceDurationTracker();
    public static final Map<String, PerformanceDurationModel> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public static final ReentrantLock PlaceComponentResult = new ReentrantLock();

    private DanaPerformanceDurationTracker() {
    }

    private static PerformanceDurationModel BuiltInFictitiousFunctionClassFactory(String p0) {
        Map<String, PerformanceDurationModel> map = KClassImpl$Data$declaredNonStaticMembers$2;
        PerformanceDurationModel performanceDurationModel = map.get(p0);
        if (performanceDurationModel == null) {
            PerformanceDurationModel performanceDurationModel2 = new PerformanceDurationModel(p0, null, null, 6, null);
            map.put(p0, performanceDurationModel2);
            return performanceDurationModel2;
        }
        return performanceDurationModel;
    }

    @Override // id.dana.analytics.tracker.performanceduration.PerformanceDurationTracker
    public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1, long p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        ReentrantLock reentrantLock = PlaceComponentResult;
        reentrantLock.lock();
        try {
            PerformanceDurationModel BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(p0);
            Intrinsics.checkNotNullParameter(p1, "");
            if (BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.get(p1) == null) {
                BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.put(p1, Long.valueOf(p2));
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // id.dana.analytics.tracker.performanceduration.PerformanceDurationTracker
    public final void PlaceComponentResult(String p0, String p1, long p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        ReentrantLock reentrantLock = PlaceComponentResult;
        reentrantLock.lock();
        try {
            PerformanceDurationModel BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(p0);
            Intrinsics.checkNotNullParameter(p1, "");
            Long l = BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.get(p1);
            if (l != null) {
                long longValue = l.longValue();
                if (BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.get(p1) == null) {
                    BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.put(p1, new ArrayList());
                }
                List<Long> list = BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.get(p1);
                if (list != null) {
                    list.add(Long.valueOf(p2 - longValue));
                }
                BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.remove(p1);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // id.dana.analytics.tracker.performanceduration.PerformanceDurationTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, long p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        ReentrantLock reentrantLock = PlaceComponentResult;
        reentrantLock.lock();
        try {
            PerformanceDurationModel BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(p0);
            Intrinsics.checkNotNullParameter(p1, "");
            if (BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.get(p1) == null) {
                BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.put(p1, Long.valueOf(p2));
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // id.dana.analytics.tracker.performanceduration.PerformanceDurationTracker
    public final void getAuthRequestContext(String p0, String p1, long p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        ReentrantLock reentrantLock = PlaceComponentResult;
        reentrantLock.lock();
        try {
            PerformanceDurationModel BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(p0);
            Intrinsics.checkNotNullParameter(p1, "");
            Long l = BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.get(p1);
            if (l != null) {
                long longValue = l.longValue();
                if (BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.get(p1) == null) {
                    BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.put(p1, new ArrayList());
                }
                List<Long> list = BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.get(p1);
                if (list != null) {
                    list.add(Long.valueOf(p2 - longValue));
                }
                BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.remove(p1);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public static Pair<String, Long>[] BuiltInFictitiousFunctionClassFactory(String... p0) {
        ArrayList arrayList = new ArrayList();
        for (String str : p0) {
            PerformanceDurationModel performanceDurationModel = KClassImpl$Data$declaredNonStaticMembers$2.get(str);
            if (performanceDurationModel != null) {
                arrayList.add(performanceDurationModel);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if ((!((PerformanceDurationModel) obj).getAuthRequestContext.isEmpty()) != false) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Map<String, List<Long>> map = ((PerformanceDurationModel) it.next()).getAuthRequestContext;
            ArrayList arrayList4 = new ArrayList(map.size());
            for (Map.Entry<String, List<Long>> entry : map.entrySet()) {
                arrayList4.add(TuplesKt.to(entry.getKey(), Long.valueOf(CollectionsKt.sumOfLong(entry.getValue()))));
            }
            CollectionsKt.addAll(arrayList3, arrayList4);
        }
        Object[] array = arrayList3.toArray(new Pair[0]);
        if (array != null) {
            return (Pair[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static Pair<String, Long>[] KClassImpl$Data$declaredNonStaticMembers$2(String... p0) {
        ArrayList arrayList = new ArrayList();
        for (String str : p0) {
            PerformanceDurationModel performanceDurationModel = KClassImpl$Data$declaredNonStaticMembers$2.get(str);
            if (performanceDurationModel != null) {
                arrayList.add(performanceDurationModel);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if ((!((PerformanceDurationModel) obj).PlaceComponentResult.isEmpty()) != false) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Map<String, List<Long>> map = ((PerformanceDurationModel) it.next()).PlaceComponentResult;
            ArrayList arrayList4 = new ArrayList(map.size());
            for (Map.Entry<String, List<Long>> entry : map.entrySet()) {
                arrayList4.add(TuplesKt.to(entry.getKey(), Long.valueOf(CollectionsKt.sumOfLong(entry.getValue()))));
            }
            CollectionsKt.addAll(arrayList3, arrayList4);
        }
        Object[] array = arrayList3.toArray(new Pair[0]);
        if (array != null) {
            return (Pair[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static List<PerformanceDurationModel> getAuthRequestContext(String... p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ArrayList arrayList = new ArrayList();
        int length = p0.length;
        for (int i = 0; i <= 0; i++) {
            PerformanceDurationModel performanceDurationModel = KClassImpl$Data$declaredNonStaticMembers$2.get(p0[0]);
            if (performanceDurationModel != null) {
                arrayList.add(performanceDurationModel);
            }
        }
        return arrayList;
    }

    public static void MyBillsEntityDataFactory(String... p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        for (String str : p0) {
            KClassImpl$Data$declaredNonStaticMembers$2.remove(str);
        }
    }

    public static long PlaceComponentResult(String... p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ArrayList arrayList = new ArrayList();
        for (String str : p0) {
            PerformanceDurationModel performanceDurationModel = KClassImpl$Data$declaredNonStaticMembers$2.get(str);
            if (performanceDurationModel != null) {
                arrayList.add(performanceDurationModel);
            }
        }
        Iterator it = arrayList.iterator();
        long j = 0;
        while (it.hasNext()) {
            Iterator<T> it2 = ((PerformanceDurationModel) it.next()).getAuthRequestContext.values().iterator();
            long j2 = 0;
            while (it2.hasNext()) {
                j2 += CollectionsKt.sumOfLong((List) it2.next());
            }
            j += j2;
        }
        return j;
    }

    public static long lookAheadTest(String... p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ArrayList arrayList = new ArrayList();
        for (String str : p0) {
            PerformanceDurationModel performanceDurationModel = KClassImpl$Data$declaredNonStaticMembers$2.get(str);
            if (performanceDurationModel != null) {
                arrayList.add(performanceDurationModel);
            }
        }
        Iterator it = arrayList.iterator();
        long j = 0;
        while (it.hasNext()) {
            Iterator<T> it2 = ((PerformanceDurationModel) it.next()).PlaceComponentResult.values().iterator();
            long j2 = 0;
            while (it2.hasNext()) {
                j2 += CollectionsKt.sumOfLong((List) it2.next());
            }
            j += j2;
        }
        return j;
    }
}
