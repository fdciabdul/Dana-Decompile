package id.dana.onboarding.citcall;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.analytics.tracker.register.RegistrationTracker;
import id.dana.domain.otp.interactor.VerifyOtpRisk;
import id.dana.onboarding.citcall.CitCallVerifyContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class CitCallVerifyPresenter_Factory implements Factory<CitCallVerifyPresenter> {
    private final Provider<CitCallVerifyContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<VerifyOtpRisk> MyBillsEntityDataFactory;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<RegistrationTracker> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CitCallVerifyPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
    }
}
