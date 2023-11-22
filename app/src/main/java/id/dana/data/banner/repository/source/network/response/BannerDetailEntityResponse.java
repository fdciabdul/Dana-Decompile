package id.dana.data.banner.repository.source.network.response;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006"}, d2 = {"Lid/dana/data/banner/repository/source/network/response/BannerDetailEntityResponse;", "", "", "bannerId", "Ljava/lang/String;", "getBannerId", "()Ljava/lang/String;", "bannerName", "getBannerName", "imageBannerUrl", "getImageBannerUrl", "", "order", "Ljava/lang/Integer;", "getOrder", "()Ljava/lang/Integer;", "placement", "getPlacement", "priority", "getPriority", "redirectUrl", "getRedirectUrl", "status", "getStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BannerDetailEntityResponse {
    private final String bannerId;
    private final String bannerName;
    private final String imageBannerUrl;
    private final Integer order;
    private final String placement;
    private final Integer priority;
    private final String redirectUrl;
    private final String status;

    public BannerDetailEntityResponse() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public BannerDetailEntityResponse(String str, String str2, String str3, String str4, String str5, String str6, Integer num, Integer num2) {
        this.bannerId = str;
        this.bannerName = str2;
        this.status = str3;
        this.placement = str4;
        this.imageBannerUrl = str5;
        this.redirectUrl = str6;
        this.priority = num;
        this.order = num2;
    }

    @JvmName(name = "getBannerId")
    public final String getBannerId() {
        return this.bannerId;
    }

    @JvmName(name = "getBannerName")
    public final String getBannerName() {
        return this.bannerName;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "getPlacement")
    public final String getPlacement() {
        return this.placement;
    }

    @JvmName(name = "getImageBannerUrl")
    public final String getImageBannerUrl() {
        return this.imageBannerUrl;
    }

    @JvmName(name = "getRedirectUrl")
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    public /* synthetic */ BannerDetailEntityResponse(String str, String str2, String str3, String str4, String str5, String str6, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) == 0 ? str6 : "", (i & 64) != 0 ? 0 : num, (i & 128) != 0 ? 0 : num2);
    }

    @JvmName(name = "getPriority")
    public final Integer getPriority() {
        return this.priority;
    }

    @JvmName(name = "getOrder")
    public final Integer getOrder() {
        return this.order;
    }
}
