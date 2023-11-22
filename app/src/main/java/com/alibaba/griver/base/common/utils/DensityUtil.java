package com.alibaba.griver.base.common.utils;

import android.content.Context;
import android.view.View;

/* loaded from: classes6.dex */
public class DensityUtil {

    /* renamed from: a  reason: collision with root package name */
    private static float f6308a;
    private static float b;

    public static float getFontSize(float f) {
        if (f == 0.875f) {
            return 14.0f;
        }
        if (f == 1.0f) {
            return 16.0f;
        }
        if (f == 1.125f) {
            return 18.0f;
        }
        if (f == 1.25f) {
            return 20.0f;
        }
        return f == 1.375f ? 22.0f : 16.0f;
    }

    public static float getScale(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return i != 4 ? 1.0f : 1.375f;
                    }
                    return 1.25f;
                }
                return 1.125f;
            }
            return 1.0f;
        }
        return 0.875f;
    }

    public static boolean isValueEqule(float f, float f2) {
        return ((int) f) == ((int) f2);
    }

    public static int dip2px(Context context, float f) {
        a(context);
        return (int) ((f * f6308a) + 0.5f);
    }

    private static void a(Context context) {
        try {
            if (f6308a == 0.0f) {
                f6308a = context.getResources().getDisplayMetrics().density;
            }
        } catch (Throwable unused) {
        }
    }

    public static int px2dip(Context context, float f) {
        a(context);
        return (int) ((f / f6308a) + 0.5f);
    }

    public static int getRelativeTop(View view) {
        return view.getId() == 16908290 ? view.getTop() : view.getTop() + getRelativeTop((View) view.getParent());
    }

    public static int getRelativeLeft(View view) {
        return view.getId() == 16908290 ? view.getLeft() : view.getLeft() + getRelativeLeft((View) view.getParent());
    }

    public static float getTextSize(float f, int i) {
        return getScale(i) * f;
    }

    public static float px2sp(Context context, float f) {
        b(context);
        return f / b;
    }

    public static int sp2px(Context context, float f) {
        b(context);
        return (int) ((f * b) + 0.5f);
    }

    private static void b(Context context) {
        try {
            if (b == 0.0f) {
                b = context.getResources().getDisplayMetrics().scaledDensity;
            }
        } catch (Throwable unused) {
        }
    }
}
