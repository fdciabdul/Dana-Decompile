package id.dana.danapoly.data.dailycheck.model.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/danapoly/data/dailycheck/model/response/CampaignInfoResponse;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lid/dana/danapoly/data/dailycheck/model/response/CampaignConfigurationResponse;", "checkInCampaignConfiguration", "Lid/dana/danapoly/data/dailycheck/model/response/CampaignConfigurationResponse;", "getCheckInCampaignConfiguration", "()Lid/dana/danapoly/data/dailycheck/model/response/CampaignConfigurationResponse;", "<init>", "(Lid/dana/danapoly/data/dailycheck/model/response/CampaignConfigurationResponse;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class CampaignInfoResponse extends BaseRpcResult {
    @SerializedName("checkInCampaignConfiguration")
    private final CampaignConfigurationResponse checkInCampaignConfiguration;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.danapoly.data.dailycheck.model.response.CampaignConfigurationResponse, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CampaignInfoResponse() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.data.dailycheck.model.response.CampaignInfoResponse.<init>():void");
    }

    public /* synthetic */ CampaignInfoResponse(CampaignConfigurationResponse campaignConfigurationResponse, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : campaignConfigurationResponse);
    }

    @JvmName(name = "getCheckInCampaignConfiguration")
    public final CampaignConfigurationResponse getCheckInCampaignConfiguration() {
        return this.checkInCampaignConfiguration;
    }

    public CampaignInfoResponse(CampaignConfigurationResponse campaignConfigurationResponse) {
        this.checkInCampaignConfiguration = campaignConfigurationResponse;
    }
}
