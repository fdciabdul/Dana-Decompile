package okio;

import javax.annotation.Nullable;

/* loaded from: classes.dex */
final class SegmentPool {
    static long KClassImpl$Data$declaredNonStaticMembers$2;
    @Nullable
    static Segment MyBillsEntityDataFactory;

    private SegmentPool() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Segment PlaceComponentResult() {
        synchronized (SegmentPool.class) {
            Segment segment = MyBillsEntityDataFactory;
            if (segment != null) {
                MyBillsEntityDataFactory = segment.getAuthRequestContext;
                segment.getAuthRequestContext = null;
                KClassImpl$Data$declaredNonStaticMembers$2 -= 8192;
                return segment;
            }
            return new Segment();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getAuthRequestContext(Segment segment) {
        if (segment.getAuthRequestContext != null || segment.lookAheadTest != null) {
            throw new IllegalArgumentException();
        }
        if (segment.moveToNextValue) {
            return;
        }
        synchronized (SegmentPool.class) {
            long j = KClassImpl$Data$declaredNonStaticMembers$2 + 8192;
            if (j > 65536) {
                return;
            }
            KClassImpl$Data$declaredNonStaticMembers$2 = j;
            segment.getAuthRequestContext = MyBillsEntityDataFactory;
            segment.MyBillsEntityDataFactory = 0;
            segment.PlaceComponentResult = 0;
            MyBillsEntityDataFactory = segment;
        }
    }
}
