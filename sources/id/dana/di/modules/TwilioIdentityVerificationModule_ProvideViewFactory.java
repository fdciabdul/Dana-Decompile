package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.twilio.identityverification.TwilioIdentityVerificationContract;

/* loaded from: classes4.dex */
public final class TwilioIdentityVerificationModule_ProvideViewFactory implements Factory<TwilioIdentityVerificationContract.View> {
    private final TwilioIdentityVerificationModule PlaceComponentResult;

    private TwilioIdentityVerificationModule_ProvideViewFactory(TwilioIdentityVerificationModule twilioIdentityVerificationModule) {
        this.PlaceComponentResult = twilioIdentityVerificationModule;
    }

    public static TwilioIdentityVerificationModule_ProvideViewFactory getAuthRequestContext(TwilioIdentityVerificationModule twilioIdentityVerificationModule) {
        return new TwilioIdentityVerificationModule_ProvideViewFactory(twilioIdentityVerificationModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TwilioIdentityVerificationContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getMyBillsEntityDataFactory());
    }
}
