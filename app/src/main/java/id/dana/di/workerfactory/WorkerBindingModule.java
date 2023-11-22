package id.dana.di.workerfactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import id.dana.data.user.UserInfoWorker;
import id.dana.pushverify.worker.PushVerifyWorker;
import id.dana.synccontact.worker.syncallcontact.SyncAllContactWorker;
import id.dana.synccontact.worker.syncallcontact.SyncAllContactWorkerFactory;
import id.dana.synccontact.worker.syncnewcontact.SyncChangedContactWorker;
import id.dana.synccontact.worker.syncnewcontact.SyncChangedContactWorkerFactory;

@Module
/* loaded from: classes2.dex */
public interface WorkerBindingModule {
    @Binds
    @IntoMap
    @WorkerKey(SyncAllContactWorker.class)
    ChildWorkerFactory BuiltInFictitiousFunctionClassFactory(SyncAllContactWorkerFactory syncAllContactWorkerFactory);

    @Binds
    @IntoMap
    @WorkerKey(PushVerifyWorker.class)
    ChildWorkerFactory KClassImpl$Data$declaredNonStaticMembers$2(PushVerifyWorkerFactory pushVerifyWorkerFactory);

    @Binds
    @IntoMap
    @WorkerKey(UserInfoWorker.class)
    ChildWorkerFactory PlaceComponentResult(UserInfoWorkerFactory userInfoWorkerFactory);

    @Binds
    @IntoMap
    @WorkerKey(SyncChangedContactWorker.class)
    ChildWorkerFactory getAuthRequestContext(SyncChangedContactWorkerFactory syncChangedContactWorkerFactory);
}
