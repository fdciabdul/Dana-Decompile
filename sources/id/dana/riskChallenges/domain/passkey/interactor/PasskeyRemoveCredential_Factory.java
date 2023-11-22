package id.dana.riskChallenges.domain.passkey.interactor;

import dagger.internal.Factory;
import id.dana.riskChallenges.domain.passkey.PasskeyRepository;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class PasskeyRemoveCredential_Factory implements Factory<PasskeyRemoveCredential> {
    private final Provider<PasskeyRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PasskeyRemoveCredential(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
