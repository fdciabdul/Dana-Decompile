package com.alibaba.griver.unify.model;

import android.graphics.Bitmap;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class IconModel implements Serializable {
    public Bitmap bitmap;
    public int color;
    public String filePath;
    public String key;
    public float size;

    public IconModel() {
    }

    public IconModel(String str, float f, int i, String str2) {
        this.key = str;
        this.color = i;
        this.size = f;
        this.filePath = str2;
    }

    public IconModel(float f, int i, Bitmap bitmap) {
        this.color = i;
        this.size = f;
        this.bitmap = bitmap;
    }
}
