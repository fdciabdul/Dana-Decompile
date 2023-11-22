package id.dana.feeds.domain.relationship.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.relationship.FeedsRelationshipRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ModifyFollowerRelationshipWithPublishResult_Factory implements Factory<ModifyFollowerRelationshipWithPublishResult> {
    private final Provider<FeedsRelationshipRepository> PlaceComponentResult;

    private ModifyFollowerRelationshipWithPublishResult_Factory(Provider<FeedsRelationshipRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static ModifyFollowerRelationshipWithPublishResult_Factory BuiltInFictitiousFunctionClassFactory(Provider<FeedsRelationshipRepository> provider) {
        return new ModifyFollowerRelationshipWithPublishResult_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ModifyFollowerRelationshipWithPublishResult(this.PlaceComponentResult.get());
    }
}
