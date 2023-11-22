package id.dana.cashier.data.repository.source.network.result;

import id.dana.data.banner.repository.source.network.response.BannerDetailEntityResponse;
import id.dana.network.base.BaseRpcResultAphome;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/CashierBannerEntityResponse;", "Lid/dana/network/base/BaseRpcResultAphome;", "Lid/dana/data/banner/repository/source/network/response/BannerDetailEntityResponse;", "banner", "Lid/dana/data/banner/repository/source/network/response/BannerDetailEntityResponse;", "getBanner", "()Lid/dana/data/banner/repository/source/network/response/BannerDetailEntityResponse;", "", "placement", "Ljava/lang/String;", "getPlacement", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Lid/dana/data/banner/repository/source/network/response/BannerDetailEntityResponse;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierBannerEntityResponse extends BaseRpcResultAphome {
    private final BannerDetailEntityResponse banner;
    private final String placement;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.data.banner.repository.source.network.response.BannerDetailEntityResponse, kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CashierBannerEntityResponse() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.data.repository.source.network.result.CashierBannerEntityResponse.<init>():void");
    }

    public /* synthetic */ CashierBannerEntityResponse(String str, BannerDetailEntityResponse bannerDetailEntityResponse, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bannerDetailEntityResponse);
    }

    @JvmName(name = "getPlacement")
    public final String getPlacement() {
        return this.placement;
    }

    @JvmName(name = "getBanner")
    public final BannerDetailEntityResponse getBanner() {
        return this.banner;
    }

    public CashierBannerEntityResponse(String str, BannerDetailEntityResponse bannerDetailEntityResponse) {
        this.placement = str;
        this.banner = bannerDetailEntityResponse;
    }
}
