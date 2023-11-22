package id.dana.data.requestmoney.repository;

import dagger.internal.Factory;
import id.dana.data.requestmoney.repository.source.local.DefaultRequestMoneyEntityData;
import id.dana.data.requestmoney.repository.source.split.SplitRequestMoneyEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RequestMoneyEntityDataFactory_Factory implements Factory<RequestMoneyEntityDataFactory> {
    private final Provider<DefaultRequestMoneyEntityData> defaultRequestMoneyEntityDataProvider;
    private final Provider<SplitRequestMoneyEntityData> splitRequestMoneyEntityDataProvider;

    public RequestMoneyEntityDataFactory_Factory(Provider<SplitRequestMoneyEntityData> provider, Provider<DefaultRequestMoneyEntityData> provider2) {
        this.splitRequestMoneyEntityDataProvider = provider;
        this.defaultRequestMoneyEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final RequestMoneyEntityDataFactory get() {
        return newInstance(this.splitRequestMoneyEntityDataProvider.get(), this.defaultRequestMoneyEntityDataProvider.get());
    }

    public static RequestMoneyEntityDataFactory_Factory create(Provider<SplitRequestMoneyEntityData> provider, Provider<DefaultRequestMoneyEntityData> provider2) {
        return new RequestMoneyEntityDataFactory_Factory(provider, provider2);
    }

    public static RequestMoneyEntityDataFactory newInstance(SplitRequestMoneyEntityData splitRequestMoneyEntityData, DefaultRequestMoneyEntityData defaultRequestMoneyEntityData) {
        return new RequestMoneyEntityDataFactory(splitRequestMoneyEntityData, defaultRequestMoneyEntityData);
    }
}
