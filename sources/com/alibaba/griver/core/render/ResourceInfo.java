package com.alibaba.griver.core.render;

/* loaded from: classes3.dex */
public class ResourceInfo {
    public boolean mIsMainDoc;
    public String mMethod;
    public String mMimeType;
    public long mStart;
    public int mStatusCode;
    public String mUrl;

    public ResourceInfo(long j, String str) {
        this.mMethod = str;
        this.mStart = j;
    }
}
