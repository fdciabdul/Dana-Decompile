package id.dana.data.feeds.repository;

import com.google.gson.reflect.TypeToken;
import id.dana.data.cache.CacheEntityData;
import id.dana.data.cache.CacheKey;
import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.feeds.mapper.DeleteFeedResultMapper;
import id.dana.data.feeds.mapper.FeedsResultMapper;
import id.dana.data.feeds.model.ActivityEntity;
import id.dana.data.feeds.repository.source.FeedsEntityData;
import id.dana.data.feeds.repository.source.FeedsEntityDataFactory;
import id.dana.data.feeds.repository.source.cache.FeedsCacheEntityDataFactory;
import id.dana.data.feeds.repository.source.network.result.DeleteFeedResult;
import id.dana.data.feeds.repository.source.network.result.FeedsResult;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.domain.feeds.FeedsRepository;
import id.dana.domain.feeds.model.DeleteFeed;
import id.dana.domain.feeds.model.Feeds;
import id.dana.domain.feeds.model.FeedsSource;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class FeedsEntityRepository implements FeedsRepository {
    private final FeedsCacheEntityDataFactory cacheFactory;
    private final ConfigEntityDataFactory configEntityDataFactory;
    private int defaultPageSize = 5;
    private final DeleteFeedResultMapper deleteFeedResultMapper;
    private final FeedsEntityDataFactory factory;
    private final FeedsResultMapper feedsResultMapper;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;

    private boolean isFirstPageForGlobalFeeds(String str) {
        return str == null;
    }

    @Inject
    public FeedsEntityRepository(DeleteFeedResultMapper deleteFeedResultMapper, FeedsEntityDataFactory feedsEntityDataFactory, FeedsCacheEntityDataFactory feedsCacheEntityDataFactory, ConfigEntityDataFactory configEntityDataFactory, FeedsResultMapper feedsResultMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        this.deleteFeedResultMapper = deleteFeedResultMapper;
        this.factory = feedsEntityDataFactory;
        this.cacheFactory = feedsCacheEntityDataFactory;
        this.feedsResultMapper = feedsResultMapper;
        this.configEntityDataFactory = configEntityDataFactory;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.feeds.FeedsRepository
    public Observable<Feeds> getGlobalFeeds(int i, String str) {
        this.defaultPageSize = i;
        if (isFirstPageForGlobalFeeds(str)) {
            Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(getIgrowthFeeds(i, str, new ArrayList()));
            FeedsResultMapper feedsResultMapper = this.feedsResultMapper;
            Objects.requireNonNull(feedsResultMapper);
            return authenticatedRequest.map(new FeedsEntityRepository$$ExternalSyntheticLambda1(feedsResultMapper)).doOnNext(new Consumer() { // from class: id.dana.data.feeds.repository.FeedsEntityRepository$$ExternalSyntheticLambda4
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    FeedsEntityRepository.this.m1285xf134fdd0((Feeds) obj);
                }
            }).startWith(createFeedsCacheEntityData().getObject(CacheKey.HOME.FEEDS_GLOBAL, Feeds.class).map(new Function() { // from class: id.dana.data.feeds.repository.FeedsEntityRepository$$ExternalSyntheticLambda5
                /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                    jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: id.dana.data.feeds.repository.FeedsEntityRepository.lambda$getGlobalFeeds$1(id.dana.domain.feeds.model.Feeds):id.dana.domain.feeds.model.Feeds
                    	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
                    	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
                    Caused by: java.lang.NullPointerException
                    */
                @Override // io.reactivex.functions.Function
                public final java.lang.Object apply(java.lang.Object r1) {
                    /*
                        r0 = this;
                        id.dana.domain.feeds.model.Feeds r1 = (id.dana.domain.feeds.model.Feeds) r1
                        id.dana.domain.feeds.model.Feeds r1 = id.dana.data.feeds.repository.FeedsEntityRepository.lambda$getGlobalFeeds$1(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.data.feeds.repository.FeedsEntityRepository$$ExternalSyntheticLambda5.apply(java.lang.Object):java.lang.Object");
                }
            }));
        }
        Observable authenticatedRequest2 = this.holdLoginV1EntityRepository.authenticatedRequest(createFeedsEntityData().getFeeds(FeedsSource.GLOBAL, i, str));
        FeedsResultMapper feedsResultMapper2 = this.feedsResultMapper;
        Objects.requireNonNull(feedsResultMapper2);
        return authenticatedRequest2.map(new FeedsEntityRepository$$ExternalSyntheticLambda1(feedsResultMapper2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getGlobalFeeds$0$id-dana-data-feeds-repository-FeedsEntityRepository  reason: not valid java name */
    public /* synthetic */ void m1285xf134fdd0(Feeds feeds) throws Exception {
        feeds.setFirstPage(true);
        createFeedsCacheEntityData().saveData(CacheKey.HOME.FEEDS_GLOBAL, feeds);
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ id.dana.domain.feeds.model.Feeds lambda$getGlobalFeeds$1(id.dana.domain.feeds.model.Feeds r1) throws java.lang.Exception {
        /*
            r0 = 1
            r1.setFirstPage(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.feeds.repository.FeedsEntityRepository.lambda$getGlobalFeeds$1(id.dana.domain.feeds.model.Feeds):id.dana.domain.feeds.model.Feeds");
    }

    @Override // id.dana.domain.feeds.FeedsRepository
    public Observable<Feeds> getUserFeeds(int i, String str) {
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createFeedsEntityData().getFeeds(FeedsSource.USER, i, str));
        FeedsResultMapper feedsResultMapper = this.feedsResultMapper;
        Objects.requireNonNull(feedsResultMapper);
        return authenticatedRequest.map(new FeedsEntityRepository$$ExternalSyntheticLambda1(feedsResultMapper));
    }

    @Override // id.dana.domain.feeds.FeedsRepository
    public Observable<DeleteFeed> deleteFeeds(String str) {
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createFeedsEntityData().deleteFeeds(str));
        final DeleteFeedResultMapper deleteFeedResultMapper = this.deleteFeedResultMapper;
        Objects.requireNonNull(deleteFeedResultMapper);
        return authenticatedRequest.map(new Function() { // from class: id.dana.data.feeds.repository.FeedsEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DeleteFeedResultMapper.this.apply((DeleteFeedResult) obj);
            }
        });
    }

    @Override // id.dana.domain.feeds.FeedsRepository
    public Observable<Feeds> getDefaultFeedFromConfig() {
        return createSplitConfigEntityData().getDefaultFeedFromConfig().map(new Function() { // from class: id.dana.data.feeds.repository.FeedsEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsEntityRepository.this.m1284x3be1070b((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getDefaultFeedFromConfig$2$id-dana-data-feeds-repository-FeedsEntityRepository  reason: not valid java name */
    public /* synthetic */ Feeds m1284x3be1070b(List list) throws Exception {
        return this.feedsResultMapper.apply(createDefaultFeedResult(convertJsonStringToListOfActivityEntity(list)));
    }

    private List<ActivityEntity> convertJsonStringToListOfActivityEntity(List<String> list) {
        return (List) JSONExtKt.PlaceComponentResult().fromJson(list.toString(), new TypeToken<List<ActivityEntity>>() { // from class: id.dana.data.feeds.repository.FeedsEntityRepository.1
        }.getType());
    }

    private FeedsResult createDefaultFeedResult(List<ActivityEntity> list) {
        FeedsResult feedsResult = new FeedsResult();
        feedsResult.setHasMore(false);
        feedsResult.setActivities(list);
        return feedsResult;
    }

    private Observable<FeedsResult> getIgrowthFeeds(final int i, String str, final List<ActivityEntity> list) {
        return this.holdLoginV1EntityRepository.authenticatedRequest(createFeedsEntityData().getFeeds(FeedsSource.GLOBAL, i, str).timeout(5L, TimeUnit.SECONDS).flatMap(new Function() { // from class: id.dana.data.feeds.repository.FeedsEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsEntityRepository.this.m1286x4f6b5f38(list, i, (FeedsResult) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getIgrowthFeeds$3$id-dana-data-feeds-repository-FeedsEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1286x4f6b5f38(List list, int i, FeedsResult feedsResult) throws Exception {
        List<ActivityEntity> combineActivities = combineActivities(feedsResult, list);
        if (needToFetchAnotherFeeds(feedsResult.isHasMore(), combineActivities)) {
            return getIgrowthFeeds(i, feedsResult.getMaxId(), combineActivities);
        }
        feedsResult.setActivities(combineActivities);
        return Observable.just(feedsResult);
    }

    private List<ActivityEntity> combineActivities(FeedsResult feedsResult, List<ActivityEntity> list) {
        List<ActivityEntity> activities = feedsResult.getActivities();
        if (list != null) {
            list.addAll(activities);
        }
        return list;
    }

    private boolean needToFetchAnotherFeeds(boolean z, List list) {
        return z && isLessThanPageSize(list);
    }

    private boolean isLessThanPageSize(List<ActivityEntity> list) {
        return list.size() < this.defaultPageSize;
    }

    private FeedsEntityData createFeedsEntityData() {
        return this.factory.createData2("network");
    }

    private ConfigEntityData createSplitConfigEntityData() {
        return this.configEntityDataFactory.createData2("split");
    }

    private CacheEntityData<Feeds> createFeedsCacheEntityData() {
        return this.cacheFactory.createData2("local");
    }
}
