package id.dana.feeds.domain.relationship.interactor;

import dagger.internal.Factory;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.relationship.FeedsRelationshipRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ModifyFollowingRelationship_Factory implements Factory<ModifyFollowingRelationship> {
    private final Provider<MixpanelRepository> PlaceComponentResult;
    private final Provider<FeedsRelationshipRepository> getAuthRequestContext;

    private ModifyFollowingRelationship_Factory(Provider<FeedsRelationshipRepository> provider, Provider<MixpanelRepository> provider2) {
        this.getAuthRequestContext = provider;
        this.PlaceComponentResult = provider2;
    }

    public static ModifyFollowingRelationship_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<FeedsRelationshipRepository> provider, Provider<MixpanelRepository> provider2) {
        return new ModifyFollowingRelationship_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ModifyFollowingRelationship(this.getAuthRequestContext.get(), this.PlaceComponentResult.get());
    }
}
