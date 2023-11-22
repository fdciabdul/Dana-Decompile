package id.dana.data.mybills.repository;

import dagger.internal.Factory;
import id.dana.data.mybills.repository.source.network.NetworkMyBillsEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MyBillsEntityDataFactory_Factory implements Factory<MyBillsEntityDataFactory> {
    private final Provider<NetworkMyBillsEntityData> getAuthRequestContext;

    private MyBillsEntityDataFactory_Factory(Provider<NetworkMyBillsEntityData> provider) {
        this.getAuthRequestContext = provider;
    }

    public static MyBillsEntityDataFactory_Factory MyBillsEntityDataFactory(Provider<NetworkMyBillsEntityData> provider) {
        return new MyBillsEntityDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MyBillsEntityDataFactory(this.getAuthRequestContext.get());
    }
}
