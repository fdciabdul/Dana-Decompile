package id.dana.data.sendmoney.x2l.model;

import id.dana.domain.sendmoney.x2l.model.BannerConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/sendmoney/x2l/model/BannerConfigEntity;", "Lid/dana/domain/sendmoney/x2l/model/BannerConfig;", "toBannerConfig", "(Lid/dana/data/sendmoney/x2l/model/BannerConfigEntity;)Lid/dana/domain/sendmoney/x2l/model/BannerConfig;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BannerConfigEntityKt {
    public static final BannerConfig toBannerConfig(BannerConfigEntity bannerConfigEntity) {
        Intrinsics.checkNotNullParameter(bannerConfigEntity, "");
        String title = bannerConfigEntity.getTitle();
        if (title == null) {
            title = "";
        }
        String subtitle = bannerConfigEntity.getSubtitle();
        if (subtitle == null) {
            subtitle = "";
        }
        String image = bannerConfigEntity.getImage();
        return new BannerConfig(title, subtitle, image != null ? image : "");
    }
}
