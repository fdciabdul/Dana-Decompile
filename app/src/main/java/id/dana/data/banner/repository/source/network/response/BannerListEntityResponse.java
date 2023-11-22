package id.dana.data.banner.repository.source.network.response;

import id.dana.network.base.BaseRpcResultAphome;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/data/banner/repository/source/network/response/BannerListEntityResponse;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "Lid/dana/data/banner/repository/source/network/response/BannerDetailEntityResponse;", "banners", "Ljava/util/List;", "getBanners", "()Ljava/util/List;", "Lid/dana/data/banner/repository/source/network/response/BannerPaginatorEntityResponse;", "paginator", "Lid/dana/data/banner/repository/source/network/response/BannerPaginatorEntityResponse;", "getPaginator", "()Lid/dana/data/banner/repository/source/network/response/BannerPaginatorEntityResponse;", "", "placement", "Ljava/lang/String;", "getPlacement", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lid/dana/data/banner/repository/source/network/response/BannerPaginatorEntityResponse;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BannerListEntityResponse extends BaseRpcResultAphome {
    private final List<BannerDetailEntityResponse> banners;
    private final BannerPaginatorEntityResponse paginator;
    private final String placement;

    public BannerListEntityResponse() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ BannerListEntityResponse(String str, List list, BannerPaginatorEntityResponse bannerPaginatorEntityResponse, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : bannerPaginatorEntityResponse);
    }

    @JvmName(name = "getPlacement")
    public final String getPlacement() {
        return this.placement;
    }

    @JvmName(name = "getBanners")
    public final List<BannerDetailEntityResponse> getBanners() {
        return this.banners;
    }

    @JvmName(name = "getPaginator")
    public final BannerPaginatorEntityResponse getPaginator() {
        return this.paginator;
    }

    public BannerListEntityResponse(String str, List<BannerDetailEntityResponse> list, BannerPaginatorEntityResponse bannerPaginatorEntityResponse) {
        this.placement = str;
        this.banners = list;
        this.paginator = bannerPaginatorEntityResponse;
    }
}
