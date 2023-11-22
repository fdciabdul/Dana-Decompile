package id.dana.feeds.domain.config.interactor;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.feeds.domain.relationship.FeedsRelationshipRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DeclineFriendRequest_Factory implements Factory<DeclineFriendRequest> {
    private final Provider<FeedsRelationshipRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DeclineFriendRequest(DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
    }
}
