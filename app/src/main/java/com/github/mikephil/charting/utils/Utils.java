package com.github.mikephil.charting.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.fullstory.instrumentation.InstrumentInjector;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.huawei.hms.framework.common.ExceptionCode;
import kotlin.time.DurationKt;

/* loaded from: classes3.dex */
public abstract class Utils {
    private static int NetworkUserEntityData$$ExternalSyntheticLambda1 = 50;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda2 = 8000;
    private static DisplayMetrics initRecordTimeStamp;
    public static final double getAuthRequestContext = Double.longBitsToDouble(1);
    public static final float KClassImpl$Data$declaredNonStaticMembers$2 = Float.intBitsToFloat(1);
    private static Rect PlaceComponentResult = new Rect();
    private static Paint.FontMetrics getErrorConfigVersion = new Paint.FontMetrics();
    private static Rect BuiltInFictitiousFunctionClassFactory = new Rect();
    private static final int[] MyBillsEntityDataFactory = {1, 10, 100, 1000, 10000, 100000, DurationKt.NANOS_IN_MILLIS, ExceptionCode.CRASH_EXCEPTION, 100000000, com.alibaba.griver.lottie.utils.Utils.SECOND_IN_NANOS};
    private static ValueFormatter moveToNextValue = new DefaultValueFormatter(1);
    private static Rect NetworkUserEntityData$$ExternalSyntheticLambda0 = new Rect();
    private static Rect scheduleImpl = new Rect();
    private static Paint.FontMetrics lookAheadTest = new Paint.FontMetrics();

    public static float KClassImpl$Data$declaredNonStaticMembers$2(float f) {
        while (f < 0.0f) {
            f += 360.0f;
        }
        return f % 360.0f;
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context) {
        if (context == null) {
            NetworkUserEntityData$$ExternalSyntheticLambda1 = ViewConfiguration.getMinimumFlingVelocity();
            NetworkUserEntityData$$ExternalSyntheticLambda2 = ViewConfiguration.getMaximumFlingVelocity();
            InstrumentInjector.log_e("MPChartLib-Utils", "Utils.init(...) PROVIDED CONTEXT OBJECT IS NULL");
            return;
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        NetworkUserEntityData$$ExternalSyntheticLambda1 = viewConfiguration.getScaledMinimumFlingVelocity();
        NetworkUserEntityData$$ExternalSyntheticLambda2 = viewConfiguration.getScaledMaximumFlingVelocity();
        initRecordTimeStamp = context.getResources().getDisplayMetrics();
    }

    public static float PlaceComponentResult(float f) {
        DisplayMetrics displayMetrics = initRecordTimeStamp;
        if (displayMetrics == null) {
            InstrumentInjector.log_e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertDpToPixel(...). Otherwise conversion does not take place.");
            return f;
        }
        return f * displayMetrics.density;
    }

    public static int MyBillsEntityDataFactory(Paint paint, String str) {
        return (int) paint.measureText(str);
    }

    public static int getAuthRequestContext(Paint paint, String str) {
        Rect rect = PlaceComponentResult;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static float KClassImpl$Data$declaredNonStaticMembers$2(Paint paint) {
        Paint.FontMetrics fontMetrics = getErrorConfigVersion;
        paint.getFontMetrics(fontMetrics);
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float MyBillsEntityDataFactory(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float getAuthRequestContext(Paint paint) {
        Paint.FontMetrics fontMetrics = getErrorConfigVersion;
        paint.getFontMetrics(fontMetrics);
        return (fontMetrics.ascent - fontMetrics.top) + fontMetrics.bottom;
    }

    public static float BuiltInFictitiousFunctionClassFactory(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return (fontMetrics.ascent - fontMetrics.top) + fontMetrics.bottom;
    }

    public static FSize PlaceComponentResult(Paint paint, String str) {
        FSize MyBillsEntityDataFactory2 = FSize.MyBillsEntityDataFactory(0.0f, 0.0f);
        Rect rect = BuiltInFictitiousFunctionClassFactory;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        MyBillsEntityDataFactory2.PlaceComponentResult = rect.width();
        MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory = rect.height();
        return MyBillsEntityDataFactory2;
    }

    public static float KClassImpl$Data$declaredNonStaticMembers$2(double d) {
        if (Double.isInfinite(d) || Double.isNaN(d) || d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return 0.0f;
        }
        float pow = (float) Math.pow(10.0d, 1 - ((int) Math.ceil((float) Math.log10(d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? -d : d))));
        double d2 = pow;
        Double.isNaN(d2);
        return ((float) Math.round(d * d2)) / pow;
    }

    public static int getAuthRequestContext(float f) {
        float KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(f);
        if (Float.isInfinite(KClassImpl$Data$declaredNonStaticMembers$22)) {
            return 0;
        }
        return ((int) Math.ceil(-Math.log10(KClassImpl$Data$declaredNonStaticMembers$22))) + 2;
    }

    public static double MyBillsEntityDataFactory(double d) {
        if (d == Double.POSITIVE_INFINITY) {
            return d;
        }
        double d2 = d + FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d2) + (d2 >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1L : -1L));
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(MPPointF mPPointF, float f, float f2, MPPointF mPPointF2) {
        double d = mPPointF.KClassImpl$Data$declaredNonStaticMembers$2;
        double d2 = f;
        double d3 = f2;
        double cos = Math.cos(Math.toRadians(d3));
        Double.isNaN(d2);
        Double.isNaN(d);
        mPPointF2.KClassImpl$Data$declaredNonStaticMembers$2 = (float) (d + (cos * d2));
        double d4 = mPPointF.PlaceComponentResult;
        double sin = Math.sin(Math.toRadians(d3));
        Double.isNaN(d2);
        Double.isNaN(d4);
        mPPointF2.PlaceComponentResult = (float) (d4 + (d2 * sin));
    }

    public static void getAuthRequestContext(MotionEvent motionEvent, VelocityTracker velocityTracker) {
        velocityTracker.computeCurrentVelocity(1000, NetworkUserEntityData$$ExternalSyntheticLambda2);
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float xVelocity = velocityTracker.getXVelocity(pointerId);
        float yVelocity = velocityTracker.getYVelocity(pointerId);
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            if (i != actionIndex) {
                int pointerId2 = motionEvent.getPointerId(i);
                if ((velocityTracker.getXVelocity(pointerId2) * xVelocity) + (velocityTracker.getYVelocity(pointerId2) * yVelocity) < 0.0f) {
                    velocityTracker.clear();
                    return;
                }
            }
        }
    }

    public static void PlaceComponentResult(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidateDelayed(10L);
        }
    }

    public static int PlaceComponentResult() {
        return NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    public static int MyBillsEntityDataFactory() {
        return NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    public static void BuiltInFictitiousFunctionClassFactory(Canvas canvas, Drawable drawable, int i, int i2, int i3, int i4) {
        MPPointF PlaceComponentResult2;
        PlaceComponentResult2 = MPPointF.MyBillsEntityDataFactory.PlaceComponentResult();
        PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2 = i - (i3 / 2);
        PlaceComponentResult2.PlaceComponentResult = i2 - (i4 / 2);
        drawable.copyBounds(NetworkUserEntityData$$ExternalSyntheticLambda0);
        drawable.setBounds(NetworkUserEntityData$$ExternalSyntheticLambda0.left, NetworkUserEntityData$$ExternalSyntheticLambda0.top, NetworkUserEntityData$$ExternalSyntheticLambda0.left + i3, NetworkUserEntityData$$ExternalSyntheticLambda0.top + i3);
        int save = canvas.save();
        canvas.translate(PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult2.PlaceComponentResult);
        drawable.draw(canvas);
        canvas.restoreToCount(save);
    }

    public static void MyBillsEntityDataFactory(Canvas canvas, String str, float f, float f2, Paint paint, MPPointF mPPointF, float f3) {
        float fontMetrics = paint.getFontMetrics(lookAheadTest);
        paint.getTextBounds(str, 0, str.length(), scheduleImpl);
        float f4 = 0.0f - scheduleImpl.left;
        float f5 = (-lookAheadTest.ascent) + 0.0f;
        Paint.Align textAlign = paint.getTextAlign();
        paint.setTextAlign(Paint.Align.LEFT);
        if (f3 != 0.0f) {
            float width = scheduleImpl.width();
            if (mPPointF.KClassImpl$Data$declaredNonStaticMembers$2 != 0.5f || mPPointF.PlaceComponentResult != 0.5f) {
                FSize KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(scheduleImpl.width(), fontMetrics, 0.017453292f * f3);
                f -= KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult * (mPPointF.KClassImpl$Data$declaredNonStaticMembers$2 - 0.5f);
                f2 -= KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory * (mPPointF.PlaceComponentResult - 0.5f);
                FSize.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$22);
            }
            canvas.save();
            canvas.translate(f, f2);
            canvas.rotate(f3);
            canvas.drawText(str, f4 - (width * 0.5f), f5 - (fontMetrics * 0.5f), paint);
            canvas.restore();
        } else {
            if (mPPointF.KClassImpl$Data$declaredNonStaticMembers$2 != 0.0f || mPPointF.PlaceComponentResult != 0.0f) {
                f4 -= scheduleImpl.width() * mPPointF.KClassImpl$Data$declaredNonStaticMembers$2;
                f5 -= fontMetrics * mPPointF.PlaceComponentResult;
            }
            canvas.drawText(str, f4 + f, f5 + f2, paint);
        }
        paint.setTextAlign(textAlign);
    }

    public static FSize MyBillsEntityDataFactory(float f, float f2, float f3) {
        return KClassImpl$Data$declaredNonStaticMembers$2(f, f2, f3 * 0.017453292f);
    }

    private static FSize KClassImpl$Data$declaredNonStaticMembers$2(float f, float f2, float f3) {
        double d = f3;
        return FSize.MyBillsEntityDataFactory(Math.abs(((float) Math.cos(d)) * f) + Math.abs(((float) Math.sin(d)) * f2), Math.abs(f * ((float) Math.sin(d))) + Math.abs(f2 * ((float) Math.cos(d))));
    }

    public static int getAuthRequestContext() {
        return Build.VERSION.SDK_INT;
    }
}
