package id.dana.data.homeinfo.repository.source.network;

import android.content.Context;
import id.dana.data.feeds.repository.source.FeedsEntityData;
import id.dana.data.feeds.repository.source.FeedsEntityDataFactory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.homeinfo.repository.source.HomeEntityData;
import id.dana.data.homeinfo.repository.source.network.request.HomeInfoRequest;
import id.dana.data.homeinfo.repository.source.network.result.HomeDataResult;
import id.dana.data.homeinfo.repository.source.network.result.HomeInfoResult;
import id.dana.data.notificationcenter.repository.source.NotificationCenterEntityData;
import id.dana.data.notificationcenter.repository.source.NotificationCenterEntityDataFactory;
import id.dana.data.notificationcenter.repository.source.network.result.HasNewResult;
import id.dana.domain.promotion.model.BannerCollection;
import id.dana.domain.promotion.repository.PromotionRepository;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class NetworkHomeEntityData extends SecureBaseNetwork<HomeInfoFacade> implements HomeEntityData {
    private final FeedsEntityDataFactory feedsEntityDataFactory;
    private final NotificationCenterEntityDataFactory notificationCenterEntityDataFactory;
    private final PromotionRepository promotionRepository;

    private static void subscribe(Observer<? super HomeInfoResult> observer) {
    }

    @Inject
    public NetworkHomeEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context, FeedsEntityDataFactory feedsEntityDataFactory, PromotionRepository promotionRepository, NotificationCenterEntityDataFactory notificationCenterEntityDataFactory) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        this.feedsEntityDataFactory = feedsEntityDataFactory;
        this.promotionRepository = promotionRepository;
        this.notificationCenterEntityDataFactory = notificationCenterEntityDataFactory;
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<HomeInfoFacade> getFacadeClass() {
        return HomeInfoFacade.class;
    }

    @Override // id.dana.data.homeinfo.repository.source.HomeEntityData
    public Observable<HomeInfoResult> getHomeInfo() {
        final HomeInfoRequest homeInfoRequest = new HomeInfoRequest();
        homeInfoRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.homeinfo.repository.source.network.NetworkHomeEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                HomeInfoResult homeInfo;
                homeInfo = ((HomeInfoFacade) obj).getHomeInfo(HomeInfoRequest.this);
                return homeInfo;
            }
        }, HomeInfoResult.class);
    }

    @Override // id.dana.data.homeinfo.repository.source.HomeEntityData
    public Observable<HomeDataResult> getUpdatedHomeData() {
        return Observable.zip(getHomeInfoNewThread(), getHomePromotionBannerNewThread(), getHasNewNotificationNewThread(), new Function3() { // from class: id.dana.data.homeinfo.repository.source.network.NetworkHomeEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function3
            public final Object apply(Object obj, Object obj2, Object obj3) {
                return NetworkHomeEntityData.lambda$getUpdatedHomeData$1((HomeInfoResult) obj, (BannerCollection) obj2, (HasNewResult) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ HomeDataResult lambda$getUpdatedHomeData$1(HomeInfoResult homeInfoResult, BannerCollection bannerCollection, HasNewResult hasNewResult) throws Exception {
        HomeDataResult homeDataResult = new HomeDataResult();
        homeDataResult.setHomeInfoResult(homeInfoResult);
        homeDataResult.setSpace(bannerCollection);
        homeDataResult.setHasNewResult(hasNewResult);
        return homeDataResult;
    }

    private Observable<HomeInfoResult> getHomeInfoNewThread() {
        return getHomeInfo().onErrorReturnItem(new HomeInfoResult()).subscribeOn(Schedulers.getAuthRequestContext());
    }

    private Observable<BannerCollection> getHomePromotionBannerNewThread() {
        return this.promotionRepository.getHomePromotionBanner().onErrorReturnItem(new BannerCollection()).subscribeOn(Schedulers.getAuthRequestContext());
    }

    private Observable<HasNewResult> getHasNewNotificationNewThread() {
        return createNotificationCenterData().hasNew().flatMap(new Function() { // from class: id.dana.data.homeinfo.repository.source.network.NetworkHomeEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkHomeEntityData.lambda$getHasNewNotificationNewThread$2((HasNewResult) obj);
            }
        }).onErrorReturnItem(new HasNewResult()).subscribeOn(Schedulers.getAuthRequestContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$getHasNewNotificationNewThread$2(HasNewResult hasNewResult) throws Exception {
        hasNewResult.setUpdated(true);
        return Observable.just(hasNewResult);
    }

    private FeedsEntityData createFeedData() {
        return this.feedsEntityDataFactory.createData2("network");
    }

    private NotificationCenterEntityData createNotificationCenterData() {
        return this.notificationCenterEntityDataFactory.createData2("network");
    }
}
