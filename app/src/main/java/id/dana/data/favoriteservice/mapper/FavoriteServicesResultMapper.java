package id.dana.data.favoriteservice.mapper;

import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.services.Category;
import id.dana.domain.services.model.ThirdPartyCategoryService;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class FavoriteServicesResultMapper {
    static final int MAX_FEATURED_SERVICE = 8;

    @Inject
    public FavoriteServicesResultMapper() {
    }

    public Observable<ThirdPartyCategoryService> transform(List<String> list, List<ThirdPartyCategoryService> list2) {
        boolean z;
        if (list2.isEmpty()) {
            return Observable.just(new ThirdPartyCategoryService());
        }
        Iterator<String> it = list.iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (next != null && !next.isEmpty()) {
                z = false;
                break;
            }
        }
        if (z) {
            ThirdPartyCategoryService featuredService = getFeaturedService(list2);
            if (featuredService != null) {
                doLimitFeaturedServices(featuredService);
                return Observable.just(featuredService);
            }
            return Observable.just(new ThirdPartyCategoryService());
        }
        ThirdPartyCategoryService featuredService2 = getFeaturedService(list2);
        if (featuredService2 == null) {
            return Observable.just(new ThirdPartyCategoryService());
        }
        return Observable.just(createNewThirdPartyCategoryServices(featuredService2, transform(list2), list));
    }

    private List<ThirdPartyServiceResponse> filterByFavoriteServices(Map<String, ThirdPartyServiceResponse> map, List<String> list, List<ThirdPartyServiceResponse> list2, ThirdPartyCategoryService thirdPartyCategoryService) {
        removeExistingFeaturedService(map, list, thirdPartyCategoryService);
        for (int i = 0; i < list.size(); i++) {
            ThirdPartyServiceResponse thirdPartyServiceResponse = map.get(list.get(i));
            if (thirdPartyServiceResponse != null) {
                list2.add(thirdPartyServiceResponse);
            } else {
                ThirdPartyServiceResponse nonPromotedFeaturedService = getNonPromotedFeaturedService(thirdPartyCategoryService);
                if (nonPromotedFeaturedService != null) {
                    list2.add(nonPromotedFeaturedService);
                    thirdPartyCategoryService.getThirdPartyServices().remove(nonPromotedFeaturedService);
                }
            }
        }
        return list2;
    }

    private void addServiceResponseToMap(List<ThirdPartyServiceResponse> list, Map<String, ThirdPartyServiceResponse> map) {
        for (int i = 0; i < list.size(); i++) {
            ThirdPartyServiceResponse thirdPartyServiceResponse = list.get(i);
            map.put(thirdPartyServiceResponse.getKey(), thirdPartyServiceResponse);
        }
    }

    private ThirdPartyCategoryService getFeaturedService(List<ThirdPartyCategoryService> list) {
        for (ThirdPartyCategoryService thirdPartyCategoryService : list) {
            if (Category.FEATURED.equalsIgnoreCase(thirdPartyCategoryService.getKey())) {
                return thirdPartyCategoryService;
            }
        }
        return null;
    }

    private Map<String, ThirdPartyServiceResponse> transform(List<ThirdPartyCategoryService> list) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            addServiceResponseToMap(list.get(i).getThirdPartyServices(), hashMap);
        }
        return hashMap;
    }

    private ThirdPartyCategoryService createNewThirdPartyCategoryServices(ThirdPartyCategoryService thirdPartyCategoryService, Map<String, ThirdPartyServiceResponse> map, List<String> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getPromotedService(thirdPartyCategoryService));
        thirdPartyCategoryService.setThirdPartyServices(filterByFavoriteServices(map, list, arrayList, thirdPartyCategoryService));
        return thirdPartyCategoryService;
    }

    private ThirdPartyServiceResponse getPromotedService(ThirdPartyCategoryService thirdPartyCategoryService) {
        if (thirdPartyCategoryService.getThirdPartyServices() == null || thirdPartyCategoryService.getThirdPartyServices().isEmpty()) {
            return new ThirdPartyServiceResponse();
        }
        return thirdPartyCategoryService.getThirdPartyServices().get(0);
    }

    private ThirdPartyServiceResponse getNonPromotedFeaturedService(ThirdPartyCategoryService thirdPartyCategoryService) {
        if (isValidThirdPartyServicesTemp(thirdPartyCategoryService)) {
            return thirdPartyCategoryService.getThirdPartyServices().get(1);
        }
        return null;
    }

    private boolean isValidThirdPartyServicesTemp(ThirdPartyCategoryService thirdPartyCategoryService) {
        return thirdPartyCategoryService.getThirdPartyServices() != null && thirdPartyCategoryService.getThirdPartyServices().size() > 1;
    }

    private void doLimitFeaturedServices(ThirdPartyCategoryService thirdPartyCategoryService) {
        if (thirdPartyCategoryService.getThirdPartyServices().size() > 8) {
            thirdPartyCategoryService.setThirdPartyServices(thirdPartyCategoryService.getThirdPartyServices().subList(0, 8));
        }
    }

    private void removeExistingFeaturedService(Map<String, ThirdPartyServiceResponse> map, List<String> list, ThirdPartyCategoryService thirdPartyCategoryService) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            ThirdPartyServiceResponse thirdPartyServiceResponse = map.get(it.next());
            if (thirdPartyServiceResponse != null) {
                thirdPartyCategoryService.getThirdPartyServices().remove(thirdPartyServiceResponse);
            }
        }
    }
}
