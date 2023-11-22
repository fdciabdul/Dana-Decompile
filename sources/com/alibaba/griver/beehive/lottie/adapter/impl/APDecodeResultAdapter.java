package com.alibaba.griver.beehive.lottie.adapter.impl;

import android.graphics.Bitmap;
import com.alibaba.griver.image.framework.meta.APImageInfo;

/* loaded from: classes6.dex */
public class APDecodeResultAdapter {
    public Bitmap bitmap;
    public int code;
    public int extra;
    public APImageInfo srcInfo;

    public APDecodeResultAdapter(int i, Bitmap bitmap, int i2, APImageInfo aPImageInfo) {
        this.code = i;
        this.bitmap = bitmap;
        this.extra = i2;
        this.srcInfo = aPImageInfo;
    }

    public boolean isSuccess() {
        return this.code == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("APDecodeResultAdapter{code=");
        sb.append(this.code);
        sb.append(", bitmap=");
        sb.append(this.bitmap);
        sb.append(", extra=");
        sb.append(this.extra);
        sb.append('}');
        return sb.toString();
    }
}
