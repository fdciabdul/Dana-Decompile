package id.dana.feeds.domain.config.interactor;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.feeds.domain.relationship.FeedsRelationshipRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class ApproveFriendRequest_Factory implements Factory<ApproveFriendRequest> {
    private final Provider<FeedsRelationshipRepository> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ApproveFriendRequest(DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
    }
}
