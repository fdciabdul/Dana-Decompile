package id.dana.mybills.data.repository;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.user.source.UserInfoEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MyBillsEntityRepository_Factory implements Factory<MyBillsEntityRepository> {
    private final Provider<UserInfoEntityDataFactory> MyBillsEntityDataFactory;
    private final Provider<HoldLoginV1EntityRepository> PlaceComponentResult;
    private final Provider<MyBillsEntityDataFactory> getAuthRequestContext;

    private MyBillsEntityRepository_Factory(Provider<MyBillsEntityDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2, Provider<UserInfoEntityDataFactory> provider3) {
        this.getAuthRequestContext = provider;
        this.PlaceComponentResult = provider2;
        this.MyBillsEntityDataFactory = provider3;
    }

    public static MyBillsEntityRepository_Factory getAuthRequestContext(Provider<MyBillsEntityDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2, Provider<UserInfoEntityDataFactory> provider3) {
        return new MyBillsEntityRepository_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MyBillsEntityRepository(this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get());
    }
}
