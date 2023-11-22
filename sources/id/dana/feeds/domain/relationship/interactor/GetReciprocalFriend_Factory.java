package id.dana.feeds.domain.relationship.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.relationship.FeedsRelationshipRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetReciprocalFriend_Factory implements Factory<GetReciprocalFriend> {
    private final Provider<FeedsRelationshipRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private GetReciprocalFriend_Factory(Provider<FeedsRelationshipRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static GetReciprocalFriend_Factory PlaceComponentResult(Provider<FeedsRelationshipRepository> provider) {
        return new GetReciprocalFriend_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetReciprocalFriend(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
