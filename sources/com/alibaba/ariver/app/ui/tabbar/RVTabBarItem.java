package com.alibaba.ariver.app.ui.tabbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alibaba.ariver.app.R;

/* loaded from: classes6.dex */
public class RVTabBarItem {

    /* renamed from: a  reason: collision with root package name */
    private RVTabBarRootLayout f5985a;
    private TextView b;
    private TextView c;
    private RVTabDotView d;

    /* loaded from: classes6.dex */
    public interface OnSelectedChangedListener {
        void onChanged(boolean z);
    }

    public RVTabBarItem(Context context) {
        RVTabBarRootLayout rVTabBarRootLayout = (RVTabBarRootLayout) LayoutInflater.from(context).inflate(R.layout.ariver_tabbar_item, (ViewGroup) null);
        this.f5985a = rVTabBarRootLayout;
        this.b = (TextView) rVTabBarRootLayout.findViewById(R.id.ariver_tabbar_item_text);
        this.c = (TextView) this.f5985a.findViewById(R.id.ariver_tabbar_item_badge);
        this.d = (RVTabDotView) this.f5985a.findViewById(R.id.ariver_tabbar_item_dot_view);
    }

    public void setOnSelectedChangedListener(OnSelectedChangedListener onSelectedChangedListener) {
        this.f5985a.setOnSelectedChangedListener(onSelectedChangedListener);
    }

    public View getRootView() {
        return this.f5985a;
    }

    public TextView getIconAreaView() {
        return this.b;
    }

    public TextView getBadgeAreaView() {
        return this.c;
    }

    public RVTabDotView getSmallDotView() {
        return this.d;
    }

    public void setTag(String str) {
        this.f5985a.setTag(str);
    }

    public String getTag() {
        return (String) this.f5985a.getTag();
    }
}
