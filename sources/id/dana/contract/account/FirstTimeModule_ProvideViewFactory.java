package id.dana.contract.account;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.account.FirstTimeContract;

/* loaded from: classes4.dex */
public final class FirstTimeModule_ProvideViewFactory implements Factory<FirstTimeContract.View> {
    private final FirstTimeModule MyBillsEntityDataFactory;

    private FirstTimeModule_ProvideViewFactory(FirstTimeModule firstTimeModule) {
        this.MyBillsEntityDataFactory = firstTimeModule;
    }

    public static FirstTimeModule_ProvideViewFactory getAuthRequestContext(FirstTimeModule firstTimeModule) {
        return new FirstTimeModule_ProvideViewFactory(firstTimeModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FirstTimeContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory());
    }
}
