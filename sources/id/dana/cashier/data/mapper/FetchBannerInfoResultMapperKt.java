package id.dana.cashier.data.mapper;

import id.dana.cashier.data.repository.source.network.result.CashierBannerEntityResponse;
import id.dana.cashier.data.repository.source.network.result.FetchBannerInfoResult;
import id.dana.cashier.domain.model.FetchBannerInfo;
import id.dana.data.banner.repository.source.network.response.BannerDetailEntityResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0005"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/CashierBannerEntityResponse;", "Lid/dana/cashier/domain/model/FetchBannerInfo;", "toFetchBannerInfo", "(Lid/dana/cashier/data/repository/source/network/result/CashierBannerEntityResponse;)Lid/dana/cashier/domain/model/FetchBannerInfo;", "Lid/dana/cashier/data/repository/source/network/result/FetchBannerInfoResult;", "(Lid/dana/cashier/data/repository/source/network/result/FetchBannerInfoResult;)Lid/dana/cashier/domain/model/FetchBannerInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FetchBannerInfoResultMapperKt {
    public static final FetchBannerInfo toFetchBannerInfo(FetchBannerInfoResult fetchBannerInfoResult) {
        Intrinsics.checkNotNullParameter(fetchBannerInfoResult, "");
        String valueOf = String.valueOf(fetchBannerInfoResult.getBannerId());
        String bannerName = fetchBannerInfoResult.getBannerName();
        String bannerType = fetchBannerInfoResult.getBannerType();
        String bizRuleType = fetchBannerInfoResult.getBizRuleType();
        Map<String, String> map = fetchBannerInfoResult.extendInfo;
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        return new FetchBannerInfo(valueOf, bannerName, bannerType, bizRuleType, map, fetchBannerInfoResult.getImageUrl(), fetchBannerInfoResult.getShowBanner(), null, "CDP", 128, null);
    }

    public static final FetchBannerInfo toFetchBannerInfo(CashierBannerEntityResponse cashierBannerEntityResponse) {
        Intrinsics.checkNotNullParameter(cashierBannerEntityResponse, "");
        BannerDetailEntityResponse banner = cashierBannerEntityResponse.getBanner();
        if (banner != null) {
            String bannerId = banner.getBannerId();
            String str = bannerId == null ? "" : bannerId;
            String bannerName = banner.getBannerName();
            String str2 = bannerName == null ? "" : bannerName;
            String imageBannerUrl = banner.getImageBannerUrl();
            String str3 = imageBannerUrl == null ? "" : imageBannerUrl;
            String redirectUrl = banner.getRedirectUrl();
            String str4 = redirectUrl == null ? "" : redirectUrl;
            String placement = banner.getPlacement();
            return new FetchBannerInfo(str, str2, placement == null ? "" : placement, null, MapsKt.emptyMap(), str3, Boolean.TRUE, str4, FetchBannerInfo.BANNER_SOURCE_BANNER_MANAGEMENT);
        }
        return FetchBannerInfo.INSTANCE.createEmptyBanner();
    }
}
