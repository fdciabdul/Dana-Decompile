package id.dana.feeds.domain.relationship.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.relationship.FeedsRelationshipRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetActiveFollowing_Factory implements Factory<GetActiveFollowing> {
    private final Provider<FeedsRelationshipRepository> BuiltInFictitiousFunctionClassFactory;

    private GetActiveFollowing_Factory(Provider<FeedsRelationshipRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GetActiveFollowing_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<FeedsRelationshipRepository> provider) {
        return new GetActiveFollowing_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetActiveFollowing(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
