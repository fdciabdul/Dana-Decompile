package com.alipay.multimedia.adjuster.data;

/* loaded from: classes7.dex */
public class UrlInfo {
    public String baseUrl;
    public Size originSize;
    public int quality = 0;

    /* loaded from: classes7.dex */
    public static class Size {
        public int mHeight;
        public int mWidth;

        public Size(int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
        }
    }
}
