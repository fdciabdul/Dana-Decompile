package id.dana.contract.feeds;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.feeds.UserFeedsContract;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class UserFeedsModule_ProvidePresenterFactory implements Factory<UserFeedsContract.Presenter> {
    private final Provider<UserFeedsPresenter> MyBillsEntityDataFactory;
    private final UserFeedsModule PlaceComponentResult;

    private UserFeedsModule_ProvidePresenterFactory(UserFeedsModule userFeedsModule, Provider<UserFeedsPresenter> provider) {
        this.PlaceComponentResult = userFeedsModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static UserFeedsModule_ProvidePresenterFactory MyBillsEntityDataFactory(UserFeedsModule userFeedsModule, Provider<UserFeedsPresenter> provider) {
        return new UserFeedsModule_ProvidePresenterFactory(userFeedsModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UserFeedsContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.get()));
    }
}
