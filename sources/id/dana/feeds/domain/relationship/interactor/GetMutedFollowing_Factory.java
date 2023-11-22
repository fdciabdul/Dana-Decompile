package id.dana.feeds.domain.relationship.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.relationship.FeedsRelationshipRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetMutedFollowing_Factory implements Factory<GetMutedFollowing> {
    private final Provider<FeedsRelationshipRepository> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetMutedFollowing(this.PlaceComponentResult.get());
    }
}
