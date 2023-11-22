package id.dana.twilio.onboarding;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.twilio.onboarding.TwilioIntroductionContract;

/* loaded from: classes5.dex */
public final class TwilioIntroductionModule_ProvideViewFactory implements Factory<TwilioIntroductionContract.View> {
    private final TwilioIntroductionModule MyBillsEntityDataFactory;

    private TwilioIntroductionModule_ProvideViewFactory(TwilioIntroductionModule twilioIntroductionModule) {
        this.MyBillsEntityDataFactory = twilioIntroductionModule;
    }

    public static TwilioIntroductionModule_ProvideViewFactory KClassImpl$Data$declaredNonStaticMembers$2(TwilioIntroductionModule twilioIntroductionModule) {
        return new TwilioIntroductionModule_ProvideViewFactory(twilioIntroductionModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TwilioIntroductionContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
