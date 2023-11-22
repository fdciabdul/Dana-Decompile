package id.dana.data.kycrenewal.repository.source.session;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class PreferenceKycRenewalEntityData_Factory implements Factory<PreferenceKycRenewalEntityData> {
    private final Provider<KycRenewalPreference> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PreferenceKycRenewalEntityData(this.PlaceComponentResult.get());
    }
}
