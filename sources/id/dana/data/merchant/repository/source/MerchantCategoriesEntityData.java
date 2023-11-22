package id.dana.data.merchant.repository.source;

import id.dana.data.merchant.model.MerchantCategoryEntity;
import id.dana.data.merchant.model.MerchantSubcategoryEntity;
import id.dana.domain.merchant.MerchantCategoryType;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public interface MerchantCategoriesEntityData {
    Observable<Map<String, MerchantCategoryEntity>> getMerchantCategories();

    Observable<List<String>> getMerchantOrder(String str);

    Observable<Map<String, MerchantSubcategoryEntity>> getMerchantSubcategories();

    Observable<Map<String, String>> getMerchantTopups();

    Observable<Map<String, MerchantCategoryEntity>> getNewMerchantCategories();

    Observable<List<String>> getNewMerchantCategoryOrder(MerchantCategoryType merchantCategoryType);

    Observable<Map<String, MerchantSubcategoryEntity>> getNewMerchantSubCategories();
}
