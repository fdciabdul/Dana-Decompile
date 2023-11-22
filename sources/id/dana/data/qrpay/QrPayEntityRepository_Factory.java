package id.dana.data.qrpay;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.offlinepay.source.PaymentModelMapper;
import id.dana.data.qrpay.source.QrPayEntityDataFactory;
import id.dana.data.security.source.SecurityEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class QrPayEntityRepository_Factory implements Factory<QrPayEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<PaymentModelMapper> paymentModelMapperProvider;
    private final Provider<QrPayEntityDataFactory> qrPayEntityDataFactoryProvider;
    private final Provider<SecurityEntityDataFactory> securityEntityDataFactoryProvider;

    public QrPayEntityRepository_Factory(Provider<QrPayEntityDataFactory> provider, Provider<SecurityEntityDataFactory> provider2, Provider<PaymentModelMapper> provider3, Provider<HoldLoginV1EntityRepository> provider4) {
        this.qrPayEntityDataFactoryProvider = provider;
        this.securityEntityDataFactoryProvider = provider2;
        this.paymentModelMapperProvider = provider3;
        this.holdLoginV1EntityRepositoryProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final QrPayEntityRepository get() {
        return newInstance(this.qrPayEntityDataFactoryProvider.get(), this.securityEntityDataFactoryProvider.get(), this.paymentModelMapperProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static QrPayEntityRepository_Factory create(Provider<QrPayEntityDataFactory> provider, Provider<SecurityEntityDataFactory> provider2, Provider<PaymentModelMapper> provider3, Provider<HoldLoginV1EntityRepository> provider4) {
        return new QrPayEntityRepository_Factory(provider, provider2, provider3, provider4);
    }

    public static QrPayEntityRepository newInstance(QrPayEntityDataFactory qrPayEntityDataFactory, SecurityEntityDataFactory securityEntityDataFactory, PaymentModelMapper paymentModelMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new QrPayEntityRepository(qrPayEntityDataFactory, securityEntityDataFactory, paymentModelMapper, holdLoginV1EntityRepository);
    }
}
