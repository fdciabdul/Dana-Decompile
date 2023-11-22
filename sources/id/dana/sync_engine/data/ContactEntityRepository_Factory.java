package id.dana.sync_engine.data;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.synccontact.mapper.ContactSyncConfigMapper;
import id.dana.sync_engine.data.entity.ContactEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ContactEntityRepository_Factory implements Factory<ContactEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<AccountEntityDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ContactSyncConfigMapper> MyBillsEntityDataFactory;
    private final Provider<ContactEntityDataFactory> PlaceComponentResult;
    private final Provider<ConfigEntityDataFactory> getAuthRequestContext;

    private ContactEntityRepository_Factory(Provider<ContactEntityDataFactory> provider, Provider<ConfigEntityDataFactory> provider2, Provider<AccountEntityDataFactory> provider3, Provider<ContactSyncConfigMapper> provider4, Provider<HoldLoginV1EntityRepository> provider5) {
        this.PlaceComponentResult = provider;
        this.getAuthRequestContext = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.BuiltInFictitiousFunctionClassFactory = provider5;
    }

    public static ContactEntityRepository_Factory PlaceComponentResult(Provider<ContactEntityDataFactory> provider, Provider<ConfigEntityDataFactory> provider2, Provider<AccountEntityDataFactory> provider3, Provider<ContactSyncConfigMapper> provider4, Provider<HoldLoginV1EntityRepository> provider5) {
        return new ContactEntityRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ContactEntityRepository(this.PlaceComponentResult.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
