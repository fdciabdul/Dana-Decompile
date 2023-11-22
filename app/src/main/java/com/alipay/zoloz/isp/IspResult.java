package com.alipay.zoloz.isp;

/* loaded from: classes7.dex */
public class IspResult {
    private long exposureTime;
    private int iso;
    private boolean needSet;

    public IspResult(boolean z, long j, int i) {
        this.needSet = z;
        this.exposureTime = j;
        this.iso = i;
    }

    public boolean isNeedSet() {
        return this.needSet;
    }

    public long getExposureTime() {
        return this.exposureTime;
    }

    public int getIso() {
        return this.iso;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IspResult{needSet=");
        sb.append(this.needSet);
        sb.append(", exposureTime=");
        sb.append(this.exposureTime);
        sb.append(", iso=");
        sb.append(this.iso);
        sb.append('}');
        return sb.toString();
    }
}
