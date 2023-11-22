package id.dana.explore.data.userpersonalization;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.explore.data.toggle.source.ExploreConfigEntityDataFactory;
import id.dana.explore.data.userpersonalization.source.UserPersonalizationEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserPersonalizationEntityRepository_Factory implements Factory<UserPersonalizationEntityRepository> {
    private final Provider<ExploreConfigEntityDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<UserPersonalizationEntityDataFactory> MyBillsEntityDataFactory;
    private final Provider<HoldLoginV1EntityRepository> getAuthRequestContext;

    private UserPersonalizationEntityRepository_Factory(Provider<UserPersonalizationEntityDataFactory> provider, Provider<ExploreConfigEntityDataFactory> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        this.MyBillsEntityDataFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.getAuthRequestContext = provider3;
    }

    public static UserPersonalizationEntityRepository_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<UserPersonalizationEntityDataFactory> provider, Provider<ExploreConfigEntityDataFactory> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        return new UserPersonalizationEntityRepository_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UserPersonalizationEntityRepository(this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get());
    }
}
