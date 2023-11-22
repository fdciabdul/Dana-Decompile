package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.PrivacySettingContract;

/* loaded from: classes5.dex */
public final class PrivacySettingModule_ProvidePrivacySettingModuleFactory implements Factory<PrivacySettingContract.View> {
    private final PrivacySettingModule KClassImpl$Data$declaredNonStaticMembers$2;

    private PrivacySettingModule_ProvidePrivacySettingModuleFactory(PrivacySettingModule privacySettingModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = privacySettingModule;
    }

    public static PrivacySettingModule_ProvidePrivacySettingModuleFactory KClassImpl$Data$declaredNonStaticMembers$2(PrivacySettingModule privacySettingModule) {
        return new PrivacySettingModule_ProvidePrivacySettingModuleFactory(privacySettingModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PrivacySettingContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getGetAuthRequestContext());
    }
}
