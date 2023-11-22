package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.pushverify.view.verificationlist.VerificationListMainContract;

/* loaded from: classes4.dex */
public final class VerificationListMainModule_ProvideView$app_productionReleaseFactory implements Factory<VerificationListMainContract.View> {
    private final VerificationListMainModule getAuthRequestContext;

    private VerificationListMainModule_ProvideView$app_productionReleaseFactory(VerificationListMainModule verificationListMainModule) {
        this.getAuthRequestContext = verificationListMainModule;
    }

    public static VerificationListMainModule_ProvideView$app_productionReleaseFactory KClassImpl$Data$declaredNonStaticMembers$2(VerificationListMainModule verificationListMainModule) {
        return new VerificationListMainModule_ProvideView$app_productionReleaseFactory(verificationListMainModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (VerificationListMainContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getPlaceComponentResult());
    }
}
