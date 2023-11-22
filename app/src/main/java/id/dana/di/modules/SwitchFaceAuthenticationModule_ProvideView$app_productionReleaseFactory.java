package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.switchfaceauth.SwitchFaceAuthContract;

/* loaded from: classes4.dex */
public final class SwitchFaceAuthenticationModule_ProvideView$app_productionReleaseFactory implements Factory<SwitchFaceAuthContract.View> {
    private final SwitchFaceAuthenticationModule KClassImpl$Data$declaredNonStaticMembers$2;

    private SwitchFaceAuthenticationModule_ProvideView$app_productionReleaseFactory(SwitchFaceAuthenticationModule switchFaceAuthenticationModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = switchFaceAuthenticationModule;
    }

    public static SwitchFaceAuthenticationModule_ProvideView$app_productionReleaseFactory MyBillsEntityDataFactory(SwitchFaceAuthenticationModule switchFaceAuthenticationModule) {
        return new SwitchFaceAuthenticationModule_ProvideView$app_productionReleaseFactory(switchFaceAuthenticationModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SwitchFaceAuthContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getBuiltInFictitiousFunctionClassFactory());
    }
}
