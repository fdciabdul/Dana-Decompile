package id.dana.riskChallenges.data.verifypassword.source;

import dagger.internal.Factory;
import id.dana.riskChallenges.data.verifypassword.source.network.NetworkVerifyPasswordEntityData;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class VerifyPasswordEntityDataFactory_Factory implements Factory<VerifyPasswordEntityDataFactory> {
    private final Provider<NetworkVerifyPasswordEntityData> PlaceComponentResult;

    private VerifyPasswordEntityDataFactory_Factory(Provider<NetworkVerifyPasswordEntityData> provider) {
        this.PlaceComponentResult = provider;
    }

    public static VerifyPasswordEntityDataFactory_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<NetworkVerifyPasswordEntityData> provider) {
        return new VerifyPasswordEntityDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new VerifyPasswordEntityDataFactory(this.PlaceComponentResult.get());
    }
}
