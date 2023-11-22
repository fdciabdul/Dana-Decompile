package com.alibaba.griver.ui.refresh;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.alibaba.griver.base.common.utils.CommonUtils;
import com.alibaba.griver.ui.R;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class ProgressView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<View> f6751a;
    private View b;
    private int c;
    private int d;
    private int e;
    private TimerHandler f;
    private boolean g;

    public ProgressView(Context context) {
        this(context, null, 0);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.f6751a = new ArrayList<>();
        this.c = 0;
        this.f = new TimerHandler();
        this.g = true;
        this.d = CommonUtils.dip2px(context, 8.0f);
        this.e = CommonUtils.dip2px(context, 6.0f);
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.griverProgressView, i, 0)) != null) {
            this.e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.griverProgressView_progress_dot_size, this.e);
            this.d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.griverProgressView_progress_dot_margin, this.d);
            obtainStyledAttributes.recycle();
        }
        a(context);
    }

    private void a(Context context) {
        View.inflate(context, R.layout.griver_ui_view_progress_dot, this);
        View findViewById = findViewById(R.id.progress_dot1);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
        marginLayoutParams.height = this.e;
        marginLayoutParams.width = this.e;
        marginLayoutParams.setMargins(0, 0, this.d, 0);
        findViewById.setAlpha(0.5f);
        findViewById.setLayoutParams(marginLayoutParams);
        this.f6751a.add(findViewById);
        View findViewById2 = findViewById(R.id.progress_dot2);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) findViewById2.getLayoutParams();
        marginLayoutParams2.height = this.e;
        marginLayoutParams2.width = this.e;
        marginLayoutParams2.setMargins(0, 0, this.d, 0);
        findViewById2.setAlpha(0.5f);
        findViewById2.setLayoutParams(marginLayoutParams2);
        this.f6751a.add(findViewById2);
        View findViewById3 = findViewById(R.id.progress_dot3);
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) findViewById3.getLayoutParams();
        marginLayoutParams3.height = this.e;
        marginLayoutParams3.width = this.e;
        findViewById3.setAlpha(0.5f);
        findViewById3.setLayoutParams(marginLayoutParams3);
        findViewById3.setAlpha(0.5f);
        this.f6751a.add(findViewById3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int i;
        int i2 = this.c;
        if (i2 >= 2) {
            i = 0;
        } else {
            i = i2 + 1;
            this.c = i;
        }
        this.c = i;
    }

    public void destory() {
        this.f.removeMessages(10086);
        this.f.removeCallbacksAndMessages(null);
        this.f = null;
    }

    public void stopLoading() {
        TimerHandler timerHandler = this.f;
        if (timerHandler != null) {
            timerHandler.removeMessages(10086);
            this.f.removeCallbacksAndMessages(null);
        }
        ArrayList<View> arrayList = this.f6751a;
        if (arrayList != null) {
            Iterator<View> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().setAlpha(0.2f);
            }
        }
    }

    public void startLoading() {
        TimerHandler timerHandler = this.f;
        if (timerHandler != null) {
            timerHandler.removeMessages(10086);
            this.f.removeCallbacksAndMessages(null);
        }
        b();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (this.g) {
            if (i == 0 && view.getVisibility() == 0) {
                b();
            } else {
                TimerHandler timerHandler = this.f;
                if (timerHandler != null) {
                    timerHandler.removeMessages(10086);
                }
            }
        }
        super.onVisibilityChanged(view, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        TimerHandler timerHandler = this.f;
        if (timerHandler != null) {
            timerHandler.removeMessages(10086);
            this.f.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        TimerHandler timerHandler = this.f;
        if (timerHandler != null) {
            timerHandler.sendEmptyMessageDelayed(10086, 400L);
        }
    }

    public void setAutoPlay(boolean z) {
        this.g = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDotsBackground(int i) {
        ArrayList<View> arrayList = this.f6751a;
        if (arrayList != null) {
            Iterator<View> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().setBackgroundResource(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class TimerHandler extends Handler {
        public TimerHandler() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AnimatorSet animatorSet = new AnimatorSet();
            if (ProgressView.this.b != null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(ProgressView.this.b, "alpha", 0.2f, 0.5f);
                ofFloat.setDuration(400L);
                animatorSet.play(ofFloat);
            }
            ProgressView.this.a();
            View view = (View) ProgressView.this.f6751a.get(ProgressView.this.c);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", 0.5f, 0.2f);
            ofFloat2.setDuration(400L);
            animatorSet.play(ofFloat2);
            animatorSet.start();
            ProgressView.this.b = view;
            ProgressView.this.b();
        }
    }
}
