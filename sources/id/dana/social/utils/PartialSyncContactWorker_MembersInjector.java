package id.dana.social.utils;

import dagger.MembersInjector;
import id.dana.feeds.domain.synccontact.SyncRunner;
import javax.inject.Named;

/* loaded from: classes2.dex */
public final class PartialSyncContactWorker_MembersInjector implements MembersInjector<PartialSyncContactWorker> {
    @Named("partialsync")
    public static void PlaceComponentResult(PartialSyncContactWorker partialSyncContactWorker, SyncRunner syncRunner) {
        partialSyncContactWorker.syncRunner = syncRunner;
    }
}
