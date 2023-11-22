package com.alibaba.griver.ui.tabbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.griver.ui.R;

/* loaded from: classes6.dex */
public class TabBarItem {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f6760a;
    private TextView b;
    private TextView c;
    private DotView d;

    public TabBarItem(Context context) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.griver_ui_tabbaritem, (ViewGroup) null);
        this.f6760a = relativeLayout;
        this.b = (TextView) relativeLayout.findViewById(R.id.h5_tabbaritem_txticon);
        this.c = (TextView) this.f6760a.findViewById(R.id.h5_tabbaritem_badge);
        this.d = (DotView) this.f6760a.findViewById(R.id.h5_tabbaritem_dotView);
    }

    public View getRootView() {
        return this.f6760a;
    }

    public View getIconAreaView() {
        return this.b;
    }

    public View getBadgeAreaView() {
        return this.c;
    }

    public DotView getSmallDotView() {
        return this.d;
    }

    public String getTag() {
        return (String) this.f6760a.getTag();
    }

    public void setTag(String str) {
        this.f6760a.setTag(str);
    }
}
