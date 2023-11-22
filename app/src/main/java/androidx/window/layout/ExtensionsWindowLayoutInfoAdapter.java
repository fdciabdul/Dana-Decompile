package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import androidx.window.core.Bounds;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.HardwareFoldingFeature;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tJ\u001d\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\tJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0011"}, d2 = {"Landroidx/window/layout/ExtensionsWindowLayoutInfoAdapter;", "", "()V", "translate", "Landroidx/window/layout/FoldingFeature;", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", "oemFeature", "Landroidx/window/extensions/layout/FoldingFeature;", "translate$window_release", "Landroidx/window/layout/WindowLayoutInfo;", "info", "Landroidx/window/extensions/layout/WindowLayoutInfo;", "validBounds", "", "bounds", "Landroidx/window/core/Bounds;", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ExtensionsWindowLayoutInfoAdapter {
    public static final ExtensionsWindowLayoutInfoAdapter MyBillsEntityDataFactory = new ExtensionsWindowLayoutInfoAdapter();

    private ExtensionsWindowLayoutInfoAdapter() {
    }

    public static WindowLayoutInfo KClassImpl$Data$declaredNonStaticMembers$2(Activity activity, androidx.window.extensions.layout.WindowLayoutInfo windowLayoutInfo) {
        HardwareFoldingFeature.Type BuiltInFictitiousFunctionClassFactory;
        FoldingFeature.State state;
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(windowLayoutInfo, "");
        List<androidx.window.extensions.layout.FoldingFeature> displayFeatures = windowLayoutInfo.getDisplayFeatures();
        Intrinsics.checkNotNullExpressionValue(displayFeatures, "");
        ArrayList arrayList = new ArrayList();
        for (androidx.window.extensions.layout.FoldingFeature foldingFeature : displayFeatures) {
            HardwareFoldingFeature hardwareFoldingFeature = null;
            if (foldingFeature instanceof androidx.window.extensions.layout.FoldingFeature) {
                Intrinsics.checkNotNullExpressionValue(foldingFeature, "");
                androidx.window.extensions.layout.FoldingFeature foldingFeature2 = foldingFeature;
                Intrinsics.checkNotNullParameter(activity, "");
                Intrinsics.checkNotNullParameter(foldingFeature2, "");
                int type = foldingFeature2.getType();
                if (type == 1) {
                    HardwareFoldingFeature.Type.Companion companion = HardwareFoldingFeature.Type.INSTANCE;
                    BuiltInFictitiousFunctionClassFactory = HardwareFoldingFeature.Type.Companion.BuiltInFictitiousFunctionClassFactory();
                } else if (type == 2) {
                    HardwareFoldingFeature.Type.Companion companion2 = HardwareFoldingFeature.Type.INSTANCE;
                    BuiltInFictitiousFunctionClassFactory = HardwareFoldingFeature.Type.Companion.getAuthRequestContext();
                }
                int state2 = foldingFeature2.getState();
                if (state2 == 1) {
                    state = FoldingFeature.State.BuiltInFictitiousFunctionClassFactory;
                } else if (state2 == 2) {
                    state = FoldingFeature.State.MyBillsEntityDataFactory;
                }
                Rect bounds = foldingFeature2.getBounds();
                Intrinsics.checkNotNullExpressionValue(bounds, "");
                if (BuiltInFictitiousFunctionClassFactory(activity, new Bounds(bounds))) {
                    Rect bounds2 = foldingFeature2.getBounds();
                    Intrinsics.checkNotNullExpressionValue(bounds2, "");
                    hardwareFoldingFeature = new HardwareFoldingFeature(new Bounds(bounds2), BuiltInFictitiousFunctionClassFactory, state);
                }
            }
            if (hardwareFoldingFeature != null) {
                arrayList.add(hardwareFoldingFeature);
            }
        }
        return new WindowLayoutInfo(arrayList);
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(Activity activity, Bounds bounds) {
        Bounds bounds2 = WindowMetricsCalculatorCompat.INSTANCE.getAuthRequestContext(activity).BuiltInFictitiousFunctionClassFactory;
        Rect rect = new Rect(bounds2.BuiltInFictitiousFunctionClassFactory, bounds2.KClassImpl$Data$declaredNonStaticMembers$2, bounds2.MyBillsEntityDataFactory, bounds2.PlaceComponentResult);
        if (bounds.getAuthRequestContext()) {
            return false;
        }
        if (bounds.MyBillsEntityDataFactory - bounds.BuiltInFictitiousFunctionClassFactory == rect.width() || bounds.PlaceComponentResult - bounds.KClassImpl$Data$declaredNonStaticMembers$2 == rect.height()) {
            if (bounds.MyBillsEntityDataFactory - bounds.BuiltInFictitiousFunctionClassFactory >= rect.width() || bounds.PlaceComponentResult - bounds.KClassImpl$Data$declaredNonStaticMembers$2 >= rect.height()) {
                return (bounds.MyBillsEntityDataFactory - bounds.BuiltInFictitiousFunctionClassFactory == rect.width() && bounds.PlaceComponentResult - bounds.KClassImpl$Data$declaredNonStaticMembers$2 == rect.height()) ? false : true;
            }
            return false;
        }
        return false;
    }
}
