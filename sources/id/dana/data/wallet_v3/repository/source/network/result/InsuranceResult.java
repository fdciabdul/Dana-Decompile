package id.dana.data.wallet_v3.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b1\u00102J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004JX\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004R\"\u0010\r\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010\u0004\"\u0004\b!\u0010\"R$\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010#\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010&R\"\u0010\u000f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b'\u0010\u0004\"\u0004\b(\u0010\"R\"\u0010\u0010\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b)\u0010\u0004\"\u0004\b*\u0010\"R\"\u0010\u0011\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b+\u0010\u0004\"\u0004\b,\u0010\"R\"\u0010\u0012\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b-\u0010\u0004\"\u0004\b.\u0010\"R\"\u0010\u0013\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b/\u0010\u0004\"\u0004\b0\u0010\""}, d2 = {"Lid/dana/data/wallet_v3/repository/source/network/result/InsuranceResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Long;", "component3", "component4", "component5", "component6", "component7", "backgroundUrl", "createdDate", "iconUrl", DecodedScanBizInfoKey.LOGO_URL, "pocketId", "pocketStatus", "pocketType", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/wallet_v3/repository/source/network/result/InsuranceResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBackgroundUrl", "setBackgroundUrl", "(Ljava/lang/String;)V", "Ljava/lang/Long;", "getCreatedDate", "setCreatedDate", "(Ljava/lang/Long;)V", "getIconUrl", "setIconUrl", "getLogoUrl", "setLogoUrl", "getPocketId", "setPocketId", "getPocketStatus", "setPocketStatus", "getPocketType", "setPocketType", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class InsuranceResult extends BaseRpcResult {
    private String backgroundUrl;
    private Long createdDate;
    private String iconUrl;
    private String logoUrl;
    private String pocketId;
    private String pocketStatus;
    private String pocketType;

    public InsuranceResult() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ InsuranceResult copy$default(InsuranceResult insuranceResult, String str, Long l, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = insuranceResult.backgroundUrl;
        }
        if ((i & 2) != 0) {
            l = insuranceResult.createdDate;
        }
        Long l2 = l;
        if ((i & 4) != 0) {
            str2 = insuranceResult.iconUrl;
        }
        String str7 = str2;
        if ((i & 8) != 0) {
            str3 = insuranceResult.logoUrl;
        }
        String str8 = str3;
        if ((i & 16) != 0) {
            str4 = insuranceResult.pocketId;
        }
        String str9 = str4;
        if ((i & 32) != 0) {
            str5 = insuranceResult.pocketStatus;
        }
        String str10 = str5;
        if ((i & 64) != 0) {
            str6 = insuranceResult.pocketType;
        }
        return insuranceResult.copy(str, l2, str7, str8, str9, str10, str6);
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

    public final InsuranceResult copy(String backgroundUrl, Long createdDate, String iconUrl, String logoUrl, String pocketId, String pocketStatus, String pocketType) {
        Intrinsics.checkNotNullParameter(backgroundUrl, "");
        Intrinsics.checkNotNullParameter(iconUrl, "");
        Intrinsics.checkNotNullParameter(logoUrl, "");
        Intrinsics.checkNotNullParameter(pocketId, "");
        Intrinsics.checkNotNullParameter(pocketStatus, "");
        Intrinsics.checkNotNullParameter(pocketType, "");
        return new InsuranceResult(backgroundUrl, createdDate, iconUrl, logoUrl, pocketId, pocketStatus, pocketType);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof InsuranceResult) {
            InsuranceResult insuranceResult = (InsuranceResult) other;
            return Intrinsics.areEqual(this.backgroundUrl, insuranceResult.backgroundUrl) && Intrinsics.areEqual(this.createdDate, insuranceResult.createdDate) && Intrinsics.areEqual(this.iconUrl, insuranceResult.iconUrl) && Intrinsics.areEqual(this.logoUrl, insuranceResult.logoUrl) && Intrinsics.areEqual(this.pocketId, insuranceResult.pocketId) && Intrinsics.areEqual(this.pocketStatus, insuranceResult.pocketStatus) && Intrinsics.areEqual(this.pocketType, insuranceResult.pocketType);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.backgroundUrl.hashCode();
        Long l = this.createdDate;
        return (((((((((((hashCode * 31) + (l == null ? 0 : l.hashCode())) * 31) + this.iconUrl.hashCode()) * 31) + this.logoUrl.hashCode()) * 31) + this.pocketId.hashCode()) * 31) + this.pocketStatus.hashCode()) * 31) + this.pocketType.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InsuranceResult(backgroundUrl=");
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
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getBackgroundUrl")
    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    @JvmName(name = "setBackgroundUrl")
    public final void setBackgroundUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.backgroundUrl = str;
    }

    public /* synthetic */ InsuranceResult(String str, Long l, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? -1L : l, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5, (i & 64) != 0 ? "" : str6);
    }

    @JvmName(name = "getCreatedDate")
    public final Long getCreatedDate() {
        return this.createdDate;
    }

    @JvmName(name = "setCreatedDate")
    public final void setCreatedDate(Long l) {
        this.createdDate = l;
    }

    @JvmName(name = "getIconUrl")
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @JvmName(name = "setIconUrl")
    public final void setIconUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.iconUrl = str;
    }

    @JvmName(name = "getLogoUrl")
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @JvmName(name = "setLogoUrl")
    public final void setLogoUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.logoUrl = str;
    }

    @JvmName(name = "getPocketId")
    public final String getPocketId() {
        return this.pocketId;
    }

    @JvmName(name = "setPocketId")
    public final void setPocketId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.pocketId = str;
    }

    @JvmName(name = "getPocketStatus")
    public final String getPocketStatus() {
        return this.pocketStatus;
    }

    @JvmName(name = "setPocketStatus")
    public final void setPocketStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.pocketStatus = str;
    }

    @JvmName(name = "getPocketType")
    public final String getPocketType() {
        return this.pocketType;
    }

    @JvmName(name = "setPocketType")
    public final void setPocketType(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.pocketType = str;
    }

    public InsuranceResult(String str, Long l, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.backgroundUrl = str;
        this.createdDate = l;
        this.iconUrl = str2;
        this.logoUrl = str3;
        this.pocketId = str4;
        this.pocketStatus = str5;
        this.pocketType = str6;
    }
}
