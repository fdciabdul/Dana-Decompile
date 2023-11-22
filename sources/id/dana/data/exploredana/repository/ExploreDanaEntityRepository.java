package id.dana.data.exploredana.repository;

import id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda10;
import id.dana.data.cache.CacheEntityData;
import id.dana.data.cache.CacheKey;
import id.dana.data.content.SpaceCode;
import id.dana.data.content.mapper.SpaceResultMapper;
import id.dana.data.content.source.ContentDeliveryEntityData;
import id.dana.data.content.source.ContentDeliveryEntityDataFactory;
import id.dana.data.content.source.cache.ContentDeliveryCacheEntityDataFactory;
import id.dana.data.content.source.network.result.SpaceRpcResult;
import id.dana.data.exploredana.repository.source.local.ExploreDanaEntityData;
import id.dana.data.exploredana.repository.source.local.ExploreDanaPreferencesDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.domain.exploredana.repository.ExploreDanaRepository;
import id.dana.domain.promotion.Space;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class ExploreDanaEntityRepository implements ExploreDanaRepository {
    private final ContentDeliveryCacheEntityDataFactory contentDeliveryCacheEntityDataFactory;
    private final ContentDeliveryEntityDataFactory contentDeliveryEntityDataFactory;
    private final ExploreDanaPreferencesDataFactory exploreDanaPreferencesDataFactory;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final SpaceResultMapper spaceResultMapper;

    @Inject
    public ExploreDanaEntityRepository(ContentDeliveryEntityDataFactory contentDeliveryEntityDataFactory, ExploreDanaPreferencesDataFactory exploreDanaPreferencesDataFactory, ContentDeliveryCacheEntityDataFactory contentDeliveryCacheEntityDataFactory, SpaceResultMapper spaceResultMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        this.contentDeliveryEntityDataFactory = contentDeliveryEntityDataFactory;
        this.exploreDanaPreferencesDataFactory = exploreDanaPreferencesDataFactory;
        this.contentDeliveryCacheEntityDataFactory = contentDeliveryCacheEntityDataFactory;
        this.spaceResultMapper = spaceResultMapper;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.exploredana.repository.ExploreDanaRepository
    public Observable<Space> getExploreDana() {
        Observable startWith = this.holdLoginV1EntityRepository.authenticatedRequest(createContentDelivery().get(SpaceCode.EXPLORE_DANA)).doOnNext(new Consumer() { // from class: id.dana.data.exploredana.repository.ExploreDanaEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExploreDanaEntityRepository.this.m1213xf7a7c821((SpaceRpcResult) obj);
            }
        }).startWith((ObservableSource) createCacheContentDelivery().getObject(CacheKey.HOME.CDP_EXPLORE, SpaceRpcResult.class));
        SpaceResultMapper spaceResultMapper = this.spaceResultMapper;
        Objects.requireNonNull(spaceResultMapper);
        return startWith.map(new CashierEntityRepository$$ExternalSyntheticLambda10(spaceResultMapper)).flatMap(new Function() { // from class: id.dana.data.exploredana.repository.ExploreDanaEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ExploreDanaEntityRepository.this.m1214x9326b823((Space) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getExploreDana$0$id-dana-data-exploredana-repository-ExploreDanaEntityRepository  reason: not valid java name */
    public /* synthetic */ void m1213xf7a7c821(SpaceRpcResult spaceRpcResult) throws Exception {
        createCacheContentDelivery().saveData(CacheKey.HOME.CDP_EXPLORE, spaceRpcResult);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getExploreDana$2$id-dana-data-exploredana-repository-ExploreDanaEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1214x9326b823(final Space space) throws Exception {
        return createExploreDanaData().checkExploreDanaPreferences(space.getCdpContents()).map(new Function() { // from class: id.dana.data.exploredana.repository.ExploreDanaEntityRepository$$ExternalSyntheticLambda2
            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: id.dana.data.exploredana.repository.ExploreDanaEntityRepository.lambda$getExploreDana$1(id.dana.domain.promotion.Space, java.util.List):id.dana.domain.promotion.Space
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
                Caused by: java.lang.NullPointerException
                */
            @Override // io.reactivex.functions.Function
            public final java.lang.Object apply(java.lang.Object r2) {
                /*
                    r1 = this;
                    id.dana.domain.promotion.Space r0 = id.dana.domain.promotion.Space.this
                    java.util.List r2 = (java.util.List) r2
                    id.dana.domain.promotion.Space r2 = id.dana.data.exploredana.repository.ExploreDanaEntityRepository.lambda$getExploreDana$1(r0, r2)
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.data.exploredana.repository.ExploreDanaEntityRepository$$ExternalSyntheticLambda2.apply(java.lang.Object):java.lang.Object");
            }
        });
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ id.dana.domain.promotion.Space lambda$getExploreDana$1(id.dana.domain.promotion.Space r0, java.util.List r1) throws java.lang.Exception {
        /*
            r0.setCdpContents(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.exploredana.repository.ExploreDanaEntityRepository.lambda$getExploreDana$1(id.dana.domain.promotion.Space, java.util.List):id.dana.domain.promotion.Space");
    }

    private ContentDeliveryEntityData createContentDelivery() {
        return this.contentDeliveryEntityDataFactory.createData2("network");
    }

    private CacheEntityData<SpaceRpcResult> createCacheContentDelivery() {
        return this.contentDeliveryCacheEntityDataFactory.createData2("local");
    }

    private ExploreDanaEntityData createExploreDanaData() {
        return this.exploreDanaPreferencesDataFactory.createData2("local");
    }

    @Override // id.dana.domain.exploredana.repository.ExploreDanaRepository
    public Observable<Boolean> setReadExploreDanaItem(String str) {
        return createExploreDanaData().setReadDanaPreferences(str);
    }

    @Override // id.dana.domain.exploredana.repository.ExploreDanaRepository
    public Observable<Boolean> setDismissAll(List<String> list) {
        return createExploreDanaData().setDismissAll(list);
    }
}
