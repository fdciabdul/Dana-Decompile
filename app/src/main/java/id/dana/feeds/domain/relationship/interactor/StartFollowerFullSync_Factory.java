package id.dana.feeds.domain.relationship.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.relationship.FeedsRelationshipRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class StartFollowerFullSync_Factory implements Factory<StartFollowerFullSync> {
    private final Provider<FeedsRelationshipRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private StartFollowerFullSync_Factory(Provider<FeedsRelationshipRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static StartFollowerFullSync_Factory PlaceComponentResult(Provider<FeedsRelationshipRepository> provider) {
        return new StartFollowerFullSync_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new StartFollowerFullSync(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
