package com.alibaba.griver.ui.tabbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class TabBarLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private List<View> f6761a;
    private int b;
    private H5TabListener c;

    /* loaded from: classes6.dex */
    public interface H5TabListener {
        void onTabItemClicked(int i, View view);
    }

    public TabBarLayout(Context context) {
        super(context);
        this.f6761a = new ArrayList();
        a();
    }

    public TabBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6761a = new ArrayList();
        a();
    }

    public TabBarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6761a = new ArrayList();
        a();
    }

    private void a() {
        setOrientation(0);
    }

    public void addTab(int i, final View view) {
        if (this.f6761a != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.tabbar.TabBarLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    int indexOf = TabBarLayout.this.f6761a.indexOf(view2);
                    if (TabBarLayout.this.c != null) {
                        TabBarLayout.this.c.onTabItemClicked(indexOf, view);
                    }
                }
            });
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
            layoutParams.gravity = 17;
            view.setLayoutParams(layoutParams);
            view.setClickable(true);
            view.setFocusable(true);
            if (i >= 0) {
                this.f6761a.add(i, view);
                addView(view, i);
                return;
            }
            this.f6761a.add(view);
            addView(view);
        }
    }

    public void addTab(View view) {
        addTab(-1, view);
    }

    public void setTabListener(H5TabListener h5TabListener) {
        this.c = h5TabListener;
    }

    private void b() {
        List<View> list = this.f6761a;
        if (list == null) {
            return;
        }
        Iterator<View> it = list.iterator();
        while (it.hasNext()) {
            it.next().setSelected(false);
        }
    }

    public void selectTab(int i) {
        List<View> list = this.f6761a;
        if (list == null) {
            return;
        }
        if (i >= list.size()) {
            i = 0;
        }
        View view = this.f6761a.get(i);
        b();
        view.setSelected(true);
        this.b = i;
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        this.f6761a.clear();
        this.b = -1;
    }

    public int getSelectedIndex() {
        return this.b;
    }

    public int getTabSize() {
        List<View> list = this.f6761a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
