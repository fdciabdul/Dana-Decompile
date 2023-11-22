package id.dana.riskChallenges.domain.verifypassword.interactor;

import dagger.internal.Factory;
import id.dana.riskChallenges.domain.verifypassword.VerifyPasswordRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class VerifyPasswordObservable_Factory implements Factory<VerifyPasswordObservable> {
    private final Provider<VerifyPasswordRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private VerifyPasswordObservable_Factory(Provider<VerifyPasswordRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static VerifyPasswordObservable_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<VerifyPasswordRepository> provider) {
        return new VerifyPasswordObservable_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new VerifyPasswordObservable(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
