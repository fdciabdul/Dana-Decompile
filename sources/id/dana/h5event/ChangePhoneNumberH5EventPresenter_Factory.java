package id.dana.h5event;

import dagger.internal.Factory;
import id.dana.domain.h5event.interactor.GetChangePhoneNumberH5Event;
import id.dana.h5event.ChangePhoneNumberH5EventContract;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class ChangePhoneNumberH5EventPresenter_Factory implements Factory<ChangePhoneNumberH5EventPresenter> {
    private final Provider<ChangePhoneNumberH5EventContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetChangePhoneNumberH5Event> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ChangePhoneNumberH5EventPresenter(this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
