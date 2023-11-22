package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.UsernameContract;
import id.dana.social.presenter.UsernamePresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class UsernameModule_ProvideUsernamePresenterFactory implements Factory<UsernameContract.Presenter> {
    private final Provider<UsernamePresenter> BuiltInFictitiousFunctionClassFactory;
    private final UsernameModule MyBillsEntityDataFactory;

    public static UsernameContract.Presenter getAuthRequestContext(UsernameModule usernameModule, UsernamePresenter usernamePresenter) {
        return (UsernameContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(usernameModule.getAuthRequestContext(usernamePresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UsernameContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
