package id.dana.riskChallenges.ui.callcsordiana.viewmodel;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.interactor.CheckHelpButtonChatbotFeature;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class CallCsOrDianaViewModel_Factory implements Factory<CallCsOrDianaViewModel> {
    private final Provider<CheckHelpButtonChatbotFeature> BuiltInFictitiousFunctionClassFactory;

    private CallCsOrDianaViewModel_Factory(Provider<CheckHelpButtonChatbotFeature> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static CallCsOrDianaViewModel_Factory getAuthRequestContext(Provider<CheckHelpButtonChatbotFeature> provider) {
        return new CallCsOrDianaViewModel_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CallCsOrDianaViewModel(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
