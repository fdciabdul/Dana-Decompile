package com.alipay.zoloz.zface.beans;

import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class PreviewData {
    public int frameMode;
    public ByteBuffer rgbData;
    public int rotation;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PreviewData{rgbData=");
        sb.append(this.rgbData);
        sb.append(", rotation=");
        sb.append(this.rotation);
        sb.append(", frameMode=");
        sb.append(this.frameMode);
        sb.append('}');
        return sb.toString();
    }
}
