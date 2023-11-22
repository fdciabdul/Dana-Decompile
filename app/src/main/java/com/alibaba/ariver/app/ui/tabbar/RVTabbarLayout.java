package com.alibaba.ariver.app.ui.tabbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class RVTabbarLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private List<RVTabBarItem> f5987a;
    private Listener b;

    /* loaded from: classes6.dex */
    public interface Listener {
        void onTabItemClicked(int i, View view);
    }

    public RVTabbarLayout(Context context) {
        super(context);
        this.f5987a = new ArrayList();
        a();
    }

    public RVTabbarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5987a = new ArrayList();
        a();
    }

    public RVTabbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5987a = new ArrayList();
        a();
    }

    private void a() {
        setOrientation(0);
    }

    public void addTab(int i, RVTabBarItem rVTabBarItem) {
        if (this.f5987a == null) {
            return;
        }
        final View rootView = rVTabBarItem.getRootView();
        rootView.setTag(rVTabBarItem);
        rootView.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.ariver.app.ui.tabbar.RVTabbarLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOf = RVTabbarLayout.this.f5987a.indexOf((RVTabBarItem) view.getTag());
                if (RVTabbarLayout.this.b != null) {
                    RVTabbarLayout.this.b.onTabItemClicked(indexOf, rootView);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.gravity = 17;
        rootView.setLayoutParams(layoutParams);
        rootView.setClickable(true);
        rootView.setFocusable(true);
        if (i >= 0) {
            this.f5987a.add(i, rVTabBarItem);
            addView(rootView, i);
            return;
        }
        this.f5987a.add(rVTabBarItem);
        addView(rootView);
    }

    public RVTabBarItem getTabBarItemAt(int i) {
        return this.f5987a.get(i);
    }

    public void addTab(RVTabBarItem rVTabBarItem) {
        addTab(-1, rVTabBarItem);
    }

    public void removeTab(int i) {
        this.f5987a.remove(i);
        removeViewAt(i);
    }

    public void setTabListener(Listener listener) {
        this.b = listener;
    }

    private void b() {
        List<RVTabBarItem> list = this.f5987a;
        if (list == null) {
            return;
        }
        Iterator<RVTabBarItem> it = list.iterator();
        while (it.hasNext()) {
            it.next().getRootView().setSelected(false);
        }
    }

    public void selectTab(int i) {
        List<RVTabBarItem> list = this.f5987a;
        if (list == null) {
            return;
        }
        if (i >= list.size()) {
            i = 0;
        }
        if (i == -1) {
            return;
        }
        RVTabBarItem rVTabBarItem = this.f5987a.get(i);
        b();
        rVTabBarItem.getRootView().setSelected(true);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        this.f5987a.clear();
    }

    public int getTabSize() {
        List<RVTabBarItem> list = this.f5987a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
