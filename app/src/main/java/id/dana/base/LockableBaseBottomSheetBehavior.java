package id.dana.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* loaded from: classes4.dex */
public class LockableBaseBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {
    public boolean MyBillsEntityDataFactory;

    public LockableBaseBottomSheetBehavior() {
        this.MyBillsEntityDataFactory = false;
    }

    public LockableBaseBottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MyBillsEntityDataFactory = false;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.MyBillsEntityDataFactory) {
            return false;
        }
        return super.onInterceptTouchEvent(coordinatorLayout, v, motionEvent);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.MyBillsEntityDataFactory) {
            return false;
        }
        return super.onTouchEvent(coordinatorLayout, v, motionEvent);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        if (this.MyBillsEntityDataFactory) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, v, view, view2, i, i2);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        if (this.MyBillsEntityDataFactory) {
            return;
        }
        super.onNestedPreScroll(coordinatorLayout, v, view, i, i2, iArr, i3);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        if (this.MyBillsEntityDataFactory) {
            return;
        }
        super.onStopNestedScroll(coordinatorLayout, v, view, i);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        if (this.MyBillsEntityDataFactory) {
            return false;
        }
        return super.onNestedPreFling(coordinatorLayout, v, view, f, f2);
    }
}
