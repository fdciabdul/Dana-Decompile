package id.dana.domain.services;

import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.services.model.CategoryServicesModel;
import id.dana.domain.services.model.ThirdPartyCategoryService;
import io.reactivex.Observable;
import j$.util.Optional;
import java.util.List;

/* loaded from: classes2.dex */
public interface ServicesRepository {
    Observable<Boolean> clearCacheFavoriteServices();

    Observable<List<CategoryServicesModel>> getAllCategories();

    Observable<List<ThirdPartyCategoryService>> getAllDefaultServices();

    Observable<List<ThirdPartyCategoryService>> getAllServices();

    Observable<List<ThirdPartyServiceResponse>> getDefaultSkuExplore(List<String> list);

    Observable<List<ThirdPartyCategoryService>> getEnabledServicesByKey(List<String> list);

    Observable<List<ThirdPartyCategoryService>> getExploreServices(List<String> list);

    Observable<ThirdPartyCategoryService> getFavoriteServiceFromRemoteSource();

    Observable<ThirdPartyCategoryService> getFavoriteServices();

    Observable<ThirdPartyCategoryService> getFavoriteServicesCache(boolean z);

    Observable<Optional<ThirdPartyServiceResponse>> getHighlightedService();

    ThirdPartyCategoryService getInMemoryFavoriteServiceCache();

    Observable<List<ThirdPartyServiceResponse>> getRawServices();

    Observable<ThirdPartyServiceResponse> getServiceByKey(String str);

    Observable<List<ThirdPartyCategoryService>> getServicesByCategoryKey(List<String> list);

    Observable<List<ThirdPartyCategoryService>> getServicesByCategoryKeyDefault(List<String> list);

    Observable<List<ThirdPartyCategoryService>> getServicesByKey(List<String> list);

    Observable<List<ThirdPartyCategoryService>> getServicesByName(List<String> list);

    Observable<Boolean> isFeatureHighlightExist(String str);

    Observable<Boolean> overwriteHighlightedService(String str);

    Observable<Boolean> resetInMemoryCategoryHighlightedFeature();

    Observable<Boolean> resetInMemoryFavoriteServiceCache();

    Observable<Boolean> saveFavoriteServices(List<String> list);

    void setInMemoryFavoriteServiceCache(ThirdPartyCategoryService thirdPartyCategoryService);

    Observable<Boolean> updateHighlightedService();
}
