package id.dana.data.danah5;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class H5EntityRepository_Factory implements Factory<H5EntityRepository> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SplitFacade> MyBillsEntityDataFactory;
    private final Provider<AccountEntityRepository> PlaceComponentResult;

    private H5EntityRepository_Factory(Provider<Context> provider, Provider<SplitFacade> provider2, Provider<AccountEntityRepository> provider3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.PlaceComponentResult = provider3;
    }

    public static H5EntityRepository_Factory PlaceComponentResult(Provider<Context> provider, Provider<SplitFacade> provider2, Provider<AccountEntityRepository> provider3) {
        return new H5EntityRepository_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new H5EntityRepository(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get());
    }
}
