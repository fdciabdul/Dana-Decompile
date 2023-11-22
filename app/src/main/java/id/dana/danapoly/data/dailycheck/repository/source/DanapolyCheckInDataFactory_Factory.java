package id.dana.danapoly.data.dailycheck.repository.source;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DanapolyCheckInDataFactory_Factory implements Factory<DanapolyCheckInDataFactory> {
    private final Provider<DanapolyCheckInData> MyBillsEntityDataFactory;

    private DanapolyCheckInDataFactory_Factory(Provider<DanapolyCheckInData> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static DanapolyCheckInDataFactory_Factory BuiltInFictitiousFunctionClassFactory(Provider<DanapolyCheckInData> provider) {
        return new DanapolyCheckInDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanapolyCheckInDataFactory(this.MyBillsEntityDataFactory.get());
    }
}
