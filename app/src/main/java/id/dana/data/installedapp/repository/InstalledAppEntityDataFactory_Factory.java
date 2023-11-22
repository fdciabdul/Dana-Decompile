package id.dana.data.installedapp.repository;

import dagger.internal.Factory;
import id.dana.data.installedapp.repository.source.local.LocalInstalledAppEntityData;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class InstalledAppEntityDataFactory_Factory implements Factory<InstalledAppEntityDataFactory> {
    private final Provider<LocalInstalledAppEntityData> getAuthRequestContext;

    private InstalledAppEntityDataFactory_Factory(Provider<LocalInstalledAppEntityData> provider) {
        this.getAuthRequestContext = provider;
    }

    public static InstalledAppEntityDataFactory_Factory MyBillsEntityDataFactory(Provider<LocalInstalledAppEntityData> provider) {
        return new InstalledAppEntityDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new InstalledAppEntityDataFactory(this.getAuthRequestContext.get());
    }
}
