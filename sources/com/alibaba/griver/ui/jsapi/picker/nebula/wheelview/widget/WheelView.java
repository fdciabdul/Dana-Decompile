package com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.fullstory.instrumentation.FSDraw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class WheelView extends ScrollView {
    public static final int LINE_COLOR = -8139290;
    public static final int OFF_SET = 1;
    public static final int TEXT_COLOR_FOCUS = -16611122;
    public static final int TEXT_COLOR_NORMAL = -4473925;
    public static final int TEXT_SIZE = 16;

    /* renamed from: a  reason: collision with root package name */
    private Context f6718a;
    private LinearLayout b;
    private List<String> c;
    private int d;
    private int e;
    private int f;
    private int g;
    private Runnable h;
    private int i;
    private int[] j;
    private OnWheelViewListener k;
    private Paint l;
    private int m;
    private int n;

    /* renamed from: o  reason: collision with root package name */
    private int f6719o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private float t;

    /* loaded from: classes6.dex */
    public interface OnWheelViewListener {
        void onSelected(boolean z, int i, String str);
    }

    public WheelView(Context context) {
        super(context);
        this.c = new ArrayList();
        this.d = 1;
        this.f = 1;
        this.h = new ScrollerTask(this, null);
        this.i = 0;
        this.n = 16;
        this.f6719o = -4473925;
        this.p = -16611122;
        this.q = -8139290;
        this.r = true;
        this.s = false;
        this.t = 0.0f;
        a(context);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new ArrayList();
        this.d = 1;
        this.f = 1;
        this.h = new ScrollerTask(this, null);
        this.i = 0;
        this.n = 16;
        this.f6719o = -4473925;
        this.p = -16611122;
        this.q = -8139290;
        this.r = true;
        this.s = false;
        this.t = 0.0f;
        a(context);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new ArrayList();
        this.d = 1;
        this.f = 1;
        this.h = new ScrollerTask(this, null);
        this.i = 0;
        this.n = 16;
        this.f6719o = -4473925;
        this.p = -16611122;
        this.q = -8139290;
        this.r = true;
        this.s = false;
        this.t = 0.0f;
        a(context);
    }

    private void a(Context context) {
        this.f6718a = context;
        setFadingEdgeLength(0);
        if (Build.VERSION.SDK_INT >= 9) {
            setOverScrollMode(2);
        }
        setVerticalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.b = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.g = getScrollY();
        postDelayed(this.h, 50L);
    }

    private void b() {
        this.e = (this.d * 2) + 1;
        this.b.removeAllViews();
        Iterator<String> it = this.c.iterator();
        while (it.hasNext()) {
            this.b.addView(a(it.next()));
        }
        a(this.i * (this.f - this.d));
    }

    private TextView a(String str) {
        TextView textView = new TextView(this.f6718a);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setText(str);
        textView.setTextSize(this.n);
        textView.setGravity(17);
        int a2 = a(15.0f);
        textView.setPadding(a2, a2, a2, a2);
        if (this.i == 0) {
            this.i = a(textView);
            StringBuilder sb = new StringBuilder();
            sb.append("itemHeight: ");
            sb.append(this.i);
            GriverLogger.debug("compositeui", sb.toString());
            this.b.setLayoutParams(new FrameLayout.LayoutParams(-1, this.i * this.e));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, -2);
            }
            setLayoutParams(new LinearLayout.LayoutParams(layoutParams.width, this.i * this.e));
        }
        return textView;
    }

    private void a(int i) {
        int i2 = this.i;
        int i3 = (i / i2) + this.d;
        int i4 = i % i2;
        if (i4 != 0 && i4 > i2 / 2) {
            i3++;
        }
        int childCount = this.b.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            TextView textView = (TextView) this.b.getChildAt(i5);
            if (textView == null) {
                return;
            }
            if (i3 == i5) {
                textView.setTextColor(this.p);
            } else {
                textView.setTextColor(this.f6719o);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] c() {
        if (this.j == null) {
            this.j = r0;
            int i = this.i;
            int i2 = this.d;
            int[] iArr = {i * i2, i * (i2 + 1)};
        }
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        OnWheelViewListener onWheelViewListener = this.k;
        if (onWheelViewListener != null) {
            boolean z = this.s;
            int i = this.f;
            int i2 = this.d;
            onWheelViewListener.onSelected(z, i - i2, this.c.get(i));
        }
    }

    private int a(float f) {
        return (int) ((f * this.f6718a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private int a(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        return view.getMeasuredHeight();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.m == 0) {
            this.m = ((Activity) this.f6718a).getWindowManager().getDefaultDisplay().getWidth();
            StringBuilder sb = new StringBuilder();
            sb.append("viewWidth: ");
            sb.append(this.m);
            GriverLogger.debug("compositeui", sb.toString());
        }
        if (this.r) {
            if (this.l == null) {
                Paint paint = new Paint();
                this.l = paint;
                paint.setColor(this.q);
                this.l.setStrokeWidth(a(1.0f));
            }
            super.setBackgroundDrawable(new AnonymousClass1());
        }
    }

    /* renamed from: com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.widget.WheelView$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 extends Drawable implements FSDraw {
        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        AnonymousClass1() {
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            int[] c = WheelView.this.c();
            canvas.drawLine(WheelView.this.m / 6, c[0], (WheelView.this.m * 5) / 6, c[0], WheelView.this.l);
            canvas.drawLine(WheelView.this.m / 6, c[1], (WheelView.this.m * 5) / 6, c[1], WheelView.this.l);
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        a(i2);
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        StringBuilder sb = new StringBuilder();
        sb.append("w: ");
        sb.append(i);
        sb.append(", h: ");
        sb.append(i2);
        sb.append(", oldw: ");
        sb.append(i3);
        sb.append(", oldh: ");
        sb.append(i4);
        GriverLogger.debug("compositeui", sb.toString());
        this.m = i;
        setBackgroundDrawable(null);
    }

    @Override // android.widget.ScrollView
    public void fling(int i) {
        super.fling(i / 3);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.t = motionEvent.getY();
        } else if (action == 1) {
            GriverLogger.debug("compositeui", String.format("items=%s, offset=%s", Integer.valueOf(this.c.size()), Integer.valueOf(this.d)));
            StringBuilder sb = new StringBuilder();
            sb.append("selectedIndex=");
            sb.append(this.f);
            GriverLogger.debug("compositeui", sb.toString());
            float y = motionEvent.getY();
            float f = this.t;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("delta=");
            sb2.append(y - f);
            GriverLogger.debug("compositeui", sb2.toString());
            this.s = true;
            a();
        }
        return super.onTouchEvent(motionEvent);
    }

    private void a(List<String> list) {
        this.c.clear();
        this.c.addAll(list);
        for (int i = 0; i < this.d; i++) {
            this.c.add(0, "");
            this.c.add("");
        }
        b();
    }

    public void setItems(List<String> list) {
        a(list);
        setSelectedIndex(0);
    }

    public void setItems(List<String> list, int i) {
        a(list);
        setSelectedIndex(i);
    }

    public void setItems(List<String> list, String str) {
        a(list);
        setSelectedItem(str);
    }

    public int getTextSize() {
        return this.n;
    }

    public void setTextSize(int i) {
        this.n = i;
    }

    public int getTextColor() {
        return this.p;
    }

    public void setTextColor(int i) {
        this.p = i;
    }

    public void setTextColor(int i, int i2) {
        this.f6719o = i;
        this.p = i2;
    }

    public boolean isLineVisible() {
        return this.r;
    }

    public void setLineVisible(boolean z) {
        this.r = z;
    }

    public int getLineColor() {
        return this.q;
    }

    public void setLineColor(int i) {
        this.q = i;
    }

    public int getOffset() {
        return this.d;
    }

    public void setOffset(int i) {
        if (i <= 0 || i > 4) {
            throw new IllegalArgumentException("Offset must between 1 and 4");
        }
        this.d = i;
    }

    @Deprecated
    public String getSeletedItem() {
        return getSelectedItem();
    }

    public String getSelectedItem() {
        return this.c.get(this.f);
    }

    public void setSelectedItem(String str) {
        for (int i = 0; i < this.c.size(); i++) {
            if (this.c.get(i).equals(str)) {
                setSelectedIndex(i - this.d);
                return;
            }
        }
    }

    @Deprecated
    public int getSeletedIndex() {
        return getSelectedIndex();
    }

    public int getSelectedIndex() {
        return this.f - this.d;
    }

    private void setSelectedIndex(final int i) {
        this.s = false;
        post(new Runnable() { // from class: com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.widget.WheelView.2
            @Override // java.lang.Runnable
            public void run() {
                WheelView wheelView = WheelView.this;
                wheelView.scrollTo(0, i * wheelView.i);
                WheelView wheelView2 = WheelView.this;
                wheelView2.f = i + wheelView2.d;
                WheelView.this.d();
            }
        });
    }

    public void setOnWheelViewListener(OnWheelViewListener onWheelViewListener) {
        this.k = onWheelViewListener;
    }

    @Override // android.view.View
    public CharSequence getContentDescription() {
        int i;
        List<String> list = this.c;
        return (list == null || (i = this.f) < 0 || i >= list.size()) ? "" : this.c.get(this.f);
    }

    /* loaded from: classes6.dex */
    class ScrollerTask implements Runnable {
        private ScrollerTask() {
        }

        /* synthetic */ ScrollerTask(WheelView wheelView, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WheelView.this.i == 0) {
                GriverLogger.debug("compositeui", "itemHeight is zero");
                return;
            }
            if (WheelView.this.g - WheelView.this.getScrollY() == 0) {
                final int i = WheelView.this.g % WheelView.this.i;
                final int i2 = WheelView.this.g / WheelView.this.i;
                StringBuilder sb = new StringBuilder();
                sb.append("initialY: ");
                sb.append(WheelView.this.g);
                sb.append(", remainder: ");
                sb.append(i);
                sb.append(", divided: ");
                sb.append(i2);
                GriverLogger.debug("compositeui", sb.toString());
                if (i != 0) {
                    if (i > WheelView.this.i / 2) {
                        WheelView.this.post(new Runnable() { // from class: com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.widget.WheelView.ScrollerTask.1
                            @Override // java.lang.Runnable
                            public void run() {
                                WheelView.this.smoothScrollTo(0, (WheelView.this.g - i) + WheelView.this.i);
                                WheelView.this.f = i2 + WheelView.this.d + 1;
                                WheelView.this.d();
                            }
                        });
                        return;
                    } else {
                        WheelView.this.post(new Runnable() { // from class: com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.widget.WheelView.ScrollerTask.2
                            @Override // java.lang.Runnable
                            public void run() {
                                WheelView.this.smoothScrollTo(0, WheelView.this.g - i);
                                WheelView.this.f = i2 + WheelView.this.d;
                                WheelView.this.d();
                            }
                        });
                        return;
                    }
                }
                WheelView wheelView = WheelView.this;
                wheelView.f = i2 + wheelView.d;
                WheelView.this.d();
                return;
            }
            WheelView.this.a();
        }
    }
}
