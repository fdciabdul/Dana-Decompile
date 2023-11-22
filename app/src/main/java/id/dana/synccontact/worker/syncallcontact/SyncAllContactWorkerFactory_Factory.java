package id.dana.synccontact.worker.syncallcontact;

import dagger.internal.Factory;
import id.dana.domain.account.interactor.HasAccount;
import id.dana.domain.synccontact.interactor.CheckSyncProcessCompleteState;
import id.dana.domain.synccontact.interactor.GetContactSyncConfig;
import id.dana.domain.synccontact.interactor.GetLastSyncedContact;
import id.dana.domain.synccontact.interactor.SaveSyncProcessStatusComplete;
import id.dana.domain.synccontact.interactor.SyncContact;
import id.dana.synccontact.SyncContactUtil;
import id.dana.synccontact.mapper.ContactModelMapper;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SyncAllContactWorkerFactory_Factory implements Factory<SyncAllContactWorkerFactory> {
    private final Provider<GetContactSyncConfig> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetLastSyncedContact> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ContactModelMapper> MyBillsEntityDataFactory;
    private final Provider<HasAccount> PlaceComponentResult;
    private final Provider<CheckSyncProcessCompleteState> getAuthRequestContext;
    private final Provider<SaveSyncProcessStatusComplete> getErrorConfigVersion;
    private final Provider<SyncContact> lookAheadTest;
    private final Provider<SyncContactUtil> scheduleImpl;

    private SyncAllContactWorkerFactory_Factory(Provider<GetContactSyncConfig> provider, Provider<SyncContact> provider2, Provider<SaveSyncProcessStatusComplete> provider3, Provider<GetLastSyncedContact> provider4, Provider<CheckSyncProcessCompleteState> provider5, Provider<ContactModelMapper> provider6, Provider<SyncContactUtil> provider7, Provider<HasAccount> provider8) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.lookAheadTest = provider2;
        this.getErrorConfigVersion = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.getAuthRequestContext = provider5;
        this.MyBillsEntityDataFactory = provider6;
        this.scheduleImpl = provider7;
        this.PlaceComponentResult = provider8;
    }

    public static SyncAllContactWorkerFactory_Factory PlaceComponentResult(Provider<GetContactSyncConfig> provider, Provider<SyncContact> provider2, Provider<SaveSyncProcessStatusComplete> provider3, Provider<GetLastSyncedContact> provider4, Provider<CheckSyncProcessCompleteState> provider5, Provider<ContactModelMapper> provider6, Provider<SyncContactUtil> provider7, Provider<HasAccount> provider8) {
        return new SyncAllContactWorkerFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SyncAllContactWorkerFactory(this.BuiltInFictitiousFunctionClassFactory, this.lookAheadTest, this.getErrorConfigVersion, this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext, this.MyBillsEntityDataFactory, this.scheduleImpl, this.PlaceComponentResult);
    }
}
