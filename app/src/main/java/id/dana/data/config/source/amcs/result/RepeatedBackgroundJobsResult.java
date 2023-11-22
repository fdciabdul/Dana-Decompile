package id.dana.data.config.source.amcs.result;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: classes2.dex */
public class RepeatedBackgroundJobsResult {
    @JSONField(name = "enable")
    public boolean enable;
    @JSONField(name = "interval_time_in_millis")
    public long intervalTimeInMillis;
    @JSONField(name = "required_charging")
    public boolean requiredCharging;
    @JSONField(name = "required_device_idle")
    public boolean requiredDeviceIdle;

    public long getIntervalTimeInMillis() {
        return this.intervalTimeInMillis;
    }

    public void setIntervalTimeInMillis(long j) {
        this.intervalTimeInMillis = j;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public boolean isRequiredCharging() {
        return this.requiredCharging;
    }

    public void setRequiredCharging(boolean z) {
        this.requiredCharging = z;
    }

    public boolean isRequiredDeviceIdle() {
        return this.requiredDeviceIdle;
    }

    public void setRequiredDeviceIdle(boolean z) {
        this.requiredDeviceIdle = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RepeatedBackgroundJobsResult{intervalTimeInMillis=");
        sb.append(this.intervalTimeInMillis);
        sb.append(", enable=");
        sb.append(this.enable);
        sb.append(", requiredCharging=");
        sb.append(this.requiredCharging);
        sb.append(", requiredDeviceIdle=");
        sb.append(this.requiredDeviceIdle);
        sb.append('}');
        return sb.toString();
    }
}
