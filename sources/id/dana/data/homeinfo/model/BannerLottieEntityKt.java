package id.dana.data.homeinfo.model;

import id.dana.domain.homeinfo.BannerLottie;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/homeinfo/model/BannerLottieEntity;", "Lid/dana/domain/homeinfo/BannerLottie;", "toBannerLottie", "(Lid/dana/data/homeinfo/model/BannerLottieEntity;)Lid/dana/domain/homeinfo/BannerLottie;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BannerLottieEntityKt {
    public static final BannerLottie toBannerLottie(BannerLottieEntity bannerLottieEntity) {
        Intrinsics.checkNotNullParameter(bannerLottieEntity, "");
        return new BannerLottie(bannerLottieEntity.getEn(), bannerLottieEntity.getId());
    }
}
