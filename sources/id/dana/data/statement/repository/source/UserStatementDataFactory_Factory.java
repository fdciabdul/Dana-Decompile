package id.dana.data.statement.repository.source;

import dagger.internal.Factory;
import id.dana.data.statement.repository.source.network.NetworkUserStatementEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserStatementDataFactory_Factory implements Factory<UserStatementDataFactory> {
    private final Provider<NetworkUserStatementEntityData> BuiltInFictitiousFunctionClassFactory;

    private UserStatementDataFactory_Factory(Provider<NetworkUserStatementEntityData> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static UserStatementDataFactory_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<NetworkUserStatementEntityData> provider) {
        return new UserStatementDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UserStatementDataFactory(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
