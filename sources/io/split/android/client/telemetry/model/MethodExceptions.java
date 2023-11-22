package io.split.android.client.telemetry.model;

import com.alibaba.ariver.kernel.RVParams;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class MethodExceptions {
    @SerializedName("tr")
    private long track;
    @SerializedName(SecurityConstants.KEY_TEXT)
    private long treatment;
    @SerializedName(RVParams.TITLE_COLOR)
    private long treatmentWithConfig;
    @SerializedName("ts")
    private long treatments;
    @SerializedName("tcs")
    private long treatmentsWithConfig;

    public long getTreatment() {
        return this.treatment;
    }

    public void setTreatment(long j) {
        this.treatment = j;
    }

    public long getTreatments() {
        return this.treatments;
    }

    public void setTreatments(long j) {
        this.treatments = j;
    }

    public long getTreatmentWithConfig() {
        return this.treatmentWithConfig;
    }

    public void setTreatmentWithConfig(long j) {
        this.treatmentWithConfig = j;
    }

    public long getTreatmentsWithConfig() {
        return this.treatmentsWithConfig;
    }

    public void setTreatmentsWithConfig(long j) {
        this.treatmentsWithConfig = j;
    }

    public long getTrack() {
        return this.track;
    }

    public void setTrack(long j) {
        this.track = j;
    }
}
