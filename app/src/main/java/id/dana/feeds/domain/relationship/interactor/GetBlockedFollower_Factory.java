package id.dana.feeds.domain.relationship.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.relationship.FeedsRelationshipRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetBlockedFollower_Factory implements Factory<GetBlockedFollower> {
    private final Provider<FeedsRelationshipRepository> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetBlockedFollower(this.PlaceComponentResult.get());
    }
}
