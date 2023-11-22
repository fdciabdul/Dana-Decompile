package id.dana.feeds.data.friend;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.feeds.data.friend.source.FriendEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FriendEntityRepository_Factory implements Factory<FriendEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<AccountEntityDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FriendEntityDataFactory> PlaceComponentResult;

    private FriendEntityRepository_Factory(Provider<FriendEntityDataFactory> provider, Provider<AccountEntityDataFactory> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        this.PlaceComponentResult = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
    }

    public static FriendEntityRepository_Factory getAuthRequestContext(Provider<FriendEntityDataFactory> provider, Provider<AccountEntityDataFactory> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        return new FriendEntityRepository_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FriendEntityRepository(this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
