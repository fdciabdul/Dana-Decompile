package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.appcompat.widget.FitWindowsViewGroup;

/* loaded from: classes6.dex */
public class FitWindowsLinearLayout extends LinearLayout implements FitWindowsViewGroup {
    private FitWindowsViewGroup.OnFitSystemWindowsListener KClassImpl$Data$declaredNonStaticMembers$2;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.appcompat.widget.FitWindowsViewGroup
    public void setOnFitSystemWindowsListener(FitWindowsViewGroup.OnFitSystemWindowsListener onFitSystemWindowsListener) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = onFitSystemWindowsListener;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        FitWindowsViewGroup.OnFitSystemWindowsListener onFitSystemWindowsListener = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (onFitSystemWindowsListener != null) {
            onFitSystemWindowsListener.BuiltInFictitiousFunctionClassFactory(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
