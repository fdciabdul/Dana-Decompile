package id.dana.synccontact.worker.syncallcontact;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import id.dana.di.workerfactory.ChildWorkerFactory;
import id.dana.domain.account.interactor.HasAccount;
import id.dana.domain.synccontact.interactor.CheckSyncProcessCompleteState;
import id.dana.domain.synccontact.interactor.GetContactSyncConfig;
import id.dana.domain.synccontact.interactor.GetLastSyncedContact;
import id.dana.domain.synccontact.interactor.SaveSyncProcessStatusComplete;
import id.dana.domain.synccontact.interactor.SyncContact;
import id.dana.synccontact.SyncContactUtil;
import id.dana.synccontact.mapper.ContactModelMapper;
import javax.inject.Inject;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public class SyncAllContactWorkerFactory implements ChildWorkerFactory {
    private final Provider<GetLastSyncedContact> BuiltInFictitiousFunctionClassFactory;
    private final Provider<HasAccount> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetContactSyncConfig> MyBillsEntityDataFactory;
    private final Provider<SyncContact> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<CheckSyncProcessCompleteState> PlaceComponentResult;
    private final Provider<ContactModelMapper> getAuthRequestContext;
    private final Provider<SyncContactUtil> lookAheadTest;
    private final Provider<SaveSyncProcessStatusComplete> moveToNextValue;

    @Inject
    public SyncAllContactWorkerFactory(Provider<GetContactSyncConfig> provider, Provider<SyncContact> provider2, Provider<SaveSyncProcessStatusComplete> provider3, Provider<GetLastSyncedContact> provider4, Provider<CheckSyncProcessCompleteState> provider5, Provider<ContactModelMapper> provider6, Provider<SyncContactUtil> provider7, Provider<HasAccount> provider8) {
        this.MyBillsEntityDataFactory = provider;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider2;
        this.moveToNextValue = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
        this.PlaceComponentResult = provider5;
        this.getAuthRequestContext = provider6;
        this.lookAheadTest = provider7;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider8;
    }

    @Override // id.dana.di.workerfactory.ChildWorkerFactory
    public final ListenableWorker MyBillsEntityDataFactory(Context context, WorkerParameters workerParameters) {
        SyncAllContactWorker syncAllContactWorker = new SyncAllContactWorker(context, workerParameters, this.getAuthRequestContext.get(), this.lookAheadTest.get());
        syncAllContactWorker.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.moveToNextValue.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
        return syncAllContactWorker;
    }
}
