package id.dana.data.promocenter.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.promocenter.repository.source.network.model.DisplayCategory;
import id.dana.data.promocenter.repository.source.network.result.PromoCenterCategoryResult;
import id.dana.domain.promocenter.model.PromoCategory;
import id.dana.domain.promocenter.model.PromoCategoryInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class CategoryEntityMapper extends BaseMapper<PromoCenterCategoryResult, PromoCategoryInfo> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public CategoryEntityMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public PromoCategoryInfo map(PromoCenterCategoryResult promoCenterCategoryResult) {
        PromoCategoryInfo promoCategoryInfo = new PromoCategoryInfo();
        if (promoCenterCategoryResult != null) {
            promoCategoryInfo.setTotalCategory(promoCenterCategoryResult.getTotalCount());
            promoCategoryInfo.setPromoCategories(map(promoCenterCategoryResult.getListOfCategory()));
        }
        return promoCategoryInfo;
    }

    private List<PromoCategory> map(List<DisplayCategory> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<DisplayCategory> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(map(it.next()));
            }
        }
        return arrayList;
    }

    private PromoCategory map(DisplayCategory displayCategory) {
        PromoCategory promoCategory = new PromoCategory();
        promoCategory.setCategoryId(displayCategory.getCategoryId());
        promoCategory.setCategoryName(displayCategory.getCategoryName());
        promoCategory.setCategoryFilter(displayCategory.getCategoryFilter());
        promoCategory.setCategorySorting(displayCategory.getCategorySorting());
        return promoCategory;
    }
}
