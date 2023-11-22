package com.alibaba.griver.ui.utils;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.core.graphics.drawable.DrawableCompat;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.ui.titlebar.NebulaTitleView;

/* loaded from: classes6.dex */
public class ColorUtils {
    public static NebulaTitleView.Theme getTheme(int i, NebulaTitleView.Theme theme) {
        try {
            Color.colorToHSV(i, new float[3]);
            if (r0[1] <= 0.75d && r0[2] >= 0.65d) {
                return NebulaTitleView.Theme.LIGHT;
            }
            return NebulaTitleView.Theme.DARK;
        } catch (Exception e) {
            GriverLogger.e("ColorUtils", String.valueOf(e));
            return theme;
        }
    }

    public static void setColor(ImageView imageView, int i) {
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            DrawableCompat.MyBillsEntityDataFactory(drawable, i);
            imageView.setImageDrawable(drawable);
        }
    }
}
