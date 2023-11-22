package id.dana.wallet_v3.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.wallet.personal.PersonalContract;
import id.dana.wallet_v3.identity.presenter.PersonalPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class PersonalModule_ProvidePresenterFactory implements Factory<PersonalContract.Presenter> {
    private final PersonalModule module;
    private final Provider<PersonalPresenter> personalPresenterProvider;

    public PersonalModule_ProvidePresenterFactory(PersonalModule personalModule, Provider<PersonalPresenter> provider) {
        this.module = personalModule;
        this.personalPresenterProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PersonalContract.Presenter get() {
        return providePresenter(this.module, this.personalPresenterProvider.get());
    }

    public static PersonalModule_ProvidePresenterFactory create(PersonalModule personalModule, Provider<PersonalPresenter> provider) {
        return new PersonalModule_ProvidePresenterFactory(personalModule, provider);
    }

    public static PersonalContract.Presenter providePresenter(PersonalModule personalModule, PersonalPresenter personalPresenter) {
        return (PersonalContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(personalModule.providePresenter(personalPresenter));
    }
}
