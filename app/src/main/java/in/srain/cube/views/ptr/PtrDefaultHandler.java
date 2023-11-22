package in.srain.cube.views.ptr;

import android.os.Build;
import android.view.View;
import android.widget.AbsListView;

/* loaded from: classes9.dex */
public abstract class PtrDefaultHandler implements PtrHandler {
    public static boolean canChildScrollUp(View view) {
        if (Build.VERSION.SDK_INT < 14) {
            if (!(view instanceof AbsListView)) {
                return view.getScrollY() > 0;
            }
            AbsListView absListView = (AbsListView) view;
            if (absListView.getChildCount() > 0) {
                return absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop();
            }
            return false;
        }
        return view.canScrollVertically(-1);
    }

    public static boolean checkContentCanBePulledDown(PtrFrameLayout ptrFrameLayout, View view, View view2) {
        return !canChildScrollUp(view);
    }

    @Override // in.srain.cube.views.ptr.PtrHandler
    public boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
        return checkContentCanBePulledDown(ptrFrameLayout, view, view2);
    }
}
