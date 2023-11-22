package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.pushverify.view.verificationlist.list.VerificationListContract;

/* loaded from: classes4.dex */
public final class VerificationListModule_ProvideView$app_productionReleaseFactory implements Factory<VerificationListContract.View> {
    private final VerificationListModule PlaceComponentResult;

    private VerificationListModule_ProvideView$app_productionReleaseFactory(VerificationListModule verificationListModule) {
        this.PlaceComponentResult = verificationListModule;
    }

    public static VerificationListModule_ProvideView$app_productionReleaseFactory KClassImpl$Data$declaredNonStaticMembers$2(VerificationListModule verificationListModule) {
        return new VerificationListModule_ProvideView$app_productionReleaseFactory(verificationListModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (VerificationListContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getBuiltInFictitiousFunctionClassFactory());
    }
}
