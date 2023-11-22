package id.dana.sync_engine.domain.interactor;

import dagger.internal.Factory;
import id.dana.sync_engine.domain.ContactRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetSyncPermissionConfigUseCase_Factory implements Factory<GetSyncPermissionConfigUseCase> {
    private final Provider<ContactRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private GetSyncPermissionConfigUseCase_Factory(Provider<ContactRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static GetSyncPermissionConfigUseCase_Factory PlaceComponentResult(Provider<ContactRepository> provider) {
        return new GetSyncPermissionConfigUseCase_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetSyncPermissionConfigUseCase(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
