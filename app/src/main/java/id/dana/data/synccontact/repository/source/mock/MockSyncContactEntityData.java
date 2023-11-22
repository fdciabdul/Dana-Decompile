package id.dana.data.synccontact.repository.source.mock;

import id.dana.data.synccontact.SyncContactEntityData;
import id.dana.data.synccontact.model.ContactEntity;
import id.dana.data.synccontact.repository.source.network.result.BizTransferSyncContactResult;
import id.dana.domain.sendmoney.model.UserContact;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class MockSyncContactEntityData implements SyncContactEntityData {
    @Inject
    public MockSyncContactEntityData() {
    }

    @Override // id.dana.data.synccontact.SyncContactEntityData
    public Observable<BizTransferSyncContactResult> syncContact(List<String> list, List<UserContact> list2) {
        return Observable.just(getSyncContactRpcResult(list));
    }

    @Override // id.dana.data.synccontact.SyncContactEntityData
    public Observable<Boolean> isSyncProcessCompleted() {
        return Observable.just(Boolean.TRUE);
    }

    @Override // id.dana.data.synccontact.SyncContactEntityData
    public Observable<Boolean> saveSyncProcessStatusComplete() {
        return Observable.just(Boolean.TRUE);
    }

    @Override // id.dana.data.synccontact.SyncContactEntityData
    public Observable<ContactEntity> getLastSyncedContact() {
        return Observable.just(new ContactEntity());
    }

    @Override // id.dana.data.synccontact.SyncContactEntityData
    public Observable<Boolean> saveLastSyncedContact(ContactEntity contactEntity) {
        return Observable.just(Boolean.TRUE);
    }

    private BizTransferSyncContactResult getSyncContactRpcResult(List<String> list) {
        BizTransferSyncContactResult bizTransferSyncContactResult = new BizTransferSyncContactResult();
        bizTransferSyncContactResult.registeredUsers = list;
        bizTransferSyncContactResult.success = true;
        return bizTransferSyncContactResult;
    }
}
