package id.dana.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class WithdrawMethodOptionModelMapper_Factory implements Factory<WithdrawMethodOptionModelMapper> {
    private final Provider<WithdrawChannelModelMapper> PlaceComponentResult;
    private final Provider<WithdrawSavedCardChannelModelMapper> getAuthRequestContext;

    private WithdrawMethodOptionModelMapper_Factory(Provider<WithdrawSavedCardChannelModelMapper> provider, Provider<WithdrawChannelModelMapper> provider2) {
        this.getAuthRequestContext = provider;
        this.PlaceComponentResult = provider2;
    }

    public static WithdrawMethodOptionModelMapper_Factory getAuthRequestContext(Provider<WithdrawSavedCardChannelModelMapper> provider, Provider<WithdrawChannelModelMapper> provider2) {
        return new WithdrawMethodOptionModelMapper_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new WithdrawMethodOptionModelMapper(this.getAuthRequestContext.get(), this.PlaceComponentResult.get());
    }
}
