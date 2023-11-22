package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.statement.UserStatementContract;
import id.dana.statement.UserStatementPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class UserStatementModule_ProvidePresenterFactory implements Factory<UserStatementContract.Presenter> {
    private final Provider<UserStatementPresenter> BuiltInFictitiousFunctionClassFactory;
    private final UserStatementModule PlaceComponentResult;

    private UserStatementModule_ProvidePresenterFactory(UserStatementModule userStatementModule, Provider<UserStatementPresenter> provider) {
        this.PlaceComponentResult = userStatementModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static UserStatementModule_ProvidePresenterFactory KClassImpl$Data$declaredNonStaticMembers$2(UserStatementModule userStatementModule, Provider<UserStatementPresenter> provider) {
        return new UserStatementModule_ProvidePresenterFactory(userStatementModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UserStatementContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
