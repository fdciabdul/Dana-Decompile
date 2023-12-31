package com.alibaba.griver.image.framework.encode;

import com.alibaba.griver.image.framework.mode.APMaxLenMode;
import com.alibaba.griver.image.framework.mode.APMode;

/* loaded from: classes6.dex */
public class APEncodeOptions {
    public static final int DEFAULT_MAX_LEN = 1280;
    public static final int QUALITY_AR = 2;
    @Deprecated
    public static final int QUALITY_HEIGHT = 1;
    public static final int QUALITY_HIGH = 1;
    public static final int QUALITY_LOW = 4;
    public static final int QUALITY_NORMAL = 0;
    public static final int QUALITY_ORIGINAL = 3;
    public Integer forceRotate;
    public APMode mode = new APMaxLenMode(DEFAULT_MAX_LEN);
    public int quality = 0;
    public int outFormat = 0;
    public String outputFile = null;
    public boolean requireOutputInfo = false;
    public boolean jniDebug = false;
    public boolean autoRotate = true;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("APEncodeOptions{mode=");
        sb.append(this.mode);
        sb.append(", quality=");
        sb.append(this.quality);
        sb.append(", outFormat=");
        sb.append(this.outFormat);
        sb.append(", outputFile='");
        sb.append(this.outputFile);
        sb.append('\'');
        sb.append(", requireOutputInfo=");
        sb.append(this.requireOutputInfo);
        sb.append(", jniDebug=");
        sb.append(this.jniDebug);
        sb.append(", autoRotate=");
        sb.append(this.autoRotate);
        sb.append(", forceRotate=");
        sb.append(this.forceRotate);
        sb.append('}');
        return sb.toString();
    }
}
