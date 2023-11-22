package id.dana.social.workmanager;

import dagger.MembersInjector;
import id.dana.feeds.domain.synccontact.SyncRunner;
import javax.inject.Named;

/* loaded from: classes2.dex */
public final class SaveContactFullSyncWorker_MembersInjector implements MembersInjector<SaveContactFullSyncWorker> {
    @Named("recurringfullsync")
    public static void getAuthRequestContext(SaveContactFullSyncWorker saveContactFullSyncWorker, SyncRunner syncRunner) {
        saveContactFullSyncWorker.syncRunner = syncRunner;
    }
}
