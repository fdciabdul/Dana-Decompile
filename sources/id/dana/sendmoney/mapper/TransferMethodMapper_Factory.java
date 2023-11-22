package id.dana.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class TransferMethodMapper_Factory implements Factory<TransferMethodMapper> {
    private final Provider<CurrencyAmountModelMapper> MyBillsEntityDataFactory;
    private final Provider<WithdrawMethodOptionModelMapper> getAuthRequestContext;

    private TransferMethodMapper_Factory(Provider<CurrencyAmountModelMapper> provider, Provider<WithdrawMethodOptionModelMapper> provider2) {
        this.MyBillsEntityDataFactory = provider;
        this.getAuthRequestContext = provider2;
    }

    public static TransferMethodMapper_Factory MyBillsEntityDataFactory(Provider<CurrencyAmountModelMapper> provider, Provider<WithdrawMethodOptionModelMapper> provider2) {
        return new TransferMethodMapper_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TransferMethodMapper(this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get());
    }
}
