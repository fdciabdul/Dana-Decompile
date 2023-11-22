package ru.noties.markwon.spans;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.TypedValue;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes6.dex */
public class SpannableTheme {
    private static final float[] whenAvailable = {2.0f, 1.5f, 1.17f, 1.0f, 0.83f, 0.67f};
    protected final int BuiltInFictitiousFunctionClassFactory;
    protected final int DatabaseTableConfigUtil;
    protected final int FragmentBottomSheetPaymentSettingBinding;
    protected final int GetContactSyncConfig;
    protected final int KClassImpl$Data$declaredNonStaticMembers$2;
    protected final int MyBillsEntityDataFactory;
    protected final int NetworkUserEntityData$$ExternalSyntheticLambda0;
    protected final float[] NetworkUserEntityData$$ExternalSyntheticLambda1;
    protected final int NetworkUserEntityData$$ExternalSyntheticLambda2;
    protected final int NetworkUserEntityData$$ExternalSyntheticLambda3;
    protected final int NetworkUserEntityData$$ExternalSyntheticLambda4;
    protected final int NetworkUserEntityData$$ExternalSyntheticLambda5;
    protected final int NetworkUserEntityData$$ExternalSyntheticLambda6;
    protected final int NetworkUserEntityData$$ExternalSyntheticLambda7;
    protected final Typeface NetworkUserEntityData$$ExternalSyntheticLambda8;
    protected final int PlaceComponentResult;
    protected final float PrepareContext;
    protected final int getAuthRequestContext;
    protected final int getCallingPid;
    protected final int getErrorConfigVersion;
    protected final int getSupportButtonTintMode;
    protected final Typeface initRecordTimeStamp;
    protected final int isLayoutRequested;
    protected final int lookAheadTest;
    protected final int moveToNextValue;
    protected final int newProxyInstance;
    protected final Drawable readMicros;
    protected final int scheduleImpl;

    private static int BuiltInFictitiousFunctionClassFactory(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().data, new int[]{i});
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    protected SpannableTheme(Builder builder) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = builder.NetworkUserEntityData$$ExternalSyntheticLambda5;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = builder.PlaceComponentResult;
        this.PlaceComponentResult = builder.BuiltInFictitiousFunctionClassFactory;
        this.BuiltInFictitiousFunctionClassFactory = builder.lookAheadTest;
        this.isLayoutRequested = builder.FragmentBottomSheetPaymentSettingBinding;
        this.MyBillsEntityDataFactory = builder.KClassImpl$Data$declaredNonStaticMembers$2;
        this.getAuthRequestContext = builder.NetworkUserEntityData$$ExternalSyntheticLambda1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = builder.GetContactSyncConfig;
        this.moveToNextValue = builder.NetworkUserEntityData$$ExternalSyntheticLambda2;
        this.getErrorConfigVersion = builder.DatabaseTableConfigUtil;
        this.lookAheadTest = builder.initRecordTimeStamp;
        this.scheduleImpl = builder.getAuthRequestContext;
        this.initRecordTimeStamp = builder.newProxyInstance;
        this.GetContactSyncConfig = builder.isLayoutRequested;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = builder.MyBillsEntityDataFactory;
        this.DatabaseTableConfigUtil = builder.NetworkUserEntityData$$ExternalSyntheticLambda7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = builder.PrepareContext;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = builder.NetworkUserEntityData$$ExternalSyntheticLambda8;
        this.PrepareContext = builder.NetworkUserEntityData$$ExternalSyntheticLambda6;
        this.getSupportButtonTintMode = builder.getSupportButtonTintMode;
        this.getCallingPid = builder.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = builder.moveToNextValue;
        this.newProxyInstance = builder.NetworkUserEntityData$$ExternalSyntheticLambda4;
        this.FragmentBottomSheetPaymentSettingBinding = builder.getErrorConfigVersion;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = builder.SubSequence;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = builder.NetworkUserEntityData$$ExternalSyntheticLambda3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = builder.whenAvailable;
        this.readMicros = builder.scheduleImpl;
    }

    public final void getAuthRequestContext(TextPaint textPaint) {
        textPaint.setUnderlineText(true);
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (i != 0) {
            textPaint.setColor(i);
        } else {
            textPaint.setColor(textPaint.linkColor);
        }
    }

    public final void MyBillsEntityDataFactory(Paint paint) {
        paint.setUnderlineText(true);
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (i != 0) {
            paint.setColor(i);
        } else if (paint instanceof TextPaint) {
            paint.setColor(((TextPaint) paint).linkColor);
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(Paint paint) {
        int i = this.BuiltInFictitiousFunctionClassFactory;
        if (i == 0) {
            i = ColorUtils.MyBillsEntityDataFactory(paint.getColor(), 25);
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i);
    }

    public final int BuiltInFictitiousFunctionClassFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = this.PlaceComponentResult;
        return i == 0 ? (int) ((this.KClassImpl$Data$declaredNonStaticMembers$2 * 0.25f) + 0.5f) : i;
    }

    public final void PlaceComponentResult(Paint paint) {
        int i = this.isLayoutRequested;
        if (i == 0) {
            i = paint.getColor();
        }
        paint.setColor(i);
        int i2 = this.MyBillsEntityDataFactory;
        if (i2 != 0) {
            paint.setStrokeWidth(i2);
        }
    }

    public final int KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        int min = Math.min(this.KClassImpl$Data$declaredNonStaticMembers$2, i) / 2;
        int i2 = this.getAuthRequestContext;
        return (i2 == 0 || i2 > min) ? min : i2;
    }

    public final void getAuthRequestContext(Paint paint, boolean z) {
        int i;
        float textSize;
        int i2;
        if (z && (i2 = this.moveToNextValue) != 0) {
            paint.setColor(i2);
        } else {
            int i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (i3 != 0) {
                paint.setColor(i3);
            }
        }
        Typeface typeface = this.initRecordTimeStamp;
        if (typeface != null) {
            paint.setTypeface(typeface);
            i = this.GetContactSyncConfig;
            if (i == 0) {
                return;
            }
        } else {
            paint.setTypeface(Typeface.MONOSPACE);
            i = this.GetContactSyncConfig;
            if (i == 0) {
                textSize = paint.getTextSize() * 0.87f;
                paint.setTextSize(textSize);
            }
        }
        textSize = i;
        paint.setTextSize(textSize);
    }

    public final int PlaceComponentResult() {
        return this.scheduleImpl;
    }

    public final int MyBillsEntityDataFactory(Paint paint, boolean z) {
        int i;
        if (!z || (i = this.lookAheadTest) == 0) {
            int i2 = this.getErrorConfigVersion;
            return i2 == 0 ? ColorUtils.MyBillsEntityDataFactory(paint.getColor(), 25) : i2;
        }
        return i;
    }

    public final void MyBillsEntityDataFactory(Paint paint, int i) {
        Typeface typeface = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        if (typeface == null) {
            paint.setFakeBoldText(true);
        } else {
            paint.setTypeface(typeface);
        }
        float[] fArr = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (fArr == null) {
            fArr = whenAvailable;
        }
        if (fArr != null && fArr.length >= i) {
            paint.setTextSize(paint.getTextSize() * fArr[i - 1]);
            return;
        }
        throw new IllegalStateException(String.format(Locale.US, "Supplied heading level: %d is invalid, where configured heading sizes are: `%s`", Integer.valueOf(i), Arrays.toString(fArr)));
    }

    public final void getAuthRequestContext(Paint paint) {
        int i = this.DatabaseTableConfigUtil;
        if (i == 0) {
            i = ColorUtils.MyBillsEntityDataFactory(paint.getColor(), 75);
        }
        paint.setColor(i);
        paint.setStyle(Paint.Style.FILL);
        int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (i2 >= 0) {
            paint.setStrokeWidth(i2);
        }
    }

    public final void MyBillsEntityDataFactory(TextPaint textPaint) {
        textPaint.setTextSize(textPaint.getTextSize() * (Float.compare(this.PrepareContext, 0.0f) == 0 ? 0.75f : this.PrepareContext));
        textPaint.baselineShift += (int) (textPaint.ascent() / 2.0f);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(TextPaint textPaint) {
        textPaint.setTextSize(textPaint.getTextSize() * (Float.compare(this.PrepareContext, 0.0f) == 0 ? 0.75f : this.PrepareContext));
        textPaint.baselineShift -= (int) (textPaint.ascent() / 2.0f);
    }

    public final void getErrorConfigVersion(Paint paint) {
        int i = this.getSupportButtonTintMode;
        if (i == 0) {
            i = ColorUtils.MyBillsEntityDataFactory(paint.getColor(), 25);
        }
        paint.setColor(i);
        paint.setStyle(Paint.Style.FILL);
        int i2 = this.getCallingPid;
        if (i2 >= 0) {
            paint.setStrokeWidth(i2);
        }
    }

    public final int getAuthRequestContext() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda3;
    }

    public final int lookAheadTest(Paint paint) {
        int i = this.FragmentBottomSheetPaymentSettingBinding;
        return i == -1 ? (int) (paint.getStrokeWidth() + 0.5f) : i;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Paint paint) {
        int i = this.newProxyInstance;
        if (i == 0) {
            i = ColorUtils.MyBillsEntityDataFactory(paint.getColor(), 75);
        }
        paint.setColor(i);
        paint.setStyle(Paint.Style.STROKE);
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda0(Paint paint) {
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (i == 0) {
            i = ColorUtils.MyBillsEntityDataFactory(paint.getColor(), 22);
        }
        paint.setColor(i);
        paint.setStyle(Paint.Style.FILL);
    }

    public final void moveToNextValue(Paint paint) {
        paint.setColor(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
        paint.setStyle(Paint.Style.FILL);
    }

    public final void scheduleImpl(Paint paint) {
        paint.setColor(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        paint.setStyle(Paint.Style.FILL);
    }

    public final Drawable MyBillsEntityDataFactory() {
        return this.readMicros;
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        int BuiltInFictitiousFunctionClassFactory;
        private int DatabaseTableConfigUtil;
        private int FragmentBottomSheetPaymentSettingBinding;
        private int GetContactSyncConfig;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        private int NetworkUserEntityData$$ExternalSyntheticLambda1;
        private int NetworkUserEntityData$$ExternalSyntheticLambda2;
        private int NetworkUserEntityData$$ExternalSyntheticLambda3;
        private int NetworkUserEntityData$$ExternalSyntheticLambda4;
        private int NetworkUserEntityData$$ExternalSyntheticLambda5;
        private float NetworkUserEntityData$$ExternalSyntheticLambda6;
        private int NetworkUserEntityData$$ExternalSyntheticLambda7;
        private float[] NetworkUserEntityData$$ExternalSyntheticLambda8;
        int PlaceComponentResult;
        private Typeface PrepareContext;
        private int SubSequence;
        int getAuthRequestContext;
        private int getSupportButtonTintMode;
        private int initRecordTimeStamp;
        private int isLayoutRequested;
        private int lookAheadTest;
        int moveToNextValue;
        private Typeface newProxyInstance;
        Drawable scheduleImpl;
        private int whenAvailable;
        int MyBillsEntityDataFactory = -1;
        int NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
        int getErrorConfigVersion = -1;

        Builder() {
        }

        public final SpannableTheme BuiltInFictitiousFunctionClassFactory() {
            return new SpannableTheme(this);
        }
    }

    /* loaded from: classes6.dex */
    static class Dip {
        final float getAuthRequestContext;

        Dip(Context context) {
            this.getAuthRequestContext = context.getResources().getDisplayMetrics().density;
        }
    }

    public static SpannableTheme MyBillsEntityDataFactory(Context context) {
        int BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(context, 16842907);
        int BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(context, 16842801);
        Dip dip = new Dip(context);
        Builder builder = new Builder();
        builder.getAuthRequestContext = (int) ((dip.getAuthRequestContext * 8.0f) + 0.5f);
        builder.PlaceComponentResult = (int) ((dip.getAuthRequestContext * 24.0f) + 0.5f);
        builder.BuiltInFictitiousFunctionClassFactory = (int) ((dip.getAuthRequestContext * 4.0f) + 0.5f);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = (int) ((dip.getAuthRequestContext * 1.0f) + 0.5f);
        builder.MyBillsEntityDataFactory = (int) ((dip.getAuthRequestContext * 1.0f) + 0.5f);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = (int) ((dip.getAuthRequestContext * 4.0f) + 0.5f);
        builder.moveToNextValue = (int) ((dip.getAuthRequestContext * 4.0f) + 0.5f);
        builder.getErrorConfigVersion = (int) ((dip.getAuthRequestContext * 1.0f) + 0.5f);
        builder.scheduleImpl = new TaskListDrawable(BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory2);
        return builder.BuiltInFictitiousFunctionClassFactory();
    }
}
