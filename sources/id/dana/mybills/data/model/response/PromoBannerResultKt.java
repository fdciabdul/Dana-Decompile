package id.dana.mybills.data.model.response;

import id.dana.mybills.domain.model.PromoBannerInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/data/model/response/PromoBannerResult;", "Lid/dana/mybills/domain/model/PromoBannerInfo;", "toPromoBannerInfo", "(Lid/dana/mybills/data/model/response/PromoBannerResult;)Lid/dana/mybills/domain/model/PromoBannerInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoBannerResultKt {
    public static final PromoBannerInfo toPromoBannerInfo(PromoBannerResult promoBannerResult) {
        Intrinsics.checkNotNullParameter(promoBannerResult, "");
        return new PromoBannerInfo(promoBannerResult.getContentName(), promoBannerResult.getContentType(), promoBannerResult.getValue());
    }
}
