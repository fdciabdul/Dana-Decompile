package id.dana.di.workerfactory;

import dagger.internal.Factory;
import id.dana.domain.user.repository.UserRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserInfoWorkerFactory_Factory implements Factory<UserInfoWorkerFactory> {
    private final Provider<UserRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private UserInfoWorkerFactory_Factory(Provider<UserRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static UserInfoWorkerFactory_Factory getAuthRequestContext(Provider<UserRepository> provider) {
        return new UserInfoWorkerFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UserInfoWorkerFactory(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
