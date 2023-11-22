package com.alipay.zoloz.toyger.algorithm;

import android.graphics.Rect;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class ToygerCameraConfig {
    public float[] color2depthExtrin;
    public float[] colorIntrin;
    public float[] depthIntrin;
    public boolean isAligned;
    public Rect roiRect;

    public ToygerCameraConfig() {
        this.roiRect = new Rect();
    }

    public ToygerCameraConfig(float[] fArr, float[] fArr2, float[] fArr3, Rect rect) {
        new Rect();
        this.colorIntrin = fArr;
        this.depthIntrin = fArr2;
        this.color2depthExtrin = fArr3;
        this.roiRect = rect;
        this.isAligned = false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ToygerCameraConfig{colorIntrin=");
        sb.append(Arrays.toString(this.colorIntrin));
        sb.append(", depthIntrin=");
        sb.append(Arrays.toString(this.depthIntrin));
        sb.append(", color2depthExtrin=");
        sb.append(Arrays.toString(this.color2depthExtrin));
        sb.append(", roiRect=");
        sb.append(this.roiRect);
        sb.append('}');
        return sb.toString();
    }
}
