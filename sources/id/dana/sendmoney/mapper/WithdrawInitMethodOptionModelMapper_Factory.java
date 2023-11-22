package id.dana.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class WithdrawInitMethodOptionModelMapper_Factory implements Factory<WithdrawInitMethodOptionModelMapper> {
    private final Provider<WithdrawInitChannelOptionModelMapper> MyBillsEntityDataFactory;
    private final Provider<WithdrawSavedCardChannelModelMapper> getAuthRequestContext;

    private WithdrawInitMethodOptionModelMapper_Factory(Provider<WithdrawSavedCardChannelModelMapper> provider, Provider<WithdrawInitChannelOptionModelMapper> provider2) {
        this.getAuthRequestContext = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static WithdrawInitMethodOptionModelMapper_Factory getAuthRequestContext(Provider<WithdrawSavedCardChannelModelMapper> provider, Provider<WithdrawInitChannelOptionModelMapper> provider2) {
        return new WithdrawInitMethodOptionModelMapper_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new WithdrawInitMethodOptionModelMapper(this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get());
    }
}
