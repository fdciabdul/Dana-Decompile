package id.dana.wallet_v3.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.wallet.personal.PersonalContract;

/* loaded from: classes5.dex */
public final class PersonalModule_ProvideViewFactory implements Factory<PersonalContract.View> {
    private final PersonalModule module;

    public PersonalModule_ProvideViewFactory(PersonalModule personalModule) {
        this.module = personalModule;
    }

    @Override // javax.inject.Provider
    public final PersonalContract.View get() {
        return provideView(this.module);
    }

    public static PersonalModule_ProvideViewFactory create(PersonalModule personalModule) {
        return new PersonalModule_ProvideViewFactory(personalModule);
    }

    public static PersonalContract.View provideView(PersonalModule personalModule) {
        return (PersonalContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(personalModule.getView());
    }
}
