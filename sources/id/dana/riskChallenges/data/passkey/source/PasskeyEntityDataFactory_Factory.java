package id.dana.riskChallenges.data.passkey.source;

import dagger.internal.Factory;
import id.dana.riskChallenges.data.passkey.source.network.NetworkPasskeyEntityData;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class PasskeyEntityDataFactory_Factory implements Factory<PasskeyEntityDataFactory> {
    private final Provider<NetworkPasskeyEntityData> KClassImpl$Data$declaredNonStaticMembers$2;

    private PasskeyEntityDataFactory_Factory(Provider<NetworkPasskeyEntityData> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static PasskeyEntityDataFactory_Factory BuiltInFictitiousFunctionClassFactory(Provider<NetworkPasskeyEntityData> provider) {
        return new PasskeyEntityDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PasskeyEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
