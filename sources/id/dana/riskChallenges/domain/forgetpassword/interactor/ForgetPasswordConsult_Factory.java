package id.dana.riskChallenges.domain.forgetpassword.interactor;

import dagger.internal.Factory;
import id.dana.riskChallenges.domain.forgetpassword.ResetPasswordRepository;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class ForgetPasswordConsult_Factory implements Factory<ForgetPasswordConsult> {
    private final Provider<ResetPasswordRepository> BuiltInFictitiousFunctionClassFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ForgetPasswordConsult(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
