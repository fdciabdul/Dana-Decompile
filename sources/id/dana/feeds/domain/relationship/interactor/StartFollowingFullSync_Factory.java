package id.dana.feeds.domain.relationship.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.relationship.FeedsRelationshipRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class StartFollowingFullSync_Factory implements Factory<StartFollowingFullSync> {
    private final Provider<FeedsRelationshipRepository> getAuthRequestContext;

    private StartFollowingFullSync_Factory(Provider<FeedsRelationshipRepository> provider) {
        this.getAuthRequestContext = provider;
    }

    public static StartFollowingFullSync_Factory BuiltInFictitiousFunctionClassFactory(Provider<FeedsRelationshipRepository> provider) {
        return new StartFollowingFullSync_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new StartFollowingFullSync(this.getAuthRequestContext.get());
    }
}
