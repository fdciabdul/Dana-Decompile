package id.dana.tracker.branch;

import io.branch.referral.util.BranchEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/tracker/branch/BranchTracker;", "", "Lid/dana/tracker/branch/BranchEventStrategy;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/tracker/branch/BranchEventStrategy;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BranchTracker {
    public static final BranchTracker INSTANCE = new BranchTracker();

    private BranchTracker() {
    }

    public static void BuiltInFictitiousFunctionClassFactory(BranchEventStrategy p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        BranchEvent branchEvent = new BranchEvent(p0.PlaceComponentResult);
        Map<String, Object> map = p0.MyBillsEntityDataFactory;
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                branchEvent.MyBillsEntityDataFactory(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        branchEvent.BuiltInFictitiousFunctionClassFactory(p0.getAuthRequestContext);
    }
}
