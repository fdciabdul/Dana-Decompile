package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.myprofile.MyProfileContract;
import id.dana.myprofile.MyProfilePresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MyProfileModule_ProvidePresenterFactory implements Factory<MyProfileContract.Presenter> {
    private final MyProfileModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<MyProfilePresenter> PlaceComponentResult;

    public static MyProfileContract.Presenter BuiltInFictitiousFunctionClassFactory(MyProfileModule myProfileModule, MyProfilePresenter myProfilePresenter) {
        return (MyProfileContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(myProfileModule.MyBillsEntityDataFactory(myProfilePresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MyProfileContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this.PlaceComponentResult.get()));
    }
}
