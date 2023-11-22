package id.dana.data.splitbill.repository.source.persistence;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import dagger.Lazy;
import id.dana.data.base.BasePersistence;
import id.dana.data.base.BasePersistenceDao;
import id.dana.data.foundation.utils.CommonUtil;
import id.dana.data.splitbill.mapper.SplitBillHistoriesResultMapper;
import id.dana.data.splitbill.mapper.SplitBillHistoryEntityToSplitBillDetailResult;
import id.dana.data.splitbill.repository.source.SplitBillEntityData;
import id.dana.data.splitbill.repository.source.network.response.GetSplitBillDetailResult;
import id.dana.data.splitbill.repository.source.network.response.GetSplitBillHistoriesResult;
import id.dana.data.splitbill.repository.source.persistence.dao.SplitBillHistoryDao;
import id.dana.data.splitbill.repository.source.persistence.entity.SplitBillHistoryEntity;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class PersistenceSplitBillEntityData extends BasePersistence implements SplitBillEntityData {
    private final SplitBillHistoryEntityToSplitBillDetailResult splitBillDetailResultMapper;
    private final SplitBillHistoriesResultMapper splitBillHistoriesResultMapper;

    @Inject
    public PersistenceSplitBillEntityData(Lazy<BasePersistenceDao> lazy, SplitBillHistoriesResultMapper splitBillHistoriesResultMapper, SplitBillHistoryEntityToSplitBillDetailResult splitBillHistoryEntityToSplitBillDetailResult) {
        super(lazy);
        this.splitBillHistoriesResultMapper = splitBillHistoriesResultMapper;
        this.splitBillDetailResultMapper = splitBillHistoryEntityToSplitBillDetailResult;
    }

    @Override // id.dana.data.splitbill.repository.source.SplitBillEntityData
    public Observable<Long> saveSplitBillHistory(final SplitBillHistoryEntity splitBillHistoryEntity) {
        return Observable.defer(new Callable() { // from class: id.dana.data.splitbill.repository.source.persistence.PersistenceSplitBillEntityData$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PersistenceSplitBillEntityData.this.m2044xd0bca6c5(splitBillHistoryEntity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$saveSplitBillHistory$0$id-dana-data-splitbill-repository-source-persistence-PersistenceSplitBillEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m2044xd0bca6c5(SplitBillHistoryEntity splitBillHistoryEntity) throws Exception {
        Long saveSplitBillHistory = getDb().splitBillHistoryDao().saveSplitBillHistory(splitBillHistoryEntity);
        getSplitBillDao().deleteOldSplitBillHistories();
        return Observable.just(saveSplitBillHistory);
    }

    @Override // id.dana.data.splitbill.repository.source.SplitBillEntityData
    public Observable<GetSplitBillHistoriesResult> getSplitBillHistories(int i) {
        return Observable.defer(new Callable() { // from class: id.dana.data.splitbill.repository.source.persistence.PersistenceSplitBillEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PersistenceSplitBillEntityData.this.m2043xed37f4e3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getSplitBillHistories$1$id-dana-data-splitbill-repository-source-persistence-PersistenceSplitBillEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m2043xed37f4e3() throws Exception {
        Observable just = Observable.just(getLocalHistories());
        final SplitBillHistoriesResultMapper splitBillHistoriesResultMapper = this.splitBillHistoriesResultMapper;
        Objects.requireNonNull(splitBillHistoriesResultMapper);
        return just.map(new Function() { // from class: id.dana.data.splitbill.repository.source.persistence.PersistenceSplitBillEntityData$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitBillHistoriesResultMapper.this.apply((List) obj);
            }
        });
    }

    @Override // id.dana.data.splitbill.repository.source.SplitBillEntityData
    public Observable<Boolean> updateSplitBillHistories(final List<SplitBillHistoryEntity> list) {
        return Observable.defer(new Callable() { // from class: id.dana.data.splitbill.repository.source.persistence.PersistenceSplitBillEntityData$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PersistenceSplitBillEntityData.this.m2046x2ffd20b1(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$updateSplitBillHistories$2$id-dana-data-splitbill-repository-source-persistence-PersistenceSplitBillEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m2046x2ffd20b1(List list) throws Exception {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SplitBillHistoryEntity splitBillHistoryEntity = (SplitBillHistoryEntity) it.next();
            SplitBillHistoryEntity historyById = getDb().splitBillHistoryDao().getHistoryById(splitBillHistoryEntity.getSplitBillId());
            if (historyById != null) {
                updateSplitBillStatus(splitBillHistoryEntity, historyById);
            } else {
                getSplitBillDao().saveSplitBillHistory(splitBillHistoryEntity);
            }
        }
        return Observable.just(Boolean.TRUE);
    }

    @Override // id.dana.data.splitbill.repository.source.SplitBillEntityData
    public void clearAll() {
        getDb().splitBillHistoryDao().clearAll();
    }

    @Override // id.dana.data.splitbill.repository.source.SplitBillEntityData
    public Observable<GetSplitBillDetailResult> getSplitBillDetail(final String str) {
        return Observable.defer(new Callable() { // from class: id.dana.data.splitbill.repository.source.persistence.PersistenceSplitBillEntityData$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PersistenceSplitBillEntityData.this.m2042x79dd1a94(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getSplitBillDetail$3$id-dana-data-splitbill-repository-source-persistence-PersistenceSplitBillEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m2042x79dd1a94(String str) throws Exception {
        Observable just = Observable.just(getSplitBillDao().getHistoryById(str));
        final SplitBillHistoryEntityToSplitBillDetailResult splitBillHistoryEntityToSplitBillDetailResult = this.splitBillDetailResultMapper;
        Objects.requireNonNull(splitBillHistoryEntityToSplitBillDetailResult);
        return just.map(new Function() { // from class: id.dana.data.splitbill.repository.source.persistence.PersistenceSplitBillEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitBillHistoryEntityToSplitBillDetailResult.this.apply((SplitBillHistoryEntity) obj);
            }
        });
    }

    @Override // id.dana.data.splitbill.repository.source.SplitBillEntityData
    public Observable<Boolean> updateSplitBillDetail(final SplitBillHistoryEntity splitBillHistoryEntity) {
        return Observable.defer(new Callable() { // from class: id.dana.data.splitbill.repository.source.persistence.PersistenceSplitBillEntityData$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PersistenceSplitBillEntityData.this.m2045x822134e8(splitBillHistoryEntity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$updateSplitBillDetail$4$id-dana-data-splitbill-repository-source-persistence-PersistenceSplitBillEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m2045x822134e8(SplitBillHistoryEntity splitBillHistoryEntity) throws Exception {
        SplitBillHistoryEntity historyById = getDb().splitBillHistoryDao().getHistoryById(splitBillHistoryEntity.getSplitBillId());
        if (historyById != null) {
            updateSplitBillHistory(historyById, splitBillHistoryEntity);
        } else {
            getSplitBillDao().saveSplitBillHistory(splitBillHistoryEntity);
        }
        return Observable.just(Boolean.TRUE);
    }

    private void updateSplitBillStatus(SplitBillHistoryEntity splitBillHistoryEntity, SplitBillHistoryEntity splitBillHistoryEntity2) {
        splitBillHistoryEntity2.setStatus(splitBillHistoryEntity.getStatus());
        splitBillHistoryEntity2.setLastUpdated(CommonUtil.KClassImpl$Data$declaredNonStaticMembers$2());
        splitBillHistoryEntity2.setCreatedDate(splitBillHistoryEntity.getCreatedDate());
        getSplitBillDao().updateSplitBillHistoryEntity(splitBillHistoryEntity2);
    }

    private List<SplitBillHistoryEntity> getLocalHistories() {
        return getSplitBillDao().getSplitBillHistories();
    }

    private void updateSplitBillHistory(SplitBillHistoryEntity splitBillHistoryEntity, SplitBillHistoryEntity splitBillHistoryEntity2) {
        splitBillHistoryEntity.setLastUpdated(CommonUtil.KClassImpl$Data$declaredNonStaticMembers$2());
        splitBillHistoryEntity.setPayers(splitBillHistoryEntity2.getPayers());
        splitBillHistoryEntity.setStatus(splitBillHistoryEntity2.getStatus());
        getSplitBillDao().updateSplitBillHistoryEntity(splitBillHistoryEntity);
    }

    private SplitBillHistoryDao getSplitBillDao() {
        return getDb().splitBillHistoryDao();
    }

    @Override // id.dana.data.splitbill.repository.source.SplitBillEntityData
    public Observable<BaseRpcResult> closePayers(List<String> list, String str) {
        throw new UnsupportedOperationException();
    }
}
