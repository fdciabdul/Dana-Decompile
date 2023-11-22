package id.dana.data.user;

import dagger.internal.Factory;
import id.dana.data.sendmoney.mapper.CurrencyAmountResultMapper;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserInfoMapper_Factory implements Factory<UserInfoMapper> {
    private final Provider<CurrencyAmountResultMapper> currencyAmountResultMapperProvider;
    private final Provider<Serializer> serializerProvider;

    public UserInfoMapper_Factory(Provider<CurrencyAmountResultMapper> provider, Provider<Serializer> provider2) {
        this.currencyAmountResultMapperProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final UserInfoMapper get() {
        return newInstance(this.currencyAmountResultMapperProvider.get(), this.serializerProvider.get());
    }

    public static UserInfoMapper_Factory create(Provider<CurrencyAmountResultMapper> provider, Provider<Serializer> provider2) {
        return new UserInfoMapper_Factory(provider, provider2);
    }

    public static UserInfoMapper newInstance(CurrencyAmountResultMapper currencyAmountResultMapper, Serializer serializer) {
        return new UserInfoMapper(currencyAmountResultMapper, serializer);
    }
}
