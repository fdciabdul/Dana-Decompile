package id.dana.cashier.domain.model;

import com.alibaba.griver.core.GriverParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u0000 12\u00020\u0001:\u00011Bi\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0082\u0001\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0004R\u0017\u0010\u0011\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b%\u0010\u0004R\u001a\u0010\u0019\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010#\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b'\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b(\u0010\u0004R&\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b*\u0010\nR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b+\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010#\u001a\u0004\b,\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010-\u001a\u0004\b.\u0010\u000e"}, d2 = {"Lid/dana/cashier/domain/model/FetchBannerInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "", "component5", "()Ljava/util/Map;", "component6", "", "component7", "()Ljava/lang/Boolean;", "component8", "component9", "bannerId", "bannerName", "bannerType", "bizRuleType", "extendInfo", GriverParams.ShareParams.IMAGE_URL, "showBanner", "redirectUrl", "bannerSource", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/domain/model/FetchBannerInfo;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBannerId", "getBannerName", "getBannerSource", "getBannerType", "getBizRuleType", "Ljava/util/Map;", "getExtendInfo", "getImageUrl", "getRedirectUrl", "Ljava/lang/Boolean;", "getShowBanner", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class FetchBannerInfo {
    public static final String BANNER_SOURCE_BANNER_MANAGEMENT = "BANNER_MANAGEMENT";
    public static final String BANNER_SOURCE_CDP = "CDP";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTEND_KEY_CTA_BUTTON_LABEL = "ctaButtonLabel";
    private final String bannerId;
    private final String bannerName;
    private final String bannerSource;
    private final String bannerType;
    private final String bizRuleType;
    private final Map<String, String> extendInfo;
    private final String imageUrl;
    private final String redirectUrl;
    private final Boolean showBanner;

    /* renamed from: component1  reason: from getter */
    public final String getBannerId() {
        return this.bannerId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getBannerName() {
        return this.bannerName;
    }

    /* renamed from: component3  reason: from getter */
    public final String getBannerType() {
        return this.bannerType;
    }

    /* renamed from: component4  reason: from getter */
    public final String getBizRuleType() {
        return this.bizRuleType;
    }

    public final Map<String, String> component5() {
        return this.extendInfo;
    }

    /* renamed from: component6  reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* renamed from: component7  reason: from getter */
    public final Boolean getShowBanner() {
        return this.showBanner;
    }

    /* renamed from: component8  reason: from getter */
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    /* renamed from: component9  reason: from getter */
    public final String getBannerSource() {
        return this.bannerSource;
    }

    public final FetchBannerInfo copy(String bannerId, String bannerName, String bannerType, String bizRuleType, Map<String, String> extendInfo, String imageUrl, Boolean showBanner, String redirectUrl, String bannerSource) {
        Intrinsics.checkNotNullParameter(bannerId, "");
        Intrinsics.checkNotNullParameter(extendInfo, "");
        Intrinsics.checkNotNullParameter(bannerSource, "");
        return new FetchBannerInfo(bannerId, bannerName, bannerType, bizRuleType, extendInfo, imageUrl, showBanner, redirectUrl, bannerSource);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof FetchBannerInfo) {
            FetchBannerInfo fetchBannerInfo = (FetchBannerInfo) other;
            return Intrinsics.areEqual(this.bannerId, fetchBannerInfo.bannerId) && Intrinsics.areEqual(this.bannerName, fetchBannerInfo.bannerName) && Intrinsics.areEqual(this.bannerType, fetchBannerInfo.bannerType) && Intrinsics.areEqual(this.bizRuleType, fetchBannerInfo.bizRuleType) && Intrinsics.areEqual(this.extendInfo, fetchBannerInfo.extendInfo) && Intrinsics.areEqual(this.imageUrl, fetchBannerInfo.imageUrl) && Intrinsics.areEqual(this.showBanner, fetchBannerInfo.showBanner) && Intrinsics.areEqual(this.redirectUrl, fetchBannerInfo.redirectUrl) && Intrinsics.areEqual(this.bannerSource, fetchBannerInfo.bannerSource);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.bannerId.hashCode();
        String str = this.bannerName;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.bannerType;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.bizRuleType;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        int hashCode5 = this.extendInfo.hashCode();
        String str4 = this.imageUrl;
        int hashCode6 = str4 == null ? 0 : str4.hashCode();
        Boolean bool = this.showBanner;
        int hashCode7 = bool == null ? 0 : bool.hashCode();
        String str5 = this.redirectUrl;
        return (((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + (str5 != null ? str5.hashCode() : 0)) * 31) + this.bannerSource.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FetchBannerInfo(bannerId=");
        sb.append(this.bannerId);
        sb.append(", bannerName=");
        sb.append(this.bannerName);
        sb.append(", bannerType=");
        sb.append(this.bannerType);
        sb.append(", bizRuleType=");
        sb.append(this.bizRuleType);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(", imageUrl=");
        sb.append(this.imageUrl);
        sb.append(", showBanner=");
        sb.append(this.showBanner);
        sb.append(", redirectUrl=");
        sb.append(this.redirectUrl);
        sb.append(", bannerSource=");
        sb.append(this.bannerSource);
        sb.append(')');
        return sb.toString();
    }

    public FetchBannerInfo(String str, String str2, String str3, String str4, Map<String, String> map, String str5, Boolean bool, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(str7, "");
        this.bannerId = str;
        this.bannerName = str2;
        this.bannerType = str3;
        this.bizRuleType = str4;
        this.extendInfo = map;
        this.imageUrl = str5;
        this.showBanner = bool;
        this.redirectUrl = str6;
        this.bannerSource = str7;
    }

    public /* synthetic */ FetchBannerInfo(String str, String str2, String str3, String str4, Map map, String str5, Boolean bool, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, map, str5, bool, (i & 128) != 0 ? "" : str6, str7);
    }

    @JvmName(name = "getBannerId")
    public final String getBannerId() {
        return this.bannerId;
    }

    @JvmName(name = "getBannerName")
    public final String getBannerName() {
        return this.bannerName;
    }

    @JvmName(name = "getBannerType")
    public final String getBannerType() {
        return this.bannerType;
    }

    @JvmName(name = "getBizRuleType")
    public final String getBizRuleType() {
        return this.bizRuleType;
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "getImageUrl")
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @JvmName(name = "getShowBanner")
    public final Boolean getShowBanner() {
        return this.showBanner;
    }

    @JvmName(name = "getRedirectUrl")
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    @JvmName(name = "getBannerSource")
    public final String getBannerSource() {
        return this.bannerSource;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0007"}, d2 = {"Lid/dana/cashier/domain/model/FetchBannerInfo$Companion;", "", "Lid/dana/cashier/domain/model/FetchBannerInfo;", "createEmptyBanner", "()Lid/dana/cashier/domain/model/FetchBannerInfo;", "", "BANNER_SOURCE_BANNER_MANAGEMENT", "Ljava/lang/String;", "BANNER_SOURCE_CDP", "EXTEND_KEY_CTA_BUTTON_LABEL", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FetchBannerInfo createEmptyBanner() {
            return new FetchBannerInfo("", "", "", "", MapsKt.emptyMap(), "", Boolean.FALSE, "", "");
        }
    }
}
