package me.zhanghai.android.materialprogressbar.internal;

import android.animation.ValueAnimator;
import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes9.dex */
public class ValueAnimatorCompat {
    private static Method sValueAnimatorGetDurationScaleMethod;
    private static boolean sValueAnimatorGetDurationScaleMethodInitialized;
    private static Field sValueAnimatorSDurationScaleField;
    private static boolean sValueAnimatorSDurationScaleFieldInitialized;
    private static final Object sValueAnimatorGetDurationScaleMethodLock = new Object();
    private static final Object sValueAnimatorSDurationScaleFieldLock = new Object();

    private ValueAnimatorCompat() {
    }

    public static boolean areAnimatorsEnabled() {
        Field valueAnimatorSDurationScaleField;
        Method valueAnimatorGetDurationScaleMethod;
        if (Build.VERSION.SDK_INT >= 26) {
            return ValueAnimator.areAnimatorsEnabled();
        }
        if (Build.VERSION.SDK_INT >= 17 && (valueAnimatorGetDurationScaleMethod = getValueAnimatorGetDurationScaleMethod()) != null) {
            try {
                return ((Float) valueAnimatorGetDurationScaleMethod.invoke(null, new Object[0])).floatValue() != 0.0f;
            } catch (Exception unused) {
            }
        }
        if (Build.VERSION.SDK_INT < 16 || (valueAnimatorSDurationScaleField = getValueAnimatorSDurationScaleField()) == null) {
            return true;
        }
        try {
            return ((Float) valueAnimatorSDurationScaleField.get(null)).floatValue() != 0.0f;
        } catch (Exception unused2) {
            return true;
        }
    }

    private static Method getValueAnimatorGetDurationScaleMethod() {
        Method method;
        synchronized (sValueAnimatorGetDurationScaleMethodLock) {
            if (!sValueAnimatorGetDurationScaleMethodInitialized) {
                try {
                    Method declaredMethod = ValueAnimator.class.getDeclaredMethod("getDurationScale", new Class[0]);
                    sValueAnimatorGetDurationScaleMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception unused) {
                }
                sValueAnimatorGetDurationScaleMethodInitialized = true;
            }
            method = sValueAnimatorGetDurationScaleMethod;
        }
        return method;
    }

    private static Field getValueAnimatorSDurationScaleField() {
        Field field;
        synchronized (sValueAnimatorSDurationScaleFieldLock) {
            if (!sValueAnimatorSDurationScaleFieldInitialized) {
                try {
                    Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
                    sValueAnimatorSDurationScaleField = declaredField;
                    declaredField.setAccessible(true);
                } catch (Exception unused) {
                }
                sValueAnimatorSDurationScaleFieldInitialized = true;
            }
            field = sValueAnimatorSDurationScaleField;
        }
        return field;
    }
}
