package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.switchfaceauth.SwitchFaceAuthContract;
import id.dana.switchfaceauth.SwitchFaceAuthPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SwitchFaceAuthenticationModule_ProvidePresenter$app_productionReleaseFactory implements Factory<SwitchFaceAuthContract.Presenter> {
    private final SwitchFaceAuthenticationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<SwitchFaceAuthPresenter> MyBillsEntityDataFactory;

    private SwitchFaceAuthenticationModule_ProvidePresenter$app_productionReleaseFactory(SwitchFaceAuthenticationModule switchFaceAuthenticationModule, Provider<SwitchFaceAuthPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = switchFaceAuthenticationModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static SwitchFaceAuthenticationModule_ProvidePresenter$app_productionReleaseFactory getAuthRequestContext(SwitchFaceAuthenticationModule switchFaceAuthenticationModule, Provider<SwitchFaceAuthPresenter> provider) {
        return new SwitchFaceAuthenticationModule_ProvidePresenter$app_productionReleaseFactory(switchFaceAuthenticationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SwitchFaceAuthContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.get()));
    }
}
