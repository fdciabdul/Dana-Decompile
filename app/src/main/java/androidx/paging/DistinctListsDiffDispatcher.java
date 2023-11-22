package androidx.paging;

import androidx.recyclerview.widget.ListUpdateCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ?\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/paging/DistinctListsDiffDispatcher;", "", "Landroidx/recyclerview/widget/ListUpdateCallback;", "p0", "", "p1", "p2", "p3", "p4", "p5", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/recyclerview/widget/ListUpdateCallback;IIIILjava/lang/Object;)V", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class DistinctListsDiffDispatcher {
    public static final DistinctListsDiffDispatcher INSTANCE = new DistinctListsDiffDispatcher();

    private DistinctListsDiffDispatcher() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void KClassImpl$Data$declaredNonStaticMembers$2(ListUpdateCallback p0, int p1, int p2, int p3, int p4, Object p5) {
        int i = p1 - p3;
        if (i > 0) {
            p0.getAuthRequestContext(p3, i, p5);
        }
        int i2 = p4 - p2;
        if (i2 > 0) {
            p0.getAuthRequestContext(p2, i2, p5);
        }
    }
}
