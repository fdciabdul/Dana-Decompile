package io.split.android.client.telemetry.model;

import com.alibaba.ariver.kernel.RVParams;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes6.dex */
public class MethodLatencies {
    @SerializedName("tr")
    private List<Long> track;
    @SerializedName(SecurityConstants.KEY_TEXT)
    private List<Long> treatment;
    @SerializedName(RVParams.TITLE_COLOR)
    private List<Long> treatmentWithConfig;
    @SerializedName("ts")
    private List<Long> treatments;
    @SerializedName("tcs")
    private List<Long> treatmentsWithConfig;

    public List<Long> getTreatment() {
        return this.treatment;
    }

    public void setTreatment(List<Long> list) {
        this.treatment = list;
    }

    public List<Long> getTreatments() {
        return this.treatments;
    }

    public void setTreatments(List<Long> list) {
        this.treatments = list;
    }

    public List<Long> getTreatmentWithConfig() {
        return this.treatmentWithConfig;
    }

    public void setTreatmentWithConfig(List<Long> list) {
        this.treatmentWithConfig = list;
    }

    public List<Long> getTreatmentsWithConfig() {
        return this.treatmentsWithConfig;
    }

    public void setTreatmentsWithConfig(List<Long> list) {
        this.treatmentsWithConfig = list;
    }

    public List<Long> getTrack() {
        return this.track;
    }

    public void setTrack(List<Long> list) {
        this.track = list;
    }
}
