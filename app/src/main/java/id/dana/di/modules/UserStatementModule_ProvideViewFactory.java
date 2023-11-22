package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.statement.UserStatementContract;

/* loaded from: classes4.dex */
public final class UserStatementModule_ProvideViewFactory implements Factory<UserStatementContract.View> {
    private final UserStatementModule MyBillsEntityDataFactory;

    private UserStatementModule_ProvideViewFactory(UserStatementModule userStatementModule) {
        this.MyBillsEntityDataFactory = userStatementModule;
    }

    public static UserStatementModule_ProvideViewFactory getAuthRequestContext(UserStatementModule userStatementModule) {
        return new UserStatementModule_ProvideViewFactory(userStatementModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UserStatementContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
