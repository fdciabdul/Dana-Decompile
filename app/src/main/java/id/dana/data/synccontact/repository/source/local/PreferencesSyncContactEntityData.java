package id.dana.data.synccontact.repository.source.local;

import id.dana.data.synccontact.SyncContactEntityData;
import id.dana.data.synccontact.model.ContactEntity;
import id.dana.data.synccontact.repository.source.network.result.BizTransferSyncContactResult;
import id.dana.domain.sendmoney.model.UserContact;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class PreferencesSyncContactEntityData implements SyncContactEntityData {
    private final SyncContactPreferences syncContactPreferences;

    @Inject
    public PreferencesSyncContactEntityData(SyncContactPreferences syncContactPreferences) {
        this.syncContactPreferences = syncContactPreferences;
    }

    @Override // id.dana.data.synccontact.SyncContactEntityData
    public Observable<BizTransferSyncContactResult> syncContact(List<String> list, List<UserContact> list2) {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.synccontact.SyncContactEntityData
    public Observable<Boolean> isSyncProcessCompleted() {
        return Observable.just(Boolean.valueOf(this.syncContactPreferences.isSyncContactProgressDone()));
    }

    @Override // id.dana.data.synccontact.SyncContactEntityData
    public Observable<Boolean> saveSyncProcessStatusComplete() {
        return Observable.just(Boolean.valueOf(this.syncContactPreferences.saveSyncProcessCompleteStatus()));
    }

    @Override // id.dana.data.synccontact.SyncContactEntityData
    public Observable<ContactEntity> getLastSyncedContact() {
        return Observable.just(this.syncContactPreferences.getLastSyncedContact());
    }

    @Override // id.dana.data.synccontact.SyncContactEntityData
    public Observable<Boolean> saveLastSyncedContact(ContactEntity contactEntity) {
        return Observable.just(Boolean.valueOf(this.syncContactPreferences.saveLastSyncedContact(contactEntity)));
    }
}
