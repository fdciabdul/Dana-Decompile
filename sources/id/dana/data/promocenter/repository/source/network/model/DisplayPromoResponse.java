package id.dana.data.promocenter.repository.source.network.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b5\u00106J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0012\u0010\tJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0080\u0001\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00072\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b%\u0010\u0011J\u0010\u0010&\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b&\u0010\u0004R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u001d\u0010'\u001a\u0004\b(\u0010\u0004R\u001a\u0010\u0019\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010'\u001a\u0004\b*\u0010\u0004R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b,\u0010\rR\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b-\u0010\u0004R\u001a\u0010\u0017\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010.\u001a\u0004\b/\u0010\tR\u001a\u0010\u001b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010.\u001a\u0004\b0\u0010\tR\u001a\u0010\u0016\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010'\u001a\u0004\b1\u0010\u0004R\u001a\u0010\u001a\u001a\u00020\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00102\u001a\u0004\b3\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010'\u001a\u0004\b4\u0010\u0004"}, d2 = {"Lid/dana/data/promocenter/repository/source/network/model/DisplayPromoResponse;", "", "", "component1", "()Ljava/lang/String;", "component10", "component2", "", "component3", "()J", "", "Lid/dana/data/promocenter/repository/source/network/model/CallToActionDTO;", "component4", "()Ljava/util/List;", "component5", "", "component6", "()I", "component7", "component8", "component9", "promoContentId", "promoName", "promoEndDate", "promoCallToActions", "promoBannerImageUrl", "promoPriority", "promoIndexId", "promoBannerVerticalImageUrl", "merchantType", "promoTncId", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/util/List;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/promocenter/repository/source/network/model/DisplayPromoResponse;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getMerchantType", "getPromoBannerImageUrl", "getPromoBannerVerticalImageUrl", "Ljava/util/List;", "getPromoCallToActions", "getPromoContentId", "J", "getPromoEndDate", "getPromoIndexId", "getPromoName", "I", "getPromoPriority", "getPromoTncId", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/util/List;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class DisplayPromoResponse {
    private final String merchantType;
    private final String promoBannerImageUrl;
    private final String promoBannerVerticalImageUrl;
    private final List<CallToActionDTO> promoCallToActions;
    private final String promoContentId;
    private final long promoEndDate;
    private final long promoIndexId;
    private final String promoName;
    private final int promoPriority;
    private final String promoTncId;

    public DisplayPromoResponse() {
        this(null, null, 0L, null, null, 0, 0L, null, null, null, 1023, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getPromoContentId() {
        return this.promoContentId;
    }

    /* renamed from: component10  reason: from getter */
    public final String getPromoTncId() {
        return this.promoTncId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getPromoName() {
        return this.promoName;
    }

    /* renamed from: component3  reason: from getter */
    public final long getPromoEndDate() {
        return this.promoEndDate;
    }

    public final List<CallToActionDTO> component4() {
        return this.promoCallToActions;
    }

    /* renamed from: component5  reason: from getter */
    public final String getPromoBannerImageUrl() {
        return this.promoBannerImageUrl;
    }

    /* renamed from: component6  reason: from getter */
    public final int getPromoPriority() {
        return this.promoPriority;
    }

    /* renamed from: component7  reason: from getter */
    public final long getPromoIndexId() {
        return this.promoIndexId;
    }

    /* renamed from: component8  reason: from getter */
    public final String getPromoBannerVerticalImageUrl() {
        return this.promoBannerVerticalImageUrl;
    }

    /* renamed from: component9  reason: from getter */
    public final String getMerchantType() {
        return this.merchantType;
    }

    public final DisplayPromoResponse copy(String promoContentId, String promoName, long promoEndDate, List<? extends CallToActionDTO> promoCallToActions, String promoBannerImageUrl, int promoPriority, long promoIndexId, String promoBannerVerticalImageUrl, String merchantType, String promoTncId) {
        Intrinsics.checkNotNullParameter(promoContentId, "");
        Intrinsics.checkNotNullParameter(promoName, "");
        Intrinsics.checkNotNullParameter(promoBannerImageUrl, "");
        Intrinsics.checkNotNullParameter(promoTncId, "");
        return new DisplayPromoResponse(promoContentId, promoName, promoEndDate, promoCallToActions, promoBannerImageUrl, promoPriority, promoIndexId, promoBannerVerticalImageUrl, merchantType, promoTncId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DisplayPromoResponse) {
            DisplayPromoResponse displayPromoResponse = (DisplayPromoResponse) other;
            return Intrinsics.areEqual(this.promoContentId, displayPromoResponse.promoContentId) && Intrinsics.areEqual(this.promoName, displayPromoResponse.promoName) && this.promoEndDate == displayPromoResponse.promoEndDate && Intrinsics.areEqual(this.promoCallToActions, displayPromoResponse.promoCallToActions) && Intrinsics.areEqual(this.promoBannerImageUrl, displayPromoResponse.promoBannerImageUrl) && this.promoPriority == displayPromoResponse.promoPriority && this.promoIndexId == displayPromoResponse.promoIndexId && Intrinsics.areEqual(this.promoBannerVerticalImageUrl, displayPromoResponse.promoBannerVerticalImageUrl) && Intrinsics.areEqual(this.merchantType, displayPromoResponse.merchantType) && Intrinsics.areEqual(this.promoTncId, displayPromoResponse.promoTncId);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.promoContentId.hashCode();
        int hashCode2 = this.promoName.hashCode();
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.promoEndDate);
        List<CallToActionDTO> list = this.promoCallToActions;
        int hashCode3 = list == null ? 0 : list.hashCode();
        int hashCode4 = this.promoBannerImageUrl.hashCode();
        int i = this.promoPriority;
        int m2 = Cbor$Arg$$ExternalSyntheticBackport0.m(this.promoIndexId);
        String str = this.promoBannerVerticalImageUrl;
        int hashCode5 = str == null ? 0 : str.hashCode();
        String str2 = this.merchantType;
        return (((((((((((((((((hashCode * 31) + hashCode2) * 31) + m) * 31) + hashCode3) * 31) + hashCode4) * 31) + i) * 31) + m2) * 31) + hashCode5) * 31) + (str2 != null ? str2.hashCode() : 0)) * 31) + this.promoTncId.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DisplayPromoResponse(promoContentId=");
        sb.append(this.promoContentId);
        sb.append(", promoName=");
        sb.append(this.promoName);
        sb.append(", promoEndDate=");
        sb.append(this.promoEndDate);
        sb.append(", promoCallToActions=");
        sb.append(this.promoCallToActions);
        sb.append(", promoBannerImageUrl=");
        sb.append(this.promoBannerImageUrl);
        sb.append(", promoPriority=");
        sb.append(this.promoPriority);
        sb.append(", promoIndexId=");
        sb.append(this.promoIndexId);
        sb.append(", promoBannerVerticalImageUrl=");
        sb.append(this.promoBannerVerticalImageUrl);
        sb.append(", merchantType=");
        sb.append(this.merchantType);
        sb.append(", promoTncId=");
        sb.append(this.promoTncId);
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DisplayPromoResponse(String str, String str2, long j, List<? extends CallToActionDTO> list, String str3, int i, long j2, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.promoContentId = str;
        this.promoName = str2;
        this.promoEndDate = j;
        this.promoCallToActions = list;
        this.promoBannerImageUrl = str3;
        this.promoPriority = i;
        this.promoIndexId = j2;
        this.promoBannerVerticalImageUrl = str4;
        this.merchantType = str5;
        this.promoTncId = str6;
    }

    @JvmName(name = "getPromoContentId")
    public final String getPromoContentId() {
        return this.promoContentId;
    }

    @JvmName(name = "getPromoName")
    public final String getPromoName() {
        return this.promoName;
    }

    @JvmName(name = "getPromoEndDate")
    public final long getPromoEndDate() {
        return this.promoEndDate;
    }

    public /* synthetic */ DisplayPromoResponse(String str, String str2, long j, List list, String str3, int i, long j2, String str4, String str5, String str6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0L : j, (i2 & 8) != 0 ? CollectionsKt.emptyList() : list, (i2 & 16) != 0 ? "" : str3, (i2 & 32) != 0 ? 0 : i, (i2 & 64) == 0 ? j2 : 0L, (i2 & 128) != 0 ? "" : str4, (i2 & 256) != 0 ? "" : str5, (i2 & 512) == 0 ? str6 : "");
    }

    @JvmName(name = "getPromoCallToActions")
    public final List<CallToActionDTO> getPromoCallToActions() {
        return this.promoCallToActions;
    }

    @JvmName(name = "getPromoBannerImageUrl")
    public final String getPromoBannerImageUrl() {
        return this.promoBannerImageUrl;
    }

    @JvmName(name = "getPromoPriority")
    public final int getPromoPriority() {
        return this.promoPriority;
    }

    @JvmName(name = "getPromoIndexId")
    public final long getPromoIndexId() {
        return this.promoIndexId;
    }

    @JvmName(name = "getPromoBannerVerticalImageUrl")
    public final String getPromoBannerVerticalImageUrl() {
        return this.promoBannerVerticalImageUrl;
    }

    @JvmName(name = "getMerchantType")
    public final String getMerchantType() {
        return this.merchantType;
    }

    @JvmName(name = "getPromoTncId")
    public final String getPromoTncId() {
        return this.promoTncId;
    }
}
