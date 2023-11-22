package id.dana.riskChallenges.data.forgetpassword.source;

import dagger.internal.Factory;
import id.dana.riskChallenges.data.forgetpassword.source.network.NetworkResetPasswordEntityData;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ResetPasswordEntityDataFactory_Factory implements Factory<ResetPasswordEntityDataFactory> {
    private final Provider<NetworkResetPasswordEntityData> BuiltInFictitiousFunctionClassFactory;

    private ResetPasswordEntityDataFactory_Factory(Provider<NetworkResetPasswordEntityData> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ResetPasswordEntityDataFactory_Factory PlaceComponentResult(Provider<NetworkResetPasswordEntityData> provider) {
        return new ResetPasswordEntityDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ResetPasswordEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
