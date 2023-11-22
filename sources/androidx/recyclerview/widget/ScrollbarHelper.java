package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class ScrollbarHelper {
    public static int KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z, boolean z2) {
        int i;
        int max;
        int i2;
        if (layoutManager.getChildCount() != 0) {
            if (state.BuiltInFictitiousFunctionClassFactory) {
                i = state.getErrorConfigVersion - state.PlaceComponentResult;
            } else {
                i = state.scheduleImpl;
            }
            if (i != 0 && view != null && view2 != null) {
                int min = Math.min(layoutManager.getPosition(view), layoutManager.getPosition(view2));
                int max2 = Math.max(layoutManager.getPosition(view), layoutManager.getPosition(view2));
                if (!z2) {
                    max = Math.max(0, min);
                } else {
                    if (state.BuiltInFictitiousFunctionClassFactory) {
                        i2 = state.getErrorConfigVersion - state.PlaceComponentResult;
                    } else {
                        i2 = state.scheduleImpl;
                    }
                    max = Math.max(0, (i2 - max2) - 1);
                }
                if (z) {
                    return Math.round((max * (Math.abs(orientationHelper.PlaceComponentResult(view2) - orientationHelper.getAuthRequestContext(view)) / (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1))) + (orientationHelper.moveToNextValue() - orientationHelper.getAuthRequestContext(view)));
                }
                return max;
            }
        }
        return 0;
    }

    public static int BuiltInFictitiousFunctionClassFactory(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z) {
        int i;
        if (layoutManager.getChildCount() != 0) {
            if (state.BuiltInFictitiousFunctionClassFactory) {
                i = state.getErrorConfigVersion - state.PlaceComponentResult;
            } else {
                i = state.scheduleImpl;
            }
            if (i == 0 || view == null || view2 == null) {
                return 0;
            }
            if (!z) {
                return Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1;
            }
            return Math.min(orientationHelper.scheduleImpl(), orientationHelper.PlaceComponentResult(view2) - orientationHelper.getAuthRequestContext(view));
        }
        return 0;
    }

    public static int PlaceComponentResult(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z) {
        int i;
        int i2;
        if (layoutManager.getChildCount() != 0) {
            if (state.BuiltInFictitiousFunctionClassFactory) {
                i = state.getErrorConfigVersion - state.PlaceComponentResult;
            } else {
                i = state.scheduleImpl;
            }
            if (i == 0 || view == null || view2 == null) {
                return 0;
            }
            if (z) {
                float PlaceComponentResult = (orientationHelper.PlaceComponentResult(view2) - orientationHelper.getAuthRequestContext(view)) / (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1);
                if (state.BuiltInFictitiousFunctionClassFactory) {
                    i2 = state.getErrorConfigVersion - state.PlaceComponentResult;
                } else {
                    i2 = state.scheduleImpl;
                }
                return (int) (PlaceComponentResult * i2);
            } else if (state.BuiltInFictitiousFunctionClassFactory) {
                return state.getErrorConfigVersion - state.PlaceComponentResult;
            } else {
                return state.scheduleImpl;
            }
        }
        return 0;
    }

    private ScrollbarHelper() {
    }
}
