package id.dana.cashier.mapper;

import dagger.internal.Factory;
import id.dana.sendmoney.mapper.CouponPayMethodInfoListModelMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class VoucherCashierModelsMapper_Factory implements Factory<VoucherCashierModelsMapper> {
    private final Provider<CouponPayMethodInfoListModelMapper> getAuthRequestContext;

    private VoucherCashierModelsMapper_Factory(Provider<CouponPayMethodInfoListModelMapper> provider) {
        this.getAuthRequestContext = provider;
    }

    public static VoucherCashierModelsMapper_Factory getAuthRequestContext(Provider<CouponPayMethodInfoListModelMapper> provider) {
        return new VoucherCashierModelsMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new VoucherCashierModelsMapper(this.getAuthRequestContext.get());
    }
}
