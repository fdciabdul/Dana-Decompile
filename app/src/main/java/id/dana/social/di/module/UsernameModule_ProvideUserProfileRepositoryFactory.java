package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.feeds.data.username.UserProfileEntityRepository;
import id.dana.feeds.domain.username.UserProfileRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class UsernameModule_ProvideUserProfileRepositoryFactory implements Factory<UserProfileRepository> {
    private final UsernameModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<UserProfileEntityRepository> PlaceComponentResult;

    private UsernameModule_ProvideUserProfileRepositoryFactory(UsernameModule usernameModule, Provider<UserProfileEntityRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = usernameModule;
        this.PlaceComponentResult = provider;
    }

    public static UsernameModule_ProvideUserProfileRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(UsernameModule usernameModule, Provider<UserProfileEntityRepository> provider) {
        return new UsernameModule_ProvideUserProfileRepositoryFactory(usernameModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UserProfileRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(this.PlaceComponentResult.get()));
    }
}
