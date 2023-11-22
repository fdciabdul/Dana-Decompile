package id.dana.data.promocenter.repository.source.network;

import android.content.Context;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.promocenter.repository.PromoCenterEntityData;
import id.dana.data.promocenter.repository.source.local.model.UserCoordinateEntityData;
import id.dana.data.promocenter.repository.source.network.request.PromoCenterAdsQueryRequest;
import id.dana.data.promocenter.repository.source.network.request.PromoCenterCategorizedRequest;
import id.dana.data.promocenter.repository.source.network.request.PromoCenterCategoryRequest;
import id.dana.data.promocenter.repository.source.network.request.PromoCenterFetchRequest;
import id.dana.data.promocenter.repository.source.network.result.PromoCenterAdsQueryResult;
import id.dana.data.promocenter.repository.source.network.result.PromoCenterCategorizedResult;
import id.dana.data.promocenter.repository.source.network.result.PromoCenterCategoryResult;
import id.dana.data.promocenter.repository.source.network.result.PromoCenterFetchResult;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class NetworkPromoCenterEntityData extends SecureBaseNetwork<PromoCenterFacade> implements PromoCenterEntityData {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public NetworkPromoCenterEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<PromoCenterFacade> getFacadeClass() {
        return PromoCenterFacade.class;
    }

    @Override // id.dana.data.promocenter.repository.PromoCenterEntityData
    public Observable<PromoCenterCategoryResult> getCategories(int i, int i2) {
        final PromoCenterCategoryRequest promoCenterCategoryRequest = new PromoCenterCategoryRequest();
        promoCenterCategoryRequest.envInfo = generateMobileEnvInfo();
        promoCenterCategoryRequest.setPageSize(i);
        promoCenterCategoryRequest.setPageNumber(i2);
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.promocenter.repository.source.network.NetworkPromoCenterEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                PromoCenterCategoryResult queryCategory;
                queryCategory = ((PromoCenterFacade) obj).queryCategory(PromoCenterCategoryRequest.this);
                return queryCategory;
            }
        });
    }

    @Override // id.dana.data.promocenter.repository.PromoCenterEntityData
    public PromoCenterCategoryResult getCachedCategories() {
        throw new UnsupportedOperationException("Unable to get cache on network data");
    }

    @Override // id.dana.data.promocenter.repository.PromoCenterEntityData
    public Observable<Boolean> saveCategories(PromoCenterCategoryResult promoCenterCategoryResult) {
        throw new UnsupportedOperationException("Have yet support post data to BE");
    }

    @Override // id.dana.data.promocenter.repository.PromoCenterEntityData
    public Observable<PromoCenterFetchResult> queryAllPromo(int i, int i2, String str) {
        final PromoCenterFetchRequest promoCenterFetchRequest = new PromoCenterFetchRequest();
        promoCenterFetchRequest.pageSize = i;
        promoCenterFetchRequest.pageNumber = i2;
        promoCenterFetchRequest.sortBy = str;
        promoCenterFetchRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.promocenter.repository.source.network.NetworkPromoCenterEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                PromoCenterFetchResult queryAllPromo;
                queryAllPromo = ((PromoCenterFacade) obj).queryAllPromo(PromoCenterFetchRequest.this);
                return queryAllPromo;
            }
        });
    }

    @Override // id.dana.data.promocenter.repository.PromoCenterEntityData
    public Observable<PromoCenterCategorizedResult> queryCategorizedPromo(List<String> list, int i, int i2, String str, String str2, double d, double d2) {
        final PromoCenterCategorizedRequest promoCenterCategorizedRequest = new PromoCenterCategorizedRequest();
        promoCenterCategorizedRequest.pageSize = i;
        promoCenterCategorizedRequest.pageNumber = i2;
        promoCenterCategorizedRequest.categories = list;
        promoCenterCategorizedRequest.sortBy = str;
        promoCenterCategorizedRequest.filterBy = str2;
        promoCenterCategorizedRequest.latitude = d;
        promoCenterCategorizedRequest.longitude = d2;
        promoCenterCategorizedRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.promocenter.repository.source.network.NetworkPromoCenterEntityData$$ExternalSyntheticLambda3
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                PromoCenterCategorizedResult queryCategorizedPromo;
                queryCategorizedPromo = ((PromoCenterFacade) obj).queryCategorizedPromo(PromoCenterCategorizedRequest.this);
                return queryCategorizedPromo;
            }
        });
    }

    @Override // id.dana.data.promocenter.repository.PromoCenterEntityData
    public Observable<PromoCenterAdsQueryResult> getPromoAds(int i, int i2, double d, double d2, int i3) {
        final PromoCenterAdsQueryRequest promoCenterAdsQueryRequest = new PromoCenterAdsQueryRequest(i3, i2, i);
        promoCenterAdsQueryRequest.envInfo = generateMobileEnvInfo();
        promoCenterAdsQueryRequest.envInfo.locationInfo.latitude = String.valueOf(d);
        promoCenterAdsQueryRequest.envInfo.locationInfo.longitude = String.valueOf(d2);
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.promocenter.repository.source.network.NetworkPromoCenterEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                PromoCenterAdsQueryResult queryPromoCenterAds;
                queryPromoCenterAds = ((PromoCenterFacade) obj).queryPromoCenterAds(PromoCenterAdsQueryRequest.this);
                return queryPromoCenterAds;
            }
        });
    }

    @Override // id.dana.data.promocenter.repository.PromoCenterEntityData
    public Observable<UserCoordinateEntityData> getUserLastCoordinate(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.promocenter.repository.PromoCenterEntityData
    public Observable<Boolean> saveUserLastCoordinate(String str, UserCoordinateEntityData userCoordinateEntityData) {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.promocenter.repository.PromoCenterEntityData
    public Observable<Integer> getCurrentAdsPageNumber(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.promocenter.repository.PromoCenterEntityData
    public Observable<Boolean> saveCurrentAdsPageNumber(String str, int i, String str2) {
        throw new UnsupportedOperationException();
    }
}
