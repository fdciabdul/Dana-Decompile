package id.dana.domain.synccontact.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.synccontact.SyncContactRepository;
import id.dana.domain.synccontact.model.ContactSyncConfig;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class GetContactSyncConfig extends UseCase<ContactSyncConfig, Void> {
    private final SyncContactRepository syncContactRepository;

    @Inject
    public GetContactSyncConfig(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SyncContactRepository syncContactRepository) {
        super(threadExecutor, postExecutionThread);
        this.syncContactRepository = syncContactRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<ContactSyncConfig> buildUseCaseObservable(Void r1) {
        return this.syncContactRepository.getContactSyncConfig();
    }
}
