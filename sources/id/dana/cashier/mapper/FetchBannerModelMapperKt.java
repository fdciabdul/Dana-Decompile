package id.dana.cashier.mapper;

import id.dana.cashier.domain.model.FetchBannerInfo;
import id.dana.cashier.model.FetchBannerModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/domain/model/FetchBannerInfo;", "Lid/dana/cashier/model/FetchBannerModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/cashier/domain/model/FetchBannerInfo;)Lid/dana/cashier/model/FetchBannerModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FetchBannerModelMapperKt {
    public static final FetchBannerModel KClassImpl$Data$declaredNonStaticMembers$2(FetchBannerInfo fetchBannerInfo) {
        Intrinsics.checkNotNullParameter(fetchBannerInfo, "");
        return new FetchBannerModel(fetchBannerInfo.getBannerId(), fetchBannerInfo.getBannerName(), fetchBannerInfo.getBannerType(), fetchBannerInfo.getBizRuleType(), fetchBannerInfo.getExtendInfo(), fetchBannerInfo.getImageUrl(), fetchBannerInfo.getShowBanner(), fetchBannerInfo.getRedirectUrl(), fetchBannerInfo.getBannerSource());
    }
}
