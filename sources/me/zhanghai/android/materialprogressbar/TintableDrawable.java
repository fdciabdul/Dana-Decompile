package me.zhanghai.android.materialprogressbar;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import androidx.core.graphics.drawable.TintAwareDrawable;

/* loaded from: classes9.dex */
public interface TintableDrawable extends TintAwareDrawable {
    @Override // me.zhanghai.android.materialprogressbar.TintableDrawable, androidx.core.graphics.drawable.TintAwareDrawable
    void setTint(int i);

    @Override // me.zhanghai.android.materialprogressbar.TintableDrawable, androidx.core.graphics.drawable.TintAwareDrawable
    void setTintList(ColorStateList colorStateList);

    @Override // me.zhanghai.android.materialprogressbar.TintableDrawable, androidx.core.graphics.drawable.TintAwareDrawable
    void setTintMode(PorterDuff.Mode mode);
}
