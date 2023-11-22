package id.dana.domain.wallet_v3.model;

import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0017\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001c\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\b"}, d2 = {"Lid/dana/domain/wallet_v3/model/InsuranceAsset;", "", "", "backgroundUrl", "Ljava/lang/String;", "getBackgroundUrl", "()Ljava/lang/String;", "setBackgroundUrl", "(Ljava/lang/String;)V", "", "createdDate", "Ljava/lang/Long;", "getCreatedDate", "()Ljava/lang/Long;", "setCreatedDate", "(Ljava/lang/Long;)V", "iconUrl", "getIconUrl", "setIconUrl", DecodedScanBizInfoKey.LOGO_URL, "getLogoUrl", "setLogoUrl", "pocketId", "getPocketId", "setPocketId", "pocketStatus", "getPocketStatus", "setPocketStatus", "pocketType", "getPocketType", "setPocketType", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InsuranceAsset {
    private String backgroundUrl;
    private Long createdDate;
    private String iconUrl;
    private String logoUrl;
    private String pocketId;
    private String pocketStatus;
    private String pocketType;

    public InsuranceAsset() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public InsuranceAsset(String str, Long l, String str2, String str3, String str4, String str5, String str6) {
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

    public /* synthetic */ InsuranceAsset(String str, Long l, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5, (i & 64) != 0 ? "" : str6);
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
}
