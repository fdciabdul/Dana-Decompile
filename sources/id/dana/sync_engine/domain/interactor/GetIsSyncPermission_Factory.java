package id.dana.sync_engine.domain.interactor;

import dagger.internal.Factory;
import id.dana.sync_engine.domain.ContactRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetIsSyncPermission_Factory implements Factory<GetIsSyncPermission> {
    private final Provider<ContactRepository> getAuthRequestContext;

    private GetIsSyncPermission_Factory(Provider<ContactRepository> provider) {
        this.getAuthRequestContext = provider;
    }

    public static GetIsSyncPermission_Factory PlaceComponentResult(Provider<ContactRepository> provider) {
        return new GetIsSyncPermission_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetIsSyncPermission(this.getAuthRequestContext.get());
    }
}
