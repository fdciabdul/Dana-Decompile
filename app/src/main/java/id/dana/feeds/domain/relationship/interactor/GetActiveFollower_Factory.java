package id.dana.feeds.domain.relationship.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.relationship.FeedsRelationshipRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetActiveFollower_Factory implements Factory<GetActiveFollower> {
    private final Provider<FeedsRelationshipRepository> MyBillsEntityDataFactory;

    private GetActiveFollower_Factory(Provider<FeedsRelationshipRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static GetActiveFollower_Factory getAuthRequestContext(Provider<FeedsRelationshipRepository> provider) {
        return new GetActiveFollower_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetActiveFollower(this.MyBillsEntityDataFactory.get());
    }
}
