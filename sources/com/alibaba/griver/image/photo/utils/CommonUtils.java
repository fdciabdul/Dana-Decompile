package com.alibaba.griver.image.photo.utils;

import android.widget.ImageView;
import com.alibaba.griver.image.R;
import java.util.List;

/* loaded from: classes6.dex */
public class CommonUtils {
    public static void setTitleBarBackDrawable(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        imageView.setImageDrawable(IconUtils.getTitleIcon_White(imageView.getContext(), R.string.griver_image_iconfont_back));
    }

    public static boolean isIndexValidInList(List list, int i) {
        return i >= 0 && list != null && !list.isEmpty() && list.size() > i;
    }
}
