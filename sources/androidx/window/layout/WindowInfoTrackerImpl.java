package androidx.window.layout;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0006\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Landroidx/window/layout/WindowInfoTrackerImpl;", "Landroidx/window/layout/WindowInfoTracker;", "Landroid/app/Activity;", "p0", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/window/layout/WindowLayoutInfo;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/app/Activity;)Lkotlinx/coroutines/flow/Flow;", "Landroidx/window/layout/WindowBackend;", "PlaceComponentResult", "Landroidx/window/layout/WindowBackend;", "Landroidx/window/layout/WindowMetricsCalculator;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/window/layout/WindowMetricsCalculator;", "MyBillsEntityDataFactory", "p1", "<init>", "(Landroidx/window/layout/WindowMetricsCalculator;Landroidx/window/layout/WindowBackend;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WindowInfoTrackerImpl implements WindowInfoTracker {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final WindowMetricsCalculator MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final WindowBackend BuiltInFictitiousFunctionClassFactory;

    public WindowInfoTrackerImpl(WindowMetricsCalculator windowMetricsCalculator, WindowBackend windowBackend) {
        Intrinsics.checkNotNullParameter(windowMetricsCalculator, "");
        Intrinsics.checkNotNullParameter(windowBackend, "");
        this.MyBillsEntityDataFactory = windowMetricsCalculator;
        this.BuiltInFictitiousFunctionClassFactory = windowBackend;
    }

    @Override // androidx.window.layout.WindowInfoTracker
    public final Flow<WindowLayoutInfo> BuiltInFictitiousFunctionClassFactory(Activity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return FlowKt.flow(new WindowInfoTrackerImpl$windowLayoutInfo$1(this, p0, null));
    }
}
