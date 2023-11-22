package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.danah5.twilioverifysecurityproduct.TwilioVerifySecurityProductManager;
import id.dana.domain.twilio.interactor.CheckTwilioEnrollmentStatus;
import id.dana.domain.twilio.interactor.TwilioRequestChallenge;
import id.dana.domain.twilio.interactor.TwilioVerifySecurityProduct;
import id.dana.domain.twilio.interactor.UpdateTwilioChallenge;
import id.dana.twilio.tracker.TwilioMixpanelTracker;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GContainerModule_ProvideTwilioSecurityProductManagerFactory implements Factory<TwilioVerifySecurityProductManager> {
    private final Provider<TwilioRequestChallenge> BuiltInFictitiousFunctionClassFactory;
    private final Provider<CheckTwilioEnrollmentStatus> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<TwilioMixpanelTracker> MyBillsEntityDataFactory;
    private final GContainerModule PlaceComponentResult;
    private final Provider<TwilioVerifySecurityProduct> getAuthRequestContext;
    private final Provider<UpdateTwilioChallenge> getErrorConfigVersion;

    private GContainerModule_ProvideTwilioSecurityProductManagerFactory(GContainerModule gContainerModule, Provider<CheckTwilioEnrollmentStatus> provider, Provider<TwilioRequestChallenge> provider2, Provider<TwilioVerifySecurityProduct> provider3, Provider<UpdateTwilioChallenge> provider4, Provider<TwilioMixpanelTracker> provider5) {
        this.PlaceComponentResult = gContainerModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.getAuthRequestContext = provider3;
        this.getErrorConfigVersion = provider4;
        this.MyBillsEntityDataFactory = provider5;
    }

    public static GContainerModule_ProvideTwilioSecurityProductManagerFactory getAuthRequestContext(GContainerModule gContainerModule, Provider<CheckTwilioEnrollmentStatus> provider, Provider<TwilioRequestChallenge> provider2, Provider<TwilioVerifySecurityProduct> provider3, Provider<UpdateTwilioChallenge> provider4, Provider<TwilioMixpanelTracker> provider5) {
        return new GContainerModule_ProvideTwilioSecurityProductManagerFactory(gContainerModule, provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TwilioVerifySecurityProductManager) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), this.getErrorConfigVersion.get(), this.MyBillsEntityDataFactory.get()));
    }
}
