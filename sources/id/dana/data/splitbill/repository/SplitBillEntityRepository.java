package id.dana.data.splitbill.repository;

import android.text.TextUtils;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.deeplink.repository.source.GenerateLinkEntityData;
import id.dana.data.deeplink.repository.source.GenerateLinkEntityDataFactory;
import id.dana.data.deeplink.repository.source.branch.result.DeepLinkEntity;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.splitbill.mapper.SplitBillDetailResultMapper;
import id.dana.data.splitbill.mapper.SplitBillDetailToSplitBillHistoryEntityMapper;
import id.dana.data.splitbill.mapper.SplitBillHistoriesMapper;
import id.dana.data.splitbill.mapper.SplitBillHistoryEntitiesMapper;
import id.dana.data.splitbill.model.SplitBillHistoryResult;
import id.dana.data.splitbill.repository.source.SplitBillEntityData;
import id.dana.data.splitbill.repository.source.SplitBillEntityDataFactory;
import id.dana.data.splitbill.repository.source.network.response.GetSplitBillDetailResult;
import id.dana.data.splitbill.repository.source.network.response.GetSplitBillHistoriesResult;
import id.dana.domain.splitbill.model.SplitBillHistory;
import id.dana.domain.splitbill.repository.SplitBillRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class SplitBillEntityRepository implements SplitBillRepository {
    private final GenerateLinkEntityDataFactory generateLinkEntityDataFactory;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final SplitBillDetailResultMapper splitBillDetailResultMapper;
    private final SplitBillDetailToSplitBillHistoryEntityMapper splitBillDetailToSplitBillHistoryEntityMapper;
    private final SplitBillEntityDataFactory splitBillEntityDataFactory;
    private final SplitBillHistoriesMapper splitBillHistoriesMapper;
    private final SplitBillHistoryEntitiesMapper splitBillHistoryEntitiesMapper;

    @Inject
    public SplitBillEntityRepository(SplitBillEntityDataFactory splitBillEntityDataFactory, SplitBillHistoriesMapper splitBillHistoriesMapper, SplitBillHistoryEntitiesMapper splitBillHistoryEntitiesMapper, SplitBillDetailResultMapper splitBillDetailResultMapper, SplitBillDetailToSplitBillHistoryEntityMapper splitBillDetailToSplitBillHistoryEntityMapper, GenerateLinkEntityDataFactory generateLinkEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        this.splitBillEntityDataFactory = splitBillEntityDataFactory;
        this.splitBillHistoriesMapper = splitBillHistoriesMapper;
        this.splitBillHistoryEntitiesMapper = splitBillHistoryEntitiesMapper;
        this.splitBillDetailResultMapper = splitBillDetailResultMapper;
        this.splitBillDetailToSplitBillHistoryEntityMapper = splitBillDetailToSplitBillHistoryEntityMapper;
        this.generateLinkEntityDataFactory = generateLinkEntityDataFactory;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    private SplitBillEntityData createLocalSplitBillEntityData() {
        return this.splitBillEntityDataFactory.createData2("local");
    }

    private SplitBillEntityData createSplitBillEntityData() {
        return this.splitBillEntityDataFactory.createData2("network");
    }

    @Override // id.dana.domain.splitbill.repository.SplitBillRepository
    public Observable<List<SplitBillHistory>> getSplitBillHistories(int i) {
        Observable onErrorResumeNext = this.holdLoginV1EntityRepository.authenticatedRequest(createSplitBillEntityData().getSplitBillHistories(i)).flatMap(new Function() { // from class: id.dana.data.splitbill.repository.SplitBillEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitBillEntityRepository.this.m2037xaf3ab001((GetSplitBillHistoriesResult) obj);
            }
        }).onErrorResumeNext(getLocalSplitBillHistories());
        final SplitBillHistoriesMapper splitBillHistoriesMapper = this.splitBillHistoriesMapper;
        Objects.requireNonNull(splitBillHistoriesMapper);
        return onErrorResumeNext.map(new Function() { // from class: id.dana.data.splitbill.repository.SplitBillEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitBillHistoriesMapper.this.apply((GetSplitBillHistoriesResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getSplitBillHistories$0$id-dana-data-splitbill-repository-SplitBillEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m2037xaf3ab001(GetSplitBillHistoriesResult getSplitBillHistoriesResult) throws Exception {
        return updateLocalHistories(getSplitBillHistoriesResult.getSplitBillHistoryList());
    }

    @Override // id.dana.domain.splitbill.repository.SplitBillRepository
    public Observable<SplitBillHistory> getSplitBillDetail(final String str) {
        return this.holdLoginV1EntityRepository.authenticatedRequest(createSplitBillEntityData().getSplitBillDetail(str)).flatMap(new Function() { // from class: id.dana.data.splitbill.repository.SplitBillEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitBillEntityRepository.this.m2035x8b3cf831(str, (GetSplitBillDetailResult) obj);
            }
        }).onErrorResumeNext(getLocalSplitBillDetail(str)).flatMap(new Function() { // from class: id.dana.data.splitbill.repository.SplitBillEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource splitBillDeeplinkIfEmpty;
                splitBillDeeplinkIfEmpty = SplitBillEntityRepository.this.getSplitBillDeeplinkIfEmpty((GetSplitBillDetailResult) obj);
                return splitBillDeeplinkIfEmpty;
            }
        }).map(new Function() { // from class: id.dana.data.splitbill.repository.SplitBillEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitBillEntityRepository.this.m2036x45b298b2((GetSplitBillDetailResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getSplitBillDetail$2$id-dana-data-splitbill-repository-SplitBillEntityRepository  reason: not valid java name */
    public /* synthetic */ SplitBillHistory m2036x45b298b2(GetSplitBillDetailResult getSplitBillDetailResult) throws Exception {
        return this.splitBillDetailResultMapper.apply(getSplitBillDetailResult.getSplitBillOrder());
    }

    @Override // id.dana.domain.splitbill.repository.SplitBillRepository
    public Observable<Boolean> closePayers(List<String> list, String str) {
        return this.holdLoginV1EntityRepository.authenticatedRequest(createSplitBillEntityData().closePayers(list, str)).map(new Function() { // from class: id.dana.data.splitbill.repository.SplitBillEntityRepository$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((BaseRpcResult) obj).success);
                return valueOf;
            }
        });
    }

    @Override // id.dana.domain.splitbill.repository.SplitBillRepository
    public Observable<SplitBillHistory> getPayerSplitBillDetail(String str) {
        return this.holdLoginV1EntityRepository.authenticatedRequest(createSplitBillEntityData().getSplitBillDetail(str)).map(new Function() { // from class: id.dana.data.splitbill.repository.SplitBillEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitBillEntityRepository.this.m2034x5c4e4db1((GetSplitBillDetailResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getPayerSplitBillDetail$4$id-dana-data-splitbill-repository-SplitBillEntityRepository  reason: not valid java name */
    public /* synthetic */ SplitBillHistory m2034x5c4e4db1(GetSplitBillDetailResult getSplitBillDetailResult) throws Exception {
        return this.splitBillDetailResultMapper.apply(getSplitBillDetailResult.getSplitBillOrder());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObservableSource<GetSplitBillDetailResult> getSplitBillDeeplinkIfEmpty(final GetSplitBillDetailResult getSplitBillDetailResult) {
        if (TextUtils.isEmpty(getSplitBillDetailResult.getSplitBillOrder().getDeeplinkUrl())) {
            return createGenerateLinkEntityData().generateSplitBillDetailDeepLink(getSplitBillDetailResult.getSplitBillOrder().getSplitBillId()).flatMap(new Function() { // from class: id.dana.data.splitbill.repository.SplitBillEntityRepository$$ExternalSyntheticLambda8
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return SplitBillEntityRepository.lambda$getSplitBillDeeplinkIfEmpty$5(GetSplitBillDetailResult.this, (DeepLinkEntity) obj);
                }
            });
        }
        return Observable.just(getSplitBillDetailResult);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$getSplitBillDeeplinkIfEmpty$5(GetSplitBillDetailResult getSplitBillDetailResult, DeepLinkEntity deepLinkEntity) throws Exception {
        getSplitBillDetailResult.getSplitBillOrder().setDeeplinkUrl(deepLinkEntity.getLink());
        return Observable.just(getSplitBillDetailResult);
    }

    private GenerateLinkEntityData createGenerateLinkEntityData() {
        return this.generateLinkEntityDataFactory.createData2("network");
    }

    private Observable<GetSplitBillHistoriesResult> getLocalSplitBillHistories() {
        return createLocalSplitBillEntityData().getSplitBillHistories(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateSplitBillDetail  reason: merged with bridge method [inline-methods] */
    public ObservableSource<GetSplitBillDetailResult> m2035x8b3cf831(final String str, GetSplitBillDetailResult getSplitBillDetailResult) {
        return createLocalSplitBillEntityData().updateSplitBillDetail(this.splitBillDetailToSplitBillHistoryEntityMapper.apply(getSplitBillDetailResult.getSplitBillOrder())).flatMap(new Function() { // from class: id.dana.data.splitbill.repository.SplitBillEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitBillEntityRepository.this.m2039x21205089(str, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$updateSplitBillDetail$6$id-dana-data-splitbill-repository-SplitBillEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m2039x21205089(String str, Boolean bool) throws Exception {
        return getLocalSplitBillDetail(str);
    }

    private Observable<GetSplitBillDetailResult> getLocalSplitBillDetail(String str) {
        return createLocalSplitBillEntityData().getSplitBillDetail(str);
    }

    private Observable<GetSplitBillHistoriesResult> updateLocalHistories(List<SplitBillHistoryResult> list) {
        return createLocalSplitBillEntityData().updateSplitBillHistories(this.splitBillHistoryEntitiesMapper.apply(list)).flatMap(new Function() { // from class: id.dana.data.splitbill.repository.SplitBillEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitBillEntityRepository.this.m2038x5a420f6b((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$updateLocalHistories$7$id-dana-data-splitbill-repository-SplitBillEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m2038x5a420f6b(Boolean bool) throws Exception {
        return getLocalSplitBillHistories();
    }
}
