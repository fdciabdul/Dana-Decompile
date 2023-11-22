package id.dana.sendmoney.domain.groupsend.interactor;

import dagger.internal.Factory;
import id.dana.domain.user.repository.UserRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetUserInfo_Factory implements Factory<GetUserInfo> {
    private final Provider<UserRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private GetUserInfo_Factory(Provider<UserRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static GetUserInfo_Factory MyBillsEntityDataFactory(Provider<UserRepository> provider) {
        return new GetUserInfo_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetUserInfo(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
