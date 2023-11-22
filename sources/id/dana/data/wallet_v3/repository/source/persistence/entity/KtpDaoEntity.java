package id.dana.data.wallet_v3.repository.source.persistence.entity;

import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u001e\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0080\u0001\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010\u0004R\u0017\u0010\u0014\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b%\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010$\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b(\u0010\nR(\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010)\u001a\u0004\b*\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b+\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010$\u001a\u0004\b,\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b-\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b.\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b/\u0010\u0004"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/persistence/entity/KtpDaoEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "", "component5", "()Ljava/lang/Long;", "component6", "component7", "", "component8", "()Ljava/util/Map;", "component9", "pocketId", "pocketStatus", "pocketType", "backgroundUrl", "createdDate", "iconUrl", DecodedScanBizInfoKey.LOGO_URL, "extendInfo", "cardTitle", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)Lid/dana/data/wallet_v3/repository/source/persistence/entity/KtpDaoEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBackgroundUrl", "getCardTitle", "Ljava/lang/Long;", "getCreatedDate", "Ljava/util/Map;", "getExtendInfo", "getIconUrl", "getLogoUrl", "getPocketId", "getPocketStatus", "getPocketType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class KtpDaoEntity {
    private final String backgroundUrl;
    private final String cardTitle;
    private final Long createdDate;
    private final Map<String, String> extendInfo;
    private final String iconUrl;
    private final String logoUrl;
    private final String pocketId;
    private final String pocketStatus;
    private final String pocketType;

    /* renamed from: component1  reason: from getter */
    public final String getPocketId() {
        return this.pocketId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getPocketStatus() {
        return this.pocketStatus;
    }

    /* renamed from: component3  reason: from getter */
    public final String getPocketType() {
        return this.pocketType;
    }

    /* renamed from: component4  reason: from getter */
    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    /* renamed from: component5  reason: from getter */
    public final Long getCreatedDate() {
        return this.createdDate;
    }

    /* renamed from: component6  reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component7  reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final Map<String, String> component8() {
        return this.extendInfo;
    }

    /* renamed from: component9  reason: from getter */
    public final String getCardTitle() {
        return this.cardTitle;
    }

    public final KtpDaoEntity copy(String pocketId, String pocketStatus, String pocketType, String backgroundUrl, Long createdDate, String iconUrl, String logoUrl, Map<String, String> extendInfo, String cardTitle) {
        Intrinsics.checkNotNullParameter(pocketId, "");
        Intrinsics.checkNotNullParameter(pocketStatus, "");
        Intrinsics.checkNotNullParameter(pocketType, "");
        Intrinsics.checkNotNullParameter(backgroundUrl, "");
        return new KtpDaoEntity(pocketId, pocketStatus, pocketType, backgroundUrl, createdDate, iconUrl, logoUrl, extendInfo, cardTitle);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof KtpDaoEntity) {
            KtpDaoEntity ktpDaoEntity = (KtpDaoEntity) other;
            return Intrinsics.areEqual(this.pocketId, ktpDaoEntity.pocketId) && Intrinsics.areEqual(this.pocketStatus, ktpDaoEntity.pocketStatus) && Intrinsics.areEqual(this.pocketType, ktpDaoEntity.pocketType) && Intrinsics.areEqual(this.backgroundUrl, ktpDaoEntity.backgroundUrl) && Intrinsics.areEqual(this.createdDate, ktpDaoEntity.createdDate) && Intrinsics.areEqual(this.iconUrl, ktpDaoEntity.iconUrl) && Intrinsics.areEqual(this.logoUrl, ktpDaoEntity.logoUrl) && Intrinsics.areEqual(this.extendInfo, ktpDaoEntity.extendInfo) && Intrinsics.areEqual(this.cardTitle, ktpDaoEntity.cardTitle);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.pocketId.hashCode();
        int hashCode2 = this.pocketStatus.hashCode();
        int hashCode3 = this.pocketType.hashCode();
        int hashCode4 = this.backgroundUrl.hashCode();
        Long l = this.createdDate;
        int hashCode5 = l == null ? 0 : l.hashCode();
        String str = this.iconUrl;
        int hashCode6 = str == null ? 0 : str.hashCode();
        String str2 = this.logoUrl;
        int hashCode7 = str2 == null ? 0 : str2.hashCode();
        Map<String, String> map = this.extendInfo;
        int hashCode8 = map == null ? 0 : map.hashCode();
        String str3 = this.cardTitle;
        return (((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KtpDaoEntity(pocketId=");
        sb.append(this.pocketId);
        sb.append(", pocketStatus=");
        sb.append(this.pocketStatus);
        sb.append(", pocketType=");
        sb.append(this.pocketType);
        sb.append(", backgroundUrl=");
        sb.append(this.backgroundUrl);
        sb.append(", createdDate=");
        sb.append(this.createdDate);
        sb.append(", iconUrl=");
        sb.append(this.iconUrl);
        sb.append(", logoUrl=");
        sb.append(this.logoUrl);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(", cardTitle=");
        sb.append(this.cardTitle);
        sb.append(')');
        return sb.toString();
    }

    public KtpDaoEntity(String str, String str2, String str3, String str4, Long l, String str5, String str6, Map<String, String> map, String str7) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.pocketId = str;
        this.pocketStatus = str2;
        this.pocketType = str3;
        this.backgroundUrl = str4;
        this.createdDate = l;
        this.iconUrl = str5;
        this.logoUrl = str6;
        this.extendInfo = map;
        this.cardTitle = str7;
    }

    public /* synthetic */ KtpDaoEntity(String str, String str2, String str3, String str4, Long l, String str5, String str6, Map map, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? null : l, (i & 32) != 0 ? "" : str5, (i & 64) != 0 ? "" : str6, (i & 128) == 0 ? map : null, (i & 256) == 0 ? str7 : "");
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

    @JvmName(name = "getExtendInfo")
    public final Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "getCardTitle")
    public final String getCardTitle() {
        return this.cardTitle;
    }
}
