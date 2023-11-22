package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.reaction.ReactionsContract;
import id.dana.social.contract.reaction.ReactionsPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ReactionsModule_ProvideReactionsPresenterFactory implements Factory<ReactionsContract.Presenter> {
    private final Provider<ReactionsPresenter> BuiltInFictitiousFunctionClassFactory;
    private final ReactionsModule getAuthRequestContext;

    private ReactionsModule_ProvideReactionsPresenterFactory(ReactionsModule reactionsModule, Provider<ReactionsPresenter> provider) {
        this.getAuthRequestContext = reactionsModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ReactionsModule_ProvideReactionsPresenterFactory BuiltInFictitiousFunctionClassFactory(ReactionsModule reactionsModule, Provider<ReactionsPresenter> provider) {
        return new ReactionsModule_ProvideReactionsPresenterFactory(reactionsModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ReactionsContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
