package id.dana.mybills.data.repository;

import dagger.internal.Factory;
import id.dana.mybills.data.repository.source.MyBillsEntityData;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MyBillsEntityDataFactory_Factory implements Factory<MyBillsEntityDataFactory> {
    private final Provider<MyBillsEntityData> BuiltInFictitiousFunctionClassFactory;
    private final Provider<MyBillsEntityData> getAuthRequestContext;

    private MyBillsEntityDataFactory_Factory(Provider<MyBillsEntityData> provider, Provider<MyBillsEntityData> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.getAuthRequestContext = provider2;
    }

    public static MyBillsEntityDataFactory_Factory BuiltInFictitiousFunctionClassFactory(Provider<MyBillsEntityData> provider, Provider<MyBillsEntityData> provider2) {
        return new MyBillsEntityDataFactory_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get());
    }
}
