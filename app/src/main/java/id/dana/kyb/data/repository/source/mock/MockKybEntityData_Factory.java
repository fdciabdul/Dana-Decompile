package id.dana.kyb.data.repository.source.mock;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MockKybEntityData_Factory implements Factory<MockKybEntityData> {
    private final Provider<Serializer> MyBillsEntityDataFactory;
    private final Provider<Context> PlaceComponentResult;

    private MockKybEntityData_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.PlaceComponentResult = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static MockKybEntityData_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider, Provider<Serializer> provider2) {
        return new MockKybEntityData_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MockKybEntityData(this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get());
    }
}
