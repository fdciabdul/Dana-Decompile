package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: classes.dex */
public class AppCompatTextViewAutoSizeHelper {
    private final TextView GetContactSyncConfig;
    private final Impl NetworkUserEntityData$$ExternalSyntheticLambda1;
    private TextPaint NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Context lookAheadTest;
    private static final RectF MyBillsEntityDataFactory = new RectF();
    private static ConcurrentHashMap<String, Method> getAuthRequestContext = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Field> BuiltInFictitiousFunctionClassFactory = new ConcurrentHashMap<>();
    private int getErrorConfigVersion = 0;
    private boolean DatabaseTableConfigUtil = false;
    private float NetworkUserEntityData$$ExternalSyntheticLambda0 = -1.0f;
    private float KClassImpl$Data$declaredNonStaticMembers$2 = -1.0f;
    private float PlaceComponentResult = -1.0f;
    private int[] moveToNextValue = new int[0];
    private boolean scheduleImpl = false;

    /* loaded from: classes.dex */
    public static class Impl {
        void KClassImpl$Data$declaredNonStaticMembers$2(StaticLayout.Builder builder, TextView textView) {
        }

        Impl() {
        }

        boolean getAuthRequestContext(TextView textView) {
            return ((Boolean) AppCompatTextViewAutoSizeHelper.KClassImpl$Data$declaredNonStaticMembers$2(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Impl23 extends Impl {
        Impl23() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        void KClassImpl$Data$declaredNonStaticMembers$2(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) AppCompatTextViewAutoSizeHelper.KClassImpl$Data$declaredNonStaticMembers$2(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Impl29 extends Impl23 {
        Impl29() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        boolean getAuthRequestContext(TextView textView) {
            return textView.isHorizontallyScrollable();
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl23, androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        void KClassImpl$Data$declaredNonStaticMembers$2(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }
    }

    public AppCompatTextViewAutoSizeHelper(TextView textView) {
        this.GetContactSyncConfig = textView;
        this.lookAheadTest = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new Impl29();
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new Impl23();
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new Impl();
        }
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.lookAheadTest.obtainStyledAttributes(attributeSet, R.styleable.V, i, 0);
        TextView textView = this.GetContactSyncConfig;
        ViewCompat.MyBillsEntityDataFactory(textView, textView.getContext(), R.styleable.V, attributeSet, obtainStyledAttributes, i, 0);
        if (obtainStyledAttributes.hasValue(R.styleable.shouldRecycleViewType)) {
            this.getErrorConfigVersion = obtainStyledAttributes.getInt(R.styleable.shouldRecycleViewType, 0);
        }
        float dimension = obtainStyledAttributes.hasValue(R.styleable.T) ? obtainStyledAttributes.getDimension(R.styleable.T, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(R.styleable.U) ? obtainStyledAttributes.getDimension(R.styleable.U, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes.hasValue(R.styleable.X) ? obtainStyledAttributes.getDimension(R.styleable.X, -1.0f) : -1.0f;
        if (obtainStyledAttributes.hasValue(R.styleable.W) && (resourceId = obtainStyledAttributes.getResourceId(R.styleable.W, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            KClassImpl$Data$declaredNonStaticMembers$2(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (initRecordTimeStamp()) {
            if (this.getErrorConfigVersion == 1) {
                if (!this.scheduleImpl) {
                    DisplayMetrics displayMetrics = this.lookAheadTest.getResources().getDisplayMetrics();
                    if (dimension2 == -1.0f) {
                        dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    }
                    if (dimension3 == -1.0f) {
                        dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                    }
                    if (dimension == -1.0f) {
                        dimension = 1.0f;
                    }
                    MyBillsEntityDataFactory(dimension2, dimension3, dimension);
                }
                scheduleImpl();
                return;
            }
            return;
        }
        this.getErrorConfigVersion = 0;
    }

    public void getAuthRequestContext(int i) {
        if (initRecordTimeStamp()) {
            if (i == 0) {
                moveToNextValue();
            } else if (i == 1) {
                DisplayMetrics displayMetrics = this.lookAheadTest.getResources().getDisplayMetrics();
                MyBillsEntityDataFactory(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                if (scheduleImpl()) {
                    PlaceComponentResult();
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown auto-size text type: ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
            }
        }
    }

    public void MyBillsEntityDataFactory(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        if (initRecordTimeStamp()) {
            DisplayMetrics displayMetrics = this.lookAheadTest.getResources().getDisplayMetrics();
            MyBillsEntityDataFactory(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (scheduleImpl()) {
                PlaceComponentResult();
            }
        }
    }

    public void getAuthRequestContext(int[] iArr, int i) throws IllegalArgumentException {
        if (initRecordTimeStamp()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.lookAheadTest.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr2[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                this.moveToNextValue = MyBillsEntityDataFactory(iArr2);
                if (!NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("None of the preset sizes is valid: ");
                    sb.append(Arrays.toString(iArr));
                    throw new IllegalArgumentException(sb.toString());
                }
            } else {
                this.scheduleImpl = false;
            }
            if (scheduleImpl()) {
                PlaceComponentResult();
            }
        }
    }

    public int lookAheadTest() {
        return this.getErrorConfigVersion;
    }

    public int getAuthRequestContext() {
        return Math.round(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    public int BuiltInFictitiousFunctionClassFactory() {
        return Math.round(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public int MyBillsEntityDataFactory() {
        return Math.round(this.PlaceComponentResult);
    }

    public int[] KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                iArr[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.moveToNextValue = MyBillsEntityDataFactory(iArr);
            NetworkUserEntityData$$ExternalSyntheticLambda0();
        }
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        boolean z = this.moveToNextValue.length > 0;
        this.scheduleImpl = z;
        if (z) {
            this.getErrorConfigVersion = 1;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = r0[0];
            this.PlaceComponentResult = r0[r1 - 1];
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1.0f;
        }
        return z;
    }

    private int[] MyBillsEntityDataFactory(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr2[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr2;
    }

    private void MyBillsEntityDataFactory(float f, float f2, float f3) throws IllegalArgumentException {
        if (f <= 0.0f) {
            StringBuilder sb = new StringBuilder();
            sb.append("Minimum auto-size text size (");
            sb.append(f);
            sb.append("px) is less or equal to (0px)");
            throw new IllegalArgumentException(sb.toString());
        } else if (f2 <= f) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Maximum auto-size text size (");
            sb2.append(f2);
            sb2.append("px) is less or equal to minimum auto-size text size (");
            sb2.append(f);
            sb2.append("px)");
            throw new IllegalArgumentException(sb2.toString());
        } else if (f3 <= 0.0f) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("The auto-size step granularity (");
            sb3.append(f3);
            sb3.append("px) is less or equal to (0px)");
            throw new IllegalArgumentException(sb3.toString());
        } else {
            this.getErrorConfigVersion = 1;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = f;
            this.PlaceComponentResult = f2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = f3;
            this.scheduleImpl = false;
        }
    }

    private boolean scheduleImpl() {
        if (initRecordTimeStamp() && this.getErrorConfigVersion == 1) {
            if (!this.scheduleImpl || this.moveToNextValue.length == 0) {
                int floor = ((int) Math.floor((this.PlaceComponentResult - this.KClassImpl$Data$declaredNonStaticMembers$2) / this.NetworkUserEntityData$$ExternalSyntheticLambda0)) + 1;
                int[] iArr = new int[floor];
                for (int i = 0; i < floor; i++) {
                    iArr[i] = Math.round(this.KClassImpl$Data$declaredNonStaticMembers$2 + (i * this.NetworkUserEntityData$$ExternalSyntheticLambda0));
                }
                this.moveToNextValue = MyBillsEntityDataFactory(iArr);
            }
            this.DatabaseTableConfigUtil = true;
        } else {
            this.DatabaseTableConfigUtil = false;
        }
        return this.DatabaseTableConfigUtil;
    }

    public void PlaceComponentResult() {
        int measuredWidth;
        if (getErrorConfigVersion()) {
            if (this.DatabaseTableConfigUtil) {
                if (this.GetContactSyncConfig.getMeasuredHeight() <= 0 || this.GetContactSyncConfig.getMeasuredWidth() <= 0) {
                    return;
                }
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext(this.GetContactSyncConfig)) {
                    measuredWidth = CrashCombineUtils.DEFAULT_MAX_INFO_LEN;
                } else {
                    measuredWidth = (this.GetContactSyncConfig.getMeasuredWidth() - this.GetContactSyncConfig.getTotalPaddingLeft()) - this.GetContactSyncConfig.getTotalPaddingRight();
                }
                int height = (this.GetContactSyncConfig.getHeight() - this.GetContactSyncConfig.getCompoundPaddingBottom()) - this.GetContactSyncConfig.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = MyBillsEntityDataFactory;
                synchronized (rectF) {
                    rectF.setEmpty();
                    rectF.right = measuredWidth;
                    rectF.bottom = height;
                    float MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(rectF);
                    if (MyBillsEntityDataFactory2 != this.GetContactSyncConfig.getTextSize()) {
                        PlaceComponentResult(0, MyBillsEntityDataFactory2);
                    }
                }
            }
            this.DatabaseTableConfigUtil = true;
        }
    }

    private void moveToNextValue() {
        this.getErrorConfigVersion = 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = -1.0f;
        this.PlaceComponentResult = -1.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1.0f;
        this.moveToNextValue = new int[0];
        this.DatabaseTableConfigUtil = false;
    }

    public void PlaceComponentResult(int i, float f) {
        Resources resources;
        Context context = this.lookAheadTest;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        BuiltInFictitiousFunctionClassFactory(TypedValue.applyDimension(i, f, resources.getDisplayMetrics()));
    }

    private void BuiltInFictitiousFunctionClassFactory(float f) {
        if (f != this.GetContactSyncConfig.getPaint().getTextSize()) {
            this.GetContactSyncConfig.getPaint().setTextSize(f);
            boolean isInLayout = Build.VERSION.SDK_INT >= 18 ? this.GetContactSyncConfig.isInLayout() : false;
            if (this.GetContactSyncConfig.getLayout() != null) {
                this.DatabaseTableConfigUtil = false;
                try {
                    Method KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2("nullLayouts");
                    if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                        KClassImpl$Data$declaredNonStaticMembers$2.invoke(this.GetContactSyncConfig, new Object[0]);
                    }
                } catch (Exception e) {
                    InstrumentInjector.log_w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (!isInLayout) {
                    this.GetContactSyncConfig.requestLayout();
                } else {
                    this.GetContactSyncConfig.forceLayout();
                }
                this.GetContactSyncConfig.invalidate();
            }
        }
    }

    private int MyBillsEntityDataFactory(RectF rectF) {
        int length = this.moveToNextValue.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i = 1;
        int i2 = length - 1;
        int i3 = 0;
        while (i <= i2) {
            int i4 = (i + i2) / 2;
            if (getAuthRequestContext(this.moveToNextValue[i4], rectF)) {
                int i5 = i4 + 1;
                i3 = i;
                i = i5;
            } else {
                i3 = i4 - 1;
                i2 = i3;
            }
        }
        return this.moveToNextValue[i3];
    }

    void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        TextPaint textPaint = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (textPaint == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.set(this.GetContactSyncConfig.getPaint());
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.setTextSize(i);
    }

    StaticLayout BuiltInFictitiousFunctionClassFactory(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.BuiltInFictitiousFunctionClassFactory(charSequence, alignment, i, i2, this.GetContactSyncConfig, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return Api16Impl.getAuthRequestContext(charSequence, alignment, i, this.GetContactSyncConfig, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        }
        return MyBillsEntityDataFactory(charSequence, alignment, i);
    }

    private boolean getAuthRequestContext(int i, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.GetContactSyncConfig.getText();
        TransformationMethod transformationMethod = this.GetContactSyncConfig.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.GetContactSyncConfig)) != null) {
            text = transformation;
        }
        int MyBillsEntityDataFactory2 = Build.VERSION.SDK_INT >= 16 ? Api16Impl.MyBillsEntityDataFactory(this.GetContactSyncConfig) : -1;
        KClassImpl$Data$declaredNonStaticMembers$2(i);
        StaticLayout BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(text, (Layout.Alignment) KClassImpl$Data$declaredNonStaticMembers$2(this.GetContactSyncConfig, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), MyBillsEntityDataFactory2);
        return (MyBillsEntityDataFactory2 == -1 || (BuiltInFictitiousFunctionClassFactory2.getLineCount() <= MyBillsEntityDataFactory2 && BuiltInFictitiousFunctionClassFactory2.getLineEnd(BuiltInFictitiousFunctionClassFactory2.getLineCount() - 1) == text.length())) && ((float) BuiltInFictitiousFunctionClassFactory2.getHeight()) <= rectF.bottom;
    }

    private StaticLayout MyBillsEntityDataFactory(CharSequence charSequence, Layout.Alignment alignment, int i) {
        return new StaticLayout(charSequence, this.NetworkUserEntityData$$ExternalSyntheticLambda2, i, alignment, ((Float) getAuthRequestContext(this.GetContactSyncConfig, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) getAuthRequestContext(this.GetContactSyncConfig, "mSpacingAdd", Float.valueOf(0.0f))).floatValue(), ((Boolean) getAuthRequestContext(this.GetContactSyncConfig, "mIncludePad", Boolean.TRUE)).booleanValue());
    }

    static <T> T KClassImpl$Data$declaredNonStaticMembers$2(Object obj, String str, T t) {
        try {
            return (T) KClassImpl$Data$declaredNonStaticMembers$2(str).invoke(obj, new Object[0]);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to invoke TextView#");
            sb.append(str);
            sb.append("() method");
            InstrumentInjector.log_w("ACTVAutoSizeHelper", sb.toString(), e);
            return t;
        }
    }

    private static <T> T getAuthRequestContext(Object obj, String str, T t) {
        try {
            Field BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(str);
            return BuiltInFictitiousFunctionClassFactory2 == null ? t : (T) BuiltInFictitiousFunctionClassFactory2.get(obj);
        } catch (IllegalAccessException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to access TextView#");
            sb.append(str);
            sb.append(" member");
            InstrumentInjector.log_w("ACTVAutoSizeHelper", sb.toString(), e);
            return t;
        }
    }

    private static Method KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        try {
            Method method = getAuthRequestContext.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                getAuthRequestContext.put(str, method);
            }
            return method;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve TextView#");
            sb.append(str);
            sb.append("() method");
            InstrumentInjector.log_w("ACTVAutoSizeHelper", sb.toString(), e);
            return null;
        }
    }

    private static Field BuiltInFictitiousFunctionClassFactory(String str) {
        try {
            Field field = BuiltInFictitiousFunctionClassFactory.get(str);
            if (field == null && (field = TextView.class.getDeclaredField(str)) != null) {
                field.setAccessible(true);
                BuiltInFictitiousFunctionClassFactory.put(str, field);
            }
            return field;
        } catch (NoSuchFieldException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to access TextView#");
            sb.append(str);
            sb.append(" member");
            InstrumentInjector.log_w("ACTVAutoSizeHelper", sb.toString(), e);
            return null;
        }
    }

    public boolean getErrorConfigVersion() {
        return initRecordTimeStamp() && this.getErrorConfigVersion != 0;
    }

    private boolean initRecordTimeStamp() {
        return !(this.GetContactSyncConfig instanceof AppCompatEditText);
    }

    /* loaded from: classes.dex */
    public static final class Api23Impl {
        private Api23Impl() {
        }

        static StaticLayout BuiltInFictitiousFunctionClassFactory(CharSequence charSequence, Layout.Alignment alignment, int i, int i2, TextView textView, TextPaint textPaint, Impl impl) {
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i);
            StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i2 == -1) {
                i2 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i2);
            try {
                impl.KClassImpl$Data$declaredNonStaticMembers$2(obtain, textView);
            } catch (ClassCastException unused) {
                InstrumentInjector.log_w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return obtain.build();
        }
    }

    /* loaded from: classes.dex */
    public static final class Api18Impl {
        private Api18Impl() {
        }
    }

    /* loaded from: classes.dex */
    public static final class Api16Impl {
        private Api16Impl() {
        }

        static int MyBillsEntityDataFactory(TextView textView) {
            return textView.getMaxLines();
        }

        static StaticLayout getAuthRequestContext(CharSequence charSequence, Layout.Alignment alignment, int i, TextView textView, TextPaint textPaint) {
            return new StaticLayout(charSequence, textPaint, i, alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
        }
    }
}
