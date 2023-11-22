package id.dana.danapoly.data.config.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class LocalDanapolyConfigEntityData_Factory implements Factory<LocalDanapolyConfigEntityData> {
    private final Provider<DanapolyPreference> BuiltInFictitiousFunctionClassFactory;

    private LocalDanapolyConfigEntityData_Factory(Provider<DanapolyPreference> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static LocalDanapolyConfigEntityData_Factory MyBillsEntityDataFactory(Provider<DanapolyPreference> provider) {
        return new LocalDanapolyConfigEntityData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new LocalDanapolyConfigEntityData(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
