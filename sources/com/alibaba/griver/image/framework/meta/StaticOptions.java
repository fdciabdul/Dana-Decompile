package com.alibaba.griver.image.framework.meta;

/* loaded from: classes6.dex */
public class StaticOptions {
    public static boolean jniDebug = false;
    public static final boolean supportNativeProcess = false;
    public static int thumbnail_allow_delta = 20;
    public static boolean useRandomAccessFileExif = true;
    public static boolean useThumbnailData = true;

    public static String value() {
        StringBuilder sb = new StringBuilder();
        sb.append("StaticOptions [supportNativeProcess: false, jniDebug: ");
        sb.append(jniDebug);
        sb.append(", useRandomAccessFileExif: ");
        sb.append(useRandomAccessFileExif);
        sb.append(", useThumbnailData: ");
        sb.append(useThumbnailData);
        sb.append(", thumbnail_allow_delta: ");
        sb.append(thumbnail_allow_delta);
        sb.append("]");
        return sb.toString();
    }
}
