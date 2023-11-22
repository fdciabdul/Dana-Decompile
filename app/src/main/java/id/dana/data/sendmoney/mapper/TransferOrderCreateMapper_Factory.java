package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class TransferOrderCreateMapper_Factory implements Factory<TransferOrderCreateMapper> {
    private final Provider<BizTransferOrderCreateRequestMapper> bizTransferOrderCreateRequestMapperProvider;
    private final Provider<BizTransferOrderCreateResultMapper> bizTransferOrderCreateResultMapperProvider;

    public TransferOrderCreateMapper_Factory(Provider<BizTransferOrderCreateRequestMapper> provider, Provider<BizTransferOrderCreateResultMapper> provider2) {
        this.bizTransferOrderCreateRequestMapperProvider = provider;
        this.bizTransferOrderCreateResultMapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final TransferOrderCreateMapper get() {
        return newInstance(this.bizTransferOrderCreateRequestMapperProvider.get(), this.bizTransferOrderCreateResultMapperProvider.get());
    }

    public static TransferOrderCreateMapper_Factory create(Provider<BizTransferOrderCreateRequestMapper> provider, Provider<BizTransferOrderCreateResultMapper> provider2) {
        return new TransferOrderCreateMapper_Factory(provider, provider2);
    }

    public static TransferOrderCreateMapper newInstance(BizTransferOrderCreateRequestMapper bizTransferOrderCreateRequestMapper, BizTransferOrderCreateResultMapper bizTransferOrderCreateResultMapper) {
        return new TransferOrderCreateMapper(bizTransferOrderCreateRequestMapper, bizTransferOrderCreateResultMapper);
    }
}
