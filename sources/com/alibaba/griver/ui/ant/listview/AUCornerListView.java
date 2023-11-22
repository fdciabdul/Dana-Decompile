package com.alibaba.griver.ui.ant.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.alibaba.griver.ui.R;

/* loaded from: classes6.dex */
public class AUCornerListView extends AUListView {

    /* renamed from: a  reason: collision with root package name */
    private int f6689a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private boolean f;

    public AUCornerListView(Context context) {
        super(context);
        this.f6689a = R.drawable.griver_ui_pop_list_corner_round;
        this.b = R.drawable.griver_ui_pop_list_corner_round_top;
        this.c = R.drawable.griver_ui_pop_list_corner_round_bottom;
        this.d = R.drawable.griver_ui_pop_list_corner_shape;
        this.e = false;
        this.f = false;
    }

    public AUCornerListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6689a = R.drawable.griver_ui_pop_list_corner_round;
        this.b = R.drawable.griver_ui_pop_list_corner_round_top;
        this.c = R.drawable.griver_ui_pop_list_corner_round_bottom;
        this.d = R.drawable.griver_ui_pop_list_corner_shape;
        this.e = false;
        this.f = false;
    }

    public AUCornerListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6689a = R.drawable.griver_ui_pop_list_corner_round;
        this.b = R.drawable.griver_ui_pop_list_corner_round_top;
        this.c = R.drawable.griver_ui_pop_list_corner_round_bottom;
        this.d = R.drawable.griver_ui_pop_list_corner_shape;
        this.e = false;
        this.f = false;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            a(pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY()));
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private void a(int i) {
        if (i != -1) {
            if (i == getFirstVisiblePosition() && !this.f) {
                if (i == getAdapter().getCount() - 1) {
                    setSelector(this.f6689a);
                } else {
                    setSelector(this.b);
                }
            } else if (i == getLastVisiblePosition() && !this.e) {
                setSelector(this.c);
            } else {
                setSelector(this.d);
            }
        }
    }

    public void updateHeadState(boolean z) {
        this.f = z;
    }

    public void updateFootState(boolean z) {
        this.e = z;
    }
}
