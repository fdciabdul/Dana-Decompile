package id.dana.data.recentcontact.repository.source.persistence;

import dagger.Lazy;
import id.dana.data.base.BasePersistence;
import id.dana.data.base.BasePersistenceDao;
import id.dana.data.recentcontact.repository.source.RecentContactEntityData;
import id.dana.data.recentcontact.repository.source.persistence.entity.DanaUserContactEntity;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class PersistenceRecentContactEntityData extends BasePersistence implements RecentContactEntityData {
    private static final String REGEX_PHONE = "^[0-9-]*";

    private boolean isDanaUserContactExist(DanaUserContactEntity danaUserContactEntity) {
        return danaUserContactEntity != null;
    }

    @Inject
    public PersistenceRecentContactEntityData(Lazy<BasePersistenceDao> lazy) {
        super(lazy);
    }

    @Override // id.dana.data.recentcontact.repository.source.RecentContactEntityData
    public Observable<Long> saveDanaUserContact(final DanaUserContactEntity danaUserContactEntity) {
        return Observable.defer(new Callable() { // from class: id.dana.data.recentcontact.repository.source.persistence.PersistenceRecentContactEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PersistenceRecentContactEntityData.this.m1726x61648543(danaUserContactEntity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$saveDanaUserContact$0$id-dana-data-recentcontact-repository-source-persistence-PersistenceRecentContactEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m1726x61648543(DanaUserContactEntity danaUserContactEntity) throws Exception {
        if (isDanaUserContactExist(getSingleDanaUserRecentContact(danaUserContactEntity.getPhoneNumber()))) {
            return Observable.just(Long.valueOf(getDb().danaUserContactDao().updateDanaUserContact(mapper(r0, danaUserContactEntity))));
        }
        return Observable.just(getDb().danaUserContactDao().insertDanaUserContact(danaUserContactEntity));
    }

    @Override // id.dana.data.recentcontact.repository.source.RecentContactEntityData
    public Observable<List<String>> getDanaUserContact() {
        return Observable.defer(new Callable() { // from class: id.dana.data.recentcontact.repository.source.persistence.PersistenceRecentContactEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PersistenceRecentContactEntityData.this.m1725x314d7f65();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getDanaUserContact$1$id-dana-data-recentcontact-repository-source-persistence-PersistenceRecentContactEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m1725x314d7f65() throws Exception {
        return Observable.just(getDb().danaUserContactDao().getDanaUserPhoneNumber());
    }

    private DanaUserContactEntity getSingleDanaUserRecentContact(String str) {
        return getDb().danaUserContactDao().getDanaUserContactEntity(str);
    }

    private DanaUserContactEntity mapper(DanaUserContactEntity danaUserContactEntity, DanaUserContactEntity danaUserContactEntity2) {
        DanaUserContactEntity danaUserContactEntity3 = new DanaUserContactEntity();
        danaUserContactEntity3.setUid(danaUserContactEntity.getUid());
        danaUserContactEntity3.setUserId(danaUserContactEntity2.getUserId());
        danaUserContactEntity3.setPhoneNumber(danaUserContactEntity2.getPhoneNumber());
        danaUserContactEntity3.setLastUpdated(danaUserContactEntity2.getLastUpdated());
        return danaUserContactEntity3;
    }
}
