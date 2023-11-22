package id.dana.riskChallenges.data.passkey.source.local;

import dagger.internal.Factory;
import id.dana.riskChallenges.data.passkey.source.local.PasskeyPreferenceEntityData;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class PasskeyPreferenceEntityData_Factory_Factory implements Factory<PasskeyPreferenceEntityData.Factory> {
    private final Provider<PasskeyPreferenceEntityData.Impl> MyBillsEntityDataFactory;

    private PasskeyPreferenceEntityData_Factory_Factory(Provider<PasskeyPreferenceEntityData.Impl> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static PasskeyPreferenceEntityData_Factory_Factory getAuthRequestContext(Provider<PasskeyPreferenceEntityData.Impl> provider) {
        return new PasskeyPreferenceEntityData_Factory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PasskeyPreferenceEntityData.Factory(this.MyBillsEntityDataFactory.get());
    }
}
