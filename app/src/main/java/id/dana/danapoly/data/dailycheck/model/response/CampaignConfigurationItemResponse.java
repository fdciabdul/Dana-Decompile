package id.dana.danapoly.data.dailycheck.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/danapoly/data/dailycheck/model/response/CampaignConfigurationItemResponse;", "", "", "position", "Ljava/lang/String;", "getPosition", "()Ljava/lang/String;", "", "prizeValue", "Ljava/lang/Integer;", "getPrizeValue", "()Ljava/lang/Integer;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class CampaignConfigurationItemResponse {
    @SerializedName("position")
    private final String position;
    @SerializedName("prizeValue")
    private final Integer prizeValue;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String, java.lang.Integer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CampaignConfigurationItemResponse() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.data.dailycheck.model.response.CampaignConfigurationItemResponse.<init>():void");
    }

    public CampaignConfigurationItemResponse(String str, Integer num) {
        this.position = str;
        this.prizeValue = num;
    }

    @JvmName(name = "getPosition")
    public final String getPosition() {
        return this.position;
    }

    public /* synthetic */ CampaignConfigurationItemResponse(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0 : num);
    }

    @JvmName(name = "getPrizeValue")
    public final Integer getPrizeValue() {
        return this.prizeValue;
    }
}
