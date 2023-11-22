package com.afollestad.materialdialogs.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import com.afollestad.materialdialogs.MaterialDialog;
import com.ap.zoloz.hummer.biz.HummerConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a-\u0010\t\u001a\u0004\u0018\u00010\u0004*\u00020\u00072\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Landroid/content/Context;", HummerConstants.CONTEXT, "", "res", "Landroid/graphics/Typeface;", "safeGetFont", "(Landroid/content/Context;I)Landroid/graphics/Typeface;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "attr", "font", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Ljava/lang/Integer;)Landroid/graphics/Typeface;"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class FontsKt {
    public static /* synthetic */ Typeface font$default(MaterialDialog materialDialog, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        return font(materialDialog, num, num2);
    }

    public static final Typeface font(MaterialDialog materialDialog, Integer num, Integer num2) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        MDUtil.INSTANCE.assertOneSet("font", num2, num);
        if (num != null) {
            return safeGetFont(materialDialog.getWindowContext(), num.intValue());
        }
        if (num2 == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        TypedArray obtainStyledAttributes = materialDialog.getWindowContext().getTheme().obtainStyledAttributes(new int[]{num2.intValue()});
        try {
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            if (resourceId != 0) {
                return safeGetFont(materialDialog.getWindowContext(), resourceId);
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private static final Typeface safeGetFont(Context context, int i) {
        try {
            return ResourcesCompat.PlaceComponentResult(context, i);
        } catch (Throwable unused) {
            return null;
        }
    }
}
