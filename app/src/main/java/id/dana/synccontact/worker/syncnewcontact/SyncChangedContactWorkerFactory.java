package id.dana.synccontact.worker.syncnewcontact;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import id.dana.di.workerfactory.ChildWorkerFactory;
import id.dana.domain.account.interactor.HasAccount;
import id.dana.domain.synccontact.interactor.GetContactSyncConfig;
import id.dana.domain.synccontact.interactor.GetLastSyncedContact;
import id.dana.domain.synccontact.interactor.SyncContact;
import id.dana.synccontact.SyncContactUtil;
import id.dana.synccontact.mapper.ContactModelMapper;
import javax.inject.Inject;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public class SyncChangedContactWorkerFactory implements ChildWorkerFactory {
    private final Provider<GetLastSyncedContact> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetContactSyncConfig> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ContactModelMapper> MyBillsEntityDataFactory;
    private final Provider<SyncContact> PlaceComponentResult;
    private final Provider<HasAccount> getAuthRequestContext;
    private final Provider<SyncContactUtil> lookAheadTest;

    @Inject
    public SyncChangedContactWorkerFactory(Provider<GetContactSyncConfig> provider, Provider<SyncContact> provider2, Provider<GetLastSyncedContact> provider3, Provider<ContactModelMapper> provider4, Provider<SyncContactUtil> provider5, Provider<HasAccount> provider6) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.PlaceComponentResult = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.lookAheadTest = provider5;
        this.getAuthRequestContext = provider6;
    }

    @Override // id.dana.di.workerfactory.ChildWorkerFactory
    public final ListenableWorker MyBillsEntityDataFactory(Context context, WorkerParameters workerParameters) {
        SyncChangedContactWorker syncChangedContactWorker = new SyncChangedContactWorker(context, workerParameters, this.MyBillsEntityDataFactory.get(), this.lookAheadTest.get());
        GetContactSyncConfig getContactSyncConfig = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
        SyncContact syncContact = this.PlaceComponentResult.get();
        GetLastSyncedContact getLastSyncedContact = this.BuiltInFictitiousFunctionClassFactory.get();
        HasAccount hasAccount = this.getAuthRequestContext.get();
        syncChangedContactWorker.KClassImpl$Data$declaredNonStaticMembers$2 = getContactSyncConfig;
        syncChangedContactWorker.scheduleImpl = syncContact;
        syncChangedContactWorker.PlaceComponentResult = getLastSyncedContact;
        syncChangedContactWorker.MyBillsEntityDataFactory = hasAccount;
        return syncChangedContactWorker;
    }
}
