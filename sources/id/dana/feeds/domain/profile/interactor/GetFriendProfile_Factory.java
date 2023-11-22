package id.dana.feeds.domain.profile.interactor;

import dagger.internal.Factory;
import id.dana.domain.account.AccountRepository;
import id.dana.feeds.domain.relationship.FeedsRelationshipRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetFriendProfile_Factory implements Factory<GetFriendProfile> {
    private final Provider<AccountRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FeedsRelationshipRepository> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetFriendProfile(this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
