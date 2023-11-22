package id.dana.data.promocenter.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.promocenter.repository.source.network.model.CategorizedPromo;
import id.dana.data.promocenter.repository.source.network.result.PromoCenterCategorizedResult;
import id.dana.domain.promocenter.model.CategoryPromo;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class CategorizedPromoEntityMapper extends BaseMapper<PromoCenterCategorizedResult, CategoryPromo> {
    @Inject
    public CategorizedPromoEntityMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public CategoryPromo map(PromoCenterCategorizedResult promoCenterCategorizedResult) {
        CategoryPromo categoryPromo = new CategoryPromo();
        if (promoCenterCategorizedResult != null && !promoCenterCategorizedResult.getListOfCategorizedPromo().isEmpty()) {
            CategorizedPromo categorizedPromo = promoCenterCategorizedResult.getListOfCategorizedPromo().get(0);
            categoryPromo.setHasMore(categorizedPromo.isHasMore());
            categoryPromo.setPromoList(PromoResultMapperKt.toPromos(categorizedPromo.getListOfPromo()));
            categoryPromo.setId(categorizedPromo.getCategoryId());
        }
        return categoryPromo;
    }
}
