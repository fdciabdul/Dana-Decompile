package id.dana.kyb.data.repository.source;

import dagger.internal.Factory;
import id.dana.kyb.data.repository.source.mock.MockKybEntityData;
import id.dana.kyb.data.repository.source.network.NetworkKybEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class KybEntityDataFactory_Factory implements Factory<KybEntityDataFactory> {
    private final Provider<MockKybEntityData> MyBillsEntityDataFactory;
    private final Provider<NetworkKybEntityData> getAuthRequestContext;

    private KybEntityDataFactory_Factory(Provider<NetworkKybEntityData> provider, Provider<MockKybEntityData> provider2) {
        this.getAuthRequestContext = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static KybEntityDataFactory_Factory MyBillsEntityDataFactory(Provider<NetworkKybEntityData> provider, Provider<MockKybEntityData> provider2) {
        return new KybEntityDataFactory_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new KybEntityDataFactory(this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get());
    }
}
