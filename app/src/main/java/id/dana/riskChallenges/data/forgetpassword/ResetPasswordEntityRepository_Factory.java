package id.dana.riskChallenges.data.forgetpassword;

import dagger.internal.Factory;
import id.dana.data.security.source.SecurityEntityDataFactory;
import id.dana.riskChallenges.data.forgetpassword.source.ResetPasswordEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ResetPasswordEntityRepository_Factory implements Factory<ResetPasswordEntityRepository> {
    private final Provider<ResetPasswordEntityDataFactory> PlaceComponentResult;
    private final Provider<SecurityEntityDataFactory> getAuthRequestContext;

    private ResetPasswordEntityRepository_Factory(Provider<ResetPasswordEntityDataFactory> provider, Provider<SecurityEntityDataFactory> provider2) {
        this.PlaceComponentResult = provider;
        this.getAuthRequestContext = provider2;
    }

    public static ResetPasswordEntityRepository_Factory MyBillsEntityDataFactory(Provider<ResetPasswordEntityDataFactory> provider, Provider<SecurityEntityDataFactory> provider2) {
        return new ResetPasswordEntityRepository_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ResetPasswordEntityRepository(this.PlaceComponentResult.get(), this.getAuthRequestContext.get());
    }
}
