package fsimpl;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Insets;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Property;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.fullstory.FS;
import com.google.android.material.badge.BadgeDrawable;

/* loaded from: classes.dex */
public class Q implements Application.ActivityLifecycleCallbacks {
    private Drawable b;
    private TextView c;
    private ImageView d;
    private ObjectAnimator e;
    private long f;

    /* renamed from: a  reason: collision with root package name */
    private final S f7811a = new S();
    private int g = -1;
    private int h = -1;

    private Bitmap a(Bitmap bitmap) {
        Bitmap a2 = C0353ex.a(bitmap, true);
        int width = a2.getWidth();
        int height = a2.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        a2.getPixels(iArr, 0, width, 0, 0, width, height);
        for (int i2 = 0; i2 < i; i2++) {
            if ((iArr[i2] >>> 24) > 136) {
                iArr[i2] = -1;
            } else {
                iArr[i2] = 0;
            }
        }
        a2.setPixels(iArr, 0, width, 0, 0, width, height);
        return a2;
    }

    private Drawable a(Context context) {
        if (this.b == null) {
            this.b = b(context);
        }
        return this.b;
    }

    private Drawable a(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843868, typedValue, true);
        Drawable drawable = context.getDrawable(typedValue.resourceId);
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setRadius(i / 2);
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ WindowInsets a(TextView textView, int i, int i2, View view, WindowInsets windowInsets) {
        Insets insets = windowInsets.getInsets(WindowInsets.Type.statusBars() | WindowInsets.Type.displayCutout());
        view.setPadding(textView.getPaddingLeft(), insets.top, textView.getPaddingRight(), i);
        view.setMinimumHeight(i2 + insets.top);
        return windowInsets;
    }

    private WindowManager.LayoutParams a() {
        int i;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -2, 1000, 280, -3);
        layoutParams.gravity = 49;
        if (Build.VERSION.SDK_INT < 30) {
            i = Build.VERSION.SDK_INT >= 28 ? 1 : 3;
            return layoutParams;
        }
        layoutParams.layoutInDisplayCutoutMode = i;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity) {
        this.c = c(activity);
        activity.getWindowManager().addView(this.c, a());
        this.d = d(activity);
        activity.getWindowManager().addView(this.d, b());
        a(this.c);
        this.f7811a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity, View view) {
        activity.getApplication().unregisterActivityLifecycleCallbacks(this);
        b(activity);
    }

    private void a(TextView textView) {
        if (this.e == null) {
            this.e = c();
        }
        this.e.setTarget(textView);
        this.e.setCurrentPlayTime(this.f);
        this.e.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(TextView textView, int i) {
        float width = textView.getWidth() / 2.0f;
        float f = i;
        this.f7811a.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, width, f, width, f});
    }

    private Drawable b(Context context) {
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), 17301560);
        Bitmap a2 = a(decodeResource);
        decodeResource.recycle();
        return new BitmapDrawable(context.getResources(), a2);
    }

    private WindowManager.LayoutParams b() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 1000, 296, -3);
        layoutParams.gravity = BadgeDrawable.TOP_END;
        return layoutParams;
    }

    private void b(Activity activity) {
        if (this.c != null) {
            activity.getWindowManager().removeView(this.c);
            this.c = null;
        }
        if (this.d != null) {
            activity.getWindowManager().removeView(this.d);
            this.d = null;
        }
        d();
        this.f7811a.b();
    }

    private int c(Context context) {
        if (this.g == -1) {
            this.g = (int) TypedValue.applyDimension(1, 24.0f, context.getResources().getDisplayMetrics());
        }
        return this.g;
    }

    private ObjectAnimator c() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object) null, Property.of(TextView.class, Float.TYPE, "alpha"), 0.04f, 0.5f);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setDuration(1600L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        return ofFloat;
    }

    private TextView c(Activity activity) {
        final TextView textView = new TextView(activity);
        textView.setTag("FSPreviewMode");
        textView.setText("Preview Mode");
        final int c = c((Context) activity);
        textView.setMinHeight(c);
        textView.setTextColor(C0349et.a(activity) ? -16777216 : -1);
        textView.setPaintFlags(32);
        textView.setBackground(this.f7811a);
        textView.setGravity(17);
        final int applyDimension = (int) TypedValue.applyDimension(1, 4.0f, activity.getResources().getDisplayMetrics());
        textView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: fsimpl.-$$Lambda$Q$Vf4rqB6FfrAnq6mHkXWKcSWEzVo
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                WindowInsets a2;
                a2 = Q.a(textView, applyDimension, c, view, windowInsets);
                return a2;
            }
        });
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: fsimpl.-$$Lambda$Q$a6-8QqVjw3T1XxBbRJCzY-UGSzk
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                Q.this.a(textView, applyDimension);
            }
        });
        FS.unmask(textView);
        return textView;
    }

    private int d(Context context) {
        if (this.h == -1) {
            this.h = (int) TypedValue.applyDimension(1, 4.0f, context.getResources().getDisplayMetrics());
        }
        return this.h;
    }

    private ImageView d(final Activity activity) {
        ImageView imageView = new ImageView(activity);
        imageView.setTag("FSPreviewMode");
        int c = c((Context) activity);
        int d = d((Context) activity);
        imageView.setMinimumWidth(c);
        imageView.setMaxWidth(c);
        imageView.setPadding(d, d, d, d);
        imageView.setAdjustViewBounds(true);
        imageView.setImageDrawable(a((Context) activity));
        imageView.setForeground(a(activity, c));
        imageView.setImageTintList(ColorStateList.valueOf(C0349et.a(activity) ? -16777216 : -1));
        imageView.setOnApplyWindowInsetsListener(new T(null));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: fsimpl.-$$Lambda$Q$RXNRGIlcrQri_etUoT0q0xvcJoU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Q.this.a(activity, view);
            }
        });
        FS.unmask(imageView);
        return imageView;
    }

    private void d() {
        ObjectAnimator objectAnimator = this.e;
        if (objectAnimator != null) {
            this.f = objectAnimator.getCurrentPlayTime();
            this.e.setTarget(null);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        if (decorView.isAttachedToWindow()) {
            a(activity);
        } else {
            decorView.addOnAttachStateChangeListener(new R(this, decorView, activity));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
