package id.dana.sendmoney.data.repository.globalsend.source.mock;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MockGlobalSendEntityData_Factory implements Factory<MockGlobalSendEntityData> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Serializer> MyBillsEntityDataFactory;

    private MockGlobalSendEntityData_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static MockGlobalSendEntityData_Factory PlaceComponentResult(Provider<Context> provider, Provider<Serializer> provider2) {
        return new MockGlobalSendEntityData_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MockGlobalSendEntityData(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
