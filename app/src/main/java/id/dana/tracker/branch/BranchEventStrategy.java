package id.dana.tracker.branch;

import android.content.Context;
import id.dana.analytics.tracker.EventStrategy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001f\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\r"}, d2 = {"Lid/dana/tracker/branch/BranchEventStrategy;", "Lid/dana/analytics/tracker/EventStrategy;", "", "PlaceComponentResult", "()V", "Landroid/content/Context;", "Landroid/content/Context;", "getAuthRequestContext", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "", "", "Ljava/util/Map;", "MyBillsEntityDataFactory", "p0", "p1", "p2", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BranchEventStrategy implements EventStrategy {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final String PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final Context getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final Map<String, Object> MyBillsEntityDataFactory;

    public BranchEventStrategy(Context context, String str, Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.getAuthRequestContext = context;
        this.PlaceComponentResult = str;
        this.MyBillsEntityDataFactory = map;
    }

    @Override // id.dana.analytics.tracker.EventStrategy
    public final void PlaceComponentResult() {
        BranchTracker branchTracker = BranchTracker.INSTANCE;
        BranchTracker.BuiltInFictitiousFunctionClassFactory(this);
    }
}
