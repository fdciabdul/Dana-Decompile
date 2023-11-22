package com.alibaba.griver.image.photo.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.StateListDrawable;
import com.alibaba.griver.base.common.utils.DensityUtil;
import com.alibaba.griver.image.R;
import com.alibaba.griver.ui.ant.basic.AUIconDrawable;
import com.alibaba.griver.ui.ant.model.IconPaintBuilder;
import com.alibaba.griver.ui.ant.utils.StateListUtils;

/* loaded from: classes6.dex */
public class IconUtils {
    public static StateListDrawable getTitleIcon_White(Context context, int i) {
        return getTitleIcon(context, i, context.getResources().getColor(R.color.griver_image_AU_COLOR_UNIVERSAL_BG));
    }

    public static StateListDrawable getTitleIcon(Context context, int i, int i2) {
        return getIconListDrawable(context, DensityUtil.dip2px(context, 22.0f), StateListUtils.getColorStateList(i2, 1728053247 & i2, 0), i);
    }

    public static StateListDrawable getIconListDrawable(Context context, int i, ColorStateList colorStateList, int i2) {
        if (colorStateList == null) {
            return null;
        }
        return getIconListDrawable(context, i, colorStateList.getDefaultColor(), colorStateList.getColorForState(new int[]{16842919}, 0), colorStateList.getColorForState(new int[]{-16842910}, 0), colorStateList.getColorForState(new int[]{16842913}, 0), i2);
    }

    public static StateListDrawable getIconListDrawable(Context context, int i, int i2, int i3, int i4, int i5, int i6) {
        if (i2 == 0) {
            return null;
        }
        if (i == 0) {
            i = DensityUtil.dip2px(context, 20.0f);
        }
        return StateListUtils.getStateListDrawable(new AUIconDrawable(context, new IconPaintBuilder(i2, i, i6)), i3 != 0 ? new AUIconDrawable(context, new IconPaintBuilder(i3, i, i6)) : null, i4 != 0 ? new AUIconDrawable(context, new IconPaintBuilder(i4, i, i6)) : null, i5 != 0 ? new AUIconDrawable(context, new IconPaintBuilder(i5, i, i6)) : null);
    }
}
