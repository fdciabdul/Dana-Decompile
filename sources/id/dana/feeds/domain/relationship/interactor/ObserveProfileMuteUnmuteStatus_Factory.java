package id.dana.feeds.domain.relationship.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.relationship.FeedsRelationshipRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class ObserveProfileMuteUnmuteStatus_Factory implements Factory<ObserveProfileMuteUnmuteStatus> {
    private final Provider<FeedsRelationshipRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ObserveProfileMuteUnmuteStatus(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
