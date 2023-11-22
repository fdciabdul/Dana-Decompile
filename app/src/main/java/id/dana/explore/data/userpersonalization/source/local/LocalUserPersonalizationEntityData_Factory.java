package id.dana.explore.data.userpersonalization.source.local;

import dagger.internal.Factory;
import id.dana.data.userpersonalization.source.local.UserPersonalizationPreferences;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalUserPersonalizationEntityData_Factory implements Factory<LocalUserPersonalizationEntityData> {
    private final Provider<UserPersonalizationPreferences> BuiltInFictitiousFunctionClassFactory;

    private LocalUserPersonalizationEntityData_Factory(Provider<UserPersonalizationPreferences> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static LocalUserPersonalizationEntityData_Factory PlaceComponentResult(Provider<UserPersonalizationPreferences> provider) {
        return new LocalUserPersonalizationEntityData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new LocalUserPersonalizationEntityData(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
