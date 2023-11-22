package id.dana.data.config.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0003\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0003\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007"}, d2 = {"Lid/dana/data/config/model/PromoAdsConfigResponse;", "", "", "component1", "()Z", "", "component2", "()I", "enable", "numberOfItemBatch", "copy", "(ZI)Lid/dana/data/config/model/PromoAdsConfigResponse;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Z", "getEnable", "I", "getNumberOfItemBatch", "<init>", "(ZI)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class PromoAdsConfigResponse {
    private final boolean enable;
    @SerializedName("number_of_item_batch")
    private final int numberOfItemBatch;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PromoAdsConfigResponse() {
        /*
            r3 = this;
            r0 = 0
            r1 = 3
            r2 = 0
            r3.<init>(r0, r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.config.model.PromoAdsConfigResponse.<init>():void");
    }

    public static /* synthetic */ PromoAdsConfigResponse copy$default(PromoAdsConfigResponse promoAdsConfigResponse, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = promoAdsConfigResponse.enable;
        }
        if ((i2 & 2) != 0) {
            i = promoAdsConfigResponse.numberOfItemBatch;
        }
        return promoAdsConfigResponse.copy(z, i);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2  reason: from getter */
    public final int getNumberOfItemBatch() {
        return this.numberOfItemBatch;
    }

    public final PromoAdsConfigResponse copy(boolean enable, @JSONField(name = "number_of_item_batch") int numberOfItemBatch) {
        return new PromoAdsConfigResponse(enable, numberOfItemBatch);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PromoAdsConfigResponse) {
            PromoAdsConfigResponse promoAdsConfigResponse = (PromoAdsConfigResponse) other;
            return this.enable == promoAdsConfigResponse.enable && this.numberOfItemBatch == promoAdsConfigResponse.numberOfItemBatch;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean z = this.enable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.numberOfItemBatch;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PromoAdsConfigResponse(enable=");
        sb.append(this.enable);
        sb.append(", numberOfItemBatch=");
        sb.append(this.numberOfItemBatch);
        sb.append(')');
        return sb.toString();
    }

    public PromoAdsConfigResponse(boolean z, @JSONField(name = "number_of_item_batch") int i) {
        this.enable = z;
        this.numberOfItemBatch = i;
    }

    public /* synthetic */ PromoAdsConfigResponse(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? 5 : i);
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "getNumberOfItemBatch")
    public final int getNumberOfItemBatch() {
        return this.numberOfItemBatch;
    }
}
