package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.UsernameContract;

/* loaded from: classes5.dex */
public final class UsernameModule_ProvideUsernameViewFactory implements Factory<UsernameContract.View> {
    private final UsernameModule getAuthRequestContext;

    public static UsernameContract.View KClassImpl$Data$declaredNonStaticMembers$2(UsernameModule usernameModule) {
        return (UsernameContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(usernameModule.getKClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UsernameContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
