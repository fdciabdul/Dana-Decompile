package com.afollestad.materialdialogs.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Html;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.R;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b^\u0010_J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ)\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J?\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J<\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00172\u001d\b\u0002\u0010\u0014\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0005¢\u0006\u0002\b\u001a\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00052\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0013¢\u0006\u0004\b\u001f\u0010 J;\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010!¢\u0006\u0004\b\"\u0010#J'\u0010$\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b$\u0010%J'\u0010&\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u0005¢\u0006\u0004\b&\u0010'J9\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b+\u0010,J9\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010.\u001a\u00020-2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b+\u0010/J\u0011\u00101\u001a\u00020\u0005*\u000200¢\u0006\u0004\b1\u00102J#\u00105\u001a\u00020\u0005\"\b\b\u0000\u00104*\u000203*\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b5\u00106J!\u00108\u001a\b\u0012\u0004\u0012\u00020\u000207*\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b8\u00109J\u001d\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050;*\u00020:¢\u0006\u0004\b<\u0010=J1\u0010?\u001a\u00020\u0007*\u0004\u0018\u00010\u00052\u0019\u0010>\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0005¢\u0006\u0002\b\u001a\u0012\u0004\u0012\u00020\u00070\u0019H\u0086\b¢\u0006\u0004\b?\u0010@J-\u0010D\u001a\u00028\u0000\"\b\b\u0000\u0010A*\u000203*\u00020B2\b\b\u0002\u0010C\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\bD\u0010EJ\u001b\u0010H\u001a\u00020(*\u00020\u00052\b\b\u0002\u0010G\u001a\u00020F¢\u0006\u0004\bH\u0010IJ\u0011\u0010J\u001a\u00020(*\u00020\n¢\u0006\u0004\bJ\u0010KJ1\u0010N\u001a\u00020\u0007*\u0004\u0018\u0001002\u0006\u0010\u000b\u001a\u00020\n2\b\u0010L\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\bN\u0010OJ%\u0010R\u001a\u00020\u0007*\u00020P2\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00070\u0019¢\u0006\u0004\bR\u0010SJE\u0010X\u001a\u00020\u0007\"\b\b\u0000\u00104*\u000203*\u0004\u0018\u00018\u00002\b\b\u0002\u0010T\u001a\u00020\u00052\b\b\u0002\u0010U\u001a\u00020\u00052\b\b\u0002\u0010V\u001a\u00020\u00052\b\b\u0002\u0010W\u001a\u00020\u0005¢\u0006\u0004\bX\u0010YJ6\u0010[\u001a\u00020\u0007\"\b\b\u0000\u00104*\u000203*\u00028\u00002\u0019\u0010>\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0019¢\u0006\u0002\bZ¢\u0006\u0004\b[\u0010\\J6\u0010]\u001a\u00020\u0007\"\b\b\u0000\u00104*\u000203*\u00028\u00002\u0019\u0010>\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0019¢\u0006\u0002\bZ¢\u0006\u0004\b]\u0010\\"}, d2 = {"Lcom/afollestad/materialdialogs/utils/MDUtil;", "", "", "method", "b", "", "a", "", "assertOneSet", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Integer;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "unchecked", "checked", "Landroid/content/res/ColorStateList;", "createColorSelector", "(Landroid/content/Context;II)Landroid/content/res/ColorStateList;", "res", "attr", "Lkotlin/Function0;", "fallback", "resolveColor", "(Landroid/content/Context;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)I", "", "attrs", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "resolveColors", "(Landroid/content/Context;[ILkotlin/jvm/functions/Function1;)[I", "", "defaultValue", "resolveDimen", "(Landroid/content/Context;ILkotlin/jvm/functions/Function0;)F", "Landroid/graphics/drawable/Drawable;", "resolveDrawable", "(Landroid/content/Context;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", "resolveFloat", "(Landroid/content/Context;IF)F", "resolveInt", "(Landroid/content/Context;II)I", "", "html", "", "resolveString", "(Landroid/content/Context;Ljava/lang/Integer;Ljava/lang/Integer;Z)Ljava/lang/CharSequence;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "materialDialog", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Ljava/lang/Integer;Z)Ljava/lang/CharSequence;", "Landroid/widget/TextView;", "additionalPaddingForFont", "(Landroid/widget/TextView;)I", "Landroid/view/View;", "T", "dimenPx", "(Landroid/view/View;I)I", "", "getStringArray", "(Landroid/content/Context;Ljava/lang/Integer;)[Ljava/lang/String;", "Landroid/view/WindowManager;", "Lkotlin/Pair;", "getWidthAndHeight", "(Landroid/view/WindowManager;)Lkotlin/Pair;", "block", "ifNotZero", "(Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "R", "Landroid/view/ViewGroup;", "ctxt", "inflate", "(Landroid/view/ViewGroup;Landroid/content/Context;I)Landroid/view/View;", "", GriverMonitorConstants.KEY_THRESHOLD, "isColorDark", "(ID)Z", "isLandscape", "(Landroid/content/Context;)Z", "attrRes", "hintAttrRes", "maybeSetTextColor", "(Landroid/widget/TextView;Landroid/content/Context;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Landroid/widget/EditText;", "callback", "textChanged", "(Landroid/widget/EditText;Lkotlin/jvm/functions/Function1;)V", "left", "top", "right", "bottom", "updatePadding", "(Landroid/view/View;IIII)V", "Lkotlin/ExtensionFunctionType;", "waitForHeight", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "waitForWidth", "<init>", "()V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class MDUtil {
    public static final byte[] MyBillsEntityDataFactory = {56, -13, -61, 104, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int BuiltInFictitiousFunctionClassFactory = 164;
    public static final MDUtil INSTANCE = new MDUtil();

    private MDUtil() {
    }

    public static /* synthetic */ CharSequence resolveString$default(MDUtil mDUtil, MaterialDialog materialDialog, Integer num, Integer num2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return mDUtil.resolveString(materialDialog, num, num2, z);
    }

    public final CharSequence resolveString(MaterialDialog materialDialog, Integer res, Integer fallback, boolean html) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        return resolveString(materialDialog.getWindowContext(), res, fallback, html);
    }

    public static /* synthetic */ CharSequence resolveString$default(MDUtil mDUtil, Context context, Integer num, Integer num2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return mDUtil.resolveString(context, num, num2, z);
    }

    public final CharSequence resolveString(Context context, Integer res, Integer fallback, boolean html) {
        int intValue;
        Intrinsics.checkParameterIsNotNull(context, "");
        if (res != null) {
            intValue = res.intValue();
        } else {
            intValue = fallback != null ? fallback.intValue() : 0;
        }
        if (intValue == 0) {
            return null;
        }
        CharSequence text = context.getResources().getText(intValue);
        Intrinsics.checkExpressionValueIsNotNull(text, "");
        return html ? Html.fromHtml(text.toString()) : text;
    }

    public static /* synthetic */ Drawable resolveDrawable$default(MDUtil mDUtil, Context context, Integer num, Integer num2, Drawable drawable, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        if ((i & 8) != 0) {
            drawable = null;
        }
        return mDUtil.resolveDrawable(context, num, num2, drawable);
    }

    public final Drawable resolveDrawable(Context context, Integer res, Integer attr, Drawable fallback) {
        Intrinsics.checkParameterIsNotNull(context, "");
        if (attr == null) {
            return res == null ? fallback : ContextCompat.PlaceComponentResult(context, res.intValue());
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{attr.intValue()});
        try {
            Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, 0);
            if (__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d != null || fallback == null) {
                fallback = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d;
            }
            return fallback;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ int resolveColor$default(MDUtil mDUtil, Context context, Integer num, Integer num2, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        if ((i & 8) != 0) {
            function0 = null;
        }
        return mDUtil.resolveColor(context, num, num2, function0);
    }

    public final int resolveColor(Context context, Integer res, Integer attr, Function0<Integer> fallback) {
        Intrinsics.checkParameterIsNotNull(context, "");
        if (attr == null) {
            return ContextCompat.BuiltInFictitiousFunctionClassFactory(context, res != null ? res.intValue() : 0);
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{attr.intValue()});
        try {
            int color = obtainStyledAttributes.getColor(0, 0);
            return (color != 0 || fallback == null) ? color : fallback.invoke().intValue();
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ int[] resolveColors$default(MDUtil mDUtil, Context context, int[] iArr, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        return mDUtil.resolveColors(context, iArr, function1);
    }

    public final int[] resolveColors(Context context, int[] attrs, Function1<? super Integer, Integer> fallback) {
        Integer invoke;
        Intrinsics.checkParameterIsNotNull(context, "");
        Intrinsics.checkParameterIsNotNull(attrs, "");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs);
        try {
            IntRange indices = kotlin.collections.ArraysKt.getIndices(attrs);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(indices, 10));
            Iterator<Integer> it = indices.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                int i = 0;
                int color = obtainStyledAttributes.getColor(nextInt, 0);
                if (color != 0) {
                    i = color;
                } else if (fallback != null && (invoke = fallback.invoke(Integer.valueOf(attrs[nextInt]))) != null) {
                    i = invoke.intValue();
                }
                arrayList.add(Integer.valueOf(i));
            }
            return CollectionsKt.toIntArray(arrayList);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static /* synthetic */ int resolveInt$default(MDUtil mDUtil, Context context, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return mDUtil.resolveInt(context, i, i2);
    }

    public final int resolveInt(Context context, int attr, int defaultValue) {
        Intrinsics.checkParameterIsNotNull(context, "");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{attr});
        try {
            return obtainStyledAttributes.getInt(0, defaultValue);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ float resolveDimen$default(MDUtil mDUtil, Context context, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            function0 = null;
        }
        return mDUtil.resolveDimen(context, i, function0);
    }

    public final float resolveDimen(Context context, int attr, Function0<Float> defaultValue) {
        float floatValue;
        Intrinsics.checkParameterIsNotNull(context, "");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{attr});
        if (defaultValue != null) {
            try {
                Float invoke = defaultValue.invoke();
                if (invoke != null) {
                    floatValue = invoke.floatValue();
                    float dimension = obtainStyledAttributes.getDimension(0, floatValue);
                    obtainStyledAttributes.recycle();
                    return dimension;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        floatValue = 0.0f;
        float dimension2 = obtainStyledAttributes.getDimension(0, floatValue);
        obtainStyledAttributes.recycle();
        return dimension2;
    }

    public static /* synthetic */ float resolveFloat$default(MDUtil mDUtil, Context context, int i, float f, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f = 0.0f;
        }
        return mDUtil.resolveFloat(context, i, f);
    }

    public final float resolveFloat(Context context, int attr, float defaultValue) {
        Intrinsics.checkParameterIsNotNull(context, "");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{attr});
        try {
            return obtainStyledAttributes.getFloat(0, defaultValue);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static /* synthetic */ boolean isColorDark$default(MDUtil mDUtil, int i, double d, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d = 0.5d;
        }
        return mDUtil.isColorDark(i, d);
    }

    public final boolean isColorDark(int i, double d) {
        if (i == 0) {
            return false;
        }
        double red = Color.red(i);
        double green = Color.green(i);
        double blue = Color.blue(i);
        Double.isNaN(red);
        Double.isNaN(green);
        Double.isNaN(blue);
        return 1.0d - ((((red * 0.299d) + (green * 0.587d)) + (blue * 0.114d)) / 255.0d) >= d;
    }

    public final <T extends View> int dimenPx(T t, int i) {
        Intrinsics.checkParameterIsNotNull(t, "");
        Context context = t.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "");
        return context.getResources().getDimensionPixelSize(i);
    }

    public final boolean isLandscape(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "");
        return resources.getConfiguration().orientation == 2;
    }

    public final void textChanged(EditText editText, final Function1<? super CharSequence, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(editText, "");
        Intrinsics.checkParameterIsNotNull(function1, "");
        editText.addTextChangedListener(new TextWatcher() { // from class: com.afollestad.materialdialogs.utils.MDUtil$textChanged$1
            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable s) {
                Intrinsics.checkParameterIsNotNull(s, "");
            }

            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Intrinsics.checkParameterIsNotNull(s, "");
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence s, int start, int before, int count) {
                Intrinsics.checkParameterIsNotNull(s, "");
                Function1.this.invoke(s);
            }
        });
    }

    public static /* synthetic */ void maybeSetTextColor$default(MDUtil mDUtil, TextView textView, Context context, Integer num, Integer num2, int i, Object obj) {
        if ((i & 4) != 0) {
            num2 = null;
        }
        mDUtil.maybeSetTextColor(textView, context, num, num2);
    }

    public final void maybeSetTextColor(TextView textView, Context context, Integer num, Integer num2) {
        int resolveColor$default;
        int resolveColor$default2;
        Intrinsics.checkParameterIsNotNull(context, "");
        if (textView != null) {
            if (num == null && num2 == null) {
                return;
            }
            if (num != null && (resolveColor$default2 = resolveColor$default(this, context, null, num, null, 10, null)) != 0) {
                textView.setTextColor(resolveColor$default2);
            }
            if (num2 == null || (resolveColor$default = resolveColor$default(this, context, null, num2, null, 10, null)) == 0) {
                return;
            }
            textView.setHintTextColor(resolveColor$default);
        }
    }

    public final int additionalPaddingForFont(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "");
        TextPaint paint = textView.getPaint();
        Intrinsics.checkExpressionValueIsNotNull(paint, "");
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f = fontMetrics.descent - fontMetrics.ascent;
        if (f > textView.getMeasuredHeight()) {
            return (int) (f - textView.getMeasuredHeight());
        }
        return 0;
    }

    public final void ifNotZero(Integer num, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "");
        if (num == null || num.intValue() == 0) {
            return;
        }
        function1.invoke(num);
    }

    public static /* synthetic */ ColorStateList createColorSelector$default(MDUtil mDUtil, Context context, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return mDUtil.createColorSelector(context, i, i2);
    }

    public final ColorStateList createColorSelector(Context context, int unchecked, int checked) {
        Intrinsics.checkParameterIsNotNull(context, "");
        if (checked == 0) {
            checked = resolveColor$default(this, context, null, Integer.valueOf(R.attr.colorControlActivated), null, 10, null);
        }
        int[][] iArr = {new int[]{-16842912, -16842908}, new int[]{16842912}, new int[]{16842908}};
        int[] iArr2 = new int[3];
        if (unchecked == 0) {
            unchecked = resolveColor$default(this, context, null, Integer.valueOf(R.attr.colorControlNormal), null, 10, null);
        }
        iArr2[0] = unchecked;
        iArr2[1] = checked;
        iArr2[2] = checked;
        return new ColorStateList(iArr, iArr2);
    }

    public final <T extends View> void waitForWidth(final T t, final Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "");
        Intrinsics.checkParameterIsNotNull(function1, "");
        if (t.getMeasuredWidth() > 0 && t.getMeasuredHeight() > 0) {
            function1.invoke(t);
        } else {
            t.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.afollestad.materialdialogs.utils.MDUtil$waitForWidth$1
                private Integer lastWidth;

                @JvmName(name = "getLastWidth")
                public final Integer getLastWidth() {
                    return this.lastWidth;
                }

                @JvmName(name = "setLastWidth")
                public final void setLastWidth(Integer num) {
                    this.lastWidth = num;
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    Integer num = this.lastWidth;
                    if (num != null) {
                        int measuredWidth = t.getMeasuredWidth();
                        if (num != null && num.intValue() == measuredWidth) {
                            t.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            return;
                        }
                    }
                    if (t.getMeasuredWidth() <= 0 || t.getMeasuredHeight() <= 0) {
                        return;
                    }
                    Integer num2 = this.lastWidth;
                    int measuredWidth2 = t.getMeasuredWidth();
                    if (num2 == null || num2.intValue() != measuredWidth2) {
                        this.lastWidth = Integer.valueOf(t.getMeasuredWidth());
                        function1.invoke(t);
                    }
                }
            });
        }
    }

    public final <T extends View> void waitForHeight(final T t, final Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "");
        Intrinsics.checkParameterIsNotNull(function1, "");
        if (t.getMeasuredWidth() > 0 && t.getMeasuredHeight() > 0) {
            function1.invoke(t);
        } else {
            t.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.afollestad.materialdialogs.utils.MDUtil$waitForHeight$1
                private Integer lastHeight;

                @JvmName(name = "getLastHeight")
                public final Integer getLastHeight() {
                    return this.lastHeight;
                }

                @JvmName(name = "setLastHeight")
                public final void setLastHeight(Integer num) {
                    this.lastHeight = num;
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    Integer num = this.lastHeight;
                    if (num != null) {
                        int measuredHeight = t.getMeasuredHeight();
                        if (num != null && num.intValue() == measuredHeight) {
                            t.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            return;
                        }
                    }
                    if (t.getMeasuredWidth() <= 0 || t.getMeasuredHeight() <= 0) {
                        return;
                    }
                    Integer num2 = this.lastHeight;
                    int measuredHeight2 = t.getMeasuredHeight();
                    if (num2 == null || num2.intValue() != measuredHeight2) {
                        this.lastHeight = Integer.valueOf(t.getMeasuredHeight());
                        function1.invoke(t);
                    }
                }
            });
        }
    }

    public final Pair<Integer, Integer> getWidthAndHeight(WindowManager windowManager) {
        Intrinsics.checkParameterIsNotNull(windowManager, "");
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return new Pair<>(Integer.valueOf(point.x), Integer.valueOf(point.y));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void updatePadding$default(com.afollestad.materialdialogs.utils.MDUtil r7, android.view.View r8, int r9, int r10, int r11, int r12, int r13, java.lang.Object r14) {
        /*
            r14 = r13 & 1
            r0 = 0
            if (r14 == 0) goto Le
            if (r8 == 0) goto Lc
            int r9 = r8.getPaddingLeft()
            goto Le
        Lc:
            r3 = 0
            goto Lf
        Le:
            r3 = r9
        Lf:
            r9 = r13 & 2
            if (r9 == 0) goto L1c
            if (r8 == 0) goto L1a
            int r10 = r8.getPaddingTop()
            goto L1c
        L1a:
            r4 = 0
            goto L1d
        L1c:
            r4 = r10
        L1d:
            r9 = r13 & 4
            if (r9 == 0) goto L2a
            if (r8 == 0) goto L28
            int r11 = r8.getPaddingRight()
            goto L2a
        L28:
            r5 = 0
            goto L2b
        L2a:
            r5 = r11
        L2b:
            r9 = r13 & 8
            if (r9 == 0) goto L38
            if (r8 == 0) goto L36
            int r12 = r8.getPaddingBottom()
            goto L38
        L36:
            r6 = 0
            goto L39
        L38:
            r6 = r12
        L39:
            r1 = r7
            r2 = r8
            r1.updatePadding(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.utils.MDUtil.updatePadding$default(com.afollestad.materialdialogs.utils.MDUtil, android.view.View, int, int, int, int, int, java.lang.Object):void");
    }

    public final <T extends View> void updatePadding(T t, int i, int i2, int i3, int i4) {
        if ((t != null && i == t.getPaddingLeft() && i2 == t.getPaddingTop() && i3 == t.getPaddingRight() && i4 == t.getPaddingBottom()) || t == null) {
            return;
        }
        t.setPadding(i, i2, i3, i4);
    }

    public final void assertOneSet(String method, Object b, Integer a2) {
        Intrinsics.checkParameterIsNotNull(method, "");
        if (a2 == null && b == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(method);
            sb.append(": You must specify a resource ID or literal value");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public final String[] getStringArray(Context context, Integer num) {
        Intrinsics.checkParameterIsNotNull(context, "");
        if (num != null) {
            String[] stringArray = context.getResources().getStringArray(num.intValue());
            Intrinsics.checkExpressionValueIsNotNull(stringArray, "");
            return stringArray;
        }
        return new String[0];
    }

    public static /* synthetic */ View inflate$default(MDUtil mDUtil, ViewGroup viewGroup, Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            context = viewGroup.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "");
        }
        return mDUtil.inflate(viewGroup, context, i);
    }

    public final <R extends View> R inflate(ViewGroup viewGroup, Context context, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "");
        Intrinsics.checkParameterIsNotNull(context, "");
        R r = (R) LayoutInflater.from(context).inflate(i, viewGroup, false);
        if (r != null) {
            return r;
        }
        throw new TypeCastException("null cannot be cast to non-null type R");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0041 -> B:15:0x0049). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r8, int r9) {
        /*
            byte[] r0 = com.afollestad.materialdialogs.utils.MDUtil.MyBillsEntityDataFactory
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 97
            r3 = 4
            r4 = -1
            if (r0 != 0) goto L14
            r3 = r1
            r4 = 4
            r5 = 4
            r6 = -1
            r1 = r0
            r0 = r9
            r9 = r8
            goto L49
        L14:
            r2 = r1
            r3 = 97
            r4 = 4
            r5 = -1
            r1 = r0
            r0 = r9
            r9 = r8
        L1c:
            int r5 = r5 + 1
            byte r6 = (byte) r3
            r2[r5] = r6
            r6 = 22
            if (r5 != r6) goto L41
            java.lang.String r1 = new java.lang.String
            r3 = 0
            r1.<init>(r2, r3)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r8 = r1.isInstance(r8)
            if (r8 == 0) goto L3c
            android.content.Context r9 = (android.content.Context) r9
            android.graphics.drawable.Drawable r8 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r9, r0)
            return r8
        L3c:
            android.graphics.drawable.Drawable r8 = r9.getDrawable(r0)
            return r8
        L41:
            r6 = r1[r4]
            r7 = r3
            r3 = r2
            r2 = r6
            r6 = r5
            r5 = r4
            r4 = r7
        L49:
            int r4 = r4 + r2
            int r2 = r4 + (-8)
            int r4 = r5 + 1
            r5 = r6
            r7 = r3
            r3 = r2
            r2 = r7
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.utils.MDUtil.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }
}
