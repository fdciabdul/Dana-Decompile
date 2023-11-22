package androidx.slidingpanelayout.widget;

import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import java.util.Iterator;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\n\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000e"}, d2 = {"Landroidx/slidingpanelayout/widget/FoldingFeatureObserver;", "", "Ljava/util/concurrent/Executor;", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/concurrent/Executor;", "Lkotlinx/coroutines/Job;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlinx/coroutines/Job;", "MyBillsEntityDataFactory", "Landroidx/slidingpanelayout/widget/FoldingFeatureObserver$OnFoldingFeatureChangeListener;", "PlaceComponentResult", "Landroidx/slidingpanelayout/widget/FoldingFeatureObserver$OnFoldingFeatureChangeListener;", "getAuthRequestContext", "Landroidx/window/layout/WindowInfoTracker;", "Landroidx/window/layout/WindowInfoTracker;", "p0", "p1", "<init>", "(Landroidx/window/layout/WindowInfoTracker;Ljava/util/concurrent/Executor;)V", "OnFoldingFeatureChangeListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FoldingFeatureObserver {
    final Executor BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    Job MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final WindowInfoTracker PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    OnFoldingFeatureChangeListener getAuthRequestContext;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/slidingpanelayout/widget/FoldingFeatureObserver$OnFoldingFeatureChangeListener;", "", "Landroidx/window/layout/FoldingFeature;", "p0", "", "PlaceComponentResult", "(Landroidx/window/layout/FoldingFeature;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public interface OnFoldingFeatureChangeListener {
        void PlaceComponentResult(FoldingFeature p0);
    }

    public FoldingFeatureObserver(WindowInfoTracker windowInfoTracker, Executor executor) {
        Intrinsics.checkNotNullParameter(windowInfoTracker, "");
        Intrinsics.checkNotNullParameter(executor, "");
        this.PlaceComponentResult = windowInfoTracker;
        this.BuiltInFictitiousFunctionClassFactory = executor;
    }

    public static final /* synthetic */ FoldingFeature KClassImpl$Data$declaredNonStaticMembers$2(WindowLayoutInfo windowLayoutInfo) {
        Object obj;
        Iterator<T> it = windowLayoutInfo.getAuthRequestContext.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((DisplayFeature) obj) instanceof FoldingFeature) {
                break;
            }
        }
        if (obj instanceof FoldingFeature) {
            return (FoldingFeature) obj;
        }
        return null;
    }
}
