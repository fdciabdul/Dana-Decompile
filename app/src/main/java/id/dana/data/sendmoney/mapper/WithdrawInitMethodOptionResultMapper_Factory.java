package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WithdrawInitMethodOptionResultMapper_Factory implements Factory<WithdrawInitMethodOptionResultMapper> {
    private final Provider<WithdrawInitChannelOptionResultMapper> withdrawInitChannelOptionResultMapperProvider;
    private final Provider<WithdrawSavedCardChannelViewResultMapper> withdrawSavedCardChannelViewResultMapperProvider;

    public WithdrawInitMethodOptionResultMapper_Factory(Provider<WithdrawSavedCardChannelViewResultMapper> provider, Provider<WithdrawInitChannelOptionResultMapper> provider2) {
        this.withdrawSavedCardChannelViewResultMapperProvider = provider;
        this.withdrawInitChannelOptionResultMapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final WithdrawInitMethodOptionResultMapper get() {
        return newInstance(this.withdrawSavedCardChannelViewResultMapperProvider.get(), this.withdrawInitChannelOptionResultMapperProvider.get());
    }

    public static WithdrawInitMethodOptionResultMapper_Factory create(Provider<WithdrawSavedCardChannelViewResultMapper> provider, Provider<WithdrawInitChannelOptionResultMapper> provider2) {
        return new WithdrawInitMethodOptionResultMapper_Factory(provider, provider2);
    }

    public static WithdrawInitMethodOptionResultMapper newInstance(WithdrawSavedCardChannelViewResultMapper withdrawSavedCardChannelViewResultMapper, WithdrawInitChannelOptionResultMapper withdrawInitChannelOptionResultMapper) {
        return new WithdrawInitMethodOptionResultMapper(withdrawSavedCardChannelViewResultMapper, withdrawInitChannelOptionResultMapper);
    }
}
