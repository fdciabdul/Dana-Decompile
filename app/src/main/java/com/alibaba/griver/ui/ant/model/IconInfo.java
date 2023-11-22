package com.alibaba.griver.ui.ant.model;

import android.graphics.drawable.Drawable;

/* loaded from: classes6.dex */
public class IconInfo {
    public static final int TYPE_DRAWABLE = 3;
    public static final int TYPE_ICONFONT = 2;
    public static final int TYPE_URL = 1;
    public Drawable drawable;
    public String icon;
    public int iconRes;
    public int type = 2;

    public IconInfo() {
    }

    public IconInfo(String str) {
        this.icon = str;
    }

    public IconInfo(Drawable drawable) {
        this.drawable = drawable;
    }

    public IconInfo(int i) {
        this.iconRes = i;
    }
}
