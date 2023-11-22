package id.dana.data.synccontact.repository.source.local;

import android.content.Context;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import id.dana.data.synccontact.model.ContactEntity;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class SyncContactPreferences {
    private static final String SYNC_CONTACT_PREFERENCES;
    private final PreferenceFacade preferenceFacade;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("SyncContactPreferences");
        sb.append("production");
        SYNC_CONTACT_PREFERENCES = sb.toString();
    }

    @Inject
    public SyncContactPreferences(Context context, Serializer serializer) {
        this.preferenceFacade = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(SYNC_CONTACT_PREFERENCES).setUseDrutherPreference(true).setSerializerFacade(serializer)).createData2("local");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSyncContactProgressDone() {
        return this.preferenceFacade.getBoolean("is_sync_process_completed").booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean saveSyncProcessCompleteStatus() {
        this.preferenceFacade.saveData("is_sync_process_completed", Boolean.TRUE);
        return true;
    }

    public ContactEntity getLastSyncedContact() {
        ContactEntity contactEntity = (ContactEntity) this.preferenceFacade.getObject("last_synced_contact", ContactEntity.class);
        return contactEntity == null ? new ContactEntity() : contactEntity;
    }

    public boolean saveLastSyncedContact(ContactEntity contactEntity) {
        this.preferenceFacade.saveData("last_synced_contact", (String) contactEntity);
        return true;
    }

    /* loaded from: classes8.dex */
    static class Key {
        private Key() {
        }
    }
}
