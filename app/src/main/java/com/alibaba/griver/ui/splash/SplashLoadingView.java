package com.alibaba.griver.ui.splash;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.ariver.app.api.ui.StatusBarUtils;
import com.alibaba.griver.ui.R;
import com.fullstory.instrumentation.FSDispatchDraw;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.Map;

/* loaded from: classes3.dex */
public class SplashLoadingView extends LoadingView implements FSDispatchDraw {
    public static final String ANIMATION_STOP_LOADING_PREPARE = "ANIMATION_STOP_LOADING_PREPARE";
    public static final String DATA_UPDATE_APPEARANCE_BG_COLOR = "UPDATE_APPEARANCE_BG_COLOR";
    public static final String DATA_UPDATE_APPEARANCE_LOADING_BOTTOM_TIP = "UPDATE_APPEARANCE_LOADING_BOTTOM_TIP";
    public static final String DATA_UPDATE_APPEARANCE_LOADING_ICON = "UPDATE_APPEARANCE_LOADING_ICON";
    public static final String DATA_UPDATE_APPEARANCE_LOADING_PROGRESS = "DATA_UPDATE_APPEARANCE_LOADING_PROGRESS";
    public static final String DATA_UPDATE_APPEARANCE_LOADING_TEXT = "UPDATE_APPEARANCE_LOADING_TEXT";
    public static final String DATA_UPDATE_APPEARANCE_LOADING_TEXT_COLOR = "UPDATE_APPEARANCE_LOADING_TEXT_COLOR";
    public static final String MSG_UPDATE_APPEARANCE = "UPDATE_APPEARANCE";

    /* renamed from: a  reason: collision with root package name */
    private Context f6755a;
    private Paint b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private Paint i;
    private Rect j;
    private int k;
    private int l;
    private int m;
    protected TextView mBottomTip;
    protected ImageView mLoadingBgIcon;
    protected ImageView mLoadingIcon;
    protected TextView mLoadingTitle;
    private int n;

    /* renamed from: o  reason: collision with root package name */
    private int f6756o;
    private int p;
    private int q;
    private int r;
    private int s;
    private Paint t;
    private ValueAnimator u;

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return fsSuperDrawChild_8ca0fdcd24eb102ce183e3d90dd7f86e(canvas, view, j);
    }

    public void fsSuperDispatchDraw_8ca0fdcd24eb102ce183e3d90dd7f86e(Canvas canvas) {
        if (InstrumentInjector.isRecordingDispatchDraw(this, canvas)) {
            return;
        }
        super.dispatchDraw(canvas);
    }

    public boolean fsSuperDrawChild_8ca0fdcd24eb102ce183e3d90dd7f86e(Canvas canvas, View view, long j) {
        if (InstrumentInjector.isRecordingDrawChild(this, canvas, view, j)) {
            return false;
        }
        return super.drawChild(canvas, view, j);
    }

    public SplashLoadingView(Context context) {
        this(context, null);
    }

    public SplashLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SplashLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = 0;
        this.m = 0;
        this.f6755a = context;
        initView();
    }

    public static void setStatusBarColor(Activity activity, int i) {
        if (!StatusBarUtils.isSupport() || activity == null) {
            return;
        }
        Window window = activity.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        window.setStatusBarColor(i);
    }

    public void initView() {
        ImageView imageView = new ImageView(this.f6755a);
        this.mLoadingIcon = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        InstrumentInjector.Resources_setImageResource(this.mLoadingIcon, R.drawable.griver_ui_default_loading_icon);
        ImageView imageView2 = new ImageView(this.f6755a);
        this.mLoadingBgIcon = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        InstrumentInjector.Resources_setImageResource(this.mLoadingBgIcon, R.drawable.griver_ui_icon_corner);
        TextView textView = new TextView(this.f6755a);
        this.mLoadingTitle = textView;
        textView.setGravity(17);
        this.mLoadingTitle.setTextColor(this.f6755a.getResources().getColor(R.color.griver_web_loading_text));
        this.mLoadingTitle.setTextSize(1, 17.0f);
        this.mLoadingTitle.setEllipsize(TextUtils.TruncateAt.END);
        this.mLoadingTitle.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        addView(this.mLoadingIcon);
        addView(this.mLoadingBgIcon);
        addView(this.mLoadingTitle);
        TextView textView2 = new TextView(this.f6755a);
        this.mBottomTip = textView2;
        textView2.setTextColor(this.f6755a.getResources().getColor(R.color.griver_web_loading_bottom_tip_text));
        this.mBottomTip.setTextSize(12.0f);
        this.mBottomTip.setGravity(17);
        this.mBottomTip.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        addView(this.mBottomTip);
        this.c = this.f6755a.getResources().getColor(R.color.griver_web_loading_progress_light_new);
        this.d = this.f6755a.getResources().getColor(R.color.griver_web_loading_progress_dark_new);
        this.e = a(R.dimen.griver_loading_progress_widget);
        this.f = a(R.dimen.griver_loading_progress_height);
        Paint paint = new Paint();
        this.b = paint;
        paint.setStrokeWidth(this.f);
        this.b.setStyle(Paint.Style.FILL);
        this.b.setStrokeCap(Paint.Cap.ROUND);
        this.b.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.i = paint2;
        paint2.setTextSize(a(R.dimen.griver_web_loading_progress_text_size));
        this.i.setAntiAlias(true);
        this.j = new Rect();
        this.n = this.f6755a.getResources().getColor(R.color.griver_web_loading_dot_dark_new);
        this.f6756o = this.f6755a.getResources().getColor(R.color.griver_web_loading_dot_light_new);
        this.s = a(R.dimen.griver_loading_dot_size);
        Paint paint3 = new Paint();
        this.t = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.r = a(R.dimen.griver_loading_dot_margin);
        setBackgroundColor(this.f6755a.getResources().getColor(R.color.griver_web_loading_default_bg));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int a2 = a(R.dimen.griver_loading_icon_size);
        this.mLoadingIcon.measure(b(a2), b(a2));
        this.mLoadingBgIcon.measure(b(a2), b(a2));
        int a3 = a(R.dimen.griver_loading_title_height);
        this.mLoadingTitle.measure(View.MeasureSpec.makeMeasureSpec(a(R.dimen.griver_loading_title_width), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(a3, Integer.MIN_VALUE));
        this.mBottomTip.measure(b(a(R.dimen.griver_loading_bottom_tip_width)), View.MeasureSpec.makeMeasureSpec(a(R.dimen.griver_loading_bottom_tip_height), Integer.MIN_VALUE));
        setMeasuredDimension(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = (getMeasuredWidth() - this.mLoadingIcon.getMeasuredWidth()) / 2;
        int a2 = a(R.dimen.griver_loading_titlebar_height) + a(R.dimen.griver_loading_icon_margin_top);
        ImageView imageView = this.mLoadingIcon;
        imageView.layout(measuredWidth, a2, imageView.getMeasuredWidth() + measuredWidth, this.mLoadingIcon.getMeasuredHeight() + a2);
        this.mLoadingBgIcon.layout(measuredWidth, a2, this.mLoadingIcon.getMeasuredWidth() + measuredWidth, this.mLoadingIcon.getMeasuredHeight() + a2);
        int measuredWidth2 = (getMeasuredWidth() - this.mLoadingTitle.getMeasuredWidth()) / 2;
        int measuredHeight = a2 + this.mLoadingIcon.getMeasuredHeight() + a(R.dimen.griver_loading_title_margin_top);
        TextView textView = this.mLoadingTitle;
        textView.layout(measuredWidth2, measuredHeight, textView.getMeasuredWidth() + measuredWidth2, this.mLoadingTitle.getMeasuredHeight() + measuredHeight);
        int measuredHeight2 = this.mLoadingTitle.getMeasuredHeight() + measuredHeight + a(R.dimen.griver_loading_dot_margin_top);
        this.h = measuredHeight2;
        this.k = measuredHeight2 + this.f + a(R.dimen.griver_loading_progress_text_margin_top);
        this.p = ((getMeasuredWidth() / 2) - this.s) - this.r;
        this.q = measuredHeight + this.mLoadingTitle.getMeasuredHeight() + a(R.dimen.griver_loading_dot_margin_top);
        int measuredWidth3 = (getMeasuredWidth() - this.mBottomTip.getMeasuredWidth()) / 2;
        int measuredHeight3 = (getMeasuredHeight() - a(R.dimen.griver_loading_bottom_tip_margin_bottom)) - this.mBottomTip.getMeasuredHeight();
        TextView textView2 = this.mBottomTip;
        textView2.layout(measuredWidth3, measuredHeight3, textView2.getMeasuredWidth() + measuredWidth3, this.mBottomTip.getMeasuredHeight() + measuredHeight3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        fsSuperDispatchDraw_8ca0fdcd24eb102ce183e3d90dd7f86e(canvas);
        if (this.progressType == 0) {
            this.t.setColor(this.n);
            this.p = ((getMeasuredWidth() / 2) - this.s) - this.r;
            for (int i = 0; i < 3; i++) {
                this.t.setColor((System.currentTimeMillis() / 300) % 3 == ((long) i) ? this.f6756o : this.n);
                canvas.drawCircle(this.p, this.q, this.s / 2, this.t);
                this.p = this.p + this.r + this.s;
            }
        } else if (this.progressType == 1) {
            this.g = (getMeasuredWidth() - this.e) / 2;
            this.b.setColor(this.d);
            int i2 = this.g;
            float f = this.h;
            canvas.drawLine(i2, f, i2 + this.e, f, this.b);
            this.b.setColor(this.c);
            int i3 = this.g;
            float f2 = this.h;
            canvas.drawLine(i3, f2, i3 + ((this.e * this.l) / 100), f2, this.b);
            StringBuilder sb = new StringBuilder();
            sb.append(this.l);
            sb.append("%");
            String obj = sb.toString();
            this.i.getTextBounds(obj, 0, obj.length(), this.j);
            Paint.FontMetricsInt fontMetricsInt = this.i.getFontMetricsInt();
            canvas.drawText(obj, (getMeasuredWidth() / 2) - (this.j.width() / 2), (this.k + fontMetricsInt.bottom) - fontMetricsInt.top, this.i);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    private int a(int i) {
        return this.f6755a.getResources().getDimensionPixelSize(i);
    }

    private int b(int i) {
        return View.MeasureSpec.makeMeasureSpec(i, 1073741824);
    }

    @Override // com.alibaba.griver.ui.splash.LoadingView
    public void onStart() {
        a();
    }

    @Override // com.alibaba.griver.ui.splash.LoadingView
    public void onStop() {
        ValueAnimator valueAnimator = this.u;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.u.cancel();
    }

    @Override // com.alibaba.griver.ui.splash.LoadingView
    public void onHandleMessage(String str, Map<String, Object> map) {
        if (MSG_UPDATE_APPEARANCE.equals(str)) {
            String str2 = (String) map.get(DATA_UPDATE_APPEARANCE_BG_COLOR);
            if (!TextUtils.isEmpty(str2)) {
                setBackgroundColor(Color.parseColor(str2));
            }
            Drawable drawable = (Drawable) map.get(DATA_UPDATE_APPEARANCE_LOADING_ICON);
            if (drawable != null) {
                this.mLoadingIcon.setImageDrawable(drawable);
            }
            String str3 = (String) map.get(DATA_UPDATE_APPEARANCE_LOADING_TEXT);
            if (str3 != null) {
                this.mLoadingTitle.setText(str3);
            }
            String str4 = (String) map.get(DATA_UPDATE_APPEARANCE_LOADING_TEXT_COLOR);
            if (!TextUtils.isEmpty(str4)) {
                this.mLoadingTitle.setTextColor(Color.parseColor(str4));
            }
            String str5 = (String) map.get(DATA_UPDATE_APPEARANCE_LOADING_BOTTOM_TIP);
            if (str5 != null) {
                this.mBottomTip.setText(str5);
            }
            Integer num = (Integer) map.get(DATA_UPDATE_APPEARANCE_LOADING_PROGRESS);
            if (num != null) {
                if (this.m <= num.intValue()) {
                    this.m = num.intValue();
                    performAnimation();
                    return;
                }
                this.l = num.intValue();
                postInvalidate();
            }
        }
    }

    @Override // com.alibaba.griver.ui.splash.LoadingView
    public ImageView getIconImageView() {
        return this.mLoadingIcon;
    }

    public int getProgress() {
        return this.l;
    }

    public void performAnimation() {
        if (this.progressType == 0) {
            if (this.u == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.u = valueAnimator;
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.alibaba.griver.ui.splash.SplashLoadingView.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        SplashLoadingView.this.postInvalidate();
                    }
                });
            }
            if (this.u.isRunning()) {
                return;
            }
            this.u.setIntValues(0, 100);
            this.u.setDuration(3600000L).start();
        } else if (this.progressType == 1) {
            if (this.u == null) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.u = valueAnimator2;
                valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.alibaba.griver.ui.splash.SplashLoadingView.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        SplashLoadingView.this.l = ((Integer) valueAnimator3.getAnimatedValue()).intValue();
                        SplashLoadingView.this.postInvalidate();
                    }
                });
            }
            if (this.u.isRunning()) {
                this.u.cancel();
            }
            this.u.setIntValues(this.l, this.m);
            this.u.setDuration(300L).start();
        }
    }

    private void a() {
        if (this.hostActivity == null || !this.hostActivity.getClass().getName().equals("com.alipay.mobile.core.loading.impl.LoadingPage")) {
            return;
        }
        setStatusBarColor(this.hostActivity, 855638016);
    }

    @Override // com.alibaba.griver.ui.splash.LoadingView
    public void setProgressType(int i) {
        if (this.progressType == i) {
            return;
        }
        super.setProgressType(i);
        onStop();
        this.u = null;
    }
}
