package id.dana.feeds.domain.reactions.interactor;

import dagger.internal.Factory;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.user.repository.UserRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetMyActivityReactionInfo_Factory implements Factory<GetMyActivityReactionInfo> {
    private final Provider<UserRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<AccountRepository> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetMyActivityReactionInfo(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
