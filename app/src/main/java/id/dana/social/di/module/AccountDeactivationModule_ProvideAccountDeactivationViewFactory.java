package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.AccountDeactivationContract;

/* loaded from: classes5.dex */
public final class AccountDeactivationModule_ProvideAccountDeactivationViewFactory implements Factory<AccountDeactivationContract.View> {
    private final AccountDeactivationModule MyBillsEntityDataFactory;

    public static AccountDeactivationContract.View MyBillsEntityDataFactory(AccountDeactivationModule accountDeactivationModule) {
        return (AccountDeactivationContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(accountDeactivationModule.getGetAuthRequestContext());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (AccountDeactivationContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getGetAuthRequestContext());
    }
}
