package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;

/* loaded from: classes.dex */
public class TintTypedArray {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {1, 78, 11, -6, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int PlaceComponentResult = 103;
    public final TypedArray BuiltInFictitiousFunctionClassFactory;
    TypedValue MyBillsEntityDataFactory;
    final Context getAuthRequestContext;

    public static TintTypedArray MyBillsEntityDataFactory(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static TintTypedArray getAuthRequestContext(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public static TintTypedArray getAuthRequestContext(Context context, int i, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(i, iArr));
    }

    private TintTypedArray(Context context, TypedArray typedArray) {
        this.getAuthRequestContext = context;
        this.BuiltInFictitiousFunctionClassFactory = typedArray;
    }

    public final Drawable BuiltInFictitiousFunctionClassFactory(int i) {
        int resourceId;
        if (this.BuiltInFictitiousFunctionClassFactory.hasValue(i) && (resourceId = this.BuiltInFictitiousFunctionClassFactory.getResourceId(i, 0)) != 0) {
            return AppCompatResources.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, resourceId);
        }
        return getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, i);
    }

    public final Drawable MyBillsEntityDataFactory(int i) {
        int resourceId;
        if (!this.BuiltInFictitiousFunctionClassFactory.hasValue(i) || (resourceId = this.BuiltInFictitiousFunctionClassFactory.getResourceId(i, 0)) == 0) {
            return null;
        }
        return AppCompatDrawableManager.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory(this.getAuthRequestContext, resourceId, true);
    }

    public final boolean getAuthRequestContext(int i, boolean z) {
        return this.BuiltInFictitiousFunctionClassFactory.getBoolean(i, z);
    }

    public final ColorStateList PlaceComponentResult(int i) {
        int resourceId;
        ColorStateList authRequestContext;
        return (!this.BuiltInFictitiousFunctionClassFactory.hasValue(i) || (resourceId = this.BuiltInFictitiousFunctionClassFactory.getResourceId(i, 0)) == 0 || (authRequestContext = AppCompatResources.getAuthRequestContext(this.getAuthRequestContext, resourceId)) == null) ? this.BuiltInFictitiousFunctionClassFactory.getColorStateList(i) : authRequestContext;
    }

    public final boolean getAuthRequestContext(int i) {
        return this.BuiltInFictitiousFunctionClassFactory.hasValue(i);
    }

    /* loaded from: classes.dex */
    static class Api21Impl {
        private Api21Impl() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0034  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x004f -> B:15:0x0054). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.drawable.Drawable getAuthRequestContext(android.content.res.TypedArray r10, int r11) {
        /*
            byte[] r0 = androidx.appcompat.widget.TintTypedArray.KClassImpl$Data$declaredNonStaticMembers$2
            r1 = 0
            r2 = r0[r1]
            int r2 = r2 + (-1)
            byte r2 = (byte) r2
            byte r3 = (byte) r2
            byte r4 = (byte) r3
            int r4 = r4 * 4
            int r4 = r4 + 4
            int r3 = r3 * 3
            int r3 = r3 + 97
            int r2 = r2 * 3
            int r2 = 23 - r2
            byte[] r5 = new byte[r2]
            int r2 = r2 + (-1)
            if (r0 != 0) goto L25
            r7 = r4
            r6 = r5
            r8 = 0
            r4 = r2
            r5 = r7
            r2 = r0
            r0 = r11
            r11 = r10
            goto L54
        L25:
            r6 = r5
            r7 = 0
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r0
            r0 = r11
            r11 = r10
        L2d:
            byte r8 = (byte) r4
            r6[r7] = r8
            int r8 = r7 + 1
            if (r7 != r3) goto L4f
            java.lang.String r2 = new java.lang.String
            r2.<init>(r6, r1)
            java.lang.Class r1 = java.lang.Class.forName(r2)
            boolean r10 = r1.isInstance(r10)
            if (r10 == 0) goto L4a
            android.content.Context r11 = (android.content.Context) r11
            android.graphics.drawable.Drawable r10 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r11, r0)
            return r10
        L4a:
            android.graphics.drawable.Drawable r10 = r11.getDrawable(r0)
            return r10
        L4f:
            r7 = r2[r5]
            r9 = r4
            r4 = r3
            r3 = r9
        L54:
            int r5 = r5 + 1
            int r7 = -r7
            int r3 = r3 + r7
            int r3 = r3 + (-8)
            r7 = r8
            r9 = r4
            r4 = r3
            r3 = r9
            goto L2d
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.TintTypedArray.getAuthRequestContext(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }
}
