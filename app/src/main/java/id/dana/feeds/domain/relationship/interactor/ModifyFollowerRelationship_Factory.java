package id.dana.feeds.domain.relationship.interactor;

import dagger.internal.Factory;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.relationship.FeedsRelationshipRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ModifyFollowerRelationship_Factory implements Factory<ModifyFollowerRelationship> {
    private final Provider<MixpanelRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FeedsRelationshipRepository> MyBillsEntityDataFactory;

    private ModifyFollowerRelationship_Factory(Provider<FeedsRelationshipRepository> provider, Provider<MixpanelRepository> provider2) {
        this.MyBillsEntityDataFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static ModifyFollowerRelationship_Factory getAuthRequestContext(Provider<FeedsRelationshipRepository> provider, Provider<MixpanelRepository> provider2) {
        return new ModifyFollowerRelationship_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ModifyFollowerRelationship(this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
