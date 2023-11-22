package id.dana.data.promotion.repository;

import id.dana.data.banner.repository.source.network.response.BannerListEntityResponse;
import id.dana.data.content.mapper.BannerListEntityMapper;
import io.reactivex.functions.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class PromotionEntityRepository$$ExternalSyntheticLambda12 implements Function {
    public final /* synthetic */ BannerListEntityMapper f$0;

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return this.f$0.transformToBannerListEntity((BannerListEntityResponse) obj);
    }
}
