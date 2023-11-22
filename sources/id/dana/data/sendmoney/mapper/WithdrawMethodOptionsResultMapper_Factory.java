package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WithdrawMethodOptionsResultMapper_Factory implements Factory<WithdrawMethodOptionsResultMapper> {
    private final Provider<WithdrawChannelViewResultMapper> withdrawChannelViewResultMapperProvider;
    private final Provider<WithdrawSavedCardChannelViewResultMapper> withdrawSavedCardChannelViewResultMapperProvider;

    public WithdrawMethodOptionsResultMapper_Factory(Provider<WithdrawChannelViewResultMapper> provider, Provider<WithdrawSavedCardChannelViewResultMapper> provider2) {
        this.withdrawChannelViewResultMapperProvider = provider;
        this.withdrawSavedCardChannelViewResultMapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final WithdrawMethodOptionsResultMapper get() {
        return newInstance(this.withdrawChannelViewResultMapperProvider.get(), this.withdrawSavedCardChannelViewResultMapperProvider.get());
    }

    public static WithdrawMethodOptionsResultMapper_Factory create(Provider<WithdrawChannelViewResultMapper> provider, Provider<WithdrawSavedCardChannelViewResultMapper> provider2) {
        return new WithdrawMethodOptionsResultMapper_Factory(provider, provider2);
    }

    public static WithdrawMethodOptionsResultMapper newInstance(WithdrawChannelViewResultMapper withdrawChannelViewResultMapper, WithdrawSavedCardChannelViewResultMapper withdrawSavedCardChannelViewResultMapper) {
        return new WithdrawMethodOptionsResultMapper(withdrawChannelViewResultMapper, withdrawSavedCardChannelViewResultMapper);
    }
}
