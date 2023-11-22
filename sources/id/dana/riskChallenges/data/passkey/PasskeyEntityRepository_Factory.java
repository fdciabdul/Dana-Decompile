package id.dana.riskChallenges.data.passkey;

import dagger.internal.Factory;
import id.dana.riskChallenges.data.passkey.source.PasskeyEntityDataFactory;
import id.dana.riskChallenges.data.passkey.source.local.PasskeyPreferenceEntityData;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class PasskeyEntityRepository_Factory implements Factory<PasskeyEntityRepository> {
    private final Provider<PasskeyPreferenceEntityData.Factory> BuiltInFictitiousFunctionClassFactory;
    private final Provider<PasskeyEntityDataFactory> getAuthRequestContext;

    private PasskeyEntityRepository_Factory(Provider<PasskeyEntityDataFactory> provider, Provider<PasskeyPreferenceEntityData.Factory> provider2) {
        this.getAuthRequestContext = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
    }

    public static PasskeyEntityRepository_Factory getAuthRequestContext(Provider<PasskeyEntityDataFactory> provider, Provider<PasskeyPreferenceEntityData.Factory> provider2) {
        return new PasskeyEntityRepository_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PasskeyEntityRepository(this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
