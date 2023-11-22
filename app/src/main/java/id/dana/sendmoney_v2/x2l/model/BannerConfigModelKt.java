package id.dana.sendmoney_v2.x2l.model;

import id.dana.domain.sendmoney.x2l.model.BannerConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/sendmoney/x2l/model/BannerConfig;", "Lid/dana/sendmoney_v2/x2l/model/BannerConfigModel;", "PlaceComponentResult", "(Lid/dana/domain/sendmoney/x2l/model/BannerConfig;)Lid/dana/sendmoney_v2/x2l/model/BannerConfigModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BannerConfigModelKt {
    public static final BannerConfigModel PlaceComponentResult(BannerConfig bannerConfig) {
        Intrinsics.checkNotNullParameter(bannerConfig, "");
        return new BannerConfigModel(bannerConfig.getTitle(), bannerConfig.getSubtitle(), bannerConfig.getImage());
    }
}
