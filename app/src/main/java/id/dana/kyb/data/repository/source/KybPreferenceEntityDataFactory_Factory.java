package id.dana.kyb.data.repository.source;

import dagger.internal.Factory;
import id.dana.kyb.data.repository.source.local.LocalKybPreferenceEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class KybPreferenceEntityDataFactory_Factory implements Factory<KybPreferenceEntityDataFactory> {
    private final Provider<LocalKybPreferenceEntityData> PlaceComponentResult;

    private KybPreferenceEntityDataFactory_Factory(Provider<LocalKybPreferenceEntityData> provider) {
        this.PlaceComponentResult = provider;
    }

    public static KybPreferenceEntityDataFactory_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<LocalKybPreferenceEntityData> provider) {
        return new KybPreferenceEntityDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new KybPreferenceEntityDataFactory(this.PlaceComponentResult.get());
    }
}
