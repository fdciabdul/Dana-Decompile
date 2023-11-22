package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WithdrawInitBaseResultMapper_Factory implements Factory<WithdrawInitBaseResultMapper> {
    private final Provider<WithdrawInitMethodOptionResultMapper> withdrawInitMethodOptionResultMapperProvider;

    public WithdrawInitBaseResultMapper_Factory(Provider<WithdrawInitMethodOptionResultMapper> provider) {
        this.withdrawInitMethodOptionResultMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public final WithdrawInitBaseResultMapper get() {
        return newInstance(this.withdrawInitMethodOptionResultMapperProvider.get());
    }

    public static WithdrawInitBaseResultMapper_Factory create(Provider<WithdrawInitMethodOptionResultMapper> provider) {
        return new WithdrawInitBaseResultMapper_Factory(provider);
    }

    public static WithdrawInitBaseResultMapper newInstance(WithdrawInitMethodOptionResultMapper withdrawInitMethodOptionResultMapper) {
        return new WithdrawInitBaseResultMapper(withdrawInitMethodOptionResultMapper);
    }
}
