package id.dana.data.wallet_v3.repository.source.network.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u0002\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0003\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0014\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004Jj\u0010\u0016\u001a\u00020\u00002\b\b\u0003\u0010\u000e\u001a\u00020\u00022\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u0013\u001a\u00020\u00022\b\b\u0003\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b#\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b%\u0010\u0007R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b'\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b(\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b)\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b*\u0010\u0004"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/network/result/KtpResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Long;", "component3", "component4", "component5", "component6", "component7", "component8", "backgroundUrl", "createdDate", "iconUrl", DecodedScanBizInfoKey.LOGO_URL, "pocketId", "pocketStatus", "pocketType", "cardTitle", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/wallet_v3/repository/source/network/result/KtpResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBackgroundUrl", "getCardTitle", "Ljava/lang/Long;", "getCreatedDate", "getIconUrl", "getLogoUrl", "getPocketId", "getPocketStatus", "getPocketType", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class KtpResult extends BaseRpcResult {
    @SerializedName("backgroundUrl")
    private final String backgroundUrl;
    private final String cardTitle;
    @SerializedName("createdDate")
    private final Long createdDate;
    @SerializedName("iconUrl")
    private final String iconUrl;
    @SerializedName(DecodedScanBizInfoKey.LOGO_URL)
    private final String logoUrl;
    @SerializedName("pocketId")
    private final String pocketId;
    @SerializedName("pocketStatus")
    private final String pocketStatus;
    @SerializedName("pocketType")
    private final String pocketType;

    public KtpResult() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    /* renamed from: component2  reason: from getter */
    public final Long getCreatedDate() {
        return this.createdDate;
    }

    /* renamed from: component3  reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component4  reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    /* renamed from: component5  reason: from getter */
    public final String getPocketId() {
        return this.pocketId;
    }

    /* renamed from: component6  reason: from getter */
    public final String getPocketStatus() {
        return this.pocketStatus;
    }

    /* renamed from: component7  reason: from getter */
    public final String getPocketType() {
        return this.pocketType;
    }

    /* renamed from: component8  reason: from getter */
    public final String getCardTitle() {
        return this.cardTitle;
    }

    public final KtpResult copy(@JSONField(name = "backgroundUrl") String backgroundUrl, @JSONField(name = "createdDate") Long createdDate, @JSONField(name = "iconUrl") String iconUrl, @JSONField(name = "logoUrl") String logoUrl, @JSONField(name = "pocketId") String pocketId, @JSONField(name = "pocketStatus") String pocketStatus, @JSONField(name = "pocketType") String pocketType, String cardTitle) {
        Intrinsics.checkNotNullParameter(backgroundUrl, "");
        Intrinsics.checkNotNullParameter(pocketStatus, "");
        Intrinsics.checkNotNullParameter(pocketType, "");
        return new KtpResult(backgroundUrl, createdDate, iconUrl, logoUrl, pocketId, pocketStatus, pocketType, cardTitle);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof KtpResult) {
            KtpResult ktpResult = (KtpResult) other;
            return Intrinsics.areEqual(this.backgroundUrl, ktpResult.backgroundUrl) && Intrinsics.areEqual(this.createdDate, ktpResult.createdDate) && Intrinsics.areEqual(this.iconUrl, ktpResult.iconUrl) && Intrinsics.areEqual(this.logoUrl, ktpResult.logoUrl) && Intrinsics.areEqual(this.pocketId, ktpResult.pocketId) && Intrinsics.areEqual(this.pocketStatus, ktpResult.pocketStatus) && Intrinsics.areEqual(this.pocketType, ktpResult.pocketType) && Intrinsics.areEqual(this.cardTitle, ktpResult.cardTitle);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.backgroundUrl.hashCode();
        Long l = this.createdDate;
        int hashCode2 = l == null ? 0 : l.hashCode();
        String str = this.iconUrl;
        int hashCode3 = str == null ? 0 : str.hashCode();
        String str2 = this.logoUrl;
        int hashCode4 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.pocketId;
        int hashCode5 = str3 == null ? 0 : str3.hashCode();
        int hashCode6 = this.pocketStatus.hashCode();
        int hashCode7 = this.pocketType.hashCode();
        String str4 = this.cardTitle;
        return (((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KtpResult(backgroundUrl=");
        sb.append(this.backgroundUrl);
        sb.append(", createdDate=");
        sb.append(this.createdDate);
        sb.append(", iconUrl=");
        sb.append(this.iconUrl);
        sb.append(", logoUrl=");
        sb.append(this.logoUrl);
        sb.append(", pocketId=");
        sb.append(this.pocketId);
        sb.append(", pocketStatus=");
        sb.append(this.pocketStatus);
        sb.append(", pocketType=");
        sb.append(this.pocketType);
        sb.append(", cardTitle=");
        sb.append(this.cardTitle);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ KtpResult(String str, Long l, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5, (i & 64) != 0 ? "" : str6, (i & 128) == 0 ? str7 : "");
    }

    @JvmName(name = "getBackgroundUrl")
    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    @JvmName(name = "getCreatedDate")
    public final Long getCreatedDate() {
        return this.createdDate;
    }

    @JvmName(name = "getIconUrl")
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @JvmName(name = "getLogoUrl")
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @JvmName(name = "getPocketId")
    public final String getPocketId() {
        return this.pocketId;
    }

    @JvmName(name = "getPocketStatus")
    public final String getPocketStatus() {
        return this.pocketStatus;
    }

    @JvmName(name = "getPocketType")
    public final String getPocketType() {
        return this.pocketType;
    }

    @JvmName(name = "getCardTitle")
    public final String getCardTitle() {
        return this.cardTitle;
    }

    public KtpResult(@JSONField(name = "backgroundUrl") String str, @JSONField(name = "createdDate") Long l, @JSONField(name = "iconUrl") String str2, @JSONField(name = "logoUrl") String str3, @JSONField(name = "pocketId") String str4, @JSONField(name = "pocketStatus") String str5, @JSONField(name = "pocketType") String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.backgroundUrl = str;
        this.createdDate = l;
        this.iconUrl = str2;
        this.logoUrl = str3;
        this.pocketId = str4;
        this.pocketStatus = str5;
        this.pocketType = str6;
        this.cardTitle = str7;
    }
}
