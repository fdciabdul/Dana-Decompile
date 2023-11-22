package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.oauth.InputNameContract;
import id.dana.oauth.presenter.InputNamePresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class InputNameModule_ProvidePresenter$app_productionReleaseFactory implements Factory<InputNameContract.Presenter> {
    private final InputNameModule MyBillsEntityDataFactory;
    private final Provider<InputNamePresenter> getAuthRequestContext;

    public static InputNameContract.Presenter MyBillsEntityDataFactory(InputNameModule inputNameModule, InputNamePresenter inputNamePresenter) {
        return (InputNameContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(inputNameModule.PlaceComponentResult(inputNamePresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (InputNameContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult(this.getAuthRequestContext.get()));
    }
}
