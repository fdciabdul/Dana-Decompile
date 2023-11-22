package id.dana.riskChallenges.domain.passkey.interactor;

import dagger.internal.Factory;
import id.dana.riskChallenges.domain.passkey.PasskeyRepository;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class PasskeyForceEnrollmentConsultAfterLogin_Factory implements Factory<PasskeyForceEnrollmentConsultAfterLogin> {
    private final Provider<PasskeyRepository> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PasskeyForceEnrollmentConsultAfterLogin(this.MyBillsEntityDataFactory.get());
    }
}
