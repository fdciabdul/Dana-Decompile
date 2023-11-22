package id.dana.riskChallenges.ui.verifypin;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.featureconfig.interactor.CheckKnowledgeBasedAuthFeature;
import id.dana.riskChallenges.domain.verifypassword.interactor.VerifyPasswordObservable;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class VerifyPinViewModel_Factory implements Factory<VerifyPinViewModel> {
    private final Provider<CheckKnowledgeBasedAuthFeature> BuiltInFictitiousFunctionClassFactory;
    private final Provider<VerifyPasswordObservable> PlaceComponentResult;
    private final Provider<GetPhoneNumber> getAuthRequestContext;

    private VerifyPinViewModel_Factory(Provider<CheckKnowledgeBasedAuthFeature> provider, Provider<VerifyPasswordObservable> provider2, Provider<GetPhoneNumber> provider3) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
        this.getAuthRequestContext = provider3;
    }

    public static VerifyPinViewModel_Factory PlaceComponentResult(Provider<CheckKnowledgeBasedAuthFeature> provider, Provider<VerifyPasswordObservable> provider2, Provider<GetPhoneNumber> provider3) {
        return new VerifyPinViewModel_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new VerifyPinViewModel(DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
    }
}
