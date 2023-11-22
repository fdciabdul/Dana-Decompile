package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.FitWindowsViewGroup;

/* loaded from: classes6.dex */
public class FitWindowsFrameLayout extends FrameLayout implements FitWindowsViewGroup {
    private FitWindowsViewGroup.OnFitSystemWindowsListener MyBillsEntityDataFactory;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.appcompat.widget.FitWindowsViewGroup
    public void setOnFitSystemWindowsListener(FitWindowsViewGroup.OnFitSystemWindowsListener onFitSystemWindowsListener) {
        this.MyBillsEntityDataFactory = onFitSystemWindowsListener;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        FitWindowsViewGroup.OnFitSystemWindowsListener onFitSystemWindowsListener = this.MyBillsEntityDataFactory;
        if (onFitSystemWindowsListener != null) {
            onFitSystemWindowsListener.BuiltInFictitiousFunctionClassFactory(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
