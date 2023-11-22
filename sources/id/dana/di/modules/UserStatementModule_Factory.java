package id.dana.di.modules;

import dagger.internal.Factory;
import id.dana.statement.UserStatementContract;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class UserStatementModule_Factory implements Factory<UserStatementModule> {
    private final Provider<UserStatementContract.View> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UserStatementModule(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
