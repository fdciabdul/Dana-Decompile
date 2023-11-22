package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.h5event.ChangePhoneNumberH5EventContract;
import id.dana.h5event.ChangePhoneNumberH5EventPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ChangePhoneNumberH5EventModule_ProvidePresenterFactory implements Factory<ChangePhoneNumberH5EventContract.Presenter> {
    private final Provider<ChangePhoneNumberH5EventPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ChangePhoneNumberH5EventModule MyBillsEntityDataFactory;

    public static ChangePhoneNumberH5EventContract.Presenter PlaceComponentResult(ChangePhoneNumberH5EventModule changePhoneNumberH5EventModule, ChangePhoneNumberH5EventPresenter changePhoneNumberH5EventPresenter) {
        return (ChangePhoneNumberH5EventContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(changePhoneNumberH5EventModule.MyBillsEntityDataFactory(changePhoneNumberH5EventPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ChangePhoneNumberH5EventContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
