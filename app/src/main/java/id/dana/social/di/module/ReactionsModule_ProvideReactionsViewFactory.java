package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.reaction.ReactionsContract;

/* loaded from: classes5.dex */
public final class ReactionsModule_ProvideReactionsViewFactory implements Factory<ReactionsContract.View> {
    private final ReactionsModule getAuthRequestContext;

    private ReactionsModule_ProvideReactionsViewFactory(ReactionsModule reactionsModule) {
        this.getAuthRequestContext = reactionsModule;
    }

    public static ReactionsModule_ProvideReactionsViewFactory MyBillsEntityDataFactory(ReactionsModule reactionsModule) {
        return new ReactionsModule_ProvideReactionsViewFactory(reactionsModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ReactionsContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getGetAuthRequestContext());
    }
}
