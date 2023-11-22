package id.dana.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class TransferPrepayMapper_Factory implements Factory<TransferPrepayMapper> {
    private final Provider<CurrencyAmountModelMapper> PlaceComponentResult;
    private final Provider<CouponPayMethodInfoListModelMapper> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TransferPrepayMapper(this.PlaceComponentResult.get(), this.getAuthRequestContext.get());
    }
}
