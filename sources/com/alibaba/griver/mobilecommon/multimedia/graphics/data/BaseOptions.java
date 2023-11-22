package com.alibaba.griver.mobilecommon.multimedia.graphics.data;

/* loaded from: classes6.dex */
public class BaseOptions {
    public boolean forceSystemDecode;
    public boolean ignoreGifAutoStart;
    public boolean ignoreMemCache;
    public boolean ignoreNetTask;
    public boolean pluginCurOpt;
    public boolean showAnimationThumb;
    public boolean saveToDiskCache = true;
    public boolean forceRunDisplayerInMain = true;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BaseOptions{ignoreNetTask=");
        sb.append(this.ignoreNetTask);
        sb.append(", ignoreGifAutoStart=");
        sb.append(this.ignoreGifAutoStart);
        sb.append(", forceSystemDecode=");
        sb.append(this.forceSystemDecode);
        sb.append(", saveDiskCache=");
        sb.append(this.saveToDiskCache);
        sb.append(", showthumb=");
        sb.append(this.showAnimationThumb);
        sb.append('}');
        return sb.toString();
    }
}
