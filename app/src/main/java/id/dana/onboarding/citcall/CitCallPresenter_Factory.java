package id.dana.onboarding.citcall;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.citcall.interactor.GetCitcallOtp;
import id.dana.domain.citcall.interactor.GetCitcallPermissionUseCase;
import id.dana.onboarding.citcall.CitCallContract;
import id.dana.onboarding.citcall.tracker.CitCallTrackerImpl;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class CitCallPresenter_Factory implements Factory<CitCallPresenter> {
    private final Provider<GetCitcallPermissionUseCase> BuiltInFictitiousFunctionClassFactory;
    private final Provider<CitCallTrackerImpl> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<CitCallContract.View> PlaceComponentResult;
    private final Provider<GetCitcallOtp> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CitCallPresenter(this.PlaceComponentResult.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
