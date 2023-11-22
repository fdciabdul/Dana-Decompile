package id.dana.cashier.data.repository.source.network.result;

import com.alibaba.griver.core.GriverParams;
import com.google.gson.annotations.SerializedName;
import id.dana.network.base.BaseRpcResultAphome;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b&\u0010'J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJX\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0007R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010\u0007R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b!\u0010\u0007R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b\"\u0010\u0007R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b#\u0010\u0007R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b%\u0010\r"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/FetchBannerInfoResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "component1", "()Ljava/lang/Integer;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "", "component6", "()Ljava/lang/Boolean;", "bannerId", "bannerName", "bannerType", "bizRuleType", GriverParams.ShareParams.IMAGE_URL, "showBanner", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lid/dana/cashier/data/repository/source/network/result/FetchBannerInfoResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/Integer;", "getBannerId", "Ljava/lang/String;", "getBannerName", "getBannerType", "getBizRuleType", "getImageUrl", "Ljava/lang/Boolean;", "getShowBanner", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class FetchBannerInfoResult extends BaseRpcResultAphome {
    @SerializedName("bannerId")
    private final Integer bannerId;
    private final String bannerName;
    private final String bannerType;
    private final String bizRuleType;
    private final String imageUrl;
    private final Boolean showBanner;

    public static /* synthetic */ FetchBannerInfoResult copy$default(FetchBannerInfoResult fetchBannerInfoResult, Integer num, String str, String str2, String str3, String str4, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            num = fetchBannerInfoResult.bannerId;
        }
        if ((i & 2) != 0) {
            str = fetchBannerInfoResult.bannerName;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = fetchBannerInfoResult.bannerType;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = fetchBannerInfoResult.bizRuleType;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = fetchBannerInfoResult.imageUrl;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            bool = fetchBannerInfoResult.showBanner;
        }
        return fetchBannerInfoResult.copy(num, str5, str6, str7, str8, bool);
    }

    /* renamed from: component1  reason: from getter */
    public final Integer getBannerId() {
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

    /* renamed from: component5  reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* renamed from: component6  reason: from getter */
    public final Boolean getShowBanner() {
        return this.showBanner;
    }

    public final FetchBannerInfoResult copy(Integer bannerId, String bannerName, String bannerType, String bizRuleType, String imageUrl, Boolean showBanner) {
        return new FetchBannerInfoResult(bannerId, bannerName, bannerType, bizRuleType, imageUrl, showBanner);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof FetchBannerInfoResult) {
            FetchBannerInfoResult fetchBannerInfoResult = (FetchBannerInfoResult) other;
            return Intrinsics.areEqual(this.bannerId, fetchBannerInfoResult.bannerId) && Intrinsics.areEqual(this.bannerName, fetchBannerInfoResult.bannerName) && Intrinsics.areEqual(this.bannerType, fetchBannerInfoResult.bannerType) && Intrinsics.areEqual(this.bizRuleType, fetchBannerInfoResult.bizRuleType) && Intrinsics.areEqual(this.imageUrl, fetchBannerInfoResult.imageUrl) && Intrinsics.areEqual(this.showBanner, fetchBannerInfoResult.showBanner);
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.bannerId;
        int hashCode = num == null ? 0 : num.hashCode();
        String str = this.bannerName;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.bannerType;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.bizRuleType;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.imageUrl;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        Boolean bool = this.showBanner;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FetchBannerInfoResult(bannerId=");
        sb.append(this.bannerId);
        sb.append(", bannerName=");
        sb.append(this.bannerName);
        sb.append(", bannerType=");
        sb.append(this.bannerType);
        sb.append(", bizRuleType=");
        sb.append(this.bizRuleType);
        sb.append(", imageUrl=");
        sb.append(this.imageUrl);
        sb.append(", showBanner=");
        sb.append(this.showBanner);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getBannerId")
    public final Integer getBannerId() {
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

    @JvmName(name = "getImageUrl")
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @JvmName(name = "getShowBanner")
    public final Boolean getShowBanner() {
        return this.showBanner;
    }

    public FetchBannerInfoResult(Integer num, String str, String str2, String str3, String str4, Boolean bool) {
        this.bannerId = num;
        this.bannerName = str;
        this.bannerType = str2;
        this.bizRuleType = str3;
        this.imageUrl = str4;
        this.showBanner = bool;
    }
}
