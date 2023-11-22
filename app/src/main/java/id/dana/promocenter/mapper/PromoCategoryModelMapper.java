package id.dana.promocenter.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.promocenter.model.CategoryPromo;
import id.dana.promocenter.model.PromoResultModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class PromoCategoryModelMapper extends BaseMapper<CategoryPromo, PromoResultModel> {
    PromoAdsModelMapper PlaceComponentResult;

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ PromoResultModel map(CategoryPromo categoryPromo) {
        CategoryPromo categoryPromo2 = categoryPromo;
        if (categoryPromo2 != null) {
            PromoResultModel promoResultModel = new PromoResultModel();
            promoResultModel.KClassImpl$Data$declaredNonStaticMembers$2 = PromoAdsModelMapper.getAuthRequestContext(categoryPromo2.getPromoList());
            promoResultModel.PlaceComponentResult = categoryPromo2.isHasMore();
            return promoResultModel;
        }
        return null;
    }

    @Inject
    public PromoCategoryModelMapper(PromoAdsModelMapper promoAdsModelMapper) {
        this.PlaceComponentResult = promoAdsModelMapper;
    }
}
