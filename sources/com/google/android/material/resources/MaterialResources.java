package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TintTypedArray;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;

/* loaded from: classes3.dex */
public class MaterialResources {
    private static final float FONT_SCALE_1_3 = 1.3f;
    private static final float FONT_SCALE_2_0 = 2.0f;
    public static final byte[] MyBillsEntityDataFactory = {75, -120, 119, 39, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int PlaceComponentResult = 98;

    private MaterialResources() {
    }

    public static ColorStateList getColorStateList(Context context, TypedArray typedArray, int i) {
        int color;
        int resourceId;
        ColorStateList authRequestContext;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (authRequestContext = AppCompatResources.getAuthRequestContext(context, resourceId)) == null) {
            if (Build.VERSION.SDK_INT <= 15 && (color = typedArray.getColor(i, -1)) != -1) {
                return ColorStateList.valueOf(color);
            }
            return typedArray.getColorStateList(i);
        }
        return authRequestContext;
    }

    public static ColorStateList getColorStateList(Context context, TintTypedArray tintTypedArray, int i) {
        int color;
        int resourceId;
        ColorStateList authRequestContext;
        if (!tintTypedArray.getAuthRequestContext(i) || (resourceId = tintTypedArray.BuiltInFictitiousFunctionClassFactory.getResourceId(i, 0)) == 0 || (authRequestContext = AppCompatResources.getAuthRequestContext(context, resourceId)) == null) {
            if (Build.VERSION.SDK_INT <= 15 && (color = tintTypedArray.BuiltInFictitiousFunctionClassFactory.getColor(i, -1)) != -1) {
                return ColorStateList.valueOf(color);
            }
            return tintTypedArray.PlaceComponentResult(i);
        }
        return authRequestContext;
    }

    public static Drawable getDrawable(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable KClassImpl$Data$declaredNonStaticMembers$2;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (KClassImpl$Data$declaredNonStaticMembers$2 = AppCompatResources.KClassImpl$Data$declaredNonStaticMembers$2(context, resourceId)) == null) ? __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(typedArray, i) : KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static TextAppearance getTextAppearance(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return new TextAppearance(context, resourceId);
    }

    public static int getDimensionPixelSize(Context context, TypedArray typedArray, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i, i2);
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i2);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static boolean isFontScaleAtLeast1_3(Context context) {
        return context.getResources().getConfiguration().fontScale >= FONT_SCALE_1_3;
    }

    public static boolean isFontScaleAtLeast2_0(Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getIndexWithValue(TypedArray typedArray, int i, int i2) {
        return typedArray.hasValue(i) ? i : i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0042 -> B:15:0x0049). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r9, int r10) {
        /*
            byte[] r0 = com.google.android.material.resources.MaterialResources.MyBillsEntityDataFactory
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 22
            r3 = 97
            r4 = -1
            r5 = 4
            if (r0 != 0) goto L17
            r4 = r1
            r5 = 22
            r6 = 4
            r7 = -1
            r1 = r0
            r0 = r10
            r10 = r9
            goto L49
        L17:
            r3 = r1
            r4 = 97
            r5 = -1
            r6 = 4
            r1 = r0
            r0 = r10
            r10 = r9
        L1f:
            int r5 = r5 + 1
            byte r7 = (byte) r4
            r3[r5] = r7
            if (r5 != r2) goto L42
            java.lang.String r1 = new java.lang.String
            r2 = 0
            r1.<init>(r3, r2)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r9 = r1.isInstance(r9)
            if (r9 == 0) goto L3d
            android.content.Context r10 = (android.content.Context) r10
            android.graphics.drawable.Drawable r9 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r10, r0)
            return r9
        L3d:
            android.graphics.drawable.Drawable r9 = r10.getDrawable(r0)
            return r9
        L42:
            r7 = r1[r6]
            r8 = r4
            r4 = r3
            r3 = r7
            r7 = r5
            r5 = r8
        L49:
            int r6 = r6 + 1
            int r5 = r5 + r3
            int r3 = r5 + (-8)
            r5 = r7
            r8 = r4
            r4 = r3
            r3 = r8
            goto L1f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.resources.MaterialResources.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }
}
