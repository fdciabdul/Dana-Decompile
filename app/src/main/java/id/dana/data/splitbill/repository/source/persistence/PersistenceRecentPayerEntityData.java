package id.dana.data.splitbill.repository.source.persistence;

import dagger.Lazy;
import id.dana.data.base.BasePersistence;
import id.dana.data.base.BasePersistenceDao;
import id.dana.data.splitbill.repository.source.RecentPayerEntityData;
import id.dana.data.splitbill.repository.source.persistence.entity.RecentPayerSplitBillEntity;
import id.dana.data.util.NumberUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class PersistenceRecentPayerEntityData extends BasePersistence implements RecentPayerEntityData {
    @Inject
    public PersistenceRecentPayerEntityData(Lazy<BasePersistenceDao> lazy) {
        super(lazy);
    }

    @Override // id.dana.data.splitbill.repository.source.RecentPayerEntityData
    public Observable<List<Long>> saveRecentPayers(final List<RecentPayerSplitBillEntity> list) {
        return Observable.defer(new Callable() { // from class: id.dana.data.splitbill.repository.source.persistence.PersistenceRecentPayerEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PersistenceRecentPayerEntityData.this.m2041x18e53324(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$saveRecentPayers$0$id-dana-data-splitbill-repository-source-persistence-PersistenceRecentPayerEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m2041x18e53324(List list) throws Exception {
        Long valueOf;
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i <= list.size() - 1; i++) {
            RecentPayerSplitBillEntity recentContactByPhoneNumber = getRecentContactByPhoneNumber(((RecentPayerSplitBillEntity) list.get(i)).getUserPhoneNumber());
            if (recentContactByPhoneNumber == null) {
                recentContactByPhoneNumber = getRecentContactByUserId(((RecentPayerSplitBillEntity) list.get(i)).getUserId());
            }
            if (recentContactByPhoneNumber == null) {
                valueOf = getDb().recentPayerSplitBillDao().saveRecentContactSplitBill((RecentPayerSplitBillEntity) list.get(i));
            } else {
                valueOf = Long.valueOf(getDb().recentPayerSplitBillDao().updateRecentContact(mapper((RecentPayerSplitBillEntity) list.get(i), recentContactByPhoneNumber)));
            }
            arrayList.add(valueOf);
        }
        deleteOldRecentPayer();
        return Observable.just(arrayList);
    }

    @Override // id.dana.data.splitbill.repository.source.RecentPayerEntityData
    public Observable<List<RecentPayerSplitBillEntity>> getRecentPayers(final int i) {
        return Observable.defer(new Callable() { // from class: id.dana.data.splitbill.repository.source.persistence.PersistenceRecentPayerEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PersistenceRecentPayerEntityData.this.m2040x45b59da4(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getRecentPayers$1$id-dana-data-splitbill-repository-source-persistence-PersistenceRecentPayerEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m2040x45b59da4(int i) throws Exception {
        return Observable.just(getDb().recentPayerSplitBillDao().getSomeRecentPayer(i));
    }

    @Override // id.dana.data.splitbill.repository.source.RecentPayerEntityData
    public void clearAll() {
        getDb().recentPayerSplitBillDao().removeAllRecentContact();
    }

    private void deleteOldRecentPayer() {
        getDb().recentPayerSplitBillDao().deleteOldRecentPayer();
    }

    private RecentPayerSplitBillEntity getRecentContactByPhoneNumber(String str) {
        return getDb().recentPayerSplitBillDao().getRecentContactByPhoneNumber(str);
    }

    private RecentPayerSplitBillEntity getRecentContactByUserId(String str) {
        return getDb().recentPayerSplitBillDao().getRecentContactByUserId(str);
    }

    private RecentPayerSplitBillEntity mapper(RecentPayerSplitBillEntity recentPayerSplitBillEntity, RecentPayerSplitBillEntity recentPayerSplitBillEntity2) {
        recentPayerSplitBillEntity2.setUserId(recentPayerSplitBillEntity.getUserId());
        recentPayerSplitBillEntity2.setUserPhoneNumber(NumberUtils.getPhoneNumberWithoutMasking(recentPayerSplitBillEntity2.getUserPhoneNumber(), recentPayerSplitBillEntity.getUserPhoneNumber()));
        recentPayerSplitBillEntity2.setAvatar(recentPayerSplitBillEntity.getAvatar());
        recentPayerSplitBillEntity2.setUserNickname(recentPayerSplitBillEntity.getUserNickname());
        recentPayerSplitBillEntity2.setLastUpdated(recentPayerSplitBillEntity.getLastUpdated());
        return recentPayerSplitBillEntity2;
    }
}
