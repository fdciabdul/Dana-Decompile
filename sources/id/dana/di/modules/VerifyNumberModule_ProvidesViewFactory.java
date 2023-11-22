package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.onboarding.verify.VerifyNumberContract;

/* loaded from: classes4.dex */
public final class VerifyNumberModule_ProvidesViewFactory implements Factory<VerifyNumberContract.View> {
    private final VerifyNumberModule KClassImpl$Data$declaredNonStaticMembers$2;

    private VerifyNumberModule_ProvidesViewFactory(VerifyNumberModule verifyNumberModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = verifyNumberModule;
    }

    public static VerifyNumberModule_ProvidesViewFactory PlaceComponentResult(VerifyNumberModule verifyNumberModule) {
        return new VerifyNumberModule_ProvidesViewFactory(verifyNumberModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (VerifyNumberContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getPlaceComponentResult());
    }
}
