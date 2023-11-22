package id.dana.sync_engine.domain.interactor;

import dagger.internal.Factory;
import id.dana.sync_engine.domain.ContactRepository;
import id.dana.sync_engine.domain.engine.DefaultSyncContactEngine;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GetContactsUseCase_Factory implements Factory<GetContactsUseCase> {
    private final Provider<ContactRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<DefaultSyncContactEngine> getAuthRequestContext;

    private GetContactsUseCase_Factory(Provider<ContactRepository> provider, Provider<DefaultSyncContactEngine> provider2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.getAuthRequestContext = provider2;
    }

    public static GetContactsUseCase_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<ContactRepository> provider, Provider<DefaultSyncContactEngine> provider2) {
        return new GetContactsUseCase_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetContactsUseCase(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get());
    }
}
