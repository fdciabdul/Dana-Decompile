package id.dana.domain.merchant;

import id.dana.domain.merchant.model.MerchantCategory;
import id.dana.domain.merchant.model.MerchantSubcategory;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes2.dex */
public interface MerchantCategoriesRepository {
    Observable<List<MerchantCategory>> getMerchantCategories();

    Observable<List<MerchantSubcategory>> getMerchantSubcategories();

    Observable<List<MerchantCategory>> getNewMerchantCategories(MerchantCategoryType merchantCategoryType);

    Observable<List<MerchantSubcategory>> getNewMerchantSubCategories();

    Observable<Boolean> initMerchantCategoriesV2();
}
