package id.dana.data.mybills.repository;

import dagger.internal.Factory;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MyBillsEntityRepository_Factory implements Factory<MyBillsEntityRepository> {
    private final Provider<MyBillsEntityDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SplitConfigEntityData> MyBillsEntityDataFactory;
    private final Provider<HoldLoginV1EntityRepository> PlaceComponentResult;

    private MyBillsEntityRepository_Factory(Provider<MyBillsEntityDataFactory> provider, Provider<SplitConfigEntityData> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.PlaceComponentResult = provider3;
    }

    public static MyBillsEntityRepository_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<MyBillsEntityDataFactory> provider, Provider<SplitConfigEntityData> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        return new MyBillsEntityRepository_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MyBillsEntityRepository(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get());
    }
}
