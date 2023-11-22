package id.dana.data.danaprotection.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalDanaProtectionInfoEntityData_Factory implements Factory<LocalDanaProtectionInfoEntityData> {
    private final Provider<DanaProtectionInfoPreference> MyBillsEntityDataFactory;

    private LocalDanaProtectionInfoEntityData_Factory(Provider<DanaProtectionInfoPreference> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static LocalDanaProtectionInfoEntityData_Factory MyBillsEntityDataFactory(Provider<DanaProtectionInfoPreference> provider) {
        return new LocalDanaProtectionInfoEntityData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new LocalDanaProtectionInfoEntityData(this.MyBillsEntityDataFactory.get());
    }
}
