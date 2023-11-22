package id.dana.danah5.danaprotection.riskchallenge;

import dagger.MembersInjector;
import id.dana.domain.account.interactor.GetAccount;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RiskChallengeBridge_MembersInjector implements MembersInjector<RiskChallengeBridge> {
    private final Provider<GetAccount> getAccountProvider;

    public RiskChallengeBridge_MembersInjector(Provider<GetAccount> provider) {
        this.getAccountProvider = provider;
    }

    public static MembersInjector<RiskChallengeBridge> create(Provider<GetAccount> provider) {
        return new RiskChallengeBridge_MembersInjector(provider);
    }

    public final void injectMembers(RiskChallengeBridge riskChallengeBridge) {
        injectGetAccount(riskChallengeBridge, this.getAccountProvider.get());
    }

    public static void injectGetAccount(RiskChallengeBridge riskChallengeBridge, GetAccount getAccount) {
        riskChallengeBridge.getAccount = getAccount;
    }
}
