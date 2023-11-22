package id.dana.explore.domain.globalsearch.model;

import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u0017\u0010\r\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u0018\u0010\tR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001c\u0010\u0004"}, d2 = {"Lid/dana/explore/domain/globalsearch/model/PopularPlaceInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()Z", "merchantId", "merchantName", DecodedScanBizInfoKey.LOGO_URL, "highlight", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lid/dana/explore/domain/globalsearch/model/PopularPlaceInfo;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getHighlight", "Ljava/lang/String;", "getLogoUrl", "getMerchantId", "getMerchantName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PopularPlaceInfo {
    public boolean highlight;
    public String logoUrl;
    public String merchantId;
    public String merchantName;

    public /* synthetic */ PopularPlaceInfo() {
    }

    public static /* synthetic */ PopularPlaceInfo copy$default(PopularPlaceInfo popularPlaceInfo, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = popularPlaceInfo.merchantId;
        }
        if ((i & 2) != 0) {
            str2 = popularPlaceInfo.merchantName;
        }
        if ((i & 4) != 0) {
            str3 = popularPlaceInfo.logoUrl;
        }
        if ((i & 8) != 0) {
            z = popularPlaceInfo.highlight;
        }
        return popularPlaceInfo.copy(str, str2, str3, z);
    }

    /* renamed from: component1  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMerchantName() {
        return this.merchantName;
    }

    /* renamed from: component3  reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    /* renamed from: component4  reason: from getter */
    public final boolean getHighlight() {
        return this.highlight;
    }

    public final PopularPlaceInfo copy(String merchantId, String merchantName, String logoUrl, boolean highlight) {
        Intrinsics.checkNotNullParameter(merchantId, "");
        Intrinsics.checkNotNullParameter(merchantName, "");
        Intrinsics.checkNotNullParameter(logoUrl, "");
        return new PopularPlaceInfo(merchantId, merchantName, logoUrl, highlight);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PopularPlaceInfo) {
            PopularPlaceInfo popularPlaceInfo = (PopularPlaceInfo) other;
            return Intrinsics.areEqual(this.merchantId, popularPlaceInfo.merchantId) && Intrinsics.areEqual(this.merchantName, popularPlaceInfo.merchantName) && Intrinsics.areEqual(this.logoUrl, popularPlaceInfo.logoUrl) && this.highlight == popularPlaceInfo.highlight;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.merchantId.hashCode();
        int hashCode2 = this.merchantName.hashCode();
        int hashCode3 = this.logoUrl.hashCode();
        boolean z = this.highlight;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PopularPlaceInfo(merchantId=");
        sb.append(this.merchantId);
        sb.append(", merchantName=");
        sb.append(this.merchantName);
        sb.append(", logoUrl=");
        sb.append(this.logoUrl);
        sb.append(", highlight=");
        sb.append(this.highlight);
        sb.append(')');
        return sb.toString();
    }

    public PopularPlaceInfo(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.merchantId = str;
        this.merchantName = str2;
        this.logoUrl = str3;
        this.highlight = z;
    }

    public /* synthetic */ PopularPlaceInfo(String str, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? false : z);
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "getMerchantName")
    public final String getMerchantName() {
        return this.merchantName;
    }

    @JvmName(name = "getLogoUrl")
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @JvmName(name = "getHighlight")
    public final boolean getHighlight() {
        return this.highlight;
    }
}
