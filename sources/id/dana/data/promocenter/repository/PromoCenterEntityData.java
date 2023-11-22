package id.dana.data.promocenter.repository;

import id.dana.data.promocenter.repository.source.local.model.UserCoordinateEntityData;
import id.dana.data.promocenter.repository.source.network.result.PromoCenterAdsQueryResult;
import id.dana.data.promocenter.repository.source.network.result.PromoCenterCategorizedResult;
import id.dana.data.promocenter.repository.source.network.result.PromoCenterCategoryResult;
import id.dana.data.promocenter.repository.source.network.result.PromoCenterFetchResult;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes2.dex */
public interface PromoCenterEntityData {
    PromoCenterCategoryResult getCachedCategories();

    Observable<PromoCenterCategoryResult> getCategories(int i, int i2);

    Observable<Integer> getCurrentAdsPageNumber(String str, String str2);

    Observable<PromoCenterAdsQueryResult> getPromoAds(int i, int i2, double d, double d2, int i3);

    Observable<UserCoordinateEntityData> getUserLastCoordinate(String str);

    Observable<PromoCenterFetchResult> queryAllPromo(int i, int i2, String str);

    Observable<PromoCenterCategorizedResult> queryCategorizedPromo(List<String> list, int i, int i2, String str, String str2, double d, double d2);

    Observable<Boolean> saveCategories(PromoCenterCategoryResult promoCenterCategoryResult);

    Observable<Boolean> saveCurrentAdsPageNumber(String str, int i, String str2);

    Observable<Boolean> saveUserLastCoordinate(String str, UserCoordinateEntityData userCoordinateEntityData);
}
