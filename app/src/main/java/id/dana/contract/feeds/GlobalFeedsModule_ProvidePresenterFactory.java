package id.dana.contract.feeds;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.feeds.GlobalFeedsContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GlobalFeedsModule_ProvidePresenterFactory implements Factory<GlobalFeedsContract.Presenter> {
    private final GlobalFeedsModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GlobalFeedsPresenter> MyBillsEntityDataFactory;

    private GlobalFeedsModule_ProvidePresenterFactory(GlobalFeedsModule globalFeedsModule, Provider<GlobalFeedsPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = globalFeedsModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static GlobalFeedsModule_ProvidePresenterFactory BuiltInFictitiousFunctionClassFactory(GlobalFeedsModule globalFeedsModule, Provider<GlobalFeedsPresenter> provider) {
        return new GlobalFeedsModule_ProvidePresenterFactory(globalFeedsModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GlobalFeedsContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.MyBillsEntityDataFactory.get()));
    }
}
