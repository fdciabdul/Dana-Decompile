package id.dana.challenge.pin;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.challenge.pin.AbstractPinContract;
import id.dana.domain.autoroute.interactor.SwitchAutoRouting;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PinSwitchAutoRoutePresenter_Factory implements Factory<PinSwitchAutoRoutePresenter> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<AbstractPinContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SwitchAutoRouting> MyBillsEntityDataFactory;

    private PinSwitchAutoRoutePresenter_Factory(Provider<Context> provider, Provider<SwitchAutoRouting> provider2, Provider<AbstractPinContract.View> provider3) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
    }

    public static PinSwitchAutoRoutePresenter_Factory getAuthRequestContext(Provider<Context> provider, Provider<SwitchAutoRouting> provider2, Provider<AbstractPinContract.View> provider3) {
        return new PinSwitchAutoRoutePresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PinSwitchAutoRoutePresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
