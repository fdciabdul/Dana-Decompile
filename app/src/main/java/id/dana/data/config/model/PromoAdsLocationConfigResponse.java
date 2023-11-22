package id.dana.data.config.model;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0003\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\bR\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/data/config/model/PromoAdsLocationConfigResponse;", "", "", "minimumRadiusInMeter", "I", "getMinimumRadiusInMeter", "()I", "setMinimumRadiusInMeter", "(I)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PromoAdsLocationConfigResponse {
    public int minimumRadiusInMeter;

    public PromoAdsLocationConfigResponse() {
        this(0, 1, null);
    }

    public PromoAdsLocationConfigResponse(@JSONField(name = "minimum_radius_in_meters") int i) {
        this.minimumRadiusInMeter = i;
    }

    public /* synthetic */ PromoAdsLocationConfigResponse(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 4000 : i);
    }

    @JvmName(name = "getMinimumRadiusInMeter")
    public final int getMinimumRadiusInMeter() {
        return this.minimumRadiusInMeter;
    }

    @JvmName(name = "setMinimumRadiusInMeter")
    public final void setMinimumRadiusInMeter(int i) {
        this.minimumRadiusInMeter = i;
    }
}
