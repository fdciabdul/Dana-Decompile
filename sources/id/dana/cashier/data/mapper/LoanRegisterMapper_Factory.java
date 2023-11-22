package id.dana.cashier.data.mapper;

import dagger.internal.Factory;
import id.dana.data.sendmoney.mapper.PayMethodRiskResultMapper;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class LoanRegisterMapper_Factory implements Factory<LoanRegisterMapper> {
    private final Provider<PayMethodRiskResultMapper> payMethodRiskResultMapperProvider;

    public LoanRegisterMapper_Factory(Provider<PayMethodRiskResultMapper> provider) {
        this.payMethodRiskResultMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public final LoanRegisterMapper get() {
        return newInstance(this.payMethodRiskResultMapperProvider.get());
    }

    public static LoanRegisterMapper_Factory create(Provider<PayMethodRiskResultMapper> provider) {
        return new LoanRegisterMapper_Factory(provider);
    }

    public static LoanRegisterMapper newInstance(PayMethodRiskResultMapper payMethodRiskResultMapper) {
        return new LoanRegisterMapper(payMethodRiskResultMapper);
    }
}
