package id.dana.synccontact.worker.syncnewcontact;

import dagger.internal.Factory;
import id.dana.domain.account.interactor.HasAccount;
import id.dana.domain.synccontact.interactor.GetContactSyncConfig;
import id.dana.domain.synccontact.interactor.GetLastSyncedContact;
import id.dana.domain.synccontact.interactor.SyncContact;
import id.dana.synccontact.SyncContactUtil;
import id.dana.synccontact.mapper.ContactModelMapper;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SyncChangedContactWorkerFactory_Factory implements Factory<SyncChangedContactWorkerFactory> {
    private final Provider<HasAccount> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SyncContact> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetContactSyncConfig> MyBillsEntityDataFactory;
    private final Provider<ContactModelMapper> PlaceComponentResult;
    private final Provider<GetLastSyncedContact> getAuthRequestContext;
    private final Provider<SyncContactUtil> getErrorConfigVersion;

    private SyncChangedContactWorkerFactory_Factory(Provider<GetContactSyncConfig> provider, Provider<SyncContact> provider2, Provider<GetLastSyncedContact> provider3, Provider<ContactModelMapper> provider4, Provider<SyncContactUtil> provider5, Provider<HasAccount> provider6) {
        this.MyBillsEntityDataFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.getAuthRequestContext = provider3;
        this.PlaceComponentResult = provider4;
        this.getErrorConfigVersion = provider5;
        this.BuiltInFictitiousFunctionClassFactory = provider6;
    }

    public static SyncChangedContactWorkerFactory_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<GetContactSyncConfig> provider, Provider<SyncContact> provider2, Provider<GetLastSyncedContact> provider3, Provider<ContactModelMapper> provider4, Provider<SyncContactUtil> provider5, Provider<HasAccount> provider6) {
        return new SyncChangedContactWorkerFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SyncChangedContactWorkerFactory(this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext, this.PlaceComponentResult, this.getErrorConfigVersion, this.BuiltInFictitiousFunctionClassFactory);
    }
}
