package com.synnapps.carouselview;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes8.dex */
public class CarouselViewPagerTransformer implements ViewPager.PageTransformer {
    public static final int DEFAULT = -1;
    public static final int DEPTH = 2;
    public static final int FLOW = 0;
    private static final float MIN_ALPHA_SLIDE = 0.35f;
    private static final float MIN_ALPHA_ZOOM = 0.5f;
    private static final float MIN_SCALE_DEPTH = 0.75f;
    private static final float MIN_SCALE_ZOOM = 0.85f;
    private static final float SCALE_FACTOR_SLIDE = 0.85f;
    public static final int SLIDE_OVER = 1;
    public static final int ZOOM = 3;
    private final int mTransformType;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Transformer {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CarouselViewPagerTransformer(int i) {
        this.mTransformType = i;
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f) {
        float abs;
        int i = this.mTransformType;
        if (i == 0) {
            view.setRotationY(f * (-30.0f));
            return;
        }
        float f2 = 0.0f;
        float f3 = 1.0f;
        if (i == 1) {
            if (f < 0.0f && f > -1.0f) {
                abs = (Math.abs(Math.abs(f) - 1.0f) * 0.14999998f) + 0.85f;
                f3 = Math.max((float) MIN_ALPHA_SLIDE, 1.0f - Math.abs(f));
                float f4 = -view.getWidth();
                float f5 = f * f4;
                if (f5 > f4) {
                    f2 = f5;
                }
            }
            abs = 1.0f;
        } else if (i == 2) {
            if (f > 0.0f && f < 1.0f) {
                f2 = view.getWidth() * (-f);
                abs = ((1.0f - Math.abs(f)) * 0.25f) + MIN_SCALE_DEPTH;
                f3 = 1.0f - f;
            }
            abs = 1.0f;
        } else if (i != 3) {
            return;
        } else {
            if (f >= -1.0f && f <= 1.0f) {
                abs = Math.max(0.85f, 1.0f - Math.abs(f));
                float f6 = (abs - 0.85f) / 0.14999998f;
                float f7 = 1.0f - abs;
                float height = (view.getHeight() * f7) / 2.0f;
                float width = (view.getWidth() * f7) / 2.0f;
                f2 = f < 0.0f ? width - (height / 2.0f) : (-width) + (height / 2.0f);
                f3 = (f6 * MIN_ALPHA_ZOOM) + MIN_ALPHA_ZOOM;
            }
            abs = 1.0f;
        }
        view.setAlpha(f3);
        view.setTranslationX(f2);
        view.setScaleX(abs);
        view.setScaleY(abs);
    }
}
