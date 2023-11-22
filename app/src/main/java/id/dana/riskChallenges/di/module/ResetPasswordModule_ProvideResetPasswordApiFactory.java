package id.dana.riskChallenges.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.riskChallenges.data.forgetpassword.source.network.ResetPasswordApi;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes5.dex */
public final class ResetPasswordModule_ProvideResetPasswordApiFactory implements Factory<ResetPasswordApi> {
    private final Provider<Retrofit.Builder> BuiltInFictitiousFunctionClassFactory;
    private final ResetPasswordModule KClassImpl$Data$declaredNonStaticMembers$2;

    private ResetPasswordModule_ProvideResetPasswordApiFactory(ResetPasswordModule resetPasswordModule, Provider<Retrofit.Builder> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = resetPasswordModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ResetPasswordModule_ProvideResetPasswordApiFactory KClassImpl$Data$declaredNonStaticMembers$2(ResetPasswordModule resetPasswordModule, Provider<Retrofit.Builder> provider) {
        return new ResetPasswordModule_ProvideResetPasswordApiFactory(resetPasswordModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ResetPasswordApi) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
