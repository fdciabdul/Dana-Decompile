package id.dana.data.recentrecipient.source.persistence;

import dagger.Lazy;
import id.dana.data.base.BasePersistence;
import id.dana.data.base.BasePersistenceDao;
import id.dana.data.recentbank.repository.source.persistance.entity.SecureRecentBankEntity;
import id.dana.data.recentrecipient.mapper.RecentRecipientMapperKt;
import id.dana.data.recentrecipient.source.RecentRecipientEntityData;
import id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao;
import id.dana.data.recentrecipient.source.persistence.entity.RecentRecipientEntity;
import id.dana.wallet_v3.constant.WalletConstant;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0007\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u00020201¢\u0006\u0004\b4\u00105J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\tJ\u001b\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\tJ+\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00062\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0018J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0019\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001a\u0010\u000eJ\u001b\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00130\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\tJ#\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00130\u00062\u0006\u0010\u0016\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001b\u0010\u000eJ\u001b\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00130\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\tJ#\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00130\u00062\u0006\u0010\u0016\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\u000eJ\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001d\u0010\u000eJ-\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0004\b!\u0010\"J\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u001e\u001a\u00020\u0014H\u0016¢\u0006\u0004\b#\u0010$J\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010%\u001a\u00020\u0011H\u0016¢\u0006\u0004\b&\u0010'J\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010(\u001a\u00020\u0011H\u0016¢\u0006\u0004\b)\u0010'J)\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0*0\u00062\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013H\u0016¢\u0006\u0004\b)\u0010+J\u0017\u0010,\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0011H\u0002¢\u0006\u0004\b,\u0010-R\u0018\u0010/\u001a\u0006*\u00020.0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100"}, d2 = {"Lid/dana/data/recentrecipient/source/persistence/PersistenceRecentRecipientEntityData;", "Lid/dana/data/base/BasePersistence;", "Lid/dana/data/recentrecipient/source/RecentRecipientEntityData;", "", "clearAll", "()V", "Lio/reactivex/Observable;", "", "getFavoriteAccountCount", "()Lio/reactivex/Observable;", "", "id", "", "getGroupFavoriteValue", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "getLastUpdatedTime", "Lid/dana/data/recentrecipient/source/persistence/entity/RecentRecipientEntity;", "getLeastTransactionFavoriteAccount", "", "Lid/dana/data/recentbank/repository/source/persistance/entity/SecureRecentBankEntity;", "getRecentBank", "filter", "maxItem", "(Ljava/lang/String;I)Lio/reactivex/Observable;", WalletConstant.CARD_INDEX_NO, "getRecentBankTransactionCount", "getRecentGroup", "getRecentRecipient", "getRecentRecipientTransactionCount", "bankEntity", "removeAllRecentBank", "(Ljava/lang/String;ILid/dana/data/recentbank/repository/source/persistance/entity/SecureRecentBankEntity;)Lio/reactivex/Observable;", "removeOldestSavedBanks", "(I)V", "removeRecentBank", "(Lid/dana/data/recentbank/repository/source/persistance/entity/SecureRecentBankEntity;)Lio/reactivex/Observable;", "recentRecipient", "removeRecentRecipient", "(Lid/dana/data/recentrecipient/source/persistence/entity/RecentRecipientEntity;)Lio/reactivex/Observable;", "recentRecipientEntity", "saveRecentRecipient", "", "(Ljava/util/List;)Lio/reactivex/Observable;", "setDataId", "(Lid/dana/data/recentrecipient/source/persistence/entity/RecentRecipientEntity;)V", "Lid/dana/data/recentrecipient/source/persistence/dao/RecentRecipientDao;", "recentRecipientDao", "Lid/dana/data/recentrecipient/source/persistence/dao/RecentRecipientDao;", "Ldagger/Lazy;", "Lid/dana/data/base/BasePersistenceDao;", "basePersistenceDao", "<init>", "(Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PersistenceRecentRecipientEntityData extends BasePersistence implements RecentRecipientEntityData {
    private final RecentRecipientDao recentRecipientDao;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public PersistenceRecentRecipientEntityData(Lazy<BasePersistenceDao> lazy) {
        super(lazy);
        Intrinsics.checkNotNullParameter(lazy, "");
        this.recentRecipientDao = getDb().recentRecipientDao();
    }

    @Override // id.dana.data.recentrecipient.source.RecentRecipientEntityData
    public final Observable<List<RecentRecipientEntity>> getRecentRecipient() {
        Observable<List<RecentRecipientEntity>> defer = Observable.defer(new Callable() { // from class: id.dana.data.recentrecipient.source.persistence.PersistenceRecentRecipientEntityData$$ExternalSyntheticLambda15
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource m1767getRecentRecipient$lambda1;
                m1767getRecentRecipient$lambda1 = PersistenceRecentRecipientEntityData.m1767getRecentRecipient$lambda1(PersistenceRecentRecipientEntityData.this);
                return m1767getRecentRecipient$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRecentRecipient$lambda-1  reason: not valid java name */
    public static final ObservableSource m1767getRecentRecipient$lambda1(PersistenceRecentRecipientEntityData persistenceRecentRecipientEntityData) {
        Intrinsics.checkNotNullParameter(persistenceRecentRecipientEntityData, "");
        return Observable.just(persistenceRecentRecipientEntityData.recentRecipientDao.getRecentRecipientList());
    }

    @Override // id.dana.data.recentrecipient.source.RecentRecipientEntityData
    public final Observable<List<RecentRecipientEntity>> getRecentRecipient(final String filter) {
        Intrinsics.checkNotNullParameter(filter, "");
        Observable<List<RecentRecipientEntity>> defer = Observable.defer(new Callable() { // from class: id.dana.data.recentrecipient.source.persistence.PersistenceRecentRecipientEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource m1768getRecentRecipient$lambda3;
                m1768getRecentRecipient$lambda3 = PersistenceRecentRecipientEntityData.m1768getRecentRecipient$lambda3(PersistenceRecentRecipientEntityData.this, filter);
                return m1768getRecentRecipient$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRecentRecipient$lambda-3  reason: not valid java name */
    public static final ObservableSource m1768getRecentRecipient$lambda3(PersistenceRecentRecipientEntityData persistenceRecentRecipientEntityData, String str) {
        Intrinsics.checkNotNullParameter(persistenceRecentRecipientEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        return Observable.just(persistenceRecentRecipientEntityData.recentRecipientDao.getRecentRecipientList(str));
    }

    @Override // id.dana.data.recentrecipient.source.RecentRecipientEntityData
    public final Observable<Long> saveRecentRecipient(final RecentRecipientEntity recentRecipientEntity) {
        Intrinsics.checkNotNullParameter(recentRecipientEntity, "");
        Observable<Long> defer = Observable.defer(new Callable() { // from class: id.dana.data.recentrecipient.source.persistence.PersistenceRecentRecipientEntityData$$ExternalSyntheticLambda14
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource m1773saveRecentRecipient$lambda4;
                m1773saveRecentRecipient$lambda4 = PersistenceRecentRecipientEntityData.m1773saveRecentRecipient$lambda4(PersistenceRecentRecipientEntityData.this, recentRecipientEntity);
                return m1773saveRecentRecipient$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveRecentRecipient$lambda-4  reason: not valid java name */
    public static final ObservableSource m1773saveRecentRecipient$lambda4(PersistenceRecentRecipientEntityData persistenceRecentRecipientEntityData, RecentRecipientEntity recentRecipientEntity) {
        Intrinsics.checkNotNullParameter(persistenceRecentRecipientEntityData, "");
        Intrinsics.checkNotNullParameter(recentRecipientEntity, "");
        persistenceRecentRecipientEntityData.setDataId(recentRecipientEntity);
        return Observable.just(Long.valueOf(persistenceRecentRecipientEntityData.recentRecipientDao.insertOrUpdate(recentRecipientEntity)));
    }

    @Override // id.dana.data.recentrecipient.source.RecentRecipientEntityData
    public final Observable<Long[]> saveRecentRecipient(final List<RecentRecipientEntity> recentRecipientEntity) {
        Intrinsics.checkNotNullParameter(recentRecipientEntity, "");
        Observable<Long[]> defer = Observable.defer(new Callable() { // from class: id.dana.data.recentrecipient.source.persistence.PersistenceRecentRecipientEntityData$$ExternalSyntheticLambda16
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource m1774saveRecentRecipient$lambda6;
                m1774saveRecentRecipient$lambda6 = PersistenceRecentRecipientEntityData.m1774saveRecentRecipient$lambda6(recentRecipientEntity, this);
                return m1774saveRecentRecipient$lambda6;
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveRecentRecipient$lambda-6  reason: not valid java name */
    public static final ObservableSource m1774saveRecentRecipient$lambda6(List list, PersistenceRecentRecipientEntityData persistenceRecentRecipientEntityData) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(persistenceRecentRecipientEntityData, "");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            persistenceRecentRecipientEntityData.setDataId((RecentRecipientEntity) it.next());
        }
        return Observable.just(persistenceRecentRecipientEntityData.recentRecipientDao.insertOrUpdate(list));
    }

    @Override // id.dana.data.recentrecipient.source.RecentRecipientEntityData
    public final Observable<Integer> removeRecentRecipient(final RecentRecipientEntity recentRecipient) {
        Intrinsics.checkNotNullParameter(recentRecipient, "");
        Observable<Integer> defer = Observable.defer(new Callable() { // from class: id.dana.data.recentrecipient.source.persistence.PersistenceRecentRecipientEntityData$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource m1772removeRecentRecipient$lambda7;
                m1772removeRecentRecipient$lambda7 = PersistenceRecentRecipientEntityData.m1772removeRecentRecipient$lambda7(RecentRecipientEntity.this, this);
                return m1772removeRecentRecipient$lambda7;
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: removeRecentRecipient$lambda-7  reason: not valid java name */
    public static final ObservableSource m1772removeRecentRecipient$lambda7(RecentRecipientEntity recentRecipientEntity, PersistenceRecentRecipientEntityData persistenceRecentRecipientEntityData) {
        Intrinsics.checkNotNullParameter(recentRecipientEntity, "");
        Intrinsics.checkNotNullParameter(persistenceRecentRecipientEntityData, "");
        if (recentRecipientEntity.getType() == 1) {
            RecentRecipientDao recentRecipientDao = persistenceRecentRecipientEntityData.recentRecipientDao;
            String cardIndexNo = recentRecipientEntity.getCardIndexNo();
            return Observable.just(Integer.valueOf(recentRecipientDao.removeRecentBank(cardIndexNo != null ? cardIndexNo : "")));
        }
        RecentRecipientDao recentRecipientDao2 = persistenceRecentRecipientEntityData.recentRecipientDao;
        String id2 = recentRecipientEntity.getId();
        return Observable.just(Integer.valueOf(recentRecipientDao2.removeRecentRecipient(id2 != null ? id2 : "")));
    }

    @Override // id.dana.data.recentrecipient.source.RecentRecipientEntityData
    public final Observable<List<SecureRecentBankEntity>> getRecentBank() {
        Observable<List<SecureRecentBankEntity>> defer = Observable.defer(new Callable() { // from class: id.dana.data.recentrecipient.source.persistence.PersistenceRecentRecipientEntityData$$ExternalSyntheticLambda10
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource m1763getRecentBank$lambda9;
                m1763getRecentBank$lambda9 = PersistenceRecentRecipientEntityData.m1763getRecentBank$lambda9(PersistenceRecentRecipientEntityData.this);
                return m1763getRecentBank$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRecentBank$lambda-9  reason: not valid java name */
    public static final ObservableSource m1763getRecentBank$lambda9(PersistenceRecentRecipientEntityData persistenceRecentRecipientEntityData) {
        Intrinsics.checkNotNullParameter(persistenceRecentRecipientEntityData, "");
        return Observable.just(RecentRecipientMapperKt.toRecentBankRecipientList(persistenceRecentRecipientEntityData.recentRecipientDao.getRecentBankList()));
    }

    @Override // id.dana.data.recentrecipient.source.RecentRecipientEntityData
    public final Observable<List<SecureRecentBankEntity>> getRecentBank(final String filter, final int maxItem) {
        Intrinsics.checkNotNullParameter(filter, "");
        Observable<List<SecureRecentBankEntity>> defer = Observable.defer(new Callable() { // from class: id.dana.data.recentrecipient.source.persistence.PersistenceRecentRecipientEntityData$$ExternalSyntheticLambda9
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource m1762getRecentBank$lambda10;
                m1762getRecentBank$lambda10 = PersistenceRecentRecipientEntityData.m1762getRecentBank$lambda10(PersistenceRecentRecipientEntityData.this, filter, maxItem);
                return m1762getRecentBank$lambda10;
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRecentBank$lambda-10  reason: not valid java name */
    public static final ObservableSource m1762getRecentBank$lambda10(PersistenceRecentRecipientEntityData persistenceRecentRecipientEntityData, String str, int i) {
        Intrinsics.checkNotNullParameter(persistenceRecentRecipientEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        ArrayList arrayList = new ArrayList();
        List<RecentRecipientEntity> recentBankList = persistenceRecentRecipientEntityData.recentRecipientDao.getRecentBankList();
        if (str.length() == 0) {
            if (recentBankList.size() > i) {
                persistenceRecentRecipientEntityData.removeOldestSavedBanks(i);
            }
            arrayList.addAll(RecentRecipientMapperKt.toRecentBankRecipientList(persistenceRecentRecipientEntityData.recentRecipientDao.getRecentBankList()));
        } else {
            arrayList.addAll(RecentRecipientMapperKt.toRecentBankRecipientList(persistenceRecentRecipientEntityData.recentRecipientDao.getRecentBankList(str, i)));
        }
        return Observable.just(arrayList);
    }

    @Override // id.dana.data.recentrecipient.source.RecentRecipientEntityData
    public final Observable<Integer> removeRecentBank(final SecureRecentBankEntity bankEntity) {
        Intrinsics.checkNotNullParameter(bankEntity, "");
        Observable<Integer> defer = Observable.defer(new Callable() { // from class: id.dana.data.recentrecipient.source.persistence.PersistenceRecentRecipientEntityData$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource m1771removeRecentBank$lambda11;
                m1771removeRecentBank$lambda11 = PersistenceRecentRecipientEntityData.m1771removeRecentBank$lambda11(PersistenceRecentRecipientEntityData.this, bankEntity);
                return m1771removeRecentBank$lambda11;
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: removeRecentBank$lambda-11  reason: not valid java name */
    public static final ObservableSource m1771removeRecentBank$lambda11(PersistenceRecentRecipientEntityData persistenceRecentRecipientEntityData, SecureRecentBankEntity secureRecentBankEntity) {
        Intrinsics.checkNotNullParameter(persistenceRecentRecipientEntityData, "");
        Intrinsics.checkNotNullParameter(secureRecentBankEntity, "");
        RecentRecipientDao recentRecipientDao = persistenceRecentRecipientEntityData.recentRecipientDao;
        String cardIndexNo = secureRecentBankEntity.getCardIndexNo();
        Intrinsics.checkNotNullExpressionValue(cardIndexNo, "");
        return Observable.just(Integer.valueOf(recentRecipientDao.removeRecentBank(cardIndexNo)));
    }

    @Override // id.dana.data.recentrecipient.source.RecentRecipientEntityData
    public final Observable<Integer> removeAllRecentBank(String filter, int maxItem, SecureRecentBankEntity bankEntity) {
        Intrinsics.checkNotNullParameter(filter, "");
        Intrinsics.checkNotNullParameter(bankEntity, "");
        Observable<Integer> defer = Observable.defer(new Callable() { // from class: id.dana.data.recentrecipient.source.persistence.PersistenceRecentRecipientEntityData$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource m1770removeAllRecentBank$lambda12;
                m1770removeAllRecentBank$lambda12 = PersistenceRecentRecipientEntityData.m1770removeAllRecentBank$lambda12(PersistenceRecentRecipientEntityData.this);
                return m1770removeAllRecentBank$lambda12;
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: removeAllRecentBank$lambda-12  reason: not valid java name */
    public static final ObservableSource m1770removeAllRecentBank$lambda12(PersistenceRecentRecipientEntityData persistenceRecentRecipientEntityData) {
        Intrinsics.checkNotNullParameter(persistenceRecentRecipientEntityData, "");
        return Observable.just(Integer.valueOf(persistenceRecentRecipientEntityData.recentRecipientDao.removeAllRecentBank()));
    }

    @Override // id.dana.data.recentrecipient.source.RecentRecipientEntityData
    public final Observable<List<RecentRecipientEntity>> getRecentGroup() {
        Observable<List<RecentRecipientEntity>> defer = Observable.defer(new Callable() { // from class: id.dana.data.recentrecipient.source.persistence.PersistenceRecentRecipientEntityData$$ExternalSyntheticLambda11
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource m1765getRecentGroup$lambda14;
                m1765getRecentGroup$lambda14 = PersistenceRecentRecipientEntityData.m1765getRecentGroup$lambda14(PersistenceRecentRecipientEntityData.this);
                return m1765getRecentGroup$lambda14;
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRecentGroup$lambda-14  reason: not valid java name */
    public static final ObservableSource m1765getRecentGroup$lambda14(PersistenceRecentRecipientEntityData persistenceRecentRecipientEntityData) {
        Intrinsics.checkNotNullParameter(persistenceRecentRecipientEntityData, "");
        return Observable.just(persistenceRecentRecipientEntityData.recentRecipientDao.getRecentGroupList());
    }

    @Override // id.dana.data.recentrecipient.source.RecentRecipientEntityData
    public final Observable<List<RecentRecipientEntity>> getRecentGroup(final String filter) {
        Intrinsics.checkNotNullParameter(filter, "");
        Observable<List<RecentRecipientEntity>> defer = Observable.defer(new Callable() { // from class: id.dana.data.recentrecipient.source.persistence.PersistenceRecentRecipientEntityData$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource m1766getRecentGroup$lambda16;
                m1766getRecentGroup$lambda16 = PersistenceRecentRecipientEntityData.m1766getRecentGroup$lambda16(PersistenceRecentRecipientEntityData.this, filter);
                return m1766getRecentGroup$lambda16;
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRecentGroup$lambda-16  reason: not valid java name */
    public static final ObservableSource m1766getRecentGroup$lambda16(PersistenceRecentRecipientEntityData persistenceRecentRecipientEntityData, String str) {
        Intrinsics.checkNotNullParameter(persistenceRecentRecipientEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        return Observable.just(persistenceRecentRecipientEntityData.recentRecipientDao.getRecentGroupList(str));
    }

    @Override // id.dana.data.recentrecipient.source.RecentRecipientEntityData
    public final Observable<Integer> getRecentBankTransactionCount(final String cardIndexNo) {
        Intrinsics.checkNotNullParameter(cardIndexNo, "");
        Observable<Integer> defer = Observable.defer(new Callable() { // from class: id.dana.data.recentrecipient.source.persistence.PersistenceRecentRecipientEntityData$$ExternalSyntheticLambda12
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource m1764getRecentBankTransactionCount$lambda17;
                m1764getRecentBankTransactionCount$lambda17 = PersistenceRecentRecipientEntityData.m1764getRecentBankTransactionCount$lambda17(PersistenceRecentRecipientEntityData.this, cardIndexNo);
                return m1764getRecentBankTransactionCount$lambda17;
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRecentBankTransactionCount$lambda-17  reason: not valid java name */
    public static final ObservableSource m1764getRecentBankTransactionCount$lambda17(PersistenceRecentRecipientEntityData persistenceRecentRecipientEntityData, String str) {
        Intrinsics.checkNotNullParameter(persistenceRecentRecipientEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        return Observable.just(Integer.valueOf(persistenceRecentRecipientEntityData.recentRecipientDao.getRecentBankTransactionCount(str)));
    }

    @Override // id.dana.data.recentrecipient.source.RecentRecipientEntityData
    public final Observable<Integer> getRecentRecipientTransactionCount(final String id2) {
        Intrinsics.checkNotNullParameter(id2, "");
        Observable<Integer> defer = Observable.defer(new Callable() { // from class: id.dana.data.recentrecipient.source.persistence.PersistenceRecentRecipientEntityData$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource m1769getRecentRecipientTransactionCount$lambda18;
                m1769getRecentRecipientTransactionCount$lambda18 = PersistenceRecentRecipientEntityData.m1769getRecentRecipientTransactionCount$lambda18(PersistenceRecentRecipientEntityData.this, id2);
                return m1769getRecentRecipientTransactionCount$lambda18;
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRecentRecipientTransactionCount$lambda-18  reason: not valid java name */
    public static final ObservableSource m1769getRecentRecipientTransactionCount$lambda18(PersistenceRecentRecipientEntityData persistenceRecentRecipientEntityData, String str) {
        Intrinsics.checkNotNullParameter(persistenceRecentRecipientEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        return Observable.just(Integer.valueOf(persistenceRecentRecipientEntityData.recentRecipientDao.getRecentTransactionTransactionCount(str)));
    }

    @Override // id.dana.data.recentrecipient.source.RecentRecipientEntityData
    public final Observable<Integer> getFavoriteAccountCount() {
        Observable<Integer> defer = Observable.defer(new Callable() { // from class: id.dana.data.recentrecipient.source.persistence.PersistenceRecentRecipientEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource m1758getFavoriteAccountCount$lambda19;
                m1758getFavoriteAccountCount$lambda19 = PersistenceRecentRecipientEntityData.m1758getFavoriteAccountCount$lambda19(PersistenceRecentRecipientEntityData.this);
                return m1758getFavoriteAccountCount$lambda19;
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getFavoriteAccountCount$lambda-19  reason: not valid java name */
    public static final ObservableSource m1758getFavoriteAccountCount$lambda19(PersistenceRecentRecipientEntityData persistenceRecentRecipientEntityData) {
        Intrinsics.checkNotNullParameter(persistenceRecentRecipientEntityData, "");
        return Observable.just(Integer.valueOf(persistenceRecentRecipientEntityData.recentRecipientDao.getFavoriteAccountCount()));
    }

    @Override // id.dana.data.recentrecipient.source.RecentRecipientEntityData
    public final Observable<Boolean> getGroupFavoriteValue(final String id2) {
        Intrinsics.checkNotNullParameter(id2, "");
        Observable<Boolean> defer = Observable.defer(new Callable() { // from class: id.dana.data.recentrecipient.source.persistence.PersistenceRecentRecipientEntityData$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource m1759getGroupFavoriteValue$lambda20;
                m1759getGroupFavoriteValue$lambda20 = PersistenceRecentRecipientEntityData.m1759getGroupFavoriteValue$lambda20(PersistenceRecentRecipientEntityData.this, id2);
                return m1759getGroupFavoriteValue$lambda20;
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getGroupFavoriteValue$lambda-20  reason: not valid java name */
    public static final ObservableSource m1759getGroupFavoriteValue$lambda20(PersistenceRecentRecipientEntityData persistenceRecentRecipientEntityData, String str) {
        Intrinsics.checkNotNullParameter(persistenceRecentRecipientEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        return Observable.just(Boolean.valueOf(persistenceRecentRecipientEntityData.recentRecipientDao.getGroupFavoriteValue(str)));
    }

    @Override // id.dana.data.recentrecipient.source.RecentRecipientEntityData
    public final Observable<RecentRecipientEntity> getLeastTransactionFavoriteAccount() {
        Observable<RecentRecipientEntity> defer = Observable.defer(new Callable() { // from class: id.dana.data.recentrecipient.source.persistence.PersistenceRecentRecipientEntityData$$ExternalSyntheticLambda7
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource m1761getLeastTransactionFavoriteAccount$lambda21;
                m1761getLeastTransactionFavoriteAccount$lambda21 = PersistenceRecentRecipientEntityData.m1761getLeastTransactionFavoriteAccount$lambda21(PersistenceRecentRecipientEntityData.this);
                return m1761getLeastTransactionFavoriteAccount$lambda21;
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getLeastTransactionFavoriteAccount$lambda-21  reason: not valid java name */
    public static final ObservableSource m1761getLeastTransactionFavoriteAccount$lambda21(PersistenceRecentRecipientEntityData persistenceRecentRecipientEntityData) {
        Intrinsics.checkNotNullParameter(persistenceRecentRecipientEntityData, "");
        return Observable.just(persistenceRecentRecipientEntityData.recentRecipientDao.getLeastTransactionFavoriteAccount());
    }

    @Override // id.dana.data.recentrecipient.source.RecentRecipientEntityData
    public final Observable<Long> getLastUpdatedTime(final String id2) {
        Intrinsics.checkNotNullParameter(id2, "");
        Observable<Long> defer = Observable.defer(new Callable() { // from class: id.dana.data.recentrecipient.source.persistence.PersistenceRecentRecipientEntityData$$ExternalSyntheticLambda13
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource m1760getLastUpdatedTime$lambda22;
                m1760getLastUpdatedTime$lambda22 = PersistenceRecentRecipientEntityData.m1760getLastUpdatedTime$lambda22(PersistenceRecentRecipientEntityData.this, id2);
                return m1760getLastUpdatedTime$lambda22;
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getLastUpdatedTime$lambda-22  reason: not valid java name */
    public static final ObservableSource m1760getLastUpdatedTime$lambda22(PersistenceRecentRecipientEntityData persistenceRecentRecipientEntityData, String str) {
        Intrinsics.checkNotNullParameter(persistenceRecentRecipientEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        return Observable.just(Long.valueOf(persistenceRecentRecipientEntityData.recentRecipientDao.getLastUpdatedTime(str)));
    }

    @Override // id.dana.data.recentrecipient.source.RecentRecipientEntityData
    public final void clearAll() {
        this.recentRecipientDao.removeAll();
    }

    private final void removeOldestSavedBanks(int maxItem) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.recentRecipientDao.getListRecentBankByLastUpdate(true));
        while (arrayList.size() > maxItem) {
            RecentRecipientDao recentRecipientDao = this.recentRecipientDao;
            String cardIndexNo = ((RecentRecipientEntity) arrayList.get(0)).getCardIndexNo();
            if (cardIndexNo == null) {
                cardIndexNo = "";
            }
            recentRecipientDao.removeRecentBank(cardIndexNo);
            arrayList.remove(0);
        }
    }

    private final void setDataId(RecentRecipientEntity recentRecipientEntity) {
        String id2;
        if (recentRecipientEntity.getType() != 1 ? (id2 = recentRecipientEntity.getId()) == null : (id2 = recentRecipientEntity.getCardIndexNo()) == null) {
            id2 = "";
        }
        recentRecipientEntity.setDataId(id2);
    }
}
