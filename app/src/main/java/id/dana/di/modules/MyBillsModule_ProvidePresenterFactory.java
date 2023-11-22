package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.mybills.di.MyBillsContract;
import id.dana.mybills.di.MyBillsPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MyBillsModule_ProvidePresenterFactory implements Factory<MyBillsContract.Presenter> {
    private final Provider<MyBillsPresenter> PlaceComponentResult;
    private final MyBillsModule getAuthRequestContext;

    private MyBillsModule_ProvidePresenterFactory(MyBillsModule myBillsModule, Provider<MyBillsPresenter> provider) {
        this.getAuthRequestContext = myBillsModule;
        this.PlaceComponentResult = provider;
    }

    public static MyBillsModule_ProvidePresenterFactory MyBillsEntityDataFactory(MyBillsModule myBillsModule, Provider<MyBillsPresenter> provider) {
        return new MyBillsModule_ProvidePresenterFactory(myBillsModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MyBillsContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getAuthRequestContext(this.PlaceComponentResult.get()));
    }
}
