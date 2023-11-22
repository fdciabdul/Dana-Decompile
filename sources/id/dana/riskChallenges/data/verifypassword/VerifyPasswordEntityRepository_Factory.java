package id.dana.riskChallenges.data.verifypassword;

import dagger.internal.Factory;
import id.dana.data.security.source.SecurityEntityDataFactory;
import id.dana.riskChallenges.data.verifypassword.source.VerifyPasswordEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class VerifyPasswordEntityRepository_Factory implements Factory<VerifyPasswordEntityRepository> {
    private final Provider<VerifyPasswordEntityDataFactory> PlaceComponentResult;
    private final Provider<SecurityEntityDataFactory> getAuthRequestContext;

    private VerifyPasswordEntityRepository_Factory(Provider<VerifyPasswordEntityDataFactory> provider, Provider<SecurityEntityDataFactory> provider2) {
        this.PlaceComponentResult = provider;
        this.getAuthRequestContext = provider2;
    }

    public static VerifyPasswordEntityRepository_Factory MyBillsEntityDataFactory(Provider<VerifyPasswordEntityDataFactory> provider, Provider<SecurityEntityDataFactory> provider2) {
        return new VerifyPasswordEntityRepository_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new VerifyPasswordEntityRepository(this.PlaceComponentResult.get(), this.getAuthRequestContext.get());
    }
}
