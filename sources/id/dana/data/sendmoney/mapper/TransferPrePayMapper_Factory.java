package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class TransferPrePayMapper_Factory implements Factory<TransferPrePayMapper> {
    private final Provider<CouponChannelInfoResultMapper> couponChannelInfoResultMapperProvider;

    public TransferPrePayMapper_Factory(Provider<CouponChannelInfoResultMapper> provider) {
        this.couponChannelInfoResultMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public final TransferPrePayMapper get() {
        return newInstance(this.couponChannelInfoResultMapperProvider.get());
    }

    public static TransferPrePayMapper_Factory create(Provider<CouponChannelInfoResultMapper> provider) {
        return new TransferPrePayMapper_Factory(provider);
    }

    public static TransferPrePayMapper newInstance(CouponChannelInfoResultMapper couponChannelInfoResultMapper) {
        return new TransferPrePayMapper(couponChannelInfoResultMapper);
    }
}
