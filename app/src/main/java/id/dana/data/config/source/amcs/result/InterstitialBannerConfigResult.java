package id.dana.data.config.source.amcs.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class InterstitialBannerConfigResult {
    @SerializedName("gapTimeInMinute")
    @JSONField(name = "gapTimeInMinute")
    private long gapTime;
    @SerializedName("resetTimeInDay")
    @JSONField(name = "resetTimeInDay")
    private long resetTime;

    public long getGapTime() {
        return this.gapTime;
    }

    public void setGapTime(long j) {
        this.gapTime = j;
    }

    public long getResetTime() {
        return this.resetTime;
    }

    public void setResetTime(long j) {
        this.resetTime = j;
    }
}
