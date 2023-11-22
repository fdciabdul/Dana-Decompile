package id.dana.data.merchant.repository.source;

import id.dana.data.merchant.model.MerchantCategoryEntity;
import id.dana.data.merchant.model.MerchantSubcategoryEntity;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00030\u0002H&¢\u0006\u0004\b\t\u0010\u0007J#\u0010\f\u001a\u00020\u000b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H&¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000f\u001a\u00020\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003H&¢\u0006\u0004\b\u000f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/merchant/repository/source/CacheMerchantCategoriesEntityData;", "", "Lio/reactivex/Observable;", "", "", "Lid/dana/data/merchant/model/MerchantCategoryEntity;", "getCachedNewMerchantCategories", "()Lio/reactivex/Observable;", "Lid/dana/data/merchant/model/MerchantSubcategoryEntity;", "getCachedNewMerchantSubCategories", "merchantCategories", "", "saveMerchantNewCategories", "(Ljava/util/Map;)V", "merchantSubCategories", "saveMerchantNewSubCategories"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface CacheMerchantCategoriesEntityData {
    Observable<Map<String, MerchantCategoryEntity>> getCachedNewMerchantCategories();

    Observable<Map<String, MerchantSubcategoryEntity>> getCachedNewMerchantSubCategories();

    void saveMerchantNewCategories(Map<String, ? extends MerchantCategoryEntity> merchantCategories);

    void saveMerchantNewSubCategories(Map<String, ? extends MerchantSubcategoryEntity> merchantSubCategories);
}
