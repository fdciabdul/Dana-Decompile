package me.zhanghai.android.materialprogressbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.core.graphics.ColorUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import me.zhanghai.android.materialprogressbar.IntrinsicPaddingDrawable;
import me.zhanghai.android.materialprogressbar.ShowBackgroundDrawable;
import me.zhanghai.android.materialprogressbar.TintableDrawable;
import me.zhanghai.android.materialprogressbar.internal.ThemeUtils;

/* loaded from: classes9.dex */
class BaseProgressLayerDrawable<ProgressDrawableType extends IntrinsicPaddingDrawable & ShowBackgroundDrawable & TintableDrawable, BackgroundDrawableType extends IntrinsicPaddingDrawable & ShowBackgroundDrawable & TintableDrawable> extends LayerDrawable implements IntrinsicPaddingDrawable, MaterialProgressDrawable, ShowBackgroundDrawable, TintableDrawable {
    private float mBackgroundAlpha;
    private final BackgroundDrawableType mBackgroundDrawable;
    private final ProgressDrawableType mProgressDrawable;
    private final ProgressDrawableType mSecondaryProgressDrawable;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {116, -27, -60, 115, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int BuiltInFictitiousFunctionClassFactory = 112;

    public BaseProgressLayerDrawable(Drawable[] drawableArr, Context context) {
        super(drawableArr);
        this.mBackgroundAlpha = ThemeUtils.getFloatFromAttrRes(16842803, 0.0f, context);
        setId(0, 16908288);
        this.mBackgroundDrawable = (BackgroundDrawableType) ((IntrinsicPaddingDrawable) __fsTypeCheck_fa35f1a1378495b6a04dd84d215e9b87(this, 0));
        setId(1, 16908303);
        this.mSecondaryProgressDrawable = (ProgressDrawableType) ((IntrinsicPaddingDrawable) __fsTypeCheck_fa35f1a1378495b6a04dd84d215e9b87(this, 1));
        setId(2, 16908301);
        this.mProgressDrawable = (ProgressDrawableType) ((IntrinsicPaddingDrawable) __fsTypeCheck_fa35f1a1378495b6a04dd84d215e9b87(this, 2));
        setTint(ThemeUtils.getColorFromAttrRes(R.attr.colorControlActivated, -16777216, context));
    }

    @Override // me.zhanghai.android.materialprogressbar.ShowBackgroundDrawable
    public boolean getShowBackground() {
        return this.mBackgroundDrawable.getShowBackground();
    }

    @Override // me.zhanghai.android.materialprogressbar.ShowBackgroundDrawable
    public void setShowBackground(boolean z) {
        if (this.mBackgroundDrawable.getShowBackground() != z) {
            this.mBackgroundDrawable.setShowBackground(z);
            this.mSecondaryProgressDrawable.setShowBackground(!z);
        }
    }

    @Override // me.zhanghai.android.materialprogressbar.IntrinsicPaddingDrawable
    public boolean getUseIntrinsicPadding() {
        return this.mBackgroundDrawable.getUseIntrinsicPadding();
    }

    @Override // me.zhanghai.android.materialprogressbar.IntrinsicPaddingDrawable
    public void setUseIntrinsicPadding(boolean z) {
        this.mBackgroundDrawable.setUseIntrinsicPadding(z);
        this.mSecondaryProgressDrawable.setUseIntrinsicPadding(z);
        this.mProgressDrawable.setUseIntrinsicPadding(z);
    }

    @Override // android.graphics.drawable.Drawable, me.zhanghai.android.materialprogressbar.TintableDrawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        int MyBillsEntityDataFactory = ColorUtils.MyBillsEntityDataFactory(i, Math.round(Color.alpha(i) * this.mBackgroundAlpha));
        this.mBackgroundDrawable.setTint(MyBillsEntityDataFactory);
        this.mSecondaryProgressDrawable.setTint(MyBillsEntityDataFactory);
        this.mProgressDrawable.setTint(i);
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable, me.zhanghai.android.materialprogressbar.TintableDrawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        ColorStateList colorStateList2;
        if (colorStateList != null) {
            if (!colorStateList.isOpaque()) {
                InstrumentInjector.log_w(getClass().getSimpleName(), "setTintList() called with a non-opaque ColorStateList, its original alpha will be discarded");
            }
            colorStateList2 = colorStateList.withAlpha(Math.round(this.mBackgroundAlpha * 255.0f));
        } else {
            colorStateList2 = null;
        }
        this.mBackgroundDrawable.setTintList(colorStateList2);
        this.mSecondaryProgressDrawable.setTintList(colorStateList2);
        this.mProgressDrawable.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable, me.zhanghai.android.materialprogressbar.TintableDrawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.mBackgroundDrawable.setTintMode(mode);
        this.mSecondaryProgressDrawable.setTintMode(mode);
        this.mProgressDrawable.setTintMode(mode);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0041 -> B:15:0x0049). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_fa35f1a1378495b6a04dd84d215e9b87(me.zhanghai.android.materialprogressbar.BaseProgressLayerDrawable r10, int r11) {
        /*
            byte[] r0 = me.zhanghai.android.materialprogressbar.BaseProgressLayerDrawable.KClassImpl$Data$declaredNonStaticMembers$2
            r1 = 23
            byte[] r2 = new byte[r1]
            r3 = 3
            r4 = 0
            if (r0 != 0) goto L13
            r5 = r2
            r6 = 3
            r7 = 23
            r8 = 0
            r2 = r0
            r0 = r11
            r11 = r10
            goto L49
        L13:
            r5 = 97
            r3 = r2
            r5 = 3
            r6 = 97
            r7 = 0
            r2 = r0
            r0 = r11
            r11 = r10
        L1d:
            int r5 = r5 + 1
            byte r8 = (byte) r6
            r3[r7] = r8
            int r7 = r7 + 1
            if (r7 != r1) goto L41
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3, r4)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r10 = r1.isInstance(r10)
            if (r10 == 0) goto L3c
            android.content.Context r11 = (android.content.Context) r11
            android.graphics.drawable.Drawable r10 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r11, r0)
            return r10
        L3c:
            android.graphics.drawable.Drawable r10 = r11.getDrawable(r0)
            return r10
        L41:
            r8 = r2[r5]
            r9 = r5
            r5 = r3
            r3 = r8
            r8 = r7
            r7 = r6
            r6 = r9
        L49:
            int r3 = -r3
            int r7 = r7 + r3
            int r3 = r7 + (-8)
            r7 = r8
            r9 = r6
            r6 = r3
            r3 = r5
            r5 = r9
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: me.zhanghai.android.materialprogressbar.BaseProgressLayerDrawable.__fsTypeCheck_fa35f1a1378495b6a04dd84d215e9b87(me.zhanghai.android.materialprogressbar.BaseProgressLayerDrawable, int):android.graphics.drawable.Drawable");
    }
}
