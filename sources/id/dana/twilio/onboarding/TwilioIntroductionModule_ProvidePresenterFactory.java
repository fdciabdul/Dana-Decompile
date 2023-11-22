package id.dana.twilio.onboarding;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.twilio.onboarding.TwilioIntroductionContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class TwilioIntroductionModule_ProvidePresenterFactory implements Factory<TwilioIntroductionContract.Presenter> {
    private final Provider<TwilioIntroductionPresenter> BuiltInFictitiousFunctionClassFactory;
    private final TwilioIntroductionModule getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TwilioIntroductionContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
