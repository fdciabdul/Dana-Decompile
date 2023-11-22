package id.dana.sync_engine.domain.interactor;

import dagger.internal.Factory;
import id.dana.sync_engine.domain.ContactRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ClearAllSyncEngineUseCase_Factory implements Factory<ClearAllSyncEngineUseCase> {
    private final Provider<ContactRepository> PlaceComponentResult;

    private ClearAllSyncEngineUseCase_Factory(Provider<ContactRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static ClearAllSyncEngineUseCase_Factory PlaceComponentResult(Provider<ContactRepository> provider) {
        return new ClearAllSyncEngineUseCase_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ClearAllSyncEngineUseCase(this.PlaceComponentResult.get());
    }
}
