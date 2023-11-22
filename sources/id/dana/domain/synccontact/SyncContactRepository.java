package id.dana.domain.synccontact;

import id.dana.domain.sendmoney.model.UserContact;
import id.dana.domain.synccontact.model.Contact;
import id.dana.domain.synccontact.model.ContactSyncConfig;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes2.dex */
public interface SyncContactRepository {
    Observable<ContactSyncConfig> getContactSyncConfig();

    Observable<Contact> getLastSyncedContact();

    Observable<Boolean> isSyncProcessCompleted();

    Observable<Boolean> saveSyncProcessStatusComplete();

    Observable<Boolean> syncContact(List<String> list, Contact contact, List<UserContact> list2);

    Observable<Boolean> syncOneContact(String str, UserContact userContact);
}
