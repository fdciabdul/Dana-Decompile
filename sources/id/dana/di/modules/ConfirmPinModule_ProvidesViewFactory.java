package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.onboarding.confirmpin.ConfirmPinContract;

/* loaded from: classes4.dex */
public final class ConfirmPinModule_ProvidesViewFactory implements Factory<ConfirmPinContract.View> {
    private final ConfirmPinModule KClassImpl$Data$declaredNonStaticMembers$2;

    private ConfirmPinModule_ProvidesViewFactory(ConfirmPinModule confirmPinModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = confirmPinModule;
    }

    public static ConfirmPinModule_ProvidesViewFactory KClassImpl$Data$declaredNonStaticMembers$2(ConfirmPinModule confirmPinModule) {
        return new ConfirmPinModule_ProvidesViewFactory(confirmPinModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ConfirmPinContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext());
    }
}
