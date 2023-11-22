package com.alibaba.ariver.app.ui.tabbar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.alibaba.ariver.app.ui.tabbar.RVTabBarItem;

/* loaded from: classes6.dex */
public class RVTabBarRootLayout extends RelativeLayout {
    RVTabBarItem.OnSelectedChangedListener mOnSelectedChangedListener;

    public RVTabBarRootLayout(Context context) {
        super(context);
    }

    public RVTabBarRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RVTabBarRootLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetSelected(boolean z) {
        RVTabBarItem.OnSelectedChangedListener onSelectedChangedListener = this.mOnSelectedChangedListener;
        if (onSelectedChangedListener != null) {
            onSelectedChangedListener.onChanged(z);
        }
        super.dispatchSetSelected(z);
    }

    public void setOnSelectedChangedListener(RVTabBarItem.OnSelectedChangedListener onSelectedChangedListener) {
        this.mOnSelectedChangedListener = onSelectedChangedListener;
    }
}
