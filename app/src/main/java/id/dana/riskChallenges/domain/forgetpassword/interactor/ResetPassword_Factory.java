package id.dana.riskChallenges.domain.forgetpassword.interactor;

import dagger.internal.Factory;
import id.dana.riskChallenges.domain.forgetpassword.ResetPasswordRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ResetPassword_Factory implements Factory<ResetPassword> {
    private final Provider<ResetPasswordRepository> PlaceComponentResult;

    private ResetPassword_Factory(Provider<ResetPasswordRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static ResetPassword_Factory getAuthRequestContext(Provider<ResetPasswordRepository> provider) {
        return new ResetPassword_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ResetPassword(this.PlaceComponentResult.get());
    }
}
