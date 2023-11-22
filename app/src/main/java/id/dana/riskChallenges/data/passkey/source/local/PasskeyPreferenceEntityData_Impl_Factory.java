package id.dana.riskChallenges.data.passkey.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.riskChallenges.data.passkey.source.local.PasskeyPreferenceEntityData;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class PasskeyPreferenceEntityData_Impl_Factory implements Factory<PasskeyPreferenceEntityData.Impl> {
    private final Provider<Context> PlaceComponentResult;

    private PasskeyPreferenceEntityData_Impl_Factory(Provider<Context> provider) {
        this.PlaceComponentResult = provider;
    }

    public static PasskeyPreferenceEntityData_Impl_Factory getAuthRequestContext(Provider<Context> provider) {
        return new PasskeyPreferenceEntityData_Impl_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PasskeyPreferenceEntityData.Impl(this.PlaceComponentResult.get());
    }
}
