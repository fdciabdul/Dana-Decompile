package id.dana.data.installedapp.repository;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class InstalledAppEntityRepository_Factory implements Factory<InstalledAppEntityRepository> {
    private final Provider<AccountEntityDataFactory> MyBillsEntityDataFactory;
    private final Provider<InstalledAppEntityDataFactory> getAuthRequestContext;

    private InstalledAppEntityRepository_Factory(Provider<InstalledAppEntityDataFactory> provider, Provider<AccountEntityDataFactory> provider2) {
        this.getAuthRequestContext = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static InstalledAppEntityRepository_Factory PlaceComponentResult(Provider<InstalledAppEntityDataFactory> provider, Provider<AccountEntityDataFactory> provider2) {
        return new InstalledAppEntityRepository_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new InstalledAppEntityRepository(this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get());
    }
}
