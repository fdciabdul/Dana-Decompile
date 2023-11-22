package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.animation.promocenter.NewPromoCenterContract;

/* loaded from: classes4.dex */
public final class NewPromoCenterModule_ProvideViewFactory implements Factory<NewPromoCenterContract.View> {
    private final NewPromoCenterModule getAuthRequestContext;

    private NewPromoCenterModule_ProvideViewFactory(NewPromoCenterModule newPromoCenterModule) {
        this.getAuthRequestContext = newPromoCenterModule;
    }

    public static NewPromoCenterModule_ProvideViewFactory BuiltInFictitiousFunctionClassFactory(NewPromoCenterModule newPromoCenterModule) {
        return new NewPromoCenterModule_ProvideViewFactory(newPromoCenterModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NewPromoCenterContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getMyBillsEntityDataFactory());
    }
}
