package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.PrivacySettingContract;
import id.dana.social.contract.PrivacySettingPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class PrivacySettingModule_ProvidePrivacySettingPresenterFactory implements Factory<PrivacySettingContract.Presenter> {
    private final Provider<PrivacySettingPresenter> BuiltInFictitiousFunctionClassFactory;
    private final PrivacySettingModule PlaceComponentResult;

    private PrivacySettingModule_ProvidePrivacySettingPresenterFactory(PrivacySettingModule privacySettingModule, Provider<PrivacySettingPresenter> provider) {
        this.PlaceComponentResult = privacySettingModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static PrivacySettingModule_ProvidePrivacySettingPresenterFactory getAuthRequestContext(PrivacySettingModule privacySettingModule, Provider<PrivacySettingPresenter> provider) {
        return new PrivacySettingModule_ProvidePrivacySettingPresenterFactory(privacySettingModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PrivacySettingContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
