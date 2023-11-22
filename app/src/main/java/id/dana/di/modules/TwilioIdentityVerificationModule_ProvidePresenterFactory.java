package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.twilio.identityverification.TwilioIdentityVerificationContract;
import id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class TwilioIdentityVerificationModule_ProvidePresenterFactory implements Factory<TwilioIdentityVerificationContract.Presenter> {
    private final TwilioIdentityVerificationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<TwilioIdentityVerificationPresenter> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TwilioIdentityVerificationContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.get()));
    }
}
