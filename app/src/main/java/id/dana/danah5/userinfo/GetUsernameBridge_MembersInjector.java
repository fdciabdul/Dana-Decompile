package id.dana.danah5.userinfo;

import dagger.MembersInjector;
import id.dana.domain.account.interactor.GetAccount;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetUsernameBridge_MembersInjector implements MembersInjector<GetUsernameBridge> {
    private final Provider<GetAccount> getAccountProvider;

    public GetUsernameBridge_MembersInjector(Provider<GetAccount> provider) {
        this.getAccountProvider = provider;
    }

    public static MembersInjector<GetUsernameBridge> create(Provider<GetAccount> provider) {
        return new GetUsernameBridge_MembersInjector(provider);
    }

    public final void injectMembers(GetUsernameBridge getUsernameBridge) {
        injectGetAccount(getUsernameBridge, this.getAccountProvider.get());
    }

    public static void injectGetAccount(GetUsernameBridge getUsernameBridge, GetAccount getAccount) {
        getUsernameBridge.getAccount = getAccount;
    }
}
