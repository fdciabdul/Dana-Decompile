package id.dana.riskChallenges.ui.resetpin;

import dagger.internal.Factory;
import id.dana.domain.resetpin.interactor.SaveDanaVizPromptAfterResetPin;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SelfUnfreezeViewModel_Factory implements Factory<SelfUnfreezeViewModel> {
    private final Provider<SaveDanaVizPromptAfterResetPin> BuiltInFictitiousFunctionClassFactory;

    private SelfUnfreezeViewModel_Factory(Provider<SaveDanaVizPromptAfterResetPin> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static SelfUnfreezeViewModel_Factory PlaceComponentResult(Provider<SaveDanaVizPromptAfterResetPin> provider) {
        return new SelfUnfreezeViewModel_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SelfUnfreezeViewModel(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
