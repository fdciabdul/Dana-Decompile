package com.alibaba.griver.beehive.lottie.adapter.impl;

/* loaded from: classes6.dex */
public class APImageQueryResultAdapter {
    public int height;
    public String path;
    public boolean success;
    public int width;

    public APImageQueryResultAdapter() {
    }

    public APImageQueryResultAdapter(boolean z, String str, int i, int i2) {
        this.success = z;
        this.path = str;
        this.width = i;
        this.height = i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("APImageQueryResult{success=");
        sb.append(this.success);
        sb.append(", path='");
        sb.append(this.path);
        sb.append('\'');
        sb.append(", width=");
        sb.append(this.width);
        sb.append(", height=");
        sb.append(this.height);
        sb.append('}');
        return sb.toString();
    }
}
