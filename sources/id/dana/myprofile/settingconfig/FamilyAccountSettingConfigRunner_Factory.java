package id.dana.myprofile.settingconfig;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FamilyAccountSettingConfigRunner_Factory implements Factory<FamilyAccountSettingConfigRunner> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;

    private FamilyAccountSettingConfigRunner_Factory(Provider<Context> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static FamilyAccountSettingConfigRunner_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider) {
        return new FamilyAccountSettingConfigRunner_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FamilyAccountSettingConfigRunner(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
