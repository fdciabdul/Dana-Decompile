package id.dana.feeds.domain.relationship.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.relationship.FeedsRelationshipRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ModifyFollowingRelationshipWithPublishResult_Factory implements Factory<ModifyFollowingRelationshipWithPublishResult> {
    private final Provider<FeedsRelationshipRepository> PlaceComponentResult;

    private ModifyFollowingRelationshipWithPublishResult_Factory(Provider<FeedsRelationshipRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static ModifyFollowingRelationshipWithPublishResult_Factory BuiltInFictitiousFunctionClassFactory(Provider<FeedsRelationshipRepository> provider) {
        return new ModifyFollowingRelationshipWithPublishResult_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ModifyFollowingRelationshipWithPublishResult(this.PlaceComponentResult.get());
    }
}
