package io.split.android.client.telemetry.model;

import com.alibaba.ariver.kernel.RVParams;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.e;

/* loaded from: classes6.dex */
public class UrlOverrides {
    @SerializedName("a")
    private boolean auth;
    @SerializedName(e.PlaceComponentResult)
    private boolean events;
    @SerializedName("s")
    private boolean sdkUrl;
    @SerializedName(RVParams.SHOW_TITLEBAR)
    private boolean stream;
    @SerializedName(SecurityConstants.KEY_TEXT)
    private boolean telemetry;

    public boolean isSdkUrl() {
        return this.sdkUrl;
    }

    public void setSdkUrl(boolean z) {
        this.sdkUrl = z;
    }

    public boolean isEvents() {
        return this.events;
    }

    public void setEvents(boolean z) {
        this.events = z;
    }

    public boolean isAuth() {
        return this.auth;
    }

    public void setAuth(boolean z) {
        this.auth = z;
    }

    public boolean isStream() {
        return this.stream;
    }

    public void setStream(boolean z) {
        this.stream = z;
    }

    public boolean isTelemetry() {
        return this.telemetry;
    }

    public void setTelemetry(boolean z) {
        this.telemetry = z;
    }
}
