package id.dana.challenge.pin.presenter;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.challenge.pin.AbstractPinContract;
import id.dana.domain.merchantmanagement.interactor.UnbindMerchant;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PinUnbindMerchantPresenter_Factory implements Factory<PinUnbindMerchantPresenter> {
    private final Provider<AbstractPinContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<UnbindMerchant> getAuthRequestContext;

    private PinUnbindMerchantPresenter_Factory(Provider<Context> provider, Provider<AbstractPinContract.View> provider2, Provider<UnbindMerchant> provider3) {
        this.PlaceComponentResult = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.getAuthRequestContext = provider3;
    }

    public static PinUnbindMerchantPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider, Provider<AbstractPinContract.View> provider2, Provider<UnbindMerchant> provider3) {
        return new PinUnbindMerchantPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PinUnbindMerchantPresenter(this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get());
    }
}
