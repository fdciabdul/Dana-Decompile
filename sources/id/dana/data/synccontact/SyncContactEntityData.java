package id.dana.data.synccontact;

import id.dana.data.synccontact.model.ContactEntity;
import id.dana.data.synccontact.repository.source.network.result.BizTransferSyncContactResult;
import id.dana.domain.sendmoney.model.UserContact;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes2.dex */
public interface SyncContactEntityData {
    Observable<ContactEntity> getLastSyncedContact();

    Observable<Boolean> isSyncProcessCompleted();

    Observable<Boolean> saveLastSyncedContact(ContactEntity contactEntity);

    Observable<Boolean> saveSyncProcessStatusComplete();

    Observable<BizTransferSyncContactResult> syncContact(List<String> list, List<UserContact> list2);
}
