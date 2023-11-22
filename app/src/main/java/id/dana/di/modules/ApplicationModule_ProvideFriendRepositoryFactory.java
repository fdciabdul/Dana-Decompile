package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.feeds.data.friend.FriendEntityRepository;
import id.dana.feeds.domain.friend.FriendRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideFriendRepositoryFactory implements Factory<FriendRepository> {
    private final ApplicationModule PlaceComponentResult;
    private final Provider<FriendEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideFriendRepositoryFactory(ApplicationModule applicationModule, Provider<FriendEntityRepository> provider) {
        this.PlaceComponentResult = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideFriendRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<FriendEntityRepository> provider) {
        return new ApplicationModule_ProvideFriendRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FriendRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.get()));
    }
}
