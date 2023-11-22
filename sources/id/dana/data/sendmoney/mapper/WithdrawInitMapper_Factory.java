package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WithdrawInitMapper_Factory implements Factory<WithdrawInitMapper> {
    private final Provider<WithdrawInitBaseResultMapper> withdrawInitBaseResultMapperProvider;

    public WithdrawInitMapper_Factory(Provider<WithdrawInitBaseResultMapper> provider) {
        this.withdrawInitBaseResultMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public final WithdrawInitMapper get() {
        return newInstance(this.withdrawInitBaseResultMapperProvider.get());
    }

    public static WithdrawInitMapper_Factory create(Provider<WithdrawInitBaseResultMapper> provider) {
        return new WithdrawInitMapper_Factory(provider);
    }

    public static WithdrawInitMapper newInstance(WithdrawInitBaseResultMapper withdrawInitBaseResultMapper) {
        return new WithdrawInitMapper(withdrawInitBaseResultMapper);
    }
}
