package id.dana.social.workmanager;

import dagger.MembersInjector;
import id.dana.feeds.domain.synccontact.SyncRunner;
import javax.inject.Named;

/* loaded from: classes2.dex */
public final class SaveContactPartialSyncWorker_MembersInjector implements MembersInjector<SaveContactPartialSyncWorker> {
    @Named("recurringpartialsync")
    public static void BuiltInFictitiousFunctionClassFactory(SaveContactPartialSyncWorker saveContactPartialSyncWorker, SyncRunner syncRunner) {
        saveContactPartialSyncWorker.syncRunner = syncRunner;
    }
}
