package id.dana.data.miniprogram.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PreferenceStoreMiniProgramsEntityData_Factory implements Factory<PreferenceStoreMiniProgramsEntityData> {
    private final Provider<StoreMiniProgramPreference> BuiltInFictitiousFunctionClassFactory;

    private PreferenceStoreMiniProgramsEntityData_Factory(Provider<StoreMiniProgramPreference> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static PreferenceStoreMiniProgramsEntityData_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<StoreMiniProgramPreference> provider) {
        return new PreferenceStoreMiniProgramsEntityData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PreferenceStoreMiniProgramsEntityData(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
