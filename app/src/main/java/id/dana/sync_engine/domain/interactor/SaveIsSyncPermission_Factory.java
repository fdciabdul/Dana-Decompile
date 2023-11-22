package id.dana.sync_engine.domain.interactor;

import dagger.internal.Factory;
import id.dana.sync_engine.domain.ContactRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SaveIsSyncPermission_Factory implements Factory<SaveIsSyncPermission> {
    private final Provider<ContactRepository> MyBillsEntityDataFactory;

    private SaveIsSyncPermission_Factory(Provider<ContactRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static SaveIsSyncPermission_Factory MyBillsEntityDataFactory(Provider<ContactRepository> provider) {
        return new SaveIsSyncPermission_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SaveIsSyncPermission(this.MyBillsEntityDataFactory.get());
    }
}
